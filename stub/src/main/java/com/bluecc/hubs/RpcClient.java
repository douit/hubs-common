package com.bluecc.hubs;

import com.bluecc.hubs.stub.Envelope;
import com.bluecc.hubs.stub.Response;
import com.bluecc.hubs.stub.RoutinesGrpc;
import com.bluecc.hubs.stub.StringValue;
import com.google.protobuf.Any;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.TimeUnit;

public class RpcClient {

    public static void main(String[] args) throws InterruptedException {
        String target = "localhost:50056";

        StringValue protoMess=StringValue.newBuilder().setValue("hi").build();
        Envelope envelope= Envelope.newBuilder()
                .setDataType("string")
                .setData(Any.pack(protoMess))
                .build();
        Response response=new RpcClient().call(target, envelope);
        System.out.println(response);
    }

    private RoutinesGrpc.RoutinesBlockingStub blockingStub;
    Response call(String target, Envelope envelope) throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forTarget(target)
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                // needing certificates.
                .usePlaintext()
                .build();
        blockingStub=RoutinesGrpc.newBlockingStub(channel);
        try {
            Response response=blockingStub.storeValue(envelope);
            return response;
        } finally {
            // ManagedChannels use resources like threads and TCP connections. To prevent leaking these
            // resources the channel should be shut down when it will no longer be used. If it may be used
            // again leave it running.
            channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
        }
    }
}
