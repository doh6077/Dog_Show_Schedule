package ca.sheridancollege.kimdohee.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.kimdohee.beans.Owner;
@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {

}
