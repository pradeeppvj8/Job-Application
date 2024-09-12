package com.pradeep.job_application.review.repository;

import com.pradeep.job_application.review.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByCompanyId(Long companyId);

    Review findByIdAndCompanyId(Long reviewId, Long companyId);

    void deleteByIdAndCompanyId(Long reviewId, Long companyId);

    boolean existsByIdAndCompanyId(Long reviewId, Long companyId);
}
