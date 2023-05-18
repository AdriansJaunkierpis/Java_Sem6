package lv.venta.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

@Table(name = "Grade_table") //table in DB
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Grade {

	@Column(name = "idg")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private long idg;
	
	@Column(name = "GValue")
	@Min(0)
	@Max(10)
	private int gvalue;

	@ManyToOne
	@JoinColumn(name = "ids")
	private Student student;
	
	@ManyToOne
	@JoinColumn(name = "idc")
	private Course course;

	public Grade(@Min(0) @Max(10) int gvalue, Student student, Course course) {
		this.gvalue = gvalue;
		this.student = student;
		this.course = course;
	}
}