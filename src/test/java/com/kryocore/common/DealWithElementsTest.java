package  com.kryocore.common;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


/**
 *
 * TODO : document me
 *
 * @author kryocore
 */
public class DealWithElementsTest {

//    private static String url = "http://news.hexun.com/2018-10-09/194667886.html";
    private static String url = "http://news.hexun.com/2018-10-18/194919527.html";
    private static String chromdriver="E:\\chromedriver.exe";
    private static WebDriver driver ;

    public static void init(){
        System.setProperty("webdriver.chrome.driver", chromdriver);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
//        options.addExtensions(new File(""));
//        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//        capabilities.setCapability("chrome.switches", Arrays.asList("--start-maximized"));
//        options.addArguments("--test-type", "--start-maximized");

        driver=new ChromeDriver(options);
        // max size the browser
//        driver.manage().window().maximize();
//        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    public static void main(String[] args) throws Exception {
        init();
        driver.get(url);


//        List<WebElement> pElement = driver.findElements(By.cssSelector("div#articleContent.details"));
//        List<WebElement> pElement = driver.findElements(By.cssSelector("p"));
//        String ruleKey = "div.txt-14 p";
//        List<WebElement> pElement = driver.findElements(By
//                .xpath(ruleKey));
//        Document doc = Jsoup.parse(driver.getPageSource());
//        List<Element> elist =  doc.select("p");
//        Element e =  doc.select("." + "Content").first();
        //ID类型
//        String ruleKey = "article";
//        WebElement webElement ;
//        try {
//            webElement = driver.findElement(By.cssSelector("div#article"));
//        } catch (Exception e) {
//            e.printStackTrace();
//            try {
//                webElement = driver.findElement(By.cssSelector("div#artibody"));
//                ruleKey = "artibody";
//            } catch (Exception e1) {
//
//            }
//        }

        WebElement container = null ;
        try {
            container = driver.findElement(By.cssSelector("div.art_contextBox"));
        } catch (Exception e) {

        }

        System.out.println(container.getText());
        System.out.println("-------------------");
        String result = "";
        if(driver != null){

            List<WebElement> ps = driver.findElements(By.tagName("p"));
            for(WebElement p : ps) {
                result += p.getText() + "\n";
            }
            System.out.println(result);
        }

//        List<WebElement> imgElement2 =  driver.findElements(By.xpath("//div[@class='img_wrapper']/img"));
//		  for(WebElement iwe:imgElement2) {
//			  System.out.println(iwe.getAttribute("src") );
//		  }
//
//        System.out.println("---------" + ruleKey);
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
//
        delay(10);

        driver.quit();
    }

    /**
     * 获取窗口属性
     */
    public void windowsProperties(){
        String defaultWindow = driver.getWindowHandle();
        WebElement myLink = driver.findElement(By
                .linkText("Copyright 2015 to be crazy"));
        Set<String> currentWindows = driver.getWindowHandles();
        System.out.println(currentWindows.size());
        for (String window : currentWindows) {
            if (!window.endsWith(defaultWindow)) {
                driver = driver.switchTo().window(window);
                driver.manage().timeouts()
                        .pageLoadTimeout(60, TimeUnit.SECONDS);
                driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                break;
            }
        }

        Assert.assertTrue(driver.getCurrentUrl().contains("tobecrazy"));
    }

    public static void delay(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
