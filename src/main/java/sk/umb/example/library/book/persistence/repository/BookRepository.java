package sk.umb.example.library.book.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sk.umb.example.library.customer.persistence.entity.CustomerEntity;

@Repository
public interface BookRepository extends CrudRepository<CustomerEntity, Long> {
    Iterable<CustomerEntity> findByLastName(String lastName);
}
