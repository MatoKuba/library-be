package sk.umb.example.library.category.persistence.entity;

import jakarta.persistence.Entity;
import sk.umb.example.library.address.persistence.entity.AddressEntity;

@Entity(name = "category")
public class CategoryEntity {
    private AddressEntity address;
    private Long id;
    private String name;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAddress(AddressEntity address) {
        this.address = address;
    }
}
