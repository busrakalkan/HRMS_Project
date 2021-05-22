package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="position")
public class Position {
	@Id
    @GeneratedValue
    @Column(name="position_id")
	private int id;
	@Column(name="position_name")
	private String positionName;
	
	public Position() {}

	public Position(int id, String positionName) {
		super();
		this.id = id;
		this.positionName = positionName;
	}
}
