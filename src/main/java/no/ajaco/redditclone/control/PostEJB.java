package no.ajaco.redditclone.control;

import no.ajaco.redditclone.entity.Comment;
import no.ajaco.redditclone.entity.Post;
import no.ajaco.redditclone.entity.PostType;
import no.ajaco.redditclone.entity.User;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Stateless
public class PostEJB {

    @PersistenceContext(name = "redditclone")
    private EntityManager em;

    public void createDummyArticle() {
        User u = new User();
        u.setUsername("Ajaco");
        em.persist(u);

        Comment c = new Comment();
        c.setAuthor(u);
        c.setContent("Ajacos first comment");
        c.setCreatedAt(new Date());
        c.setUpdatedAt(new Date());

        em.persist(c);

        Post p = new Post();
        p.setAuthor(u);
        p.setPostType(PostType.SELF);
        p.setTitle("Ajacos first post");
        List<Comment> postComments = new ArrayList<>();
        postComments.add(c);
        p.setComments(postComments);

        em.persist(p);

    }

    public String printContent() {
        Query q = em.createNamedQuery(Post.POSTS_BY_NAME).setParameter("name", "Ajaco");
        List<Post> posts = (List<Post>)q.getResultList();
        if(posts != null && posts.size() > 0){
            Post p = posts.get(0);
            return p.toString();
//            return "TITLE: " + posts.get(0).getTitle() + "\n Comments:" + posts.get(0).getComments().get(0).getContent() + " | Author: " + posts.get(0).getComments().get(0).getAuthor();
        } else return "";
    }
}
