package com.sample.amqp.reqreply;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile({"reqreply", "rpc"})
@Configuration
public class RPCConfig {

    @Profile("client")
    private static class ClientConfig {

        @Bean
        DirectExchange directExchange(){
            return new DirectExchange("reqerply.rpc");
        }

        @Bean
        RPCClient client(){
            return new RPCClient();
        }
    }

    @Profile("server")
    private static class ServerConfig {
        @Bean
        Queue queue(){
            return new Queue("reqerply.rpc.requests");
        }

        @Bean
        DirectExchange directExchange(){
            return new DirectExchange("reqerply.rpc");
        }

        @Bean
        Binding binding(DirectExchange directExchange, Queue queue){
            return BindingBuilder.bind(queue).to(directExchange).with("rpc");
        }

        @Bean
        RPCServer server() { return new RPCServer();}
    }

}
