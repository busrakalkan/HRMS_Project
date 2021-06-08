package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class JobAdvertisementDto {

	private String companyName;
	private String positionName;
	private String cityName;
	private String releaseDate;
	private String deadlineDate;
	private int totalOpenPosition;

}
