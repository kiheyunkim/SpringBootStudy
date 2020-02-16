package com.apress.spring;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@SpringBootApplication
public class SpringBootSimpleApplication implements CommandLineRunner,ApplicationRunner{
	private static final Logger log = LoggerFactory.getLogger(SpringBootSimpleApplication.class);
		
	public static void main(String[] args) {
		SpringApplication.run(SpringBootSimpleApplication.class, args);
	}
	
	@Bean
	String info() {
		return "그냥 간단한 문자열 빈입니다";
	}
	
	@Autowired
	String info;
	
	@Override
	public void run(ApplicationArguments args) throws Exception{
		log.info("## > Application 구현체 ...");
		log.info("info 빈에 액세스: "+ info);
		args.getNonOptionArgs().forEach(file->log.info(file));
	}
	
	@Override
	public void run(String... args) throws Exception{
		log.info("## > CommandLineRunner 구현체...");
		log.info("info 빈에 액세스 : " + info);
		for(String arg : args) {
			log.info(arg);
		}
	}
}