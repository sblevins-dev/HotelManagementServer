package dev.stephenblevins.hospitality.hub;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/rooms")
public class RoomController {

    Logger log = Logger.getLogger(this.getClass().getName());

    @Autowired
    private RoomService roomService;

    @GetMapping
    public ResponseEntity<List<Room>> getAllRooms() {
        return new ResponseEntity<>(roomService.getAllRooms(), HttpStatus.OK);
    }

    @GetMapping("/roomNum/{roomNumber}")
    public ResponseEntity<Optional<Room>> getRoomByNumber(@PathVariable String roomNumber) {
        return new ResponseEntity<>(roomService.singleRoom(roomNumber), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Room>> getRoomById(@PathVariable ObjectId id) {
        return new ResponseEntity<>(roomService.singleRoomId(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Room> createGuest(@RequestBody Room room) {
        log.info("Creating room: " + room);
        try {
            Room createdRoom = roomService.createRoom(room);
            return new ResponseEntity<>(createdRoom, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Room> updateGuest(@PathVariable ObjectId id, @RequestBody Room room) {
        log.info("Updating room: " + room + " with id: " + id);
        try {
            Optional<Room> foundRoom = roomService.singleRoomId(id);
            log.info("Found room: " + foundRoom);

            if (foundRoom.isPresent()) {
                room.setId(new ObjectId(String.valueOf(foundRoom.get().getId())));
            }

            Room updatedRoom = roomService.updateRoom(id, room);
            return new ResponseEntity<>(updatedRoom, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
