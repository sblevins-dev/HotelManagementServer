package dev.stephenblevins.hospitality.hub;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection= "rooms")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {

    @Id
    private ObjectId id;
    private String roomNumber;
    private Integer beds;
    private Integer floorNumber;
    private String status;
    private String description;
}
