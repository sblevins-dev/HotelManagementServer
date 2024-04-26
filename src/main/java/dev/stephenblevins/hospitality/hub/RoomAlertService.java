package dev.stephenblevins.hospitality.hub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class RoomAlertService {

    @Autowired
    private RoomAlertRepository roomAlertRepository;

    public List<RoomAlert> getAll() { return roomAlertRepository.findAll(); }

    public Optional<RoomAlert> singleRoomAlert(String id) { return roomAlertRepository.findById(id); }

    public RoomAlert createRoomAlert(RoomAlert roomAlert) { return roomAlertRepository.save(roomAlert); }

    public RoomAlert updateRoomAlert(@PathVariable String id, RoomAlert roomAlert) {
        return roomAlertRepository.save(roomAlert);
    }

    public void deleteRoomAlert(String id) { roomAlertRepository.deleteById(id); }
}
