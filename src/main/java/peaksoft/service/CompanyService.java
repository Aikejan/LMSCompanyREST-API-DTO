package peaksoft.service;

import peaksoft.dto.request.CompanyRequest;
import peaksoft.dto.response.CompanyResponse;
import peaksoft.dto.SimpleResponse;


import java.util.List;

public interface CompanyService {
    SimpleResponse saveCompany(CompanyRequest companyRequest);
    List<CompanyResponse> getAllCompanies();
    CompanyResponse findById(Long companyId);

    SimpleResponse deleteCompanyById(Long companyId);

    SimpleResponse updateCompany(Long id, CompanyRequest companyRequest);
}
