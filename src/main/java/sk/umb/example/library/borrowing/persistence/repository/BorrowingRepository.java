package sk.umb.example.library.borrowing.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sk.umb.example.library.borrowing.persistence.entity.BorrowingEntity;

@Repository
public interface BorrowingRepository extends CrudRepository<BorrowingEntity, Long> {
    Iterable<BorrowingEntity> findByUserId(Number id);
}
