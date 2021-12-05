/*
 * Copyright 2015 The gRPC Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bluecc.saga;

import com.bluecc.hubs.stub.Envelope;
import com.bluecc.hubs.stub.OrderHeaderData;
import com.bluecc.hubs.stub.Response;
import com.bluecc.hubs.stub.RoutinesGrpc;
import com.google.protobuf.Any;
import com.google.protobuf.Message;
import io.grpc.*;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

import static com.bluecc.saga.ResourceHelper.readResourceFromFile;
import static com.bluecc.saga.SagaModule.startup;

@Slf4j
public class HubsClient {
    // private static final Logger logger = Logger.getLogger(CustomHeaderClient.class.getName());

    private final ManagedChannel originChannel;
    private final RoutinesGrpc.RoutinesBlockingStub blockingStub;

    public HubsClient(String host, int port) {
        originChannel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        ClientInterceptor interceptor = new HeaderClientInterceptor();
        Channel channel = ClientInterceptors.intercept(originChannel, interceptor);
        blockingStub = RoutinesGrpc.newBlockingStub(channel);
    }

    private void shutdown() throws InterruptedException {
        originChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    private void storeValue(String source) {
        Message protoMess = readResourceFromFile(source,
                OrderHeaderData.newBuilder())
                .build();
        Envelope envelope = Envelope.newBuilder()
                .setDataType("OrderHeader")
                .setData(Any.pack(protoMess))
                .build();
        try {
            Response response = blockingStub.storeValue(envelope);
            System.out.println(response);
        } catch (StatusRuntimeException e) {
            log.warn("RPC failed: {}", e.getStatus());
        }
    }

    /**
     * Main start the client from the command line.
     */
    public static void main(String[] args) throws Exception {
        HubsClient client = startup(HubsClient.class);
        try {
            client.storeValue("dataset/fixtures/order_head_simple.json");
        } finally {
            client.shutdown();
        }
    }
}
