package peaksoft.valdation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;



import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)                     // PROGRAMMA ZAPUSC BOLGONDO ISHTEYT
@Constraint(validatedBy = PhoneNumberValidator.class)  // logica jazylgan class korsotyp koyduk
                                                      // TARGETTTI ushularga koysik bolot polyaga metodko
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
public @interface  PhoneNumberValidation {
    String message() default "Phone number should start with country code '+996' and consist of 13  symbols ";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
// @email   //... @NY TEKSHERET
