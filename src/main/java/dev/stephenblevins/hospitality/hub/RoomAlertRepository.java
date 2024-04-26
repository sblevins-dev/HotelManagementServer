package dev.stephenblevins.hospitality.hub;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomAlertRepository extends MongoRepository<RoomAlert, String> {
}
