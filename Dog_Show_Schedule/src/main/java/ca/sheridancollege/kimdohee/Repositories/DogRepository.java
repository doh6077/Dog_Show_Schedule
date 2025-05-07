package ca.sheridancollege.kimdohee.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.kimdohee.beans.Dog;

@Repository
public interface DogRepository extends JpaRepository<Dog, Long> {
	
	

}
