package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "job_advertisement")
@AllArgsConstructor
@NoArgsConstructor

public class JobAdvertisement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "job_description")
	private String jobDescription;
	
	@Column(name = "total_open_positions")
	private int totalOpenPositions;
	
	@Column(name = "deadline_date")
	private String deadlineDate;
	
	@Column(name = "release_date")
	private String releaseDate;
	
	@Column(name = "is_active")
	private boolean isActive;
	
	@Column(name = "min_salary")
	private int minSalary;
	
	@Column(name = "max_salary")
	private int maxSalary;

	@ManyToOne
	@JoinColumn(name = "employer_id")
	private Employer employer;
	
	@ManyToOne
	@JoinColumn(name = "position_id")
	private Position position;
	
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;

}
