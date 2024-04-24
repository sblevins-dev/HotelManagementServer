package dev.stephenblevins.hospitality.hub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/guests")
public class GuestController {

    @Autowired
    private GuestService guestService;

    @GetMapping
    public ResponseEntity<List<Guest>> getGuests() {
        return new ResponseEntity<>(guestService.getAllGuests(), HttpStatus.OK);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Optional<Guest>> getGuestById(@PathVariable ObjectId id) {
//        return new ResponseEntity<>(guestService.singleGuest(id), HttpStatus.OK);
//    }
}
