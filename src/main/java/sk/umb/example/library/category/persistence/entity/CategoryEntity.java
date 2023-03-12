package sk.umb.example.library.category.persistence.entity;

import jakarta.persistence.Entity;

@Entity(name = "category")
public class CategoryEntity {
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
}
