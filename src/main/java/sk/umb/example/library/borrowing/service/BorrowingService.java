package sk.umb.example.library.borrowing.service;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import sk.umb.example.library.address.persistence.repository.AddressRepository;
import sk.umb.example.library.book.persistence.entity.BookEntity;
import sk.umb.example.library.book.persistence.repository.BookRepository;
import sk.umb.example.library.borrowing.persistence.entity.BorrowingEntity;
import sk.umb.example.library.borrowing.persistence.repository.BorrowingRepository;
import sk.umb.example.library.customer.persistence.entity.CustomerEntity;
import sk.umb.example.library.customer.persistence.repository.CustomerRepository;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BorrowingService {
    private final BorrowingRepository borrowingRepository;
    private final AddressRepository addressRepository;
    private final BookRepository bookRepository;
    private final CustomerRepository customerRepository;


    public BorrowingService(BorrowingRepository borrowingRepository, AddressRepository addressRepository, BookRepository bookRepository, CustomerRepository customerRepository) {
        this.borrowingRepository = borrowingRepository;
        this.addressRepository = addressRepository;
        this.bookRepository = bookRepository;
        this.customerRepository = customerRepository;
    }

    public List<BorrowingDetailDTO> getAllBorrowings() {
        return mapToDTOList(borrowingRepository.findAll());
    }

    public List<BorrowingDetailDTO> getBorrowingsByUserId(Long userId) {
        return mapToDTOList(borrowingRepository.findByUserId(userId));
    }

    @Transactional
    public void borrowBook(BorrowingRequestDTO borrowingRequestDTO){
        BorrowingEntity borrowing = new BorrowingEntity();

        Optional<BookEntity> bookEntityOptional = bookRepository.findById(borrowingRequestDTO.getBookId());
        if(!bookEntityOptional.isPresent()) {
            // Handle book not found error
        }
        BookEntity bookEntity = bookEntityOptional.get();
        borrowing.setBookEntity(bookEntity);

        Optional<CustomerEntity> customerEntityOptional = customerRepository.findById(borrowingRequestDTO.getUserId());
        if (!customerEntityOptional.isPresent()) {
            // Handle customer not found error
        }
        CustomerEntity customerEntity = customerEntityOptional.get();
        borrowing.setCustomer(customerEntity);

        borrowing.setDate(LocalDate.now());

        borrowingRepository.save(borrowing);

        bookEntity.setCount(bookEntity.getCount() - 1);
        bookRepository.save(bookEntity);
    }


    @Transactional
    public void returnBook(Long borrowingId){
        Optional<BorrowingEntity> borrowing = borrowingRepository.findById(borrowingId);

        BookEntity book = borrowing.get().getBookEntity();

        borrowingRepository.deleteById(borrowingId);

        book.setCount(book.getCount() + 1);
        bookRepository.save(book);
    }

    private List<BorrowingDetailDTO> mapToDTOList(Iterable<BorrowingEntity> borrowingEntities) {
        List<BorrowingDetailDTO> borrowings = new ArrayList<>();

        borrowingEntities.forEach(borrowingEntity -> {
            BorrowingDetailDTO DTO = mapToDTO(borrowingEntity);
            borrowings.add(DTO);
        });

        return borrowings;
    }

    private BorrowingDetailDTO mapToDTO(BorrowingEntity borrowingEntity) {
        BorrowingDetailDTO DTO = new BorrowingDetailDTO();
        DTO.setId(borrowingEntity.getId());
        DTO.setBookDetailDTO(borrowingEntity.getBookEntity().getTitle());
        DTO.setCustomerDetailDTO(borrowingEntity.getCustomerDetailDTO());
        DTO.setDate(borrowingEntity.getDate());

        return DTO;
    }
}
