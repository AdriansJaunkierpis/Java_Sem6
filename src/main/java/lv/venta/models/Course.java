package lv.venta.models;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "Course_table") //table in DB
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Course {

	@Column(name = "idc")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private long idc;
	
	@Column(name = "Title")
	@NotNull
	@Size(min = 1, max = 25)
	@Pattern(regexp = "[A-Z]{1}[a-z\\ ]+", message = "Only Latin letters and space")
	private String title;
	
	@Column(name = "creditPoints")
	@Min(0)
	@Max(20)
	private int creditPoints;
	
	@OneToOne
	@JoinColumn(name = "idp")
	private Professor professor;
	
	@OneToMany(mappedBy = "course")
	private Collection<Grade> grades;

	public Course(
			@NotNull @Size(min = 1, max = 25) @Pattern(regexp = "[A-Z]{1}[a-z\\ ]+", message = "Only Latin letters and space") String title,
			@Min(0) @Max(20) int creditPoints, Professor professor) {
		this.title = title;
		this.creditPoints = creditPoints;
		this.professor = professor;
	}

	
}
