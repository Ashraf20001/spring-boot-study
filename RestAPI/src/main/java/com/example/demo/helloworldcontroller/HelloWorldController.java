package com.example.demo.helloworldcontroller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@Autowired
	private MessageSource messageSource;

	@GetMapping(path = "hello-world-bean")
	public HelloWorldBean getHelloWorldBean() {
		return new HelloWorldBean("Hello World");
	}
	
	@GetMapping(path = "hello-world-internationalized")
	public String getInternalizedHelloWorld() {
		Locale locale=LocaleContextHolder.getLocale();
		return messageSource.getMessage("greeting.message", null,locale);
	}
	
	@GetMapping(path = "hello-world-bean/path-variable/{name}")
	public HelloWorldBean getHelloWorldBeanName(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World , %s", name));
	}
	
}
