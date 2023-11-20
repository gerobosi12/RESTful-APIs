package net.java.emsbackend.mapper;

import net.java.emsbackend.dto.CompanyDto;
import net.java.emsbackend.entity.Company;

public class CompanyMapper {
    public static CompanyDto mapToCompanyDto(Company company) {
        return new CompanyDto(
                company.getId(),
                company.getName(),
                company.getAddress(),
                company.getEmail(),
                company.getOwner()

        );


    }

    public static Company mapToCompany(CompanyDto companyDto) {
        return new Company(


                companyDto.getId(),
                companyDto.getName(),
                companyDto.getAddress(),
                companyDto.getEmail(),
                companyDto.getOwner()
        );
    }
}
