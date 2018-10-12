package com.demo.spring;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class NyPassEncoader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BCryptPasswordEncoder encoader = new BCryptPasswordEncoder();
		System.out.println(encoader.encode("welcome"));

	}

}
