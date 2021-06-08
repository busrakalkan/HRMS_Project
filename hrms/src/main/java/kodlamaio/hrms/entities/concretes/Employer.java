package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
@Table(name = "employers")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisement"})

public class Employer  extends User{
	
	@Column(name = "company_name")
	@NotBlank
	@NotNull
	@NotEmpty
	private String companyName;
	
	@Column(name = "web_address")
	@NotBlank
	@NotNull
	@NotEmpty
	private String webAddress;
	
	@Column(name = "phone_number")
	@NotBlank
	@NotNull
	@NotEmpty
	private String phoneNumber;
	
	@OneToMany(mappedBy="employer")
	private List<JobAdvertisement> jobAdvertisement;

}
