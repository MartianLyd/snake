package com.kryocore.snake.crt.utils;

/**
 * This file created at 2018年8月27日 下午4:58:42.
 *
 * Copyright (c) 2002-2015 kryocore, Inc. All rights reserved.
 */


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * TODO : document me
 * 
 * @author kryocore
 */
public class ElementsUtils {

	 /**
     * 获取文章列表
     */
    public static List<String> getArticleListFromUrl(String url) {
    	Document doc = null;
    	List<String> urlList = new ArrayList<String>();
        try {
        	doc = Jsoup.connect(url).userAgent(
            		"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36")
            		.timeout(8000).post();
	        Element element = doc.getElementById("share_con");
	        Elements aelements = element.getElementsByTag("a");
	        
	        String contentElement = null;
	        for(Element e : aelements) {
	        	contentElement = e.attr("href");
	        	if(contentElement != null && !contentElement.equals("")) {
	        		urlList.add(contentElement);
	        	}
	        }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return urlList;
    }
    
    /**
     * 获取指定文章列表
     */
    public static List<String> getArticleUpdateListFromUrl(String url) {
    	Document doc = null;
    	List<String> urlList = new ArrayList<String>();
        try {
        	doc = Jsoup.connect(url).userAgent(
            		"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36")
            		.timeout(8000).post();
//	        Element element = doc.getElementById("share_con");
	        Elements ulElements = doc.getElementsByClass("list-unit-1");
//	        Elements aelements = ulElements.getElementsByTag("ul");
	        
	        String contentElement = null;
	        for(Element e : ulElements) {
	        	Elements aelements = e.getElementsByTag("ul");
	        	 for(Element ee : aelements) {
	        		Elements aelementsin = ee.getElementsByTag("a");
	        		 for(Element eee : aelementsin) {
	        			 contentElement = eee.attr("href");
	        			 if(contentElement != null && !contentElement.equals("")) {
	 	 	        		urlList.add(contentElement);
	 	 	        	}
	        		 }
	 	        	
	 	        	
	 	        }
	        }
	        
        } catch (IOException e) {
            e.printStackTrace();
        }
        return urlList;
    }
    
    

    
    /**
     * 获取可可英语文章列表
     */
    public static List<String> getArticle21stListFromUrl(String url,String website) {
    	Document doc = null;
    	List<String> urlList = new ArrayList<String>();
        try {
//        	doc = Jsoup.connect(url).userAgent(
//            		"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36")
//            		.timeout(8000).post();
        	
        	
			Connection conn = Jsoup.connect(url).timeout(5000);
			conn.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
			conn.header("Accept-Encoding", "gzip, deflate, sdch");
			conn.header("Accept-Language", "zh-CN,zh;q=0.8");
			conn.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");
			doc = conn.execute().parse();
			
			Elements divElements = doc.getElementsByAttributeValue("style", "float:left; border:1px solid #dce1e5; padding:3px;");
	        
	        String contentElement = null;
	        
	        for(Element e : divElements) {
	        	contentElement = e.getElementsByTag("a").attr("href");
    			if(contentElement != null && !contentElement.equals("")) {
	 	        	urlList.add(website + contentElement);
	 	        }
	        }
	        
        } catch (IOException e) {
            e.printStackTrace();
        }
        return urlList;
    }

	/**
	 * 获取FT中文网文章列表
	 */
	public static List<String> getArticleFTChineseListFromUrl(String url,String website) {
		Document doc = null;
		List<String> urlList = new ArrayList<String>();
		try {
//        	doc = Jsoup.connect(url).userAgent(
//            		"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36")
//            		.timeout(8000).post();


			Connection conn = Jsoup.connect(url).timeout(5000);
			conn.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
			conn.header("Accept-Encoding", "gzip, deflate, sdch");
			conn.header("Accept-Language", "zh-CN,zh;q=0.8");
			conn.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");
			doc = conn.execute().parse();

			Elements h2Elements = doc.getElementsByTag("h2");
			String contentElement = null;

			for(Element e : h2Elements) {
				contentElement = e.getElementsByTag("a").attr("href");
				if(contentElement != null && !contentElement.equals("")) {
					urlList.add(website + contentElement);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return urlList;
	}
    
    
    
    /**
     * 获取本地文章列表
     */
    public static List<String> getArticleLocalHtmlFromUrl(String url) {
    	Document doc = null;
    	List<String> urlList = new ArrayList<String>();
//    	StringBuilder s = new StringBuilder("");
//    	try {
//	    	 File foutEN = new File("K:\\部署临时文件\\yty\\2018\\201808\\201808300912\\《中英對照讀新聞》- 自由電子報.html");
//	    	 FileInputStream fosEN = new FileInputStream(foutEN);
//	    	 InputStreamReader oswEN = new InputStreamReader(fosEN);
//	    	 BufferedReader br = new BufferedReader(oswEN);
//	         String line;
//	         while ((line = br.readLine()) != null) {
//	             s.append(line);
//	         }
//    	}catch(Exception e) {
//    		e.printStackTrace();
//    	}
        try {
//        	doc = Jsoup.connect(url).userAgent(
//            		"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36")
//            		.timeout(8000).post();
        	
        	
			Connection conn = Jsoup.connect(url).timeout(5000);
			conn.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
			conn.header("Accept-Encoding", "gzip, deflate, sdch");
			conn.header("Accept-Language", "zh-CN,zh;q=0.8");
			conn.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");
			doc = conn.execute().parse();

//        	doc = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(3000).post();
        	
//        	doc = Jsoup.parse(oswEN.openStream(), "UTF-8", url);
//        	doc = Jsoup.parse(s.toString());
        	
        	// //ul[@class='g-list']
	        Element element = doc.getElementById("content_english");
//	        Elements ulElements = doc.getElementsByClass("table_english");
	        Elements trElements = element.getElementsByTag("tr");
	        
	        String contentElement = null;
	        
	        for(Element e : trElements) {
//	        	Elements aelist = e.getElementsByTag("h3");
	        	contentElement = e.getElementsByTag("a").attr("href");
    			if(contentElement != null && !contentElement.equals("")) {
	 	        	urlList.add(contentElement);
	 	        }
	        }
	        
        } catch (Exception e) {
            e.printStackTrace();
        }
        return urlList;
    }
    
    
    /**
     * 获取英语巴士文章列表
     */
    public static List<String> getArticleEnBusListFromUrl(String url) {
    	Document doc = null;
    	List<String> urlList = new ArrayList<String>();
        try {
//        	doc = Jsoup.connect(url).userAgent(
//            		"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36")
//            		.timeout(8000).post();
        	
//			Connection conn = Jsoup.connect(url).timeout(5000);
//			conn.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
//			conn.header("Accept-Encoding", "gzip, deflate, sdch");
//			conn.header("Accept-Language", "zh-CN,zh;q=0.8");
//			conn.header("charset", "utf-8");
//			conn.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");
//			doc = conn.execute().parse();
			

//        	doc = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(3000).post();
        	doc = Jsoup.parse(new URL(url).openStream(), "GBK", url);
        	// //ul[@class='g-list']
//	        Element element = doc.getElementById("menu-list");
	        Elements ulElements = doc.getElementsByClass("g-list");
	        Elements liElements = ulElements.get(0).getElementsByTag("li");
	        
	        String contentElement = null;
	        
	        for(Element e : liElements) {
	        	Elements aelist = e.getElementsByTag("h3");
	        	contentElement = aelist.get(0).getElementsByTag("a").attr("href");
    			if(contentElement != null && !contentElement.equals("")) {
	 	        	urlList.add(contentElement);
	 	        }
	        }
	        
        } catch (IOException e) {
            e.printStackTrace();
        }
        return urlList;
    }
    
    
    /**
     * 获取英语巴士文章列表
     */
    public static List<String> getArticleChinaDayListFromUrl(String url) {
    	Document doc = null;
    	List<String> urlList = new ArrayList<String>();
        try {
//        	doc = Jsoup.connect(url).userAgent(
//            		"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36")
//            		.timeout(8000).post();
        	
//			Connection conn = Jsoup.connect(url).timeout(5000);
//			conn.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
//			conn.header("Accept-Encoding", "gzip, deflate, sdch");
//			conn.header("Accept-Language", "zh-CN,zh;q=0.8");
//			conn.header("charset", "utf-8");
//			conn.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");
//			doc = conn.execute().parse();
			

//        	doc = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(3000).post();
        	doc = Jsoup.parse(new URL(url).openStream(), "GBK", url);
        	// //ul[@class='g-list']
//	        Element element = doc.getElementById("menu-list");
	        Elements ulElements = doc.getElementsByClass("content_left");
	        Elements liElements = ulElements.get(0).getElementsByTag("div");
	        
	        String contentElement = null;
	        Elements pElements = liElements.get(0).getElementsByClass("gy_box_txt3");
	        for(Element e : pElements) {
	        	Elements aelist = e.getElementsByTag("a");
//	        	Elements pelist = aelist.get(0).getElementsByTag("p");
	        	contentElement = e.getElementsByTag("a").attr("href");
    			if(contentElement != null && !contentElement.equals("")) {
	 	        	urlList.add("https:" + contentElement);
	 	        }
	        }
	        
        } catch (IOException e) {
            e.printStackTrace();
        }
        return urlList;
    }
    
    /**
     * 获取自由时报文章列表
     */
    public static List<String> getArticleLibertyTimeNetListFromUrl(String url) {
    	Document doc = null;
    	List<String> urlList = new ArrayList<String>();
        try {
        	doc = Jsoup.connect(url).userAgent(
            		"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36")
            		.timeout(8000).post();
//        	doc = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(3000).post();
        	// //ul[@id="menu-list"]//h2//a[2]
	        Element element = doc.getElementById("content_english");
//	        Elements ulElements = doc.getElementsByClass("list-unit-1");
	        Elements aelements = element.getElementsByTag("tbody");
	        
	        String contentElement = null;
	        
	        for(Element e : aelements) {
	        	Elements aelist = e.getElementsByTag("a");
	        	contentElement = aelist.get(1).attr("href");
    			if(contentElement != null && !contentElement.equals("")) {
	 	        	urlList.add(contentElement);
	 	        }
	        }
	        
        } catch (IOException e) {
            e.printStackTrace();
        }
        return urlList;
    }
    
//    public static void main(String[] args) {
//    	String url = "http://www.tingclass.net/list-8555-1.html";
//    	getArticleUpdateListFromUrl(url);
//    }
}
