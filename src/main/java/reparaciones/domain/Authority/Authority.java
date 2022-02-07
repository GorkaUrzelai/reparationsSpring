package reparaciones.domain.Authority;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="authorities")
public class Authority {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column
	@NotNull
	private String authority;
	
	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
}