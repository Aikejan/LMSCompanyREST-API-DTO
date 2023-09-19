package peaksoft.service;

import peaksoft.dto.request.CompanyRequest;
import peaksoft.dto.response.CompanyResponse;
import peaksoft.dto.response.PaginationResponse;
import peaksoft.dto.response.SimpleResponse;


import java.util.List;

public interface CompanyService {
    SimpleResponse saveCompany(CompanyRequest companyRequest);
    List<CompanyResponse> getAllCompanies();
    CompanyResponse findById(Long companyId);

    SimpleResponse deleteCompanyById(Long companyId);

    SimpleResponse updateCompany(Long id, CompanyRequest companyRequest);

    PaginationResponse getAllPagination(int currentPage, int pageSize);
}
