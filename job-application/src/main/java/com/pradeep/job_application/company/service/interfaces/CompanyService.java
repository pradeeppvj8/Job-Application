package com.pradeep.job_application.company.service.interfaces;

import com.pradeep.job_application.company.model.Company;

import java.util.List;

public interface CompanyService {

    List<Company> getAllCompanies();

    boolean updateCompany(Company company, Long id);

    void createCompany(Company company);

    boolean deleteCompany(Long id);

    Company getCompanyById(Long id);
}
