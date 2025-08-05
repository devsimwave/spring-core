package com.greedy.section04.circulardependency.fieldinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationService {
    @Autowired
    private OrderService orderService;

    public void sendNotification(String userId) {
        System.out.println("[" + userId + "] 알림 전송");
    }
}
