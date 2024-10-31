package com.davidlamyc.kafka_webclient_test.data;

public class TodosResponse {
    int userId;
    String title;
    boolean completed;
    int id;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TodosResponse{" +
                "userId=" + userId +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                ", id=" + id +
                '}';
    }
}
