package web.test;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by fedosovmax on 11.02.16.
 */
@Entity
@Table(name = "NEWS")
public class News implements Serializable {


        private static final long serialVersionUID = -5527566248002296042L;

        @Id
        @Column(name = "ID_NEWS")
        @GeneratedValue
        private Integer idNews;

        @Column(name = "NAME")
        private String name;

        @Column(name = "BODY")
        private String body;

        @Column(name = "PUTDATE")
        private Date putdate;

        public Integer getIdNews() {
            return idNews;
        }

        public void setId(Integer idNews) {
            this.idNews = idNews;
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
                ", idNews=" + idNews +
                ", name='" + name + '\'' +
                ", putdate=" + putdate
                ;
         }


}

