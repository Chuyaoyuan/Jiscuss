package com.yaoyuan.jiscuss.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="setting")
public class Setting implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="key")
    private String key;
    
    @Column(name="value")
    private String value;
}
