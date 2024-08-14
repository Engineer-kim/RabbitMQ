package com.market.order;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderApplicationQueueConfig {

    @Value("${message.exchange}")
    private String exchange;

    @Value("${message.queue.product}")
    private String queueProduct;

    @Value("${message.queue.payment}")
    private String queuePayment;

    @Bean public TopicExchange exchange() { return new TopicExchange(exchange); }

    //메세지 큐 생성
    @Bean public Queue queueProduct() { return new Queue(queueProduct); }
    @Bean public Queue queuePayment() { return new Queue(queuePayment); }


    //이전에 생성한 큐 기반으로 바인딩(통신 설정)
    @Bean public Binding bindingProduct() { return BindingBuilder.bind(queueProduct()).to(exchange()).with(queueProduct); }
    @Bean public Binding bindingPayment() { return BindingBuilder.bind(queuePayment()).to(exchange()).with(queuePayment); }
}