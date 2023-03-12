package sk.umb.example.library.book.service;
import jakarta.transaction.Transactional;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import sk.umb.example.library.address.persistence.entity.AddressEntity;
import sk.umb.example.library.address.persistence.repository.AddressRepository;
import sk.umb.example.library.address.service.AddressDetailDto;
import sk.umb.example.library.book.persistence.repository.BookRepository;
import sk.umb.example.library.book.persistence.entity.BookEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final AddressRepository addressRepository;

    public BookService(BookRepository bookRepository,
                       AddressRepository addressRepository) {
        this.bookRepository = bookRepository;
        this.addressRepository = addressRepository;
    }

    public List<BookDetailDTO> getAllBooks() {
        return mapToDtoList(bookRepository.findAll());
    }

    public List<BookDetailDTO> searchBookByAuthorLastName(String author) {
        return mapToDtoList(bookRepository.findByAuthorLastName(author));
    }

    public BookDetailDTO getBookById(Long bookId) {
        return mapToDto(getBookEntityById(bookId));
    }


    @Transactional
    public Long createBook(BookRequestDTO bookRequestDto) {
        BookEntity entity = mapToEntity(bookRequestDto);

        return bookRepository.save(entity).getId();
    }

    @Transactional
    public void updateBook(Long bookId, BookRequestDTO bookRequestDTO) {
        BookEntity book = getBookEntityById(bookId);

        if (! Strings.isEmpty(bookRequestDTO.getAuthorFirstName())) {
            book.setAuthorFirstName(bookRequestDTO.getAuthorFirstName());
        }

        if (! Strings.isEmpty(bookRequestDTO.getAuthorLastName())) {
            book.setAuthorLastName(bookRequestDTO.getAuthorLastName());
        }

        if (! Strings.isEmpty(bookRequestDTO.getTitle())) {
            book.setTitle(bookRequestDTO.getTitle());
        }
        if (! Strings.isEmpty(bookRequestDTO.getIsbn())) {
            book.setIsbn(bookRequestDTO.getIsbn());
        }
        if (bookRequestDTO.getCount() != 0) {
            book.setCount(bookRequestDTO.getCount());
        }

        bookRepository.save(book);
    }

    @Transactional
    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    private BookEntity getBookEntityById(Long bookId) {
        Optional<BookEntity> book = bookRepository.findById(bookId);

        if (book.isEmpty()) {
            throw new IllegalArgumentException("book not found. ID: " + bookId);
        }

        return book.get();
    }

    private BookEntity mapToEntity(BookRequestDTO dto) {
        BookEntity book = new BookEntity();

        if ( ! Objects.isNull(dto.getAddressId()) ) {
            Optional<AddressEntity> address = addressRepository.findById(dto.getAddressId());

            if (address.isPresent()) {
                book.setAddress(address.get());
            }
        }

        book.setAuthorLastName(dto.getAuthorLastName());
        book.setAuthorFirstName(dto.getAuthorFirstName());
        book.setTitle(dto.getTitle());
        book.setIsbn(dto.getIsbn());
        book.setCount(dto.getCount());

        return book;
    }

    private List<BookDetailDTO> mapToDtoList(Iterable<BookEntity> bookEntities) {
        List<BookDetailDTO> books = new ArrayList<>();

        bookEntities.forEach(bookEntity -> {
            BookDetailDTO dto = mapToDto(bookEntity);
            books.add(dto);
        });

        return books;
    }

    private BookDetailDTO mapToDto(BookEntity bookEntity) {
        BookDetailDTO dto = new BookDetailDTO();
        dto.setId(bookEntity.getId());
        dto.setAuthorFirstName(bookEntity.getAuthorFirstName());
        dto.setAuthorLastName(bookEntity.getAuthorLastName());
        dto.setTitle(bookEntity.getTitle());
        dto.setIsbn(bookEntity.getIsbn());
        dto.setCount(bookEntity.getCount());

        return dto;
    }

    private AddressDetailDto mapToDto(AddressEntity addressEntity) {
        AddressDetailDto dto = new AddressDetailDto();
        dto.setId(addressEntity.getId());
        dto.setCity(addressEntity.getCity());

        return dto;
    }
}