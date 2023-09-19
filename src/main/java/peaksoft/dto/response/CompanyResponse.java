package peaksoft.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import peaksoft.entities.Course;
import peaksoft.entities.Instructor;

import java.util.List;



@Getter
@Setter
@Builder
@AllArgsConstructor
public class CompanyResponse {
    private Long id;
    private String name;
    private String country;
    private String address;
    private String phoneNumber;


    public CompanyResponse(Long id, String name, String country, String address, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

}
