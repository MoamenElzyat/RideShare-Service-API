package com.example.miniapp.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "payments")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private Double amount;

    @NonNull
    private String paymentMethod;

    @NonNull
    private Boolean paymentStatus;

    @OneToOne
    @JoinColumn(name = "trip_id", referencedColumnName = "id")
    private Trip trip;
    
    /**
     * Logical constructor for testing with all fields
     * @param id payment ID (can be null for new payments)
     * @param amount payment amount
     * @param paymentMethod method of payment (e.g., CREDIT_CARD, CASH)
     * @param paymentStatus payment status (true=completed, false=pending)
     * @param trip the associated trip (can be null)
     */
    public Payment(Long id, Double amount, String paymentMethod, Boolean paymentStatus, Trip trip) {
        this.id = id;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
        this.trip = trip;
    }
    // Constructor for tests

    public Payment(Long id, Double amount, String paymentMethod, Boolean paymentStatus) {
        this.id = id;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
    }
    // Manually adding setter for id for compatibility
    public void setId(Long id) {
        this.id = id;
    }
}
