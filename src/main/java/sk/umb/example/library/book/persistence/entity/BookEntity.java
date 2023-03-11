package sk.umb.example.library.book.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import sk.umb.example.library.address.persistence.entity.AddressEntity;

@Entity(name = "book")
public class BookEntity {
    @Id
    @GeneratedValue
    private Long id;


    @ManyToOne
    private AddressEntity address;

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

}