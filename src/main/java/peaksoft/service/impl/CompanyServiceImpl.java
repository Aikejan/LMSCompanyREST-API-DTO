package peaksoft.service.impl;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.dto.request.CompanyRequest;
import peaksoft.dto.response.CompanyResponse;
import peaksoft.dto.SimpleResponse;
import peaksoft.entities.Company;
import peaksoft.repo.CompanyRepository;
import peaksoft.service.CompanyService;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;


@Service
@RequiredArgsConstructor
@Transactional
@Builder
public class CompanyServiceImpl implements CompanyService {
    private  final CompanyRepository companyRepository;

    @Override
    public SimpleResponse saveCompany(CompanyRequest companyRequest) {
        try {
            Company company = new Company();
            company.setName(companyRequest.getName());
            company.setCountry(companyRequest.getCountry());
            company.setAddress(companyRequest.getAddress());
            company.setPhoneNumber(companyRequest.getPhoneNumber());

            if (companyRepository.existsByName(company.getName())) {
                throw new IOException("Company name and phoneNumber must be unique");
            }

            companyRepository.save(company);

            return SimpleResponse.builder()
                    .status("SUCCESSFULLY SAVED")
                    .message("Company with id: " + company.getName() + " is saved!")
                    .build();

        } catch (IOException e) {
            return SimpleResponse.builder()
                    .status("ERROR")
                    .message("Failed to save company: " + e.getMessage())
                    .build();
        }
    }

    @Override
    public List<CompanyResponse> getAllCompanies() {
        return companyRepository.getAllCompanies();
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




