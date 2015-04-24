package com.example.databasefun;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "configuration")
public class Configuration {

	@Id
	@GeneratedValue
	private Long config_id;

	@Column(length = 255)
	private String config_key;

	@Column(length = 255)
	private String config_value;

	private Date createDate;

	public Long getConfig_id() {
		return config_id;
	}

	public String getConfig_key() {
		return config_key;
	}

	public void setConfig_key(String key) {
		this.config_key = key;
	}

	public String getConfig_value() {
		return config_value;
	}

	public void setConfig_value(String value) {
		this.config_value = value;
	}

	public Date getCreateDate() {
		return createDate;
	}
}
