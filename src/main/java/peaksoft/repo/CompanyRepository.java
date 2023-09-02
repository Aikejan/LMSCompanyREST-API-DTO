package peaksoft.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import peaksoft.dto.response.CompanyResponse;
import peaksoft.entities.Company;

import java.util.List;


@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    @Query("select new peaksoft.dto.response.CompanyResponse(c.id,c.name,c.country,c.address,c.phoneNumber) from Company c")
    List<CompanyResponse> getAllCompanies();

    boolean existsByName(String name);
    @Query("select new peaksoft.dto.response.CompanyResponse(c.name,c.country,c.address,c.phoneNumber)from Company  c where c.id = :id")
    CompanyResponse getCompanyById(Long companyId);
}
