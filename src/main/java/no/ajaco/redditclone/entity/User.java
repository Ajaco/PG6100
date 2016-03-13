package no.ajaco.redditclone.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    public User(String username, List<Comment> comments, List<Post> posts) {
        this.username = username;
        this.comments = comments;
        this.posts = posts;
    }

    public User() {
    }

    @Id
    @GeneratedValue
    private int id;
    private String username;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Comment> comments;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Post> posts;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
