package dislog.cs.cs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dislog.cs.cs.model.Type;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {
}
