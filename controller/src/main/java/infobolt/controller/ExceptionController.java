package infobolt.controller;

import infobolt.exceptions.AlkatreszNemTalalhato;
import infobolt.exceptions.RosszAzonosito;
import infobolt.exceptions.AlkatreszMarVan;
import infobolt.exceptions.RosszGyartasiev;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(AlkatreszNemTalalhato.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    public String notFound(AlkatreszNemTalalhato e) {
        return e.getMessage();
    }

    @ExceptionHandler(RosszAzonosito.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    public String RosszAzonosito(RosszAzonosito e) {
        return e.getMessage();
    }

    @ExceptionHandler(RosszGyartasiev.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    public String RosszGyartasiEv(RosszGyartasiev e) {
        return e.getMessage();
    }

    @ExceptionHandler(AlkatreszMarVan.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.IM_USED)
    public String AlkatreszMarVan(AlkatreszMarVan e) {
        return e.getMessage();
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ResponseBody
    public String unSupported(){
        return "Acceptable media types:"+ MediaType.APPLICATION_JSON_VALUE;
    }

}
