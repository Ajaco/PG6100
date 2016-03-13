package no.ajaco.redditclone.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = Post.ALL_POSTS, query="SELECT p FROM Post p"),
        @NamedQuery(name = Post.POSTS_BY_NAME, query="SELECT p FROM Post p WHERE p.author.username LIKE :name")
})
public class Post {

    public static final String ALL_POSTS = "allPosts";
    public static final String POSTS_BY_NAME = "postsByName";

    public Post(String title, User author, PostType postType) {
        this.title = title;
        this.author = author;
        this.postType = postType;
    }

    public Post() {
    }

    @Id
    @GeneratedValue
    private int id;
    private String title;

    @ManyToOne
    private User author;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Comment> comments;

    @Enumerated(EnumType.STRING)
    private PostType postType;

    @Override
    public String toString() {
        return String.format("Post title: %s | Post author: %s | Post type: %s | Post comment count: %d", getTitle(), getAuthor().getUsername(), postType, getComments().size());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public PostType getPostType() {
        return postType;
    }

    public void setPostType(PostType postType) {
        this.postType = postType;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}

