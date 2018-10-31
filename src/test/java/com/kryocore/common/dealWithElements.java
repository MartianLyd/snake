/**
 * This file created at 2018年8月30日 下午5:46:05.
 *
 * Copyright (c) 2002-2015 kryocore, Inc. All rights reserved.
 */
package com.kryocore.common;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.kryocore.snake.crt.utils.ElementsUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.gargoylesoftware.htmlunit.javascript.host.file.File;

//import com.packt.webdriver.chapter3.DriverFactory;

/**
 *
 * TODO : document me
 * 
 * @author kryocore
 */
public class dealWithElements {

    public static void main(String[] args) throws Exception {
        String URL = "http://www.ftchinese.com/story/001079621/ce?ccode=LanguageSwitch&archive";
        String chromdriver="./chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromdriver);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
//        options.addExtensions(new File(""));
//        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//        capabilities.setCapability("chrome.switches",
//                Arrays.asList("--start-maximized"));
//        options.addArguments("--test-type", "--start-maximized");
        WebDriver driver=new ChromeDriver(options);
        WebDriver driver2=new ChromeDriver(options);

        String crawlerUrl = "http://www.ftchinese.com/channel/ce.html";
//        List<String> urlList = ElementsUtils.getArticleFTChineseListFromUrl(crawlerUrl,"");

        driver.get(crawlerUrl);
        List<WebElement> imgElement2 =  driver.findElements(By.xpath("//h2/a"));



        for(int k = 0;k<imgElement2.size();k++){

            try{
                String url = imgElement2.get(k).getAttribute("href");
                System.out.println("url: " + url);
//                imgElement2.get(k).click();
//                url = url.replace("?","/ce?ccode=LanguageSwitch&");
                driver2.get(url);
                List<WebElement> imgElement3 =  driver2.findElements(By.xpath("//div[@id='story-body-container']"));
                for(WebElement iwe:imgElement3) {
                    System.out.println(iwe.getText() );
                }

                System.out.println("---------");
            } catch(Exception e){

            }

        }

        // max size the browser
//        driver.manage().window().maximize();
//        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        
//        List<WebElement> pElement = driver.findElements(By.cssSelector("div#articleContent.details"));
//        List<WebElement> pElement = driver.findElements(By.cssSelector("p"));
//        String ruleKey = "div.txt-14 p";
//        List<WebElement> pElement = driver.findElements(By
//                .xpath(ruleKey));
//        Document doc = Jsoup.parse(driver.getPageSource());
//        List<Element> elist =  doc.select("p");
//        Element e =  doc.select("." + "Content").first();
//        List<WebElement> imgElement2 =  driver.findElements(By.xpath("//div[@id='story-body-container']"));
//		  for(WebElement iwe:imgElement2) {
//			  System.out.println(iwe.getText() );
//		  }
//
//		  System.out.println("---------");
//        for(WebElement webElement:pElement) {
//        	List<WebElement> pel = webElement.findElements(By.xpath("//div[@id='articleContent']/p"));
//        	  for(WebElement we:pel) {
//        		 
//        		  List<WebElement> imgElement =  we.findElements(By.xpath("//div[@id='articleContent']/p/a/img"));
//        		  for(WebElement iwe:imgElement) {
//        			  System.out.println(iwe.getAttribute("src"));
//        		  }
//        		  
//        	  }
//           
////        	System.out.println("contentHtml: "+webElement.outerHtml());
//        }
        
//        System.out.println("contentHtml: "+e.outerHtml());


//        WebElement upload = driver.findElement(By
//                .xpath("//td/input[@type='file']"));
//        upload.sendKeys("C:/Users/Young/Desktop/demo.html");
//        Assert.assertTrue(upload.getAttribute("value").contains("demo"));
//        // for alert
//        WebElement clickOnAlert = driver.findElement(By
//                .xpath("//td/input[@name='alterbutton']"));
//        clickOnAlert.click();
//        delay(2);
//        // get alert
//        Alert alert = driver.switchTo().alert();
//        Assert.assertTrue(alert.getText().contains("alert"));
//        // click alert ok
//        alert.accept();
//
//        delay(2);
//        // for prompt
//        WebElement clickOnPrompt = driver.findElement(By
//                .xpath("//td/input[@name='promptbutton']"));
//        clickOnPrompt.click();
//        delay(2);
//        Alert prompt = driver.switchTo().alert();
//
//        prompt.sendKeys("I love Selenium");
//        prompt.accept();
//        delay(5);
//        Alert afterAccept = driver.switchTo().alert();
//        Assert.assertTrue(afterAccept.getText().contains("I love Selenium"));
//        // click alert ok
//        afterAccept.accept();
//        delay(2);
//        // for confirm
//        WebElement clickOnConfirm = driver.findElement(By
//                .xpath("//td/input[@name='confirmbutton']"));
//        clickOnConfirm.click();
//        delay(2);
//        Alert confirm = driver.switchTo().alert();
//        confirm.dismiss();
//        delay(2);
//        Alert afterDismiss = driver.switchTo().alert();
//        Assert.assertTrue(afterDismiss.getText().contains("You pressed Cancel"));
//        delay(2);
//        afterDismiss.accept();
//        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//
//        WebElement selector = driver.findElement(By.id("Selector"));
//        Select select = new Select(selector);
//        select.selectByIndex(3);
//        select.selectByVisibleText("桃子");
//        select.selectByValue("apple");
//
//        System.out.println(select.getAllSelectedOptions().toString());
//        delay(2);
//        WebElement showSelectResult = driver.findElement(By
//                .name("showSelectResult"));
//        showSelectResult.click();
//        delay(2);
//        Alert yourSelect = driver.switchTo().alert();
//        Assert.assertTrue(yourSelect.getText().contains("苹果"));
//
//        delay(2);
//        yourSelect.accept();
//
//        // input box
//        WebElement editBox = driver.findElement(By
//                .xpath("//td/input[@id='edit']"));
//        editBox.sendKeys("Selenium is good");
//        WebElement submitButton = driver.findElement(By
//                .xpath("//input[@type='button' and @name='submit']"));
//        submitButton.click();
//        delay(2);
//        Alert submitAlert = driver.switchTo().alert();
//        Assert.assertEquals(submitAlert.getText(), "Selenium is good");
//        submitAlert.accept();
//        delay(2);
//
//        // for radio Box
//
//        WebElement duRadioBox = driver.findElement(By
//                .cssSelector("div#radio>input.Baidu"));
//        WebElement aLiRadioBox = driver.findElement(By
//                .cssSelector("div#radio>input.Alibaba"));
//        WebElement TXRadioBox = driver.findElement(By
//                .cssSelector("div#radio>input.Tencent"));
//        WebElement MiRadioBox = driver.findElement(By
//                .cssSelector("div#radio>input.Mi"));
//        delay(2);
//        Assert.assertTrue(TXRadioBox.isSelected());
//        Assert.assertTrue(!MiRadioBox.isEnabled());
//        delay(2);
//        duRadioBox.click();
//        Assert.assertTrue(duRadioBox.isSelected());
//        delay(2);
//
//        aLiRadioBox.click();
//        Assert.assertTrue(aLiRadioBox.isSelected());
//        delay(2);
//
//        // for checkBox
//
//        List<WebElement> webCheckBox = driver.findElements(By
//                .xpath("//input[@type='checkbox']"));
//
//        for (WebElement e : webCheckBox) {
//            e.click();
//            Assert.assertTrue(e.isSelected());
//            delay(2);
//        }
//
//        // for links
//        String defaultWindow = driver.getWindowHandle();
//        WebElement myLink = driver.findElement(By
//                .linkText("Copyright 2015 to be crazy"));
//        delay(3);
//        // scroll to mylink
//        JavascriptExecutor scroll = (JavascriptExecutor) driver;
//        scroll.executeScript("arguments[0].scrollIntoView();", myLink);
//        // open link in a new windows press shift when you click
//        delay(2);
//        Actions actions = new Actions(driver);
//        actions.keyDown(Keys.SHIFT).click(myLink).perform();
//
//        delay(3);
//        Set<String> currentWindows = driver.getWindowHandles();
//        System.out.println(currentWindows.size());
//        for (String window : currentWindows) {
//            if (!window.endsWith(defaultWindow)) {
//                driver = driver.switchTo().window(window);
//                driver.manage().timeouts()
//                        .pageLoadTimeout(60, TimeUnit.SECONDS);
//                driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//                break;
//            }
//        }
//
//        Assert.assertTrue(driver.getCurrentUrl().contains("tobecrazy"));
        delay(3);

        driver.quit();
    }

    /**
     * @author Young
     * @param seconds
     */
    public static void delay(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
