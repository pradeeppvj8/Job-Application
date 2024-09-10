package com.pradeep.job_application.review.service.impl;

import com.pradeep.job_application.company.model.Company;
import com.pradeep.job_application.company.repository.CompanyRepository;
import com.pradeep.job_application.review.model.Review;
import com.pradeep.job_application.review.repository.ReviewRepository;
import com.pradeep.job_application.review.service.interfaces.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final CompanyRepository companyRepository;

    @Override
    public List<Review> getAllReviewsForCompany(Long companyId) {
        return reviewRepository.findByCompanyId(companyId);
    }

    @Override
    public boolean addReview(Long companyId, Review review) {
        Optional<Company> companyOpt = companyRepository.findById(companyId);

        if (companyOpt.isPresent()) {
            review.setCompany(companyOpt.get());
            reviewRepository.save(review);
            return true;
        } else {
            return false;
        }
    }
}
