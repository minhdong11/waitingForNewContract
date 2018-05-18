package test.example.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.example.exception.ResourceNotFoundException;
import test.example.model.Room;
import test.example.repository.BookingRepository;
import test.example.repository.RoomRepository;
import test.example.service.RoomService;
@Service
public class RoomServiceImpl implements RoomService{
	@Autowired
	RoomRepository roomRepository;
	
	@Autowired
	BookingRepository bookingRepository;
	
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
	public Room statusUpdate(Room room) {
		Room roomm = roomRepository.findById(room.getId())
				.orElseThrow(()-> new ResourceNotFoundException("Room", "id", room.getId()));
		roomm.setStatus(room.isStatus());
		Room updateStatus = roomRepository.save(roomm);
		return updateStatus;
	}

	

	


	


}
