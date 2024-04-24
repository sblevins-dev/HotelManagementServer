package dev.stephenblevins.hospitality.hub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestService {

    @Autowired
    private GuestRepository guestRepository;

    public List<Guest> getAllGuests() { return guestRepository.findAll(); }

//    public Optional<Guest> singleGuest(ObjectId id) {
//        return guestRepository.findById(id);
//    }
}
