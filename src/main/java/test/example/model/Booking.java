package test.example.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;


/**
 * @author DongHM
 *
 */
@Entity
public class Booking implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	@JsonManagedReference
	private User user;
	
	@ManyToOne
	@JoinColumn(name="room_id")
	@JsonManagedReference
	private Room room;
	
	private Date startDate;
	
	private Date endDate;

	private long price;
	public long getPrice() {
		return price;
	}



	public void setPrice(long price) {
		this.price = price;
	}




	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public Room getRoom() {
		return room;
	}



	public void setRoom(Room room) {
		this.room = room;
	}



	public Date getStartDate() {
		return startDate;
	}



	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}



	public Date getEndDate() {
		return endDate;
	}



	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}



	public Booking(long id, User user, Room room, Date startDate, Date endDate) {
		super();
		this.id = id;
		this.user = user;
		this.room = room;
		this.startDate = startDate;
		this.endDate = endDate;
	}



	public Booking() {
		super();
	}



	@Override
	public String toString() {
		return "Booking [id=" + id + ", user=" + user + ", room=" + room + "]";
	}
	
	
	
}
