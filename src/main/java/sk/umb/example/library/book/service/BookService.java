package sk.umb.example.library.book.service;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class BookService {
    private final AtomicLong lastIndex = new AtomicLong(0);

    private final Map<Long, BookDetailDTO> bookDatabase = new HashMap();

    public List<BookDetailDTO> getAllBooks() {
        return new ArrayList<>(bookDatabase.values());
    }

    public List<BookDetailDTO> searchBookByAuthorLastName(String AuthorlastName) {
        return bookDatabase.values().stream()
                .filter(dto -> AuthorlastName.equals(dto.getAuthorLastName()))
                .toList();
    }

    public BookDetailDTO getBookById(Long bookId) {
        validateBookExists(bookId);

        return bookDatabase.get(bookId);
    }

    public Long createBook(BookRequestDTO bookRequestDTO) {
        BookDetailDTO bookDetailDTO = mapToBookDetailDTO(lastIndex.getAndIncrement(),
                bookRequestDTO);

        bookDatabase.put(bookDetailDTO.getId(), bookDetailDTO);

        return bookDetailDTO.getId();
    }

    private static BookDetailDTO mapToBookDetailDTO(Long index, BookRequestDTO bookRequestDTO) {
        BookDetailDTO dto = new BookDetailDTO();

        dto.setId(index);
        dto.setAuthorLastName(bookRequestDTO.getAuthorLastName());
        dto.setAuthorFirstName(bookRequestDTO.getAuthorFirstName());
        dto.setTitle(bookRequestDTO.getTitle());
        dto.setCount(bookRequestDTO.getCount());
        dto.setIsbn(bookRequestDTO.getIsbn());
        dto.setCategoryIds(index);


        return dto;
    }

    public void updateBook(Long bookId, BookRequestDTO bookRequestDTO) {
        validateBookExists(bookId);

        BookDetailDTO bookDetailDTO = bookDatabase.get(bookId);

        if (! Strings.isEmpty(bookRequestDTO.getAuthorFirstName())) {
            bookDetailDTO.setAuthorFirstName(bookRequestDTO.getAuthorFirstName());
        }

        if (! Strings.isEmpty(bookRequestDTO.getAuthorLastName())) {
            bookDetailDTO.setAuthorLastName(bookRequestDTO.getAuthorLastName());
        }

        if (! Strings.isEmpty(bookRequestDTO.getTitle())) {
            bookDetailDTO.setTitle(bookRequestDTO.getTitle());
        }

        if (bookRequestDTO.getIsbn() != 0) {
            bookDetailDTO.setIsbn(bookRequestDTO.getIsbn());
        }

        if (bookRequestDTO.getCount() != 0) {
            bookDetailDTO.setCount(bookRequestDTO.getCount());
        }
    }

    private void validateBookExists(Long bookId) {
        if (! bookDatabase.containsKey(bookId)) {
            throw new IllegalArgumentException("BookId: " + bookId + " does not exists!");
        }
    }

    public void deleteBook(Long bookId) {
        bookDatabase.remove(bookId);
    }
}