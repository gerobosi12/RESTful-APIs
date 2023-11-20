package net.java.emsbackend.service;

import net.java.emsbackend.dto.CompanyDto;

public interface CompanyService {
    CompanyDto createCompany(CompanyDto companyDto);
    CompanyDto getCompanyById(Long companyId);





}
