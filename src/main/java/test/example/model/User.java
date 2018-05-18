package test.example.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
//	public enum Gender{
//	    Male, Female, Transgender;
//	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private long userid;

	@Column(name ="username")
	private String username;
	
	@Column(name ="password")
	private String password;
	
	@Column(name ="first_name")
	private String firstname;
	
	@Column(name ="last_name")
	private String lastname;
	
	@Column(name ="address")
	private String address;
	
	@Column(name ="phone")
	private String phone;

	@Column(name ="gender")
	private String gender;
	
	@Column(name ="email")
	private String mail;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
//	@JsonIgnore
	private Set<Roles> roles;
	
	public List<Booking> getBooking() {
		return booking;
	}

	public void setBooking(List<Booking> booking) {
		this.booking = booking;
	}

	public long getUserid() {
		return userid;
	}
	
	@OneToMany(mappedBy="room",fetch=FetchType.LAZY)
	@JsonBackReference
	private List<Booking> booking;


	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Roles> getRoles() {
		return roles;
	}

	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
	public User(long userid, String username, String password, String firstname, String lastname, String address,
			String phone, String gender, String mail, Set<Roles> roles, List<Booking> booking) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.phone = phone;
		this.gender = gender;
		this.mail = mail;
		this.roles = roles;
		this.booking = booking;
	}

	@Override
	public String toString() {
		return "User [userId=" + userid + ", username=" + username + ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}

	public User() {
		super();
	}
	
	
}
