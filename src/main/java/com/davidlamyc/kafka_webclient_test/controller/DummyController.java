package com.davidlamyc.kafka_webclient_test.controller;

import com.davidlamyc.kafka_webclient_test.data.Dummy;
import com.davidlamyc.kafka_webclient_test.service.DummyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.concurrent.CompletableFuture;

@Controller
public class DummyController {
    @Autowired
    DummyService service;

    public CompletableFuture<Void> dummyControllerFunc(Dummy dummy) {
        for (int i = 1; i < dummy.getMyData(); i++) {
            service.dummy(dummy);
            System.out.println("done");
        };
        CompletableFuture completableFuture = new CompletableFuture();
        completableFuture.complete(null);
        return completableFuture;
    }
}
