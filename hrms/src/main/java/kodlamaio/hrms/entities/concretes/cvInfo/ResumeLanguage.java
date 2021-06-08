package kodlamaio.hrms.entities.concretes.cvInfo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


import kodlamaio.hrms.entities.concretes.Resume;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name = "resume_language")
@NoArgsConstructor
@AllArgsConstructor

public class ResumeLanguage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "language_name")
	private String language;
	
	@Column(name = "language_level")
	@Max(5)
	@Min(1)
	private int languageLevel;
	
	@ManyToOne()
    @JoinColumn(name="resume_id")
    private Resume resume;

}
