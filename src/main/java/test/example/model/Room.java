package test.example.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Room implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "room_id")
	private long id;

	@Column(name = "room")
	private String room;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "status")
	private boolean status;

	@OneToMany(mappedBy="user",fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Booking> booking;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}


	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


	public Room(long id, String room, String type, boolean status, List<Booking> booking) {
		super();
		this.id = id;
		this.room = room;
		this.type = type;
		this.status = status;
		this.booking = booking;
	}

	public Room() {
		super();
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", room=" + room + ", type=" + type + ", status=" + status + "]";
	}
	

}
