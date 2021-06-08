package kodlamaio.hrms.entities.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeDto {
	
	private String name;
	private String surname;
	private String githubLink;
	private String linkedinLink;
	private String coverLetter;
    private List<ExperienceDto> experiences;
    private List<SchoolDto> schools;
    private List<SkillDto> skills;
    private List<LanguageDto> languages;
    

}



