package sk.umb.example.library.borrowing.service;

import java.util.Date;

public class BorrowingDetailDTO {
    private Long id;
    private String BookDetailDTO;
    private String CustomerDetailDTO;
    private Date date;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
