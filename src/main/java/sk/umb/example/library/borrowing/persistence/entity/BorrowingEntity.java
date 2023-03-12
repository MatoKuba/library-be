package sk.umb.example.library.borrowing.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.Date;

@Entity(name = "borrowing")
public class BorrowingEntity {
    @Id
    private Long id;
    private String BookDetailDTO;
    private String CustomerDetailDTO;
    private Date date;

    @ManyToOne
    private CustomerEntity customer;

    @ManyToOne
    private BookEntity bookEntity;

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public BookEntity getBookEntity() {
        return bookEntity;
    }

    public void setBookEntity(BookEntity bookEntity) {
        this.bookEntity = bookEntity;
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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


}
