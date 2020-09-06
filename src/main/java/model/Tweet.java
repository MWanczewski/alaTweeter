package model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tweet")
public class Tweet {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private long id;

  @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
  @JoinColumn(name = "id_author")
  private AppUser author;

  @Column(name = "published_at")
  @CreationTimestamp
  private Date publishedAt;

  @Column(name = "message")
  private String message;

  public Tweet() {
  }

  public Tweet(AppUser author, String message) {
    this.message = message;
    this.author = author;
  }

  public long getId() {
    return id;
  }

  public AppUser getAuthor() {
    return author;
  }

  public void setAuthor(AppUser author) {
    this.author = author;
  }

  public Date getPublishedAt() {
    return publishedAt;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public void setId(long id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "Tweet{" +
            "id=" + id +
            ", author=" + author +
            ", publishedAt=" + publishedAt +
            ", message='" + message + '\'' +
            '}';
  }
}
