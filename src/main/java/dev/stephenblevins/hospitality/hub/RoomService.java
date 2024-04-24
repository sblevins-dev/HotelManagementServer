package dev.stephenblevins.hospitality.hub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
