package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.request.CompanyRequest;
import peaksoft.dto.response.CompanyResponse;
import peaksoft.dto.SimpleResponse;
import peaksoft.service.CompanyService;

import java.util.List;


@RestController
@RequestMapping("/api/company")
@RequiredArgsConstructor
public class CompanyAPI {

    private final CompanyService companyService;
    @GetMapping
    public List<CompanyResponse> getAllCompanies(){
        return  companyService.getAllCompanies();
    }

    @PostMapping
    public SimpleResponse saveCompany(@RequestBody CompanyRequest companyRequest) {
        return companyService.saveCompany(companyRequest);

    }

    @GetMapping("{companyId}")
    public CompanyResponse getById(@PathVariable Long companyId){
        return companyService.findById(companyId);
    }

    @DeleteMapping("/{id}")
    public SimpleResponse deleteById(@PathVariable Long id) {
        return companyService.deleteCompanyById(id);
    }

    @PutMapping("/{id}")
    public SimpleResponse update(@PathVariable Long id, @RequestBody CompanyRequest companyRequest) {
        return companyService.updateCompany(id, companyRequest);
    }
}



