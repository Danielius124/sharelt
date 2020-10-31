package com.share.sharelt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.share.sharelt.repositories", "com.share.sharelt.entity", "com.share.sharelt.web", "com.share.sharelt.services"})
@EntityScan("com.share.sharelt.entity")
@EnableJpaRepositories("com.share.sharelt.repositories")
public class ShareltApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShareltApplication.class, args); }


}
