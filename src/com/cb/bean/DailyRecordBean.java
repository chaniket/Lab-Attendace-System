package com.cb.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SelectBeforeUpdate;
@Entity
@Table(name="tbl_dailyrecord")
@SelectBeforeUpdate
@DynamicUpdate
public class DailyRecordBean implements Serializable{
	@Id
	@GenericGenerator(name = "incre", strategy = "increment")
	@GeneratedValue(generator = "incre")
	private Integer id;
	@OneToOne
	@JoinColumn(name = "stud_id")
	private StudentInfoBean stud_id;

	public DailyRecordBean() {

	}

	public DailyRecordBean(StudentInfoBean stud_id) {
		super();
		this.stud_id = stud_id;
	}

	public void setStud_id(StudentInfoBean stud_id) {
		this.stud_id = stud_id;
	}

	public StudentInfoBean getStud_id() {
		return stud_id;
	}
}
