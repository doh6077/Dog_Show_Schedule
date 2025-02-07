package ca.sheridancollege.kimdohee.beans;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Dog {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String lastName; 
    // Many dogs can be assigned to One Owner
    @ManyToOne
    @JoinColumn(name = "owner_id") // JoinColumn으로 수정
    private Owner owner;

    // Many dogs can be assigned to Many Judges
    @ManyToMany
    @JoinTable(
        name = "dog_judge",  
        joinColumns = @JoinColumn(name = "dog_id"),
        inverseJoinColumns = @JoinColumn(name = "judge_id")
    )
    private List<Judge> judges;  
}
