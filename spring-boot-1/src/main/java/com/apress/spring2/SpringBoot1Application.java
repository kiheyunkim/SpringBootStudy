package com.apress.spring2;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class SpringBoot1Application {
	/*
	@Bean
	  InitializingBean saveData(JournalRepository repo) {
		return () -> {
		      repo.save(new Journal("스프링 부트 입문", "오늘부터 스프링 부트 공부하기 시작했다", "01/01/2016"));
		      repo.save(new Journal("간단한 스프링 부트 프로젝트", "스프링 부트 프로젝트를 처음 만들어보았다", "01/02/2016"));
		      repo.save(new Journal("스프링 부트 해부", "스프링 부트를 자세히 살펴보았다.", "02/01/2016"));
		      repo.save(new Journal("스프링 부트 클라우드", "클라우드 파운드리를 응용한 스프링 부트를 공부했다", "03/01/2016"));
		    };
	  }
	  */
	public static void main(String[] args) {
		SpringApplication.run(SpringBoot1Application.class, args);
	}

}

@Component
class MyComponent{
	
	private static final Logger log = LoggerFactory.getLogger(MyComponent.class);
	
	@Autowired
	public MyComponent(ApplicationArguments args) {
		boolean enable = args.containsOption("enable");
		
		log.info(enable ? "1" : "0");
		if(enable)
			log.info("### > enable 옵션을 주셨네요");
		
		List<String> _args = args.getNonOptionArgs();
		log.info("## > 다른 인자...");
		if(!_args.isEmpty()) {
			_args.forEach(file->log.info(file));
		}
	}
}
