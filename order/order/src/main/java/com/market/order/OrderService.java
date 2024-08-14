package com.market.order;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    @Value("${message.queue.product}")
    private String productQueue;

    @Value("${message.queue.payment}")
    private String paymentQueue;

    private final RabbitTemplate rabbitTemplate;  // RabbitTemplate을 통해 메시지를 전송

    public void createOrder(String orderId) {
        // 제품 큐에 주문 ID를 전송
        rabbitTemplate.convertAndSend(productQueue, orderId);
        // 결제 큐에 주문 ID를 전송
        rabbitTemplate.convertAndSend(paymentQueue, orderId);
    }

}