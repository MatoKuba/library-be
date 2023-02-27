package sk.umb.example.library.borrowing.service;

public class BorrowingRequestDTO {
    private Long bookId;
    private Long UserId;

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getUserId() {
        return UserId;
    }

    public void setUserId(Long userId) {
        UserId = userId;
    }
}
