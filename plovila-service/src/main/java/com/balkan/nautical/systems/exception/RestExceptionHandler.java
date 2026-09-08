package com.balkan.nautical.systems.exception;


import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.balkan.nautical.systems.utils.BalkanNautikaMessageSourceAccessor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestControllerAdvice
@Log4j2
@RequiredArgsConstructor
public class RestExceptionHandler {

	
	private final BalkanNautikaMessageSourceAccessor messageSourceAccessor;
	
}
