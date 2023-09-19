package peaksoft.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.request.CompanyRequest;
import peaksoft.dto.response.CompanyResponse;
import peaksoft.dto.response.PaginationResponse;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.service.CompanyService;

import java.util.List;


@RestController
@RequestMapping("/api/company")
@Tag(name = "CompanyAPI")
@RequiredArgsConstructor
public class CompanyAPI {

    private final CompanyService companyService;


    @PreAuthorize("hasAuthority('ADMIN')")  ///  PUT OPEREDELYAUSHIY PUT POLE
    @GetMapping
    public List<CompanyResponse> getAllCompanies(){
        return  companyService.getAllCompanies();
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public SimpleResponse saveCompany(@RequestBody CompanyRequest companyRequest) {
        return companyService.saveCompany(companyRequest);
    }

    @PreAuthorize("hasAuthority('INSTRUCTOR')")
    @GetMapping("{companyId}")
    public CompanyResponse getById(@PathVariable Long companyId){
        return companyService.findById(companyId);
    }


    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public SimpleResponse deleteById(@PathVariable Long id) {
        return companyService.deleteCompanyById(id);
    }


    @PreAuthorize("hasAuthority('INSTRUCTOR')")
    @PutMapping("/{id}")
    public SimpleResponse update(@PathVariable Long id, @RequestBody CompanyRequest companyRequest) {
        return companyService.updateCompany(id, companyRequest);
    }

    public ResponseEntity<PaginationResponse> paginationResponse(@RequestParam @Min(1) int currentPage,
                                                                 @RequestParam @Min(1) int pageSize){
        if(currentPage < 1 || pageSize < 1){
            return ResponseEntity.badRequest().build();
        }
        PaginationResponse response = companyService.getAllPagination(currentPage,pageSize);
        return ResponseEntity.ok(response);
    }
}



