package net.lnk.spring.boot.tomcat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Ben
 * @memo 2017年3月3日
 */
// DataSource 必须要配置，否则启动失败
@SpringBootApplication(scanBasePackages = { "net.lnk.spring.boot.common", "net.lnk.spring.boot.tomcat.config" })
public class SpringBootTomcatApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTomcatApplication.class, args);
	}

}
