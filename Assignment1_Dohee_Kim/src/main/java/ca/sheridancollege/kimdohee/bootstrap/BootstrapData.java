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
		for (int i = 1; i < 31; i ++) {
			Dog dog = Dog.builder().name("dog" + i ).build();
			dogRepo.save(dog);
		}
		for (int i = 1; i < 4; i ++) {
			Judge j = Judge.builder().name("judge" + i).build();
			judRepo.save(j);
		}
		for (int i = 1; i < 7; i ++) {
			Owner own = Owner.builder().firstName("owner" + i).lastName("last" + i).build(); 
			ownRepo.save(own);
		}


		
	}

}
