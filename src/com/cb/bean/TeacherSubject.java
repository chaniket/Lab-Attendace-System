package com.cb.bean;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
//@Table(name = "tbl_teacher_subject")
//@PrimaryKeyJoinColumn(name="staff_id")
public class TeacherSubject  implements Serializable {

	private static final long serialVersionUID = -6375833799960484376L;
	/*@Id
	@GenericGenerator(name = "incre", strategy = "increment")
	@GeneratedValue(generator = "incre")
	private Integer id;
	*/
	/*@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "staff_id")
	*/
	@Id
	@GenericGenerator(name = "incre", strategy = "increment")
	@GeneratedValue(generator = "incre")
	@Column
	private Integer staff_id;
	@Column(name="practical_name")
	private String practical_name;

	public TeacherSubject() {

	}

	public TeacherSubject(String practical_name) {
		super();
		this.practical_name = practical_name;
	}

	public Integer getStud_id() {
		return staff_id;
	}

	public void setStud_id(Integer stud_id) {
		this.staff_id = stud_id;
	}

	public String getPractical_name() {
		return practical_name;
	}

	public void setPractical_name(String practical_name) {
		this.practical_name = practical_name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "TeacherSubject [stud_id=" + staff_id + ", practical_name=" + practical_name + "]";
	}
}
