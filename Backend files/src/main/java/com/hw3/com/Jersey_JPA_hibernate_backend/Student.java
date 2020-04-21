package com.hw3.com.Jersey_JPA_hibernate_backend;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
//added the table name to be used in the database
@Table(name="studenttable")
public class Student implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//creating an primary key called 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String tel;
	private String emailId;
	private String sdate;
	private String like_about_college;
	private String intrested_in_college;
	private String recommend;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	//firstname set and get
	@Column(name = "firstName", nullable = true)
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	//lastname set and get	
	@Column(name = "lastName", nullable = true)
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	//address set and get
	@Column(name = "address", nullable = true)
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}

	//city set and get
	@Column(name = "city", nullable = true)
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	//state get and set
	@Column(name = "state", nullable = true)
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	//zip set and get
	@Column(name = "zip", nullable = true)
	public String getZip() {
		return zip;
	}
	
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	//tel set and get
	@Column(name = "tel", nullable = true)
	public String getTel() {
		return tel;
	}
	
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	//emailId set and get
	@Column(name = "emailId", nullable = true)
	public String getEmailId() {
		return emailId;
	}
	
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	//sdate set and get
	@Column(name = "sdate", nullable = true)
	public String getSdate() {
		return sdate;
	}
	
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	
	//like_about_college set and get
	@Column(name = "like_about_college", nullable = true)
	public String getLike_about_college() {
		return like_about_college;
	}
	
	public void setLike_about_college(String like_about_college) {
		this.like_about_college = like_about_college;
	}
	
	//intrested_in_college set and get
	@Column(name = "intrested_in_college", nullable = true)
	public String getIntrested_in_college() {
		return intrested_in_college;
	}
	
	public void setIntrested_in_college(String intrested_in_college) {
		this.intrested_in_college = intrested_in_college;
	}
	
	//recommend set and get
	@Column(name = "recommend", nullable = true)	
	public String getRecommend() {
		return recommend;
	}
	
	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}
	

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", city=" + city
				+ ", state=" + state +", zip=" + zip +", tel=" + tel +", emailId=" + emailId +", sdate=" + sdate +", like_about_college=" + like_about_college +", intrested_in_college=" + intrested_in_college +", recommend=" + recommend +"]";
	}
	
	

}
