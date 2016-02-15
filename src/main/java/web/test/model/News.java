package web.test.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "NEWS")
public class News implements Serializable {
    private static final long serialVersionUID = -5527566248002296042L;

    @Id
    @GeneratedValue
    @Column(name="ID")
    private Long id;


    private String name;


    private String body;


    private Date putdate;




    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "news_category", catalog = "", joinColumns = {
            @JoinColumn(name = "NEWS_ID", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "CATEGORY_ID",
                    nullable = false, updatable = false) })
    private Set<Category> categories;


    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getPutdate() {
        return putdate;
    }

    public void setPutdate(Date putdate) {
        this.putdate = putdate;
    }

    @Override
    public String toString() {
        return
                "body='" + body + '\'' +
                        ", idNews=" + id +
                        ", name='" + name + '\'' +
                        ", putdate=" + putdate
                ;
    }

    public NewsDTO toDTO(){
        NewsDTO newsDTO = new NewsDTO();
        newsDTO.setIdNews(this.id);
        newsDTO.setName(this.name);
        newsDTO.setBody(this.body);
        newsDTO.setPutdate(this.putdate);
        return newsDTO;
    }
}

