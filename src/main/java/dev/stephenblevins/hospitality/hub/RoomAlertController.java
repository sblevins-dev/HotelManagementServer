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
@RequestMapping("/api/v1/roomAlerts")
public class RoomAlertController {
    Logger log = Logger.getLogger(this.getClass().getName());

    @Autowired
    private RoomAlertService roomAlertService;

    @GetMapping
    public ResponseEntity<List<RoomAlert>> getRoomAlerts() {
        return new ResponseEntity<>(roomAlertService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{roomNumber}")
    public ResponseEntity<Optional<RoomAlert>> getRoomAlert(@PathVariable String roomNumber) {
        return new ResponseEntity<>(roomAlertService.singleRoomAlert(roomNumber), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RoomAlert> createRoomAlert(@RequestBody RoomAlert roomAlert) {
        log.info("Trying to create room alert: " + roomAlert.toString());
        return new ResponseEntity<>(roomAlertService.createRoomAlert(roomAlert), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoomAlert> updateRoomAlert(@PathVariable String id, @RequestBody RoomAlert roomAlert) {
        try {
            Optional<RoomAlert> optionalRoomAlert = roomAlertService.singleRoomAlert(id);
            if (optionalRoomAlert.isPresent()) {
                roomAlert.setId(optionalRoomAlert.get().getId());
            }


            RoomAlert updatedRoomAlert = roomAlertService.updateRoomAlert(id, roomAlert);
            return new ResponseEntity<>(updatedRoomAlert, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
