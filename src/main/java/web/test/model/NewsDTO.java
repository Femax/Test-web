package web.test.model;

import java.util.Date;

/**
 * Created by fedosovmax on 15.02.16.
 */
public class NewsDTO {

    private Long idNews;


    private String name;


    private String body;


    private Date putdate;


    private String category;

    public Long getIdNews() {
        return idNews;
    }

    public void setIdNews(Long idNews) {
        this.idNews = idNews;
    }

    public Date getPutdate() {
        return putdate;
    }

    public void setPutdate(Date putdate) {
        this.putdate = putdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
