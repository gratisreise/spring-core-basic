package com.example.springbasic;

import com.example.springbasic.member.Grade;
import com.example.springbasic.member.Member;
import com.example.springbasic.member.MemberService;
import com.example.springbasic.member.MemberServiceImpl;
import com.example.springbasic.order.Order;
import com.example.springbasic.order.OrderService;
import com.example.springbasic.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
        ApplicationContext applicationContext =
            new AnnotationConfigApplicationContext(AppConfig.class);
//        OrderService orderService = appConfig.orderService();
//        MemberService memberService = appConfig.memberService();

        OrderService orderService =
            applicationContext.getBean("orderService", OrderService.class);
        MemberService memberService =
            applicationContext.getBean("memberService", MemberService.class);

        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + order);
    }

}
