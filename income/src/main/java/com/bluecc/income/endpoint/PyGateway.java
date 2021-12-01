package com.bluecc.income.endpoint;

import py4j.CallbackClient;
import py4j.GatewayServer;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import static com.bluecc.income.dummy.store.StoreModule.startup;
import static py4j.GatewayServer.*;

/**
 * $ just i endpoint.PyGateway
 */
public class PyGateway {
    public static void main(String[] args) {
        PyGateway gateway=startup(PyGateway.class);
        gateway.serve();
    }

    GatewayServer gateway;
    int port = DEFAULT_PORT;
    int callbackPort = DEFAULT_PYTHON_PORT;

    void serve(){
        InetAddress defaultAddress= null;
        try {
            defaultAddress = InetAddress.getByName("0.0.0.0");
            this.gateway = new GatewayServer(
                    this,
                    port, defaultAddress,
                    DEFAULT_CONNECT_TIMEOUT, DEFAULT_READ_TIMEOUT, null,
                    new CallbackClient(callbackPort, defaultAddress));

            gateway.start();
            System.out.println(String.format(" [✔] Gateway Server Started on port %d, callback %d", port, callbackPort));

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}
