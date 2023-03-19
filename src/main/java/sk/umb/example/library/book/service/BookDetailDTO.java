package sk.umb.example.library.book.service;

import sk.umb.example.library.address.service.AddressDetailDto;

public class BookDetailDTO {
    private Long id;
    private String authorFirstName;
    private String authorLastName;

    private String title;

    private String isbn;

    private int count;

    private CategoryDetailDTO categoryDetailDTO;

    private Set<CategoryDetailDTO> categories;

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

    public Set<CategoryDetailDTO> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategoryDetailDTO> categories) {
        this.categories = categories;
    }
}