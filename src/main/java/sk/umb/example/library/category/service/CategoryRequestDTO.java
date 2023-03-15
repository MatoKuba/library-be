package sk.umb.example.library.category.service;

public class CategoryRequestDTO {
    private String name;

    public Long getAddressId() {
        return addressId;
    }
    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }
    private Long addressId;
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}
