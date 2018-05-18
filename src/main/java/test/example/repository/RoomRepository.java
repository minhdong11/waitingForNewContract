package test.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.example.model.Room;
@Repository
public interface RoomRepository extends JpaRepository<Room, Long>{

	List<Room> findByStatus(boolean status);
	List<Room> findByRoomContaining(String room);
	
}
