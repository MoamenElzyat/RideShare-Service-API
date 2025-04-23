package com.example.miniapp.services;

import com.example.miniapp.models.Rating;
import com.example.miniapp.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;

    @Autowired
    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public Rating addRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    public Rating updateRating(String id, Rating updatedRating) {
        updatedRating.setId(id);
        return ratingRepository.save(updatedRating);
    }

    public void deleteRating(String id) {
        ratingRepository.deleteById(id);
    }

    public List<Rating> getRatingsByTripAndType(Long tripId, String ratingType) {
        return ratingRepository.findByTripIdAndRatingType(tripId, ratingType);
    }

    public List<Rating> getRatingsByMinimumRating(int minRating) {
        return ratingRepository.findByRatingGreaterThan(minRating);
    }

    public List<Rating> findRatingsAboveScore(int minScore) {
        return ratingRepository.findByRatingGreaterThan(minScore);
    }
}
