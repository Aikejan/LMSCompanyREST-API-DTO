package peaksoft.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import peaksoft.exception.*;

@RestControllerAdvice                       // BAARDYK EXCEPTIONDORDU KARMAP BERET
public class GlobalExceptionHandler {      // baardyk exceptioClasstardy karmap beret
    @ExceptionHandler(NotFoundException.class)  // NOTFOUND CLASSTYN ICHINDEGI EXCEPTIONDORDU KAYTARAT
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse notFoundException(NotFoundException e) {
        return ExceptionResponse.builder()
                .httpStatus(HttpStatus.NOT_FOUND)
                .exceptionClassName(e.getClass().getSimpleName())// NOTFOUND CLASSTYN ATYN KAYTARAT
                .message(e.getMessage())           // NOTFOUND CLASSTYN MESSAGESYN KAYTARAT
                .build();

    }

    @ExceptionHandler(AlreadyExistException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ExceptionResponse alreadyExistException(AlreadyExistException e) { // CONFLICT BOLOT BUL CLASSTA
        return ExceptionResponse.builder()
                .httpStatus(HttpStatus.CONFLICT)
                .exceptionClassName(e.getClass().getSimpleName())
                .message(e.getMessage())
                .build();
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse badRequestException(BadRequestException a) {
        return ExceptionResponse.builder()
                .httpStatus(HttpStatus.BAD_REQUEST)
                .exceptionClassName(a.getClass().getSimpleName())
                .message(a.getMessage())
                .build();
    }

    @ExceptionHandler(BadCredentialException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)         // PAROLDU JE EMAILDY TUURA EMES BERSEK EXCEPTION YRGYTAT
    public ExceptionResponse badCredentialException(BadCredentialException a) {
        return ExceptionResponse.builder()
                .httpStatus(HttpStatus.FORBIDDEN)
                .exceptionClassName(a.getClass().getSimpleName())
                .message(a.getMessage())
                .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)         // PAROLDU JE EMAILDY TUURA EMES BERSEK EXCEPTION YRGYTAT
    public ExceptionResponse methodArgumentNotValidException(MethodArgumentNotValidException a) {
        return ExceptionResponse.builder()
                .httpStatus(HttpStatus.NOT_FOUND)
                .exceptionClassName(a.getClass().getSimpleName())
                .message(a.getMessage())
                .build();
    }
}