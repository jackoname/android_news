package com.example.test.bean;

public class News {
    private int  newsid;
   private  String more;
    private  String cla;
    private  String title;

    public News(int newsid, String more, String cla, String title) {
        this.newsid = newsid;
        this.more = more;
        this.cla = cla;
        this.title = title;
    }
    public News( String title,String more, String cla) {
        this.more = more;
        this.cla = cla;
        this.title = title;
    }
    public News( String title,String more, String cla ,int newsid) {
        this.more = more;
        this.cla = cla;
        this.title = title;
        this.newsid =newsid;
    }
    public int getNewsid() {
        return newsid;
    }

    public void setNewsid(int newsid) {
        this.newsid = newsid;
    }

    public String getMore() {
        return more;
    }

    public void setMore(String more) {
        this.more = more;
    }

    public String getCla() {
        return cla;
    }

    public void setCla(String cla) {
        this.cla = cla;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
