package com.bet.bet1.component;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsyncDemo {
    @Async
    public void demo(){
        try {
            System.out.println("Executing task..");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}
