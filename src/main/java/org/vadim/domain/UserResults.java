package org.vadim.domain;

import javax.persistence.*;

@Entity
@Table(name = "us_res")
public class UserResults {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private Integer result;
    private String date;

    //@ManyToOne(fetch = FetchType.EAGER)
    //@JoinColumn(name = "user_id")
    //private User author;
    private String authorName;


    public UserResults(Integer result, String username, String date) {
        this.result = result;
        this.date = date;
        this.authorName = username;
    }

    public UserResults() {
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
