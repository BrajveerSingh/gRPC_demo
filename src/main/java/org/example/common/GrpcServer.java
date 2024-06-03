package org.example.common;

import io.grpc.BindableService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.ServerServiceDefinition;
import io.grpc.ServiceDescriptor;
import org.example.sec06.BankService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Arrays;

public class GrpcServer {
    private static final Logger LOGGER = LoggerFactory.getLogger(GrpcServer.class);

    private final Server server;

    public GrpcServer(final Server server){
        this.server = server;
    }

    public static GrpcServer create(final BindableService... services){
        return create(6565, services);
    }
    public static GrpcServer create(final int port, final BindableService... services){
        var builder = ServerBuilder.forPort(port);
        Arrays.asList(services).forEach(
                service -> builder.addService(service)
        );
        return new GrpcServer(builder.build());
    }

    public GrpcServer start() {
        var services = server.getServices()
                .stream()
                .map(ServerServiceDefinition::getServiceDescriptor)
                .map(ServiceDescriptor::getName)
                .toList();
        try{
            server.start();
            LOGGER.info("Server started. listening on port {}, services: {}",
                    server.getPort(), services);
            return this;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void await() {
        try {
            server.awaitTermination();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void stop() {
        server.shutdownNow();
        LOGGER.info("Server is stopped.");
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        var server = ServerBuilder.forPort(6565)
                .addService(new BankService())
                .build();
        server.start();
        server.awaitTermination();
    }
}
