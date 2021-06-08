package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SchoolDto {

	private String schoolName;
	private String degree;
	private String department;
	private String startedDate;
	private String endedDate;

}
