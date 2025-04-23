package com.example.miniapp.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "captains")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Captain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    @Column(unique = true)
    private String licenseNumber;

    private Double avgRatingScore;

    @OneToMany(mappedBy = "captain", cascade = CascadeType.ALL)
    private List<Trip> trips;
    
    // Constructor used in tests
    public Captain(String name, String licenseNumber, double avgRatingScore) {
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.avgRatingScore = avgRatingScore;
    }
    
    /**
     * Logical constructor with ID for testing
     * @param id captain ID (can be null for new captains)
     * @param name captain name
     * @param licenseNumber captain license number
     * @param avgRatingScore captain's average rating
     */
    public Captain(Long id, String name, String licenseNumber, Double avgRatingScore) {
        this.id = id;
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.avgRatingScore = avgRatingScore;
    }
    
    // Manually adding setter for id for compatibility
    public void setId(Long id) {
        this.id = id;
    }
}
