package sk.example.umb.library.customer.controller;


import org.springframework.web.bind.annotation.*;


import java.awt.*;
import java.util.Collection;
import java.util.Collections;

@RestController
public class CustomerController {
    @GetMapping("/api/customers")
    public List searchCustomer(@RequestParam(required = false)String lastName){
        System.out.println("Search customer called:");
        return (List) Collections.emptyList();
    }

    @GetMapping("/api/customers/{customerId}")
    public void getCustomer(@PathVariable Long customerId){
        System.out.println("get customer called:");
    }

    @PostMapping("/api/customers")
    public void createCustomer(){
        System.out.println("create customer called:");
    }

    @PostMapping("/api/customers/{customerId}")
    public void updateCustomer(@PathVariable Long customerId){
        System.out.println("create customer called:" + customerId);
    }

    @DeleteMapping("/api/customers/{customerId}")
    public void deleteCustomer(@PathVariable Long customerId){
        System.out.println("delete customer called ID:" + customerId);
    }


}
