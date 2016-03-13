package no.ajaco.redditclone.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Comment {

    public Comment(String content, Date createdAt, Date updatedAt, User author, List<Comment> replies) {
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.author = author;
        this.replies = replies;
    }

    public Comment() {
    }

    @Id
    @GeneratedValue
    private int id;
    private String content;
    private Date createdAt;
    private Date updatedAt;

    @ManyToOne
    private User author;

    @OneToMany
    private List<Comment> replies;

    @ManyToOne
    private Post parentPost;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public List<Comment> getReplies() {
        return replies;
    }

    public void setReplies(List<Comment> replies) {
        this.replies = replies;
    }

    public Post getParentPost() {
        return parentPost;
    }

    public void setParentPost(Post parentPost) {
        this.parentPost = parentPost;
    }
}
