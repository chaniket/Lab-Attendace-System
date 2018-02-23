package com.cb.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "tbl_teacher_info")
public class Teacher_Info implements Serializable {

	private static final long serialVersionUID = -7227790343351696132L;
	@Id
	@GenericGenerator(name = "incre", strategy = "increment")
	@GeneratedValue(generator = "incre")
	private Integer staff_id;
	private String firstName;
	private String lastName;
	private String email;
	private String qualification;
	@OneToMany
	@JoinTable(name="tbl_teacher_subjects", joinColumns=@JoinColumn(name="staffid"),
	inverseJoinColumns=@JoinColumn(name="staff_id1"))
	private List<TeacherSubject> teacherSubject;

	public Teacher_Info() {
		// TODO Auto-generated constructor stub
	}

	public Teacher_Info( String firstName, String lastName, String email, String qualification,
			List<TeacherSubject> teacherSubject) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.qualification = qualification;
		this.teacherSubject = teacherSubject;
	}

	public void setTeacherSubject(List<TeacherSubject> teacherSubject) {
		this.teacherSubject = teacherSubject;
	}

	public List<TeacherSubject> getTeacherSubject() {
		return teacherSubject;
	}

	public Integer getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(Integer staff_id) {
		this.staff_id = staff_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	@Override
	public String toString() {
		return "Teacher_Info [staff_id=" + staff_id + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", qualification=" + qualification + "]";
	}

}
