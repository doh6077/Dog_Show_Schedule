package ca.sheridancollege.kimdohee.bootstrap;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ca.sheridancollege.kimdohee.Repositories.DogRepository;
import ca.sheridancollege.kimdohee.Repositories.JudgeRepository;
import ca.sheridancollege.kimdohee.Repositories.OwnerRepository;
import ca.sheridancollege.kimdohee.beans.Dog;
import ca.sheridancollege.kimdohee.beans.Judge;
import ca.sheridancollege.kimdohee.beans.Owner;
import lombok.AllArgsConstructor;
@Component 
@AllArgsConstructor 
public class BootstrapData implements CommandLineRunner {
	
	private DogRepository dogRepo; 
	private JudgeRepository judRepo; 
	private OwnerRepository ownRepo; 

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Dog d = Dog.builder().name("dog1" ).build();
		dogRepo.save(d);
		Dog d1 = Dog.builder().name("dog2" ).build();
		dogRepo.save(d1);
		Judge j = Judge.builder().name("judge1" ).build();
		judRepo.save(j);
		Judge j1 = Judge.builder().name("judge2" ).build();
		judRepo.save(j1);
		Owner own = Owner.builder().firstName("owner1").lastName("meow").build(); 
		ownRepo.save(own);
		d.setOwner(own);
		d1.setOwner(own);
		List<Judge> judges = new ArrayList<>();  // Initialize the list
		judges.add(j); 
		judges.add(j1);
		d.setJudges(judges);
		dogRepo.save(d);
		dogRepo.save(d1);
		judRepo.save(j);
		judRepo.save(j1);		
		ownRepo.save(own);

		
	}

}
