# About the project

This project explains how to implement exception handing by making use of @ControllerAdvice annotation in your REST based applications.

### Steps to implement Exception Handling in REST Services

* STEP 1 - Create a custom class which will extend RuntimeException class. And place a @ResponseEntity annotation above the class. @ResponseStatus(HttpStatus.BAD_REQUEST).
E.g. AgeNotInRangeException class will extend RuntimeException

* STEP 2 - Create another class E.g. CustomExceptionHandler, which will extends ResponseEntityExceptionHandler. This class should be annotated with @ControllerAdvice. And whichever methods you add inside this class should be annotated with @ExceptionHandler(<Name of the custom exception>) and inside that the name of custom exception class should be given. E.g. AgeNotInRangeException.class.
This method will return a response of type ResponseEntity<ErrorDetails>. ErrorDetails class will have a String which will carry the exception message and if possible another variable which will have an ENUM or string like AGE_NOT_IN_RANGE.

* STEP 3 - Finally if the intended business logic does not work then we can just add a throw statement with the Custom exception class we created in STEP 1
E.g. throw new AgeNotInRangeException("You are not eligible for the service as per the age restriction");