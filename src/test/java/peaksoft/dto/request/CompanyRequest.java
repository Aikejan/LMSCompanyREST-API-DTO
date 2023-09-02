package peaksoft.dto.request;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CompanyRequest {
    //@Length(min = 2, max = 20, message = "Name's length should be between 2 and 20!")
    private String name;
    //        @NotNull(message = "Country shouldn't be null!")
    private String country;
   // @NotNull(message = "Address shouldn't be null!")
    private String address;
    //@Pattern(regehp = "\\+996\\d{9}", message = "Phone number should start with +996 and consist of 13 characters!")
    private  String phoneNumber;

    public CompanyRequest(String name, String country, String address, String phoneNumber) {
        this.name = name;
        this.country = country;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
}
