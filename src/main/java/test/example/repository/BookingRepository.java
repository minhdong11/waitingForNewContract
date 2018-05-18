package test.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import test.example.model.Booking;
import test.example.model.Room;

public interface BookingRepository extends JpaRepository<Booking, Long>{
	List<Booking> findByRoom(Room room);
}
