/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.barbaro.panaderia.models;

/**
 *
 * @author ericknavarro
 */
import java.sql.Date;

public class Pan {

	private int id;
	private String nombre;
	private String descripcion;
	private float precio;
	private String tamano;
	private Date fecha;

	public Pan() {
	}

	public Pan(int id, String nombre, String descripcion, String tamano, float precio, Date fecha) {

		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tamano = tamano;
		this.precio = precio;
		this.fecha = fecha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getTamano() {
		return tamano;
	}

	public void setTamano(String tamano) {
		this.tamano = tamano;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
