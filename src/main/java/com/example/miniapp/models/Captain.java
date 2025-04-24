package com.example.miniapp.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "captains")
public class Captain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String licenseNumber;

    private Double avgRatingScore;

    @OneToMany(mappedBy = "captain", cascade = CascadeType.ALL)
    private List<Trip> trips;
    
    // Default constructor
    public Captain() {
    }
    
    // Constructor with required fields
    public Captain(String name, String licenseNumber) {
        this.name = name;
        this.licenseNumber = licenseNumber;
    }
    
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
    
    // All-args constructor
    public Captain(Long id, String name, String licenseNumber, Double avgRatingScore, List<Trip> trips) {
        this.id = id;
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.avgRatingScore = avgRatingScore;
        this.trips = trips;
    }
    
    // Getters and setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getLicenseNumber() {
        return licenseNumber;
    }
    
    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }
    
    public Double getAvgRatingScore() {
        return avgRatingScore;
    }
    
    public void setAvgRatingScore(Double avgRatingScore) {
        this.avgRatingScore = avgRatingScore;
    }
    
    public List<Trip> getTrips() {
        return trips;
    }
    
    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        Captain captain = (Captain) o;
        
        if (id != null ? !id.equals(captain.id) : captain.id != null) return false;
        if (name != null ? !name.equals(captain.name) : captain.name != null) return false;
        if (licenseNumber != null ? !licenseNumber.equals(captain.licenseNumber) : captain.licenseNumber != null)
            return false;
        return avgRatingScore != null ? avgRatingScore.equals(captain.avgRatingScore) : captain.avgRatingScore == null;
    }
    
    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (licenseNumber != null ? licenseNumber.hashCode() : 0);
        result = 31 * result + (avgRatingScore != null ? avgRatingScore.hashCode() : 0);
        return result;
    }
    
    @Override
    public String toString() {
        return "Captain{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", licenseNumber='" + licenseNumber + '\'' +
                ", avgRatingScore=" + avgRatingScore +
                '}';
    }
}
