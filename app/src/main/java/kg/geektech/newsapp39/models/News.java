package kg.geektech.newsapp39.models;

import java.io.Serializable;

public class News implements Serializable {
    private String title;
    private String createdAT;

    public News(String title, String createdAT) {
        this.title = title;
        this.createdAT = createdAT;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreatedAT() {
        return createdAT;
    }

    public void setCreatedAT(String createdAT) {
        this.createdAT = createdAT;
    }
}
