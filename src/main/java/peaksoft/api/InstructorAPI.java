package peaksoft.api;



import org.springframework.web.bind.annotation.*;
import peaksoft.dto.SimpleResponse;
import peaksoft.dto.request.InstructorRequest;
import peaksoft.dto.response.InstructorResponse;
import peaksoft.service.InstructorService;

import java.util.List;

@RestController
@RequestMapping("/api/instructors")

public class InstructorAPI {
    private  final InstructorService instructorService;

    public InstructorAPI(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping
    public List<InstructorResponse> getAll() {
        return instructorService.getAllInstructors();
    }

    @PostMapping("/save")
    public SimpleResponse saveInstructor(@RequestBody InstructorRequest instructorRequest) {
        return instructorService.saveInstructor(instructorRequest);
    }

    @GetMapping("/{id}")
    public InstructorResponse getById(@PathVariable Long id) {
        return instructorService.getInstructorById(id);
    }

    @PutMapping("/{id}")
    public SimpleResponse update(@PathVariable Long id, @RequestBody InstructorRequest instructorRequest) {
        return instructorService.updateInstructor(id, instructorRequest);
    }

    @DeleteMapping("/{id}")
    public SimpleResponse deleteById(@PathVariable Long id) {
        return instructorService.deleteInstructorById(id);
    }

    @PostMapping("/{companyId}/{instructorId}/assignCompanyIdByInstructorId")
    public SimpleResponse assign(@PathVariable Long companyId, @PathVariable Long instructorId){
        return instructorService.assignInstructor(companyId, instructorId);
    }

}
