package com.pradeep.job_application.company.repository;

import com.pradeep.job_application.company.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
