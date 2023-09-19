package peaksoft.service.impl;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.dto.request.CompanyRequest;
import peaksoft.dto.response.CompanyResponse;
import peaksoft.dto.response.PaginationResponse;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.entities.Company;
import peaksoft.repo.CompanyRepository;
import peaksoft.service.CompanyService;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;


@Service
@RequiredArgsConstructor
@Transactional
@Builder
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;

    @Override
    public SimpleResponse saveCompany(CompanyRequest companyRequest) {
        Company company = new Company();
        company.setName(companyRequest.getName());
        company.setCountry(companyRequest.getCountry());
        company.setAddress(companyRequest.getAddress());
        company.setPhoneNumber(companyRequest.getPhoneNumber());

        if (companyRepository.existsByName(company.getName())) {
            new IOException("Company name and phoneNumber must be unique");
        }

        companyRepository.save(company);

        return SimpleResponse.builder()
                .status("SUCCESSFULLY SAVED")
                .message("Company with id: " + company.getName() + " is saved!")
                .build();

    }

    @Override
    public List<CompanyResponse> getAllCompanies() {
//        return companyRepository.getAllCompanies();
        return null;
    }


    @Override
    public SimpleResponse updateCompany(Long companyId, CompanyRequest companyRequest) {
        try {
            Company company = companyRepository.findById(companyId).orElseThrow(() ->
                    new NoSuchElementException("Company with id: " + companyId + " does not exist"));

            company.setName(companyRequest.getName());
            company.setCountry(companyRequest.getCountry());
            company.setAddress(companyRequest.getAddress());
            company.setPhoneNumber(companyRequest.getPhoneNumber());
            companyRepository.save(company);

            return SimpleResponse.builder()
                    .status("SUCCESSFULLY UPDATED")
                    .message("Company with id: " + company.getName() + " is updated")
                    .build();

        } catch (Exception e) {
            return SimpleResponse.builder()
                    .status("ERROR")
                    .message("Failed to update company: " + e.getMessage())
                    .build();
        }


    }

    @Override
    public PaginationResponse getAllPagination(int currentPage, int pageSize) {

        Pageable pageable = PageRequest.of(currentPage - 1, pageSize);
        Page<CompanyResponse> companies = companyRepository.findAllCompanies(pageable);
        return PaginationResponse.builder()
                .t(Collections.singletonList(companies.getContent()))
                .currentPage(companies.getNumber())
                .pageSize(companies.getTotalPages())
                .build();

    }



    @Override
    public CompanyResponse findById(Long companyId) {

        try {
            companyRepository.findById(companyId).orElseThrow(() ->
                    new NoSuchElementException("Company with id: " + companyId + " is not found!"));
            return companyRepository.getCompanyById(companyId);

        } catch (Exception e) {
            throw new RuntimeException("Failed to get company: " + e.getMessage());
        }
    }







    @Override
    public SimpleResponse deleteCompanyById(Long companyId) {

        try {
            companyRepository.deleteById(companyId);
            return SimpleResponse.builder().status("SUCCESSFULLY DELETED!")
                    .message("Company with id: " + companyId + " is deleted!").build();

        } catch (Exception e) {
            throw new RuntimeException("Failed to delete company: " + e.getMessage());
        }
    }
    }




