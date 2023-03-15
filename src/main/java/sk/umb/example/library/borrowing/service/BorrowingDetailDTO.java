package sk.umb.example.library.borrowing.service;

import java.time.LocalDate;

public class BorrowingDetailDTO {
    private Long id;
    private String BookDetailDTO;
    private String CustomerDetailDTO;
    private LocalDate date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookDetailDTO() {
        return BookDetailDTO;
    }

    public void setBookDetailDTO(String bookDetailDTO) {
        BookDetailDTO = bookDetailDTO;
    }

    public String getCustomerDetailDTO() {
        return CustomerDetailDTO;
    }

    public void setCustomerDetailDTO(String customerDetailDTO) {
        CustomerDetailDTO = customerDetailDTO;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
