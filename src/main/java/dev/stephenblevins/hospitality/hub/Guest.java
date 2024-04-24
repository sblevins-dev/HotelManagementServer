package dev.stephenblevins.hospitality.hub;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "guests")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Guest {

    @Id
    private ObjectId id;
    private String fName;
    private String lName;
    private String roomNum;
    private Integer additionalGuests;
    LocalDateTime checkIn;
    LocalDateTime checkOut;
}
