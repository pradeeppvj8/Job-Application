package com.pradeep.job_application.review.service.impl;

import com.pradeep.job_application.company.model.Company;
import com.pradeep.job_application.company.service.interfaces.CompanyService;
import com.pradeep.job_application.review.model.Review;
import com.pradeep.job_application.review.repository.ReviewRepository;
import com.pradeep.job_application.review.service.interfaces.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final CompanyService companyService;

    @Override
    public List<Review> getAllReviewsForCompany(Long companyId) {
        return reviewRepository.findByCompanyId(companyId);
    }

    @Override
    public boolean addReview(Long companyId, Review review) {
        Company company = companyService.getCompanyById(companyId);

        if (company != null) {
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Review getReview(Long companyId, Long reviewId) {
        return reviewRepository.findByIdAndCompanyId(reviewId, companyId);
    }

    @Override
    public boolean updateReview(Long companyId, Long reviewId, Review updatedReview) {
        Company company = companyService.getCompanyById(companyId);

        if (company != null) {
            updatedReview.setCompany(company);
            updatedReview.setId(reviewId);
            reviewRepository.save(updatedReview);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteReview(Long companyId, Long reviewId) {
        Company company = companyService.getCompanyById(companyId);

        if (company != null && reviewRepository.existsByIdAndCompanyId(reviewId, companyId)) {
            Review review = reviewRepository.findByIdAndCompanyId(reviewId, companyId);
            company.getReviews().remove(review);
            companyService.updateCompany(company, companyId);
            reviewRepository.deleteByIdAndCompanyId(reviewId,companyId);
            return true;
        } else {
            return false;
        }
    }
}
