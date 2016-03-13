package no.ajaco.redditclone.control;

import no.ajaco.redditclone.entity.News;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.List;

@Stateless
public class NewsEJB {

    @PersistenceContext(name = "redditclone")
    private EntityManager em;

    public List<News> getAllNews(){
        return em.createNamedQuery(News.ALL_NEWS, News.class).getResultList();
    }

    public void createDummyArticle(String title) {
        News n = new News(title);
        em.persist(n);
    }
}
