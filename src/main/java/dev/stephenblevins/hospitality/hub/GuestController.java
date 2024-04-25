package dev.stephenblevins.hospitality.hub;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/guests")
public class GuestController {

    Logger log = Logger.getLogger(this.getClass().getName());

    @Autowired
    private GuestService guestService;

    @GetMapping
    public ResponseEntity<List<Guest>> getGuests() {
        return new ResponseEntity<>(guestService.getAllGuests(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Guest>> getGuestById(@PathVariable ObjectId id) {
        return new ResponseEntity<>(guestService.singleGuest(id), HttpStatus.OK);
    }

//    private ObjectId id;
//    private String fName;
//    private String lName;
//    private String roomNum;
//    private Integer additionalGuests;
//    LocalDateTime checkIn;
//    LocalDateTime checkOut;

    @PostMapping
    public ResponseEntity<Guest> createGuest(@RequestBody Guest guest) {
        log.info("Creating guest: " + guest);
        try {
            Guest createdGuest = guestService.createGuest(guest);
            return new ResponseEntity<>(createdGuest, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Guest> updateGuest(@PathVariable ObjectId id, @RequestBody Guest guest) {
        log.info("Updating guest: " + guest + " with id: " + id);
        try {
            Optional<Guest> foundGuest = guestService.singleGuest(id);
            log.info("Found guest: " + foundGuest);

            if (foundGuest.isPresent()) {
                guest.setId(new ObjectId(String.valueOf(foundGuest.get().getId())));
            }

            Guest updatedGuest = guestService.updateGuest(id, guest);
            return new ResponseEntity<>(updatedGuest, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Guest> deleteGuest(@PathVariable ObjectId id) {
        try {
            guestService.deleteGuest(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
