package test.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import test.example.exception.ResourceNotFoundException;
import test.example.model.Booking;
import test.example.model.Room;
import test.example.service.RoomService;

@RestController
@RequestMapping("/room")
public class RoomController {
	
	@Autowired
	RoomService roomService;
	
	@GetMapping
	public List<Room> getAllRoom(){
		Booking book = new Booking();
		System.out.println(book);
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
	
	@GetMapping("/{room}")
	public List<Room> findByRoomName(String roomName){
		return roomService.findByRoomContaining(roomName);
	}
}
