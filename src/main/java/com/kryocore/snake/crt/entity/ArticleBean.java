package com.kryocore.snake.crt.entity;


import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * Created by kryocore on 2018/10/9.
 */
@Entity
@Table(name = "EN_ZN_SOURCE_DATA", schema = "", catalog = "TRANSLATION_CORPUS")
public class ArticleBean {

    private long id;
    private String en_title;
    private String zn_title;
    private Long newsId;
    private Long sourceId;
    private String url;
    private String addTime;
    private String sourceTime;
    private String crawlTime;
    private String newsMark;



    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "source_id")
    public Long getSourceId() {
        return sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    @Basic
    @Column(name = "source_time")
    public String getSourceTime() {
        return sourceTime;
    }

    public void setSourceTime(String sourceTime) {
        this.sourceTime = sourceTime;
    }

    @Basic
    @Column(name = "crawl_time")
    public String getCrawlTime() {
        return crawlTime;
    }

    public void setCrawlTime(String crawlTime) {
        this.crawlTime = crawlTime;
    }


    @Basic
    @Column(name = "mask")
    public String getNewsMark() {
        return newsMark;
    }

    public void setNewsMark(String newsMark) {
        this.newsMark = newsMark;
    }


    @Basic
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "add_time")
    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    @Basic
    @Column(name = "news_id")
    public Long getNewsId() {
        return newsId;
    }

    public void setNewsId(Long newsId) {
        this.newsId = newsId;
    }


    @Basic
    @Column(name = "en_title")
    public String getEn_title() {
        return en_title;
    }

    public void setEn_title(String en_title) {
        this.en_title = en_title;
    }

    @Basic
    @Column(name = "zn_title")
    public String getZn_title() {
        return zn_title;
    }

    public void setZn_title(String zn_title) {
        this.zn_title = zn_title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArticleBean that = (ArticleBean) o;

        if (id != that.id) return false;
        if (en_title != null ? !en_title.equals(that.en_title) : that.en_title != null) return false;
        if (zn_title != null ? !zn_title.equals(that.zn_title) : that.zn_title != null) return false;
        if (newsId != null ? !newsId.equals(that.newsId) : that.newsId != null) return false;
        if (sourceId != null ? !sourceId.equals(that.sourceId) : that.sourceId != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (addTime != null ? !addTime.equals(that.addTime) : that.addTime != null) return false;
        if (sourceTime != null ? !sourceTime.equals(that.sourceTime) : that.sourceTime != null) return false;
        if (crawlTime != null ? !crawlTime.equals(that.crawlTime) : that.crawlTime != null) return false;

        return newsMark != null ? newsMark.equals(that.newsMark) : that.newsMark == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (en_title != null ? en_title.hashCode() : 0);
        result = 31 * result + (zn_title != null ? zn_title.hashCode() : 0);
        result = 31 * result + (newsId != null ? newsId.hashCode() : 0);
        result = 31 * result + (sourceId != null ? sourceId.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (addTime != null ? addTime.hashCode() : 0);
        result = 31 * result + (sourceTime != null ? sourceTime.hashCode() : 0);
        result = 31 * result + (crawlTime != null ? crawlTime.hashCode() : 0);
        result = 31 * result + (newsMark != null ? newsMark.hashCode() : 0);
        return result;
    }
}
