package net.lnk.spring.boot.mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Ben
 * @memo 2017年3月1日
 */
@SpringBootApplication(scanBasePackages = { "net.lnk.spring.boot.common", "net.lnk.spring.boot.mybatis" })
public class SpringBootMybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMybatisApplication.class, args);
	}

}
