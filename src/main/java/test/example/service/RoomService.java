package test.example.service;

import java.util.List;
import java.util.Optional;

import test.example.model.Room;

public interface RoomService {
	Optional<Room> findRoomById(long id);
	List<Room> findByStatus(boolean status);
	List<Room> findByRoomContaining(String room);
	List<Room> getAll();
	boolean updateStatus(boolean status);
}
