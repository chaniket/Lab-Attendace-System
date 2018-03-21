package com.cb.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;

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
	@NaturalId
	private String email;
	private String qualification;
	/*
	 * @OneToMany(cascade = javax.persistence.CascadeType.ALL)
	 * 
	 * @JoinTable(name = "tbl_teacher_subjects", joinColumns = @JoinColumn(name
	 * = "tbl_t_info_staffid"), inverseJoinColumns = @JoinColumn(name =
	 * "tbl_sub_id1")) private List<TeacherSubject> teacherSubject;
	 */
/*	@OneToOne(cascade = javax.persistence.CascadeType.ALL)
	//@JoinColumn(name="staff_id")
	private TeacherSubject teacherSubject;*/

	public Teacher_Info() {

	}

	public Teacher_Info(String firstName, String lastName, String email, String qualification,
			List<TeacherSubject> teacherSubject) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.qualification = qualification;
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
