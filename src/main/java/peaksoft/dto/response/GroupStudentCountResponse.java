package peaksoft.dto.response;

import lombok.Builder;

import java.util.List;
@Builder
public class GroupStudentCountResponse {
    private Long id;
    private  String name;
    private String country;
    private String address;
    private String phoneNumber;
    private List<String > groupName;
    private List<String> courseName;
    private List<String> instructorName;
    private  int allStudentsOfNumber;

    public GroupStudentCountResponse(Long id, String name, String country, String address, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
}
