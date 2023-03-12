package sk.umb.example.library.book.service;

public class BookRequestDTO {
    private String authorFirstName;
    private String authorLastName;

    private String title;

    private int isbn;

    private int count;

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    private Long addressId;

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

    public void setIsbn(int ISBN) {
        this.isbn = ISBN;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setCount(int num) {
        this.count += num;
    }

    public int getCount() {
        return count;
    }

}