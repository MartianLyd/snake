package com.kryocore.snake.crt.agent;

import com.kryocore.snake.SnakeApplication;
import com.kryocore.snake.crt.biz.fortune.FTChineseCrawler;
import com.kryocore.snake.crt.repository.ArticleRepository;
import com.kryocore.snake.crt.repository.CorpusRepository;
import com.kryocore.snake.crt.repository.NewsDetailRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Component
public class AgentTask {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(SnakeApplication.class);

    @Autowired
    NewsDetailRepository newsDetailRepository;

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    CorpusRepository corpusRepository;


    @Async("myTaskAsyncPool")
    public void execute() {
        try {

            long startTime = System.currentTimeMillis();

            int count = bizStart(String.valueOf(0));

            long endTime = System.currentTimeMillis();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public int bizStart(String sourceId) {
            //获取当前时间
        LocalDateTime localDateTime =LocalDateTime.now();
        logger.info("当前时间为:" + localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
//        SpringTaskB stb = new SpringTaskB();
//        stb.timerFixedDelay();

//        NewsDetail newsDetail = newsDetailRepository.findByNewsMark("377EDEC74B75DA2B6CE640C915A76CBF");
//        System.out.println(newsDetail.getTitle());
        logger.info("抓取开始" );
//        FTChineseCrawler ftChineseCrawler = new FTChineseCrawler(articleRepository,corpusRepository);
//        ftChineseCrawler.crawlArticle();
//        System.exit(0);

        return 0;
    }




}
