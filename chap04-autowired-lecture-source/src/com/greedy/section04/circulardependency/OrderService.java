package com.greedy.section04.circulardependency;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

    private final NotificationService notificationService;

    @Autowired
    public OrderService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void completeOrder() {
        System.out.println("주문 완료");
        notificationService.sendNotification("user123");
    }

}
