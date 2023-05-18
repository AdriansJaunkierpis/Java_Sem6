package lv.venta.models;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "professor_table") //table in DB
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Professor {

	@Column(name = "idp")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private long idp;
	
	@Column(name = "Name")
	@NotNull
	@Size(min = 1, max = 20)
	@Pattern(regexp = "[A-Z]{1}[a-z\\ ]+", message = "Only Latin letters and space")
	private String name;
	
	@Column(name = "Surname")
	@NotNull
	@Size(min = 1, max = 20)
	@Pattern(regexp = "[A-Z]{1}[a-z\\ ]+", message = "Only Latin letters and space")
	private String surname;
	
	@Column(name = "Degree")
	@NotNull
	private Degree degree;
	
	@ManyToMany
	@JoinTable(name = "prof_course_table",
	joinColumns = @JoinColumn(name = "idc"),
	inverseJoinColumns = @JoinColumn(name = "idp"))
	@ToString.Exclude
	private Collection<Course> course;

	public Professor(String name, String surname, Degree degree) {
		this.name = name;
		this.surname = surname;
		this.degree = degree;
	}
	
	
}
