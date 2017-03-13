package net.lnk.spring.boot.thymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Ben
 * @memo 2017年2月28日
 */
@SpringBootApplication(scanBasePackages = { "net.lnk.spring.boot.common", "net.lnk.spring.boot.thymeleaf" })
public class SpringBootThymeleafApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootThymeleafApplication.class, args);
	}

}
