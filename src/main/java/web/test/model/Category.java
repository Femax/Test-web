package web.test.model;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by fedosovmax on 15.02.16.
 */
@Entity
@Table(name = "CATEGORY")
public class Category implements Serializable {


    @Id
    @Column(name = "id")
    private Long id;

    private String name;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "categories")
    private List<News> news;

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

    public CategoryDTO toDTO(){
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setName(this.name);
        categoryDTO.setId(this.id);
        return categoryDTO;
    }
}
