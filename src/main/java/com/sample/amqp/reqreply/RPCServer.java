package com.sample.amqp.reqreply;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class RPCServer {

	@RabbitListener(queues = "reqerply.rpc.requests")
    public MyMessage fibonacci(MyMessage m){
        int num = m.getNum();
        String correlationId = m.getCorrelationId();
        System.out.println(" [x] received request for " + num + " - " + correlationId);
        int result = fib(num);
        System.out.println(" [.] returned " + result);
        MyMessage msg = new MyMessage(result, correlationId);
        return msg;
    }

    public int fib(int n){
        return n == 0 ? 0 : n == 1 ? 1 : (fib(n-1) + fib(n-2));
    }

}