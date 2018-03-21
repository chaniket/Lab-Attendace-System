package com.cb.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "tbl_teacher_subject")
// @PrimaryKeyJoinColumn(name="staff_id")
public class TeacherSubject implements Serializable {

	private static final long serialVersionUID = -6375833799960484376L;
	/*
	 * @Id
	 * 
	 * @GenericGenerator(name = "incre", strategy = "increment")
	 * 
	 * @GeneratedValue(generator = "incre") private Integer id;
	 */
	/*
	 * @OneToMany(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "staff_id")
	 */
	@Id
	@GenericGenerator(name = "incre", strategy = "increment")
	@GeneratedValue(generator = "incre")
	private Integer staff_id;
	private String practical_name1;
	private String practical_name2;
	private String practical_name3;

	public TeacherSubject() {

	}
	
	public TeacherSubject(Integer staff_id, String practical_name1, String practical_name2, String practical_name3) {
		super();
		this.staff_id = staff_id;
		this.practical_name1 = practical_name1;
		this.practical_name2 = practical_name2;
		this.practical_name3 = practical_name3;
	}


	public Integer getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(Integer staff_id) {
		this.staff_id = staff_id;
	}

	public String getPractical_name1() {
		return practical_name1;
	}

	public void setPractical_name1(String practical_name1) {
		this.practical_name1 = practical_name1;
	}

	public String getPractical_name2() {
		return practical_name2;
	}

	public void setPractical_name2(String practical_name2) {
		this.practical_name2 = practical_name2;
	}

	public String getPractical_name3() {
		return practical_name3;
	}

	public void setPractical_name3(String practical_name3) {
		this.practical_name3 = practical_name3;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "TeacherSubject [staff_id=" + staff_id + ", practical_name1=" + practical_name1 + ", practical_name2="
				+ practical_name2 + ", practical_name3=" + practical_name3 + "]";
	}

}
