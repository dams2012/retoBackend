package com.intercorp.clientes.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
@Table(name = "tb_cliente")
public class Cliente implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nombre;
	
	@Column(name="ape_paterno")
	private String apePaterno;
	
	@Column(name="ape_materno")
	private String apeMaterno;
	
	private int edad;
	
	@Column(name="fecha_nac")
	private Date fechaNac;
	
	@Transient
	private Date fechaMuerteProbable;
	
	public Cliente() {}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApePaterno() {
		return apePaterno;
	}

	public void setApePaterno(String apePaterno) {
		this.apePaterno = apePaterno;
	}

	public String getApeMaterno() {
		return apeMaterno;
	}

	public void setApeMaterno(String apeMaterno) {
		this.apeMaterno = apeMaterno;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechaMuerteProbable() {
		return fechaMuerteProbable;
	}

	public void setFechaMuerteProbable(Date fechaMuerteProbable) {
		this.fechaMuerteProbable = fechaMuerteProbable;
	}

	public void calcularFechaMuerte() {
		int edadMuerteProbable = 90;
		
		Calendar c = Calendar.getInstance();
		c.setTime(getFechaNac());
		c.add(Calendar.YEAR, edadMuerteProbable);
		this.fechaMuerteProbable = c.getTime();
	}
	
}
