package net.lnk.spring.boot.common.config;

import org.springframework.beans.factory.annotation.Configurable;

/**
 * @author Ben
 * @memo 2017年3月2日
 */
// 该注解可以被子类集成，因其被标记了@Inherited
@Configurable
public class DBConfig {

	protected String dbType;
	protected String driverClassName;
	protected String url;
	protected String user;
	protected String password;

	public String getDbType() {
		return dbType;
	}

	public void setDbType(String dbType) {
		this.dbType = dbType;
	}

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
