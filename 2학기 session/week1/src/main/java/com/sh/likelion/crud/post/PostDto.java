package com.sh.likelion.crud.post;

public class PostDto {
    private String title;
    private String content;
    private String writer;

    private PostDto(){};

    public PostDto(String title, String content, String writer){
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString(){
        return "PostDto{" +
                "title="+title+'|'+
                ", content="+content+'|'+
                ", writer="+writer+'|'+
                "}";
    }
}
