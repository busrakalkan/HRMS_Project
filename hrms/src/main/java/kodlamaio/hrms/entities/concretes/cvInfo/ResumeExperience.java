package kodlamaio.hrms.entities.concretes.cvInfo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import kodlamaio.hrms.entities.concretes.Resume;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "resume_experience")
@NoArgsConstructor
@AllArgsConstructor
public class ResumeExperience {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "experience_name")
	private String companyName;
	
	@Column(name = "experience_position")
	private String position;
	
	@Column(name = "started_date")
	private String startedDate;
	
	@Column(name = "ended_date")
	private String endedDate;
	
	@ManyToOne()
    @JoinColumn(name="resume_id")
    private Resume resume;
}
