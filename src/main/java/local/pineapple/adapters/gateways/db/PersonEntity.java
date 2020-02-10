package local.pineapple.adapters.gateways.db;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("person")
public class PersonEntity implements Persistable<String> {
	@Id
	private String id;
	private String givenName;
	private String familyName;
	private LocalDate birthday;
	private Integer sex;
	private String bloodType;

	@Transient
	private boolean exists;

	@Override
	public boolean isNew() {
		return !exists;
	}
}
