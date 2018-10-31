package com.kryocore.snake.crt.entity;


import javax.persistence.*;

/**
 * Created by kryocore on 2018/10/9.
 */
@Entity
@Table(name = "EN_ZN", schema = "", catalog = "TRANSLATION_CORPUS")
public class CorpusBean {

    private long id;
    private Long mainId;
    private String en_corpus;
    private String zn_corpus;

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
    @Column(name = "main_id")
    public Long getMainId() {
        return mainId;
    }

    public void setMainId(Long mainId) {
        this.mainId = mainId;
    }

    @Basic
    @Column(name = "en_corpus")
    public String getEn_corpus() {
        return en_corpus;
    }

    public void setEn_corpus(String en_corpus) {
        this.en_corpus = en_corpus;
    }

    @Basic
    @Column(name = "zn_corpus")
    public String getZn_corpus() {
        return zn_corpus;
    }

    public void setZn_corpus(String zn_corpus) {
        this.zn_corpus = zn_corpus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CorpusBean that = (CorpusBean) o;

        if (id != that.id) return false;
        if (mainId != that.mainId) return false;
        if (en_corpus != null ? !en_corpus.equals(that.en_corpus) : that.en_corpus != null) return false;

        return zn_corpus != null ? zn_corpus.equals(that.zn_corpus) : that.zn_corpus == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (mainId != null ? mainId.hashCode() : 0);
        result = 31 * result + (en_corpus != null ? en_corpus.hashCode() : 0);
        result = 31 * result + (zn_corpus != null ? zn_corpus.hashCode() : 0);

        return result;
    }
}
