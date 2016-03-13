package no.ajaco.redditclone.boundary;

import no.ajaco.redditclone.control.NewsEJB;
import no.ajaco.redditclone.entity.News;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@RequestScoped
@ManagedBean(name = "newsBoundary")
public class NewsBoundary {

    @Inject
    private NewsEJB newsEJB;


    public List<News> getAllNews() {
        return newsEJB.getAllNews();
    }

    public void createDummyArticle(String title) {
        System.out.println("Am i being invoked?");
        newsEJB.createDummyArticle(title);
    }
}
