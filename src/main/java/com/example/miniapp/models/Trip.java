package com.example.miniapp.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "trips")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private LocalDateTime tripDate;

    @NonNull
    private String origin;

    @NonNull
    private String destination;

    @NonNull
    private Double tripCost;

    @ManyToOne
    @JoinColumn(name = "captain_id")
    private Captain captain;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne(mappedBy = "trip", cascade = CascadeType.ALL)
    private Payment payment;
    
    /**
     * Logical constructor for testing with all fields
     * @param id trip ID (can be null for new trips)
     * @param tripDate date and time of the trip
     * @param origin origin location
     * @param destination destination location
     * @param tripCost cost of the trip
     * @param captain captain of the trip (can be null)
     * @param customer customer of the trip (can be null)
     */
    public Trip(Long id, LocalDateTime tripDate, String origin, String destination, 
               Double tripCost, Captain captain, Customer customer) {
        this.id = id;
        this.tripDate = tripDate;
        this.origin = origin;
        this.destination = destination;
        this.tripCost = tripCost;
        this.captain = captain;
        this.customer = customer;
    }
    // Constructor for tests

    public Trip(Long id, LocalDateTime tripDate, String origin, String destination, Double tripCost) {
        this.id = id;
        this.tripDate = tripDate;
        this.origin = origin;
        this.destination = destination;
        this.tripCost = tripCost;
    }
    public Trip(String origin, String destination, Double cost) {
        this.tripDate = LocalDateTime.now();
        this.origin = origin;
        this.destination = destination;
        this.tripCost = cost;
    }
    // Manually adding setter for id for compatibility
    public void setId(Long id) {
        this.id = id;
    }
}
