package com.cb.bean;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "tbl_teacher_day_log")
public class TeacherLogInfo implements Serializable {
	@Id
	@GenericGenerator(name = "incre", strategy = "increment")
	@GeneratedValue(generator = "incre")
	private Integer id;
	private static final long serialVersionUID = -2223486346746310521L;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "staff_id")
	private Teacher_Info stud_id;
	private String practical_name;
	private String class_name;
	@Temporal(TemporalType.DATE)
	private Date todate;
	@Temporal(TemporalType.TIME)
	private Date login_time;
	@Temporal(TemporalType.TIME)
	private Date logout_time;

	public TeacherLogInfo() {
	}

	public TeacherLogInfo(Teacher_Info stud_id, String practical_name, String class_name, Date todate, Time login_time,
			Time logout_time) {
		super();
		this.stud_id = stud_id;
		this.practical_name = practical_name;
		this.class_name = class_name;
		this.todate = todate;
		this.login_time = login_time;
		this.logout_time = logout_time;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Teacher_Info getStud_id() {
		return stud_id;
	}

	public void setStud_id(Teacher_Info stud_id) {
		this.stud_id = stud_id;
	}

	public String getPractical_name() {
		return practical_name;
	}

	public void setPractical_name(String practical_name) {
		this.practical_name = practical_name;
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

	public Date getTodate() {
		return todate;
	}

	public void setTodate(Date todate) {
		this.todate = todate;
	}

	public Date getLogin_time() {
		return login_time;
	}

	public void setLogin_time(Date login_time) {
		this.login_time = login_time;
	}

	public Date getLogout_time() {
		return logout_time;
	}

	public void setLogout_time(Date logout_time) {
		this.logout_time = logout_time;
	}

	@Override
	public String toString() {
		return "StudentDayLogBean [stud_id=" + stud_id + ", practical_name=" + practical_name + ", class_name="
				+ class_name + ", todate=" + todate + ", login_time=" + login_time + ", logout_time=" + logout_time
				+ "]";
	}

}
