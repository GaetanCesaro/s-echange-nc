package com.gegette.sechangenc.model;

import io.micrometer.core.lang.NonNull;

import javax.persistence.*;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", insertable = false, updatable = false)
    private Long id;

    @NonNull
    @Column(nullable = false, name = "TITLE")
    private String title;

    @NonNull
    @Column(nullable = false, name = "DESCRIPTION")
    private String description;

    @NonNull
    @Column(nullable = false, name = "PRICE")
    private int price;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false, updatable = false)
    private User owner;

    public Post() {
    }

    public Post(String title, String description, int price, User owner) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post Post = (Post) o;

        return id.equals(Post.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", owner=" + owner +
                '}';
    }
}