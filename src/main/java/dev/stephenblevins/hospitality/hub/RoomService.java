package dev.stephenblevins.hospitality.hub;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getAllRooms() { return roomRepository.findAll(); }

    public Optional<Room> singleRoom(String roomNumber) {
        return roomRepository.findByRoomNumber(roomNumber);
    }

    public Optional<Room> singleRoomId(ObjectId id) { return roomRepository.findById(id); }

    public Room createRoom(Room room) { return roomRepository.save(room); }

    public Room updateRoom(@PathVariable ObjectId id, Room room) { return roomRepository.save(room); }
}
