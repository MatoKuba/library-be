package sk.umb.example.library.book.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sk.umb.example.library.book.persistence.entity.BookEntity;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, Long> {

}
