package com.gg.controller;

import com.gg.domain.Room;
import com.gg.domain.User;
import com.gg.repository.UserRepository;
import com.gg.service.RoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/chat")
@Log4j2
public class RoomController {
    private final RoomService roomService;

    private final UserRepository userRepository;

    @GetMapping(value = "/rooms")
    public List<Room> rooms(){
        log.info("# All Chat Rooms");

        return roomService.findAllRooms();
    }

    @PostMapping(value = "/room")
    public Room create(@RequestParam String roomCategory, @RequestParam String roomTitle) {
        User user = userRepository.findById(1L).get();
        log.info("# Create Chat Room, category : " + roomCategory + "title" + roomTitle + "user" + user.getNickname() );
        return roomService.createRoom(roomCategory, roomTitle, user);
    }
}