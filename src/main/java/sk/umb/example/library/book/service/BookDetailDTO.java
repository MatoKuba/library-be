package sk.umb.example.library.book.service;

public class BookDetailDTO {
    private Long id;
    private String authorFirstName;
    private String authorLastName;

    private String title;

    private int isbn;

    private int count;

    private Long categoryIds;

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

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
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