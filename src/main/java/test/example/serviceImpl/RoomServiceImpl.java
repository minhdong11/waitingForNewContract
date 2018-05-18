package test.example.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.example.model.Room;
import test.example.repository.RoomRepository;
import test.example.service.RoomService;
@Service
public class RoomServiceImpl implements RoomService{
	@Autowired
	RoomRepository roomRepository;
	
	@Override
	public List<Room> findByStatus(boolean status) {
		return roomRepository.findByStatus(status);
	}

	@Override
	public Optional<Room> findRoomById(long id) {
		return roomRepository.findById(id);
	}

	@Override
	public List<Room> findByRoomContaining(String room) {
		return roomRepository.findByRoomContaining(room);
	}

	@Override
	public List<Room> getAll() {
		return roomRepository.findAll();
	}

	@Override
	public boolean updateStatus(boolean status) {
		
		return status;
	}


}
