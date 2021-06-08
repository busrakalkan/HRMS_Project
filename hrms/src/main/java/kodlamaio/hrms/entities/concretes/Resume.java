package kodlamaio.hrms.entities.concretes;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kodlamaio.hrms.entities.concretes.cvInfo.ResumeExperience;
import kodlamaio.hrms.entities.concretes.cvInfo.ResumeLanguage;
import kodlamaio.hrms.entities.concretes.cvInfo.ResumeSchool;
import kodlamaio.hrms.entities.concretes.cvInfo.ResumeSkill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name = "resume")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobSeeker"})

public class Resume {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name="photo_link")
	private String photoLink;
	
	@Column(name = "github_link")
	private String githubLink;
	
	@Column(name = "linkedin_link")
	private String linkedinLink;
	
	@Column(name = "cover_letter")
	private String coverLetter;
	
	@OneToOne()
    @JoinColumn(name="job_seeker_id")
    private JobSeeker jobSeeker;
	
	@JsonIgnore
	@OneToMany(mappedBy = "resume")
	private List<ResumeSchool> schools;
	
	@JsonIgnore
	@OneToMany(mappedBy = "resume")
	private List<ResumeExperience> experince;
	
	@JsonIgnore
	@OneToMany(mappedBy = "resume")
	private List<ResumeLanguage> language;
	
	@JsonIgnore
	@OneToMany(mappedBy = "resume")
	private List<ResumeSkill> skills;

}
