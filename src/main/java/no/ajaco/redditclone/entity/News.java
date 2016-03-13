package no.ajaco.redditclone.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.GeneratedValue;

@Entity
@NamedQueries({
        @NamedQuery(name = News.HELLO_WORLD_NEWS_QUERY, query="SELECT n FROM News n WHERE n.title = 'Hello world'"),
        @NamedQuery(name = News.ALL_NEWS, query="SELECT n FROM News n")
})
public class News {

    public static final String ALL_NEWS = "allNews";
    public static final String HELLO_WORLD_NEWS_QUERY = "helloWorldNewsQuery";
    public static final String INSERT_DUMMY_ARTICLE = "insertDummyArticle";

    public News() {
    }

    public News(String title) {
        this.title = title;
    }

    @Id
    @GeneratedValue
    private long id;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    private String title;
}

