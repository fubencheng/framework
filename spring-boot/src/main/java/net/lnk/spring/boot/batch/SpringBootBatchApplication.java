package net.lnk.spring.boot.batch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Ben
 * @memo 2017年2月24日
 */
@EnableTransactionManagement
@SpringBootApplication(scanBasePackages = { "net.lnk.spring.boot.common", "net.lnk.spring.boot.batch" })
public class SpringBootBatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBatchApplication.class);
	}

}
