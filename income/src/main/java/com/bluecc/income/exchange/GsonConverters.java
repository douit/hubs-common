package com.bluecc.income.exchange;

import com.bluecc.hubs.fund.Util;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableMap;
import com.google.common.primitives.Primitives;
import com.linecorp.armeria.common.*;
import com.linecorp.armeria.common.annotation.Nullable;
import com.linecorp.armeria.server.ServiceRequestContext;
import com.linecorp.armeria.server.annotation.RequestConverterFunction;
import com.linecorp.armeria.server.annotation.ResponseConverterFunction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.ParameterizedType;

public class GsonConverters {

    public static final class Response {
        static final String SUCCESS = "success";

        private final String result;
        private final String from;

        private Response(String result, String from) {
            this.result = result;
            this.from = from;
        }

        @JsonProperty
        public String result() {
            return result;
        }

        @JsonProperty
        public String from() {
            return from;
        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class JsonString {
        String value;
    }

    public static final class GsonResponseConverter implements ResponseConverterFunction {
        @Override
        public HttpResponse convertResponse(
                ServiceRequestContext ctx, ResponseHeaders headers,
                @Nullable Object result, HttpHeaders trailers) throws Exception {

            if (result == null) {
                return ResponseConverterFunction.fallthrough();
            }

            if (result instanceof JsonString) {
                return HttpResponse.of(headers, HttpData.ofUtf8(((JsonString) result).getValue()),
                        trailers);
            } else if (result.getClass().isPrimitive() || Primitives.isWrapperType(result.getClass())) {
                return HttpResponse.of(headers, HttpData.ofUtf8(Util.prettyJson(
                        ImmutableMap.of("result", result))), trailers);
            } else if (result instanceof Response) {
                final Response response = (Response) result;
                final HttpData body = HttpData.ofUtf8(response.result() + ':' + response.from());
                return HttpResponse.of(headers, body, trailers);
            } else {
                String resultBody = Util.prettyJson(result);
                final HttpData body = HttpData.ofUtf8(resultBody);
                return HttpResponse.of(headers, body, trailers);
            }

            // return ResponseConverterFunction.fallthrough();
        }
    }

    public static final class GsonRequestConverter implements RequestConverterFunction {
        @Override
        public Object convertRequest(
                ServiceRequestContext ctx, AggregatedHttpRequest request, Class<?> expectedResultType,
                @Nullable ParameterizedType expectedParameterizedResultType) throws Exception {

            final MediaType mediaType = request.contentType();
            if (mediaType != null && mediaType.is(MediaType.JSON)) {
                return Util.GSON_NO_EXCLUDE.fromJson(request.contentUtf8(), expectedResultType);
            }
            return RequestConverterFunction.fallthrough();
        }
    }
}
