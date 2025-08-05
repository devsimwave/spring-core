package com.greedy.section04.circulardependency.fieldinjection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

    @Autowired
    private NotificationService notificationService;

    public void completeOrder() {
        System.out.println("주문 완료 처리");
        notificationService.sendNotification("user123");
    }

}
