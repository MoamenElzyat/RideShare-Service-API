package com.example.miniapp.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "trips")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime tripDate;

    private String origin;

    private String destination;

    private Double tripCost;

    @ManyToOne
    @JoinColumn(name = "captain_id")
    private Captain captain;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne(mappedBy = "trip", cascade = CascadeType.ALL)
    private Payment payment;
    
    // Default constructor
    public Trip() {
    }
    
    // Constructor with required fields
    public Trip(LocalDateTime tripDate, String origin, String destination, Double tripCost) {
        this.tripDate = tripDate;
        this.origin = origin;
        this.destination = destination;
        this.tripCost = tripCost;
    }
    
    // All-args constructor
    public Trip(Long id, LocalDateTime tripDate, String origin, String destination, Double tripCost, 
               Captain captain, Customer customer, Payment payment) {
        this.id = id;
        this.tripDate = tripDate;
        this.origin = origin;
        this.destination = destination;
        this.tripCost = tripCost;
        this.captain = captain;
        this.customer = customer;
        this.payment = payment;
    }
    
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
    
    // Getters and setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public LocalDateTime getTripDate() {
        return tripDate;
    }
    
    public void setTripDate(LocalDateTime tripDate) {
        this.tripDate = tripDate;
    }
    
    public String getOrigin() {
        return origin;
    }
    
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    
    public String getDestination() {
        return destination;
    }
    
    public void setDestination(String destination) {
        this.destination = destination;
    }
    
    public Double getTripCost() {
        return tripCost;
    }
    
    public void setTripCost(Double tripCost) {
        this.tripCost = tripCost;
    }
    
    public Captain getCaptain() {
        return captain;
    }
    
    public void setCaptain(Captain captain) {
        this.captain = captain;
    }
    
    public Customer getCustomer() {
        return customer;
    }
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public Payment getPayment() {
        return payment;
    }
    
    public void setPayment(Payment payment) {
        this.payment = payment;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        Trip trip = (Trip) o;
        
        if (id != null ? !id.equals(trip.id) : trip.id != null) return false;
        if (tripDate != null ? !tripDate.equals(trip.tripDate) : trip.tripDate != null) return false;
        if (origin != null ? !origin.equals(trip.origin) : trip.origin != null) return false;
        if (destination != null ? !destination.equals(trip.destination) : trip.destination != null) return false;
        return tripCost != null ? tripCost.equals(trip.tripCost) : trip.tripCost == null;
    }
    
    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (tripDate != null ? tripDate.hashCode() : 0);
        result = 31 * result + (origin != null ? origin.hashCode() : 0);
        result = 31 * result + (destination != null ? destination.hashCode() : 0);
        result = 31 * result + (tripCost != null ? tripCost.hashCode() : 0);
        return result;
    }
    
    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", tripDate=" + tripDate +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", tripCost=" + tripCost +
                '}';
    }
}
