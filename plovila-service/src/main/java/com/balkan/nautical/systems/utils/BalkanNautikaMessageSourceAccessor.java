package com.balkan.nautical.systems.utils;


import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;







@Component
@RequiredArgsConstructor
public class BalkanNautikaMessageSourceAccessor {

    private final BalkanNautikaMessageSource messageSource;

    public String getMessage(String code, Object... args) {
        return messageSource.getMessage(code,args,code,LocaleContextHolder.getLocale());
    }
}