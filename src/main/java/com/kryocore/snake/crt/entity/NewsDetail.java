package com.kryocore.snake.crt.entity;


import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * Created by lvshimin on 2017/6/7.
 */
@Entity
@Table(name = "NEWS", schema = "", catalog = "kryocore")
public class NewsDetail {


    private long id;
    private String title;
    private String content;
    private String picUrl;
    private String picPath;
    private Long sourceId;
    private String sourceTime;
    private String crawlTime;
    private String keyword;
    private String tag;
    private String newsMark;
    private String author;
    private String url;
    private String addTime;
    private String type;
    private String related;
    private Long newsId;
    private Double newsIndex;
    private String description;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Type(type="text")
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "pic_url")
    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    @Basic
    @Column(name = "pic_path")
    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
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

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Type(type="text")
    @Column(name = "keyword")
    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @Basic
    @Column(name = "tag")
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Basic
    @Column(name = "news_mark")
    public String getNewsMark() {
        return newsMark;
    }

    public void setNewsMark(String newsMark) {
        this.newsMark = newsMark;
    }

    @Basic
    @Column(name = "author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "related")
    public String getRelated() {
        return related;
    }

    public void setRelated(String related) {
        this.related = related;
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
    @Column(name = "news_index")
    public Double getNewsIndex() {
        return newsIndex;
    }

    public void setNewsIndex(Double newsIndex) {
        this.newsIndex = newsIndex;
    }



    @Basic
    @Column(name = "description")
    public String getDescription() { return description;}

    public void setDescription(String description) { this.description = description;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NewsDetail that = (NewsDetail) o;

        if (id != that.id) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (picUrl != null ? !picUrl.equals(that.picUrl) : that.picUrl != null) return false;
        if (picPath != null ? !picPath.equals(that.picPath) : that.picPath != null) return false;
        if (sourceId != null ? !sourceId.equals(that.sourceId) : that.sourceId != null) return false;
        if (sourceTime != null ? !sourceTime.equals(that.sourceTime) : that.sourceTime != null) return false;
        if (crawlTime != null ? !crawlTime.equals(that.crawlTime) : that.crawlTime != null) return false;
        if (keyword != null ? !keyword.equals(that.keyword) : that.keyword != null) return false;
        if (tag != null ? !tag.equals(that.tag) : that.tag != null) return false;
        if (newsMark != null ? !newsMark.equals(that.newsMark) : that.newsMark != null) return false;
        if (author != null ? !author.equals(that.author) : that.author != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (addTime != null ? !addTime.equals(that.addTime) : that.addTime != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (related != null ? !related.equals(that.related) : that.related != null) return false;
        if (newsId != null ? !newsId.equals(that.newsId) : that.newsId != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        return newsIndex != null ? newsIndex.equals(that.newsIndex) : that.newsIndex == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (picUrl != null ? picUrl.hashCode() : 0);
        result = 31 * result + (picPath != null ? picPath.hashCode() : 0);
        result = 31 * result + (sourceId != null ? sourceId.hashCode() : 0);
        result = 31 * result + (sourceTime != null ? sourceTime.hashCode() : 0);
        result = 31 * result + (crawlTime != null ? crawlTime.hashCode() : 0);
        result = 31 * result + (keyword != null ? keyword.hashCode() : 0);
        result = 31 * result + (tag != null ? tag.hashCode() : 0);
        result = 31 * result + (newsMark != null ? newsMark.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (addTime != null ? addTime.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (related != null ? related.hashCode() : 0);
        result = 31 * result + (newsId != null ? newsId.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (newsIndex != null ? newsIndex.hashCode() : 0);
        return result;
    }
}
