package com.mbti;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.mbti"})
@EntityScan(basePackages = {"com.mbti.vo"}) // 엔터티가 위치한 패키지
@MapperScan("com.mbti.mapper")
public class WdwdnApplication {

	public static void main(String[] args) {
		SpringApplication.run(WdwdnApplication.class, args);
	}

}
