package com.davidlamyc.kafka_webclient_test.data;

public class Dummy {
    int myData;

    public int getMyData() {
        return myData;
    }

    public void setMyData(int myData) {
        this.myData = myData;
    }

    @Override
    public String toString() {
        return "Dummy{" +
                "myData=" + myData +
                '}';
    }
}
