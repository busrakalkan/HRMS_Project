package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ExperienceDto {

	private String companyName;
	private String position;
	private String startedDate;
	private String endedDate;

}
