package sk.umb.example.library.borrowing.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class BorrowingController {
    @GetMapping("/api/borrowings")
    public void listResource(@RequestParam(required = false) String borrowingName) {
        System.out.println("Search item called.");
    }

    @GetMapping("/api/borrowings/{borrowingId}")
    public void retrieveDetail(@PathVariable Long borrowingId) {
        System.out.println("Get borrowing called.");
    }

    @PostMapping("/api/borrowings")
    public void createResource() {
        System.out.println("Create borrowing called:");
    }

    @PutMapping("/api/borrowings/{borrwoingId}")
    public void updateResource(@PathVariable Long customerId) {
        System.out.println("Update customer called: ID = " + customerId);
    }

    @DeleteMapping("/api/borrowings/{borrowingId}")
    public void deleteResource(@PathVariable Long borrowingId) {
        System.out.println("Delete borrowing called: ID = " + borrowingId);
    }
    
}

