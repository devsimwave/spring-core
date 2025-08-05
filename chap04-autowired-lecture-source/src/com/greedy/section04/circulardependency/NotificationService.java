package com.greedy.section04.circulardependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationService {
    private final OrderService orderService;

    @Autowired
    public NotificationService(OrderService orderService) {
        this.orderService = orderService;
    }

    public void sendNotification(String userId) {
        System.out.println("[" + userId + "] 에게 알림 전송");
    }
}
