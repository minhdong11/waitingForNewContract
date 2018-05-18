package test.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import test.example.exception.ResourceNotFoundException;
import test.example.model.Room;
import test.example.repository.BookingRepository;
import test.example.repository.UserRepository;
import test.example.service.RoomService;

@RestController
@RequestMapping("/room")
public class RoomController {
	@Autowired
	UserRepository userRepository;
	@Autowired
	BookingRepository bookingRepository;
	@Autowired
	RoomService roomService;
	
	@GetMapping
	public List<Room> getAllRoom(){
		//test
		System.out.println(bookingRepository.findAll());
		return roomService.getAll();
	}
	
	@GetMapping("/{id}")
	public Room findRoomById(@PathVariable long id){
		return roomService.findRoomById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Room", "id", id));
	}
	
	@GetMapping("/status/{status}")
	public List<Room> findByStatus(@PathVariable boolean status){
		
		return roomService.findByStatus(status);
	}
	
	@GetMapping("/{roomName}")
	public List<Room> findByRoomName(String roomName){
		return roomService.findByRoomContaining(roomName);
	}
	
	@PutMapping("/{room}")
	public Room updateStatus(@RequestBody Room room){
		
		return roomService.statusUpdate(room);
	}
}
