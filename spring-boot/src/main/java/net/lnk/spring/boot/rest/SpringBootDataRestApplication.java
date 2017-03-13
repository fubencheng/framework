package net.lnk.spring.boot.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Ben
 * @memo 2017年2月27日
 */
@SpringBootApplication(scanBasePackages = { "net.lnk.spring.boot.common", "net.lnk.spring.boot.rest" })
public class SpringBootDataRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataRestApplication.class, args);
	}

}
