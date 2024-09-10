package com.pradeep.job_application.review.service.interfaces;

import com.pradeep.job_application.review.model.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviewsForCompany(Long companyId);

    boolean addReview(Long companyId, Review review);
}
