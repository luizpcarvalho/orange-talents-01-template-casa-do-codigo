package br.com.zup.casadocodigo.config.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ErrosHandler {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErroDeValidacaoDto> argumentoInvalidoHandle(MethodArgumentNotValidException e) {
        List<ErroDeValidacaoDto> errosDto = new ArrayList<>();

        List<FieldError> errors = e.getBindingResult().getFieldErrors();
        errors.forEach(erro -> {
            String mensagem = messageSource.getMessage(erro, LocaleContextHolder.getLocale());
            ErroDeValidacaoDto erroDto = new ErroDeValidacaoDto(erro.getField(), mensagem);
            errosDto.add(erroDto);
        });

        return errosDto;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EntityNotFoundException.class)
    public ErroDeValidacaoDto erroEntidadeNaoEncontradaHandler(EntityNotFoundException e) {
        String mensagem = e.getMessage();
        ErroDeValidacaoDto erroDeValidacaoDto = new ErroDeValidacaoDto("cadastro", mensagem);
        return erroDeValidacaoDto;
    }

}