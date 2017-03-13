package net.lnk.spring.boot.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Ben
 * @memo 2017年2月22日
 */
@EnableTransactionManagement
@SpringBootApplication(scanBasePackages = { "net.lnk.spring.boot.common", "net.lnk.spring.boot.jpa" })
public class SpringBootJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaApplication.class, args);
	}

}
