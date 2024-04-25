package dev.stephenblevins.hospitality.hub;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class GuestService {

    @Autowired
    private GuestRepository guestRepository;

    public List<Guest> getAllGuests() { return guestRepository.findAll(); }

    public Optional<Guest> singleGuest(ObjectId id) {
        return guestRepository.findById(id);
    }

    public Guest createGuest(@RequestBody Guest guest) { return guestRepository.save(guest); }

    public Guest updateGuest(@PathVariable ObjectId id, @RequestBody Guest guest) { return guestRepository.save(guest); }

    public void deleteGuest(@PathVariable ObjectId id) { guestRepository.deleteById(id);}
}
