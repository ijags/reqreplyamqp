package com.sample.amqp.reqreply;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;


public class RPCClient {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private DirectExchange directExchange;

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send(){

        MyMessage requestMsg = new MyMessage();
        System.out.println(" [x] requesting fib(" + requestMsg.getNum() + ")");

        MyMessage responseMsg = (MyMessage) rabbitTemplate.convertSendAndReceive
                        (directExchange.getName(),"rpc", requestMsg);

        System.out.println(" [.] got response '" + responseMsg.getNum() + "' - " + responseMsg.getCorrelationId() );
    }
}
