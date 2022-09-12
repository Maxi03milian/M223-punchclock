package ch.ms.punchclock.repository;

import ch.ms.punchclock.model.Entry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntityRepository extends CrudRepository<Entry, Long> {

}
