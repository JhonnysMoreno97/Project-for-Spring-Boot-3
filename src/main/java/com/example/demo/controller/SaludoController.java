package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RequestMapping
@RestController("api")
public class SaludoController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/saludo")
    public String index(@RequestHeader(name = "Accept-Language", required = false) String acceptLanguage) {
        Locale locale = extractLocaleFromHeader(acceptLanguage);
        return messageSource.getMessage("saludo.message", null, locale);
    }

    private Locale extractLocaleFromHeader(String acceptLanguage) {
        if (acceptLanguage == null || acceptLanguage.isEmpty()) {
            return Locale.getDefault(); // Usar el Locale por defecto si no se proporciona el encabezado
        }

        // Toma la primera parte del encabezado (el primer idioma)
        String[] languages = acceptLanguage.split(",");
        String primaryLanguage = languages[0].split(";")[0].trim();
        return Locale.forLanguageTag(primaryLanguage);
    }


}
