package com.kryocore.snake.crt.biz.fortune;

import com.hankcs.hanlp.HanLP;
import com.kryocore.snake.crt.entity.ArticleBean;
import com.kryocore.snake.crt.entity.CorpusBean;
import com.kryocore.snake.crt.repository.ArticleRepository;
import com.kryocore.snake.crt.repository.CorpusRepository;
import com.kryocore.snake.crt.utils.DateUtil;
import com.kryocore.snake.crt.utils.MD5Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * FT中文网
 * 数据源id 8
 */
@Component
public class FTChineseCrawler {

//    @Autowired
//    ArticleRepository articleRepository;

    private static final Logger logger = LoggerFactory.getLogger(FTChineseCrawler.class);
    public static final Object signal = new Object();// 线程间通信
    private static Long sourceId = 8L;// FT中文网
    private static String website = "http://www.ftchinese.com";
    private static String chromdriver="./chromedriver.exe";
    private static String crawlerUrl = "http://www.ftchinese.com/channel/ce.html";
    ArticleRepository articleRepository;
    CorpusRepository corpusRepository;

    public FTChineseCrawler(){
    }

    public FTChineseCrawler(ArticleRepository articleRepository, CorpusRepository corpusRepository){
        this.articleRepository = articleRepository;
        this.corpusRepository = corpusRepository;
    }

    /**
     * 获取文章链接
     * @return
     */
    public List<WebElement> getArticleByChannel(WebDriver driver){
        driver.get(crawlerUrl);
        return driver.findElements(By.xpath("//h2/a"));
    }

    /**
     * 解析文章
     * @return
     */
    public void parseArticle(List<WebElement> webElements,WebDriver driver){

        for(int k = 0;k<webElements.size();k++){

            try{
                String url = webElements.get(k).getAttribute("href");
//                String url = "http://www.ftchinese.com/story/001079550/ce?adchannelID=1100";
                logger.info("url: " + url);
                ArticleBean ab = articleRepository.findByNewsMark(MD5Tools.MD5(url));
                if(ab == null){
                }else{
                    continue;
                }


                //开始解析页面
                driver.get(url);

                ArticleBean arb = new ArticleBean();
                ArticleBean result=null;
                WebElement titleElement =  driver.findElement(By.xpath("//h1"));
                List<WebElement> corElement3 =  driver.findElements(By.xpath("//div[@id='story-body-container']/div"));
                System.out.println("title: " + titleElement.getText());
                arb.setEn_title(titleElement.getText());
                arb.setSourceId(sourceId);
                arb.setUrl(url);
                arb.setNewsMark(MD5Tools.MD5(url));
                arb.setAddTime(DateUtil.getDateStr(new Date()));
                result = articleRepository.save(arb);


                List<CorpusBean> corpusList = new ArrayList<CorpusBean>();
                CorpusBean corpus = null;

                List<String> pStringList = new ArrayList<>();
                for(int q = 0;q< corElement3.size();q++) {
                    if(!corElement3.get(q).getText().trim().equals("")
                            && !corElement3.get(q).getText().contains("译者/")){
//                        corElement3.remove(q);
                        pStringList.add(corElement3.get(q).getText());
                    }
                }


                for(int g = 0;g< pStringList.size();g++) {
                    if(g%2 == 0) {
                        corpus = new CorpusBean();
                        corpus.setEn_corpus(pStringList.get(g));
                        corpusList.add(corpus);
                    }else {
                        if(corpusList.get(corpusList.size()-1).getZn_corpus() == null ||
                                corpusList.get(corpusList.size()-1).getZn_corpus().equals("")) {
                            corpusList.get(corpusList.size()-1).setZn_corpus(HanLP.convertToSimplifiedChinese(pStringList.get(g)));
                            System.out.println(corpusList.get(corpusList.size()-1).getEn_corpus());
                            System.out.println(corpusList.get(corpusList.size()-1).getZn_corpus());
                        }
                    }
                }

                for(int m = 0;m<corpusList.size();m++){
                    corpusList.get(m).setMainId(result.getId());
                    if(corpusList.get(m).getZn_corpus() == null
                            ||corpusList.get(m).getZn_corpus().trim().equals("")
                            ||corpusList.get(m).getEn_corpus() == null
                            ||corpusList.get(m).getEn_corpus().trim().equals("")){
                        continue;
                    }else{
                        corpusRepository.save(corpusList.get(m));
                    }

                }

                System.out.println("---------");
            } catch(Exception e){

//                e.printStackTrace();
            }

        }
    }

    public void crawlArticle() {
        System.setProperty("webdriver.chrome.driver", chromdriver);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");

        WebDriver driverChannel =new ChromeDriver(options);
        WebDriver driverArticle =new ChromeDriver(options);

        //获取文章链接
        List<WebElement> articleElement = getArticleByChannel(driverChannel);
        //解析文章
        parseArticle(articleElement,driverArticle);

    }
}
