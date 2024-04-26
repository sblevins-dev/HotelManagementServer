package dev.stephenblevins.hospitality.hub;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection= "roomAlerts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomAlert {
    @Id
    private ObjectId id;
    private String issue;
    private String room;
    private String status;
    private String assignee;
}
