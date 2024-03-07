package com.sample.amqp.reqreply;

import java.io.Serializable;
import java.util.Random;
import java.util.UUID;

public class MyMessage implements Serializable {

    int num;
    String correlationId;
    private static final long serialVersionUID = 1L;
	
    public MyMessage() {
        num = getRand();
        correlationId = UUID.randomUUID().toString();
    }
    private int getRand(){
        Random rand = new Random();
        return rand.nextInt(30);
    }

    public MyMessage(int num, String correlationId) {
        this.num = num;
        this.correlationId = correlationId;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    public int getNum() {
        return num;
    }

    public String getCorrelationId() {
        return correlationId;
    }
}
