package com.kryocore.snake.crt.entity;


import com.kryocore.snake.crt.repository.NewsDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@EnableScheduling
public class SpringTaskB {

    @Autowired
    NewsDetailRepository newsDetailRepository;

    /*fixedDelay:上一次执行完毕时间点之后5秒再执行*/
//    @Scheduled(fixedDelay = 5000)
    public void timerFixedDelay() {

//        try {
//            Thread.sleep(100);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
        System.out.println(String.format("(fixedDelay)现在时间：%s", new Date()));

        NewsDetail newsDetail = newsDetailRepository.findByNewsMark("377EDEC74B75DA2B6CE640C915A76CBF");
        System.out.println(newsDetail.getTitle());

    }



}
