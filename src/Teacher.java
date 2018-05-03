import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

public class Teacher implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private String name;

	@Column
	private String subject;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "class_id")
	private Set<SchoolClass> classes;

	private Set<Teacher> teachers;
	
	public Teacher() {
		teachers = new HashSet<Teacher>();
	}

	public void setTeacher(Set<Teacher> teachers) {
		this.teachers = teachers;
	}

	public void addTeacher(Teacher newTeacher) {
		teachers.add(newTeacher);
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSubject() {
		return subject;
	}

	public Set<SchoolClass> getClasses() {
		return classes;
	}

	public void setId(long id) {

		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setClasses(Set<SchoolClass> classes) {
		this.classes = classes;
	}

	@Override
	public String toString() {
		return "Teacher{" + "id=" + id + ", name='" + name + '\'' + ", subject='" + subject + '\'' + ", classes="
				+ classes + '}';
	}

}
