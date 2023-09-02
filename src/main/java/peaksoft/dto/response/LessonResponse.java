package peaksoft.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class LessonResponse {
    private  Long id;
    private String name;

    public LessonResponse(String name) {
        this.name = name;
    }
}
