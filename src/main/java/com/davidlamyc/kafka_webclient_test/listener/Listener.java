package com.davidlamyc.kafka_webclient_test.listener;

import com.davidlamyc.kafka_webclient_test.controller.DummyController;
import com.davidlamyc.kafka_webclient_test.data.Dummy;
import com.davidlamyc.kafka_webclient_test.service.DummyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class Listener {
    @Autowired
    private DummyController dummyController;

    @KafkaListener(id = "foo", topics = "myTopic", clientIdPrefix = "myClientId")
    public void listen(Dummy dummy) {
        System.out.println(dummy);

        CompletableFuture.runAsync(() -> dummyController.dummyControllerFunc(dummy));
    }
}
