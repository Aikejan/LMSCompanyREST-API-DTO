package peaksoft.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GlobalHandlerException {

    @ExceptionHandler(InvalidNameException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)

    public ExceptionResponse InvalidException(InvalidNameException i){
        return  new ExceptionResponse(HttpStatus.BAD_REQUEST,i.getClass().getSimpleName(),
                i.getMessage());
    }
}
