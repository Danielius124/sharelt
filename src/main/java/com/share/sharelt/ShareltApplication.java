package com.share.sharelt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.Entity;
import java.util.Locale;

@SpringBootApplication
@ComponentScan({"com.share.sharelt.dao", "com.share.sharelt.entity", "com.share.sharelt.rest", "com.share.sharelt.service"})
@EntityScan("com.share.sharelt.entity")
@EnableJpaRepositories("com.share.sharelt.dao")
public class ShareltApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShareltApplication.class, args); }


}
