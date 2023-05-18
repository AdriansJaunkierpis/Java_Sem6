package lv.venta.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "Student") //table in DB
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Student {

	@Column(name = "ids")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private long ids;
	
	@Column(name = "name")
	@NotNull
	@Size(min = 1, max = 20)
	@Pattern(regexp = "[A-Z]{1}[a-z\\ ]+", message = "Only Latin letters and space")
	private String name;
	
	@Column(name = "surname")
	@NotNull
	@Size(min = 1, max = 20)
	@Pattern(regexp = "[A-Z]{1}[a-z\\ ]+", message = "Only Latin letters and space")
	private String surname;

	public Student(
			@NotNull @Size(min = 1, max = 20) @Pattern(regexp = "[A-Z]{1}[a-z\\ ]+", message = "Only Latin letters and space") String name,
			@NotNull @Size(min = 1, max = 20) @Pattern(regexp = "[A-Z]{1}[a-z\\ ]+", message = "Only Latin letters and space") String surname) {
		this.name = name;
		this.surname = surname;
	}
	
	
}
