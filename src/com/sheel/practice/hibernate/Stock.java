package com.sheel.practice.hibernate;

import java.io.Serializable;

import javax.persistence.Table;

import org.hibernate.annotations.Entity;


@javax.persistence.Entity
@Table(name="STOCK")
public class Stock implements Serializable {
	private Integer stockId;
	

}
