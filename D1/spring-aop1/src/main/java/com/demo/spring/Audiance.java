package com.demo.spring;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import org.springframework.stereotype.Component;

@Component
@Aspect
public class Audiance {

	@Before("execution(* com.demo.spring.Performer.perform(..))")
	public void takeSeat() {
		System.out.println("take ur seatf");

	}

	@Before("execution(* com.demo.spring.Performer.perform(..))")
	public void switchOffMobile() {
		System.out.println("swt off");

	}

	@AfterReturning("execution(* com.demo.spring.Performer.perform(..))")
	public void applaud() {
		System.out.println("clapinggg 3 times");
	}

}
