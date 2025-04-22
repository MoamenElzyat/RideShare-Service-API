package com.example.miniapp.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "ratings")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Rating {

    @Id
    private String id;

    @NonNull
    private Long tripId;

    @NonNull
    private Integer rating;

    private String comment;

    @NonNull
    private String ratingType;

    @NonNull
    private LocalDateTime ratingDate;

    // Constructor used in tests
    public Rating(long entityId, String entityType, int score, String comment, LocalDateTime ratingDate) {
        this.tripId = entityId;
        this.ratingType = entityType;
        this.rating = score;
        this.comment = comment;
        this.ratingDate = ratingDate;
    }
    
    // For backward compatibility with tests
    public Integer getScore() {
        return this.rating;
    }
    
    // For backward compatibility with tests
    public void setScore(int score) {
        this.rating = score;
    }
    
    // Manually adding setter for id for compatibility
    public void setId(String id) {
        this.id = id;
    }
}
