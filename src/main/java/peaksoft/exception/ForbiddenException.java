package peaksoft.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ForbiddenException extends  RuntimeException{  /// zapreshen exception
    public ForbiddenException(){

    }
    public ForbiddenException(String message){
        super(message);
    }
}
