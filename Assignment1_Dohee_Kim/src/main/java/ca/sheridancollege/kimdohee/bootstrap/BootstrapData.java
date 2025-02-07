package ca.sheridancollege.kimdohee.bootstrap;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;

import ca.sheridancollege.kimdohee.Repositories.DogRepository;
import ca.sheridancollege.kimdohee.Repositories.JudgeRepository;
import ca.sheridancollege.kimdohee.Repositories.OwnerRepository;
import ca.sheridancollege.kimdohee.beans.Dog;
import ca.sheridancollege.kimdohee.beans.Judge;
import ca.sheridancollege.kimdohee.beans.Owner;

public class BootstrapData implements CommandLineRunner {
	
	private DogRepository dogRepo; 
	private JudgeRepository judRepo; 
	private OwnerRepository ownRepo; 

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Dog d = Dog.builder().name("dog1" ).build();
		dogRepo.save(d);
		Judge j = Judge.builder().name("judge1" ).build();
		judRepo.save(j);
		Owner own = Owner.builder().firstName("owner1").lastName("meow").build(); 
		ownRepo.save(own);
		d.setOwner(own);
		List<Judge> judges = new ArrayList<>();  // Initialize the list
		judges.add(j);  
		d.setJudges(judges);
		dogRepo.save(d);
		
		

		
	}

}
