package dmacc.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * @author chumb - djackson16 CIS175 - Spring 2024 Apr 2, 2024
 */

@Entity
@Data
public class Fudge {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private int count;

	public Fudge() {
		super();
	}

}
