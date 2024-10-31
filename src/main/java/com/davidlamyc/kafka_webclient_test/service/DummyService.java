package com.davidlamyc.kafka_webclient_test.service;

import com.davidlamyc.kafka_webclient_test.data.Dummy;
import com.davidlamyc.kafka_webclient_test.data.TodosRequest;
import com.davidlamyc.kafka_webclient_test.data.TodosResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Collections;

@Service
public class DummyService {
    @Autowired
    @Qualifier("myWebClient")
    private WebClient client;

    public ResponseEntity<TodosResponse> dummy(Dummy dummy) {
        TodosRequest todosRequest = new TodosRequest();
        todosRequest.setCompleted(false);
        todosRequest.setTitle("foo");
        todosRequest.setUserId(dummy.getMyData());

        System.out.println("Sending..." + todosRequest.toString());

        return client.post()
                .uri("/todos")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(todosRequest), TodosRequest.class)
                .retrieve()
                .toEntity(TodosResponse.class).block();
    }
}
