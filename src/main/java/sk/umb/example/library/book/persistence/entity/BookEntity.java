package sk.umb.example.library.book.persistence.entity;

import jakarta.persistence.*;
import jdk.jfr.Category;
import sk.umb.example.library.address.persistence.entity.AddressEntity;

import java.util.Set;

@Entity(name = "book")
public class BookEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String authorFirstName;
    private String authorLastName;

    private String title;

    private String isbn;

    private int count;

    private Long categoryIds;

    @ManyToMany
    private AddressEntity address;
    @JoinTable(name="category_book",
            joinColumns=@JoinColumn(name="book_id"),
            inverseJoinColumns=@JoinColumn(name="category_id"))

    private Set<Category> categories;

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String AuthorFirstName) {
        this.authorFirstName = AuthorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String AuthorLastName) {
        this.authorLastName = AuthorLastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String Title) {
        this.title = Title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setCount(int count) {
        this.count += count;
    }

    public int getCount() {
        return count;
    }

    public void setCategoryIds(Long categoryIds) {
        this.categoryIds = categoryIds;
    }

    public Long getCategoryIds() {
        return categoryIds;
    }

}