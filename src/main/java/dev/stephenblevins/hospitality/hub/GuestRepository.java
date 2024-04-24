package dev.stephenblevins.hospitality.hub;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends MongoRepository<Guest, ObjectId> {
    //Optional<Guest> findById(ObjectId id);
}
