package peaksoft.api;

import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.response.PaginationResponse;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.dto.request.StudentRequest;
import peaksoft.dto.response.StudentResponse;
import peaksoft.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentAPI {

      private final StudentService studentService;



    @GetMapping("/{groupId}/getAll")
    public List<StudentResponse> getAll(@PathVariable Long groupId) {
        return studentService.getAllStudents(groupId);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/{groupId}/save")
    public SimpleResponse save(@PathVariable Long groupId, @RequestBody @Valid StudentRequest studentRequest) {
        return studentService.saveStudent(groupId, studentRequest);
    }
        @PermitAll
    @GetMapping("/{id}")
    StudentResponse getById(@PathVariable Long id) {
        return studentService.getById(id);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/{id}/update")
    public SimpleResponse update(@PathVariable Long id, @RequestBody StudentRequest studentRequest) {
        return studentService.updateStudent(id, studentRequest);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}/delete")
    public SimpleResponse delete(@PathVariable Long id) {
        return studentService.deleteById(id);
    }
    @PreAuthorize("hasAuthority('INSTRUCTOR')")
    @PostMapping("/creat")
    public SimpleResponse createGroup(@RequestBody Long id) {
        String groupName = httpStatus.name();
        List<Long> courseIds =httpStatus.names();

        return studentService.createGroups(groupName, courseIds);
    }
    @PreAuthorize("hasAuthority('INSTRUCTOR')")
    @PostMapping("/blocked/{studentId}")
    public SimpleResponse blockUnblockStudent(@PathVariable Long studentId, @RequestParam Boolean block){
        return studentService.blockUnblockStudent(studentId,block);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/filter")
    public List<StudentResponse> getFilterStudent(@RequestParam String studyFormat){
        return studentService.filter(studyFormat);
    }
    @GetMapping("/pagination")
    public PaginationResponse pagination(@RequestParam int currentPage,
                                                              @RequestParam int pageSize){
        return studentService.getAllPagination(currentPage, pageSize);


    }


}
