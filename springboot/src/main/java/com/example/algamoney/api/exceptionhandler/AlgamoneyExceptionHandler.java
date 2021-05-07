package com.example.algamoney.api.exceptionhandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Locale;

@ControllerAdvice
public class AlgamoneyExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {

        String mensagemUsuario = messageSource.getMessage("mensagem.invalida",null, LocaleContextHolder.getLocale());
        String mensagemProgramador = ex.getCause().toString();
        return handleExceptionInternal(ex, new Erro(mensagemUsuario, mensagemProgramador),
                headers, HttpStatus.BAD_REQUEST, request);

    }

    public static class Erro{

        private String mensagemUsuario;
        private String mensagemProgramador;

        public Erro(String mensagemUsuario, String mensagemProgramador){
            this.mensagemUsuario = mensagemUsuario;
            this.mensagemProgramador = mensagemProgramador;
        }

        public String getMensagemUsuario() {
            return mensagemUsuario;
        }

        public String getMensagemProgramador() {
            return mensagemProgramador;
        }
        
    }

}
