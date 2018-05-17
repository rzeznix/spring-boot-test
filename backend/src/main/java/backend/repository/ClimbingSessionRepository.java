package backend.repository;

import backend.model.ClimbingSession;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface ClimbingSessionRepository extends CrudRepository<ClimbingSession, Long> {


}