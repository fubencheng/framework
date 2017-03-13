package net.lnk.spring.boot.thymeleaf.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import tk.mybatis.spring.mapper.MapperScannerConfigurer;

/**
 * @author Ben
 * @memo 2017年3月2日
 */
@Component
@Configurable
@AutoConfigureAfter(MybatisConfig.class)
public class MapperScannerConfig {

	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer() {
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
		mapperScannerConfigurer.setBasePackage("net.lnk.spring.boot.thymeleaf.mapper");
		return mapperScannerConfigurer;
	}

}
