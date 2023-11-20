package net.java.emsbackend.service.impl;


import lombok.AllArgsConstructor;
import net.java.emsbackend.dto.CompanyDto;
import net.java.emsbackend.entity.Company;
import net.java.emsbackend.exeption.ResourceNotFound;
import net.java.emsbackend.mapper.CompanyMapper;
import net.java.emsbackend.repository.CompanyRepository;
import net.java.emsbackend.service.CompanyService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private CompanyRepository companyRepository;

    @Override
    public CompanyDto createCompany(CompanyDto companyDto) {
        Company company = CompanyMapper.mapToCompany(companyDto);
        Company savedCompany = companyRepository.save(company);
        return CompanyMapper.mapToCompanyDto(savedCompany);
    }

    @Override
    public CompanyDto getCompanyById(Long companyId) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() ->
                        new ResourceNotFound("Company doesn't exist with the given id : " + companyId));
        return CompanyMapper.mapToCompanyDto(company);


    }
}


