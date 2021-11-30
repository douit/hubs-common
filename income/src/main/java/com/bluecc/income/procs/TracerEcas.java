package com.bluecc.income.procs;

import com.bluecc.hubs.fund.pubs.Condition;
import com.bluecc.hubs.fund.pubs.Eca;
import com.bluecc.hubs.fund.pubs.Ecas;
import com.bluecc.hubs.stub.Envelope;
import com.bluecc.income.exchange.IProc;
import com.google.protobuf.Message;
import reactor.util.function.Tuple2;

import java.util.function.Consumer;
import java.util.function.Function;

@Ecas
public class TracerEcas {
    @Eca("receiveEvent")
    @Condition("value!=empty && value!='hello'")
    public Function<Message, Envelope> info(){
        return e -> {
            System.out.println("receive -> "+e);
            return null;
        };
    }

    @Eca
    public Consumer<Message> trace(){
        return e -> {
            System.out.println("receive -> "+e);
        };
    }

    @Eca
    public Function<Tuple2<IProc.ProcContext, Message>, Envelope> store(){
        return e -> {
            return null;
        };
    }
}

