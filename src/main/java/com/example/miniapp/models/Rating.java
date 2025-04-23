package com.example.miniapp.models;

import lombok.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
    private Long entityId; // Updated from tripId

    @NonNull
    private String entityType; // Added for clarity (captain, customer, trip)

    @NonNull
    @Min(1)
    @Max(5)
    private Integer score;

    private String comment;

    @NonNull
    private LocalDateTime ratingDate;

    // Constructor for tests
    public Rating(long entityId, String entityType, int score, String comment, LocalDateTime ratingDate) {
        this.entityId = entityId;
        this.entityType = entityType;
        this.score = score;
        this.comment = comment;
        this.ratingDate = ratingDate;
    }
    public Rating(int score) {
        this.entityId = 1L;
        this.entityType = "trip";
        this.score = score;
        this.ratingDate = LocalDateTime.now();
    }
}