package ca.sheridancollege.kimdohee.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.kimdohee.beans.Judge;
@Repository
public interface JudgeRepository extends JpaRepository<Judge, Long> {

}
