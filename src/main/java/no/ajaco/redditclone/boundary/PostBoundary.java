package no.ajaco.redditclone.boundary;

import no.ajaco.redditclone.control.PostEJB;
import no.ajaco.redditclone.entity.Post;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
@ManagedBean(name = "postBoundary")
public class PostBoundary {

    @Inject
    private PostEJB postEJB;

    public void createDummyArticle() {
        postEJB.createDummyArticle();
    }

    public String printContent() {
        String s = postEJB.printContent();
        return postEJB.printContent();
    }
}
