package com.kingshuk.spring.aspectpractice.aspects;

import java.time.LocalTime;
import java.time.ZonedDateTime;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SetterMethodAspect {

	@Before("execution(* *.*.*EffectiveDate(..)) && args(effectiveDate)")
	public void dateFormatUpdate(ZonedDateTime effectiveDate) {
		System.out.println("Converting the date time to a date structure");
		effectiveDate = effectiveDate.with(LocalTime.of(00, 00, 00));
	}
}
