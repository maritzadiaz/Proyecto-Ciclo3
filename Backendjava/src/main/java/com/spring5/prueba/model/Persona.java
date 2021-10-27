package com.spring5.prueba.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="persona")
public class Persona implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 25, nullable=false)
	private String nombre;
	@Column(length = 1, nullable=false)
	private String genero;
	@Column(length = 25, nullable=false)
	private String apellido;
	@Column(nullable=false, unique=true)
	private Long numeroDocumento;
	@Column(length = 2, nullable=false)
	private String tipoDocumento;
	@Column(length = 255)
	private String perfil;
	@Column(length = 255)
	private String email;
	@Column(length = 255)
	private Float talla;
	@Column(length = 255)
	private Float peso;
	private Timestamp fechaRegistro;
	@Column(length = 255)
	private Float imc;
	@Column(length = 255)
	private String condicion;
	private String recomendacion;
	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Long getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(Long numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Float getTalla() {
		return talla;
	}
	public void setTalla(Float talla) {
		this.talla = talla;
	}
	public Float getPeso() {
		return peso;
	}
	public void setPeso(Float peso) {
		this.peso = peso;
	}
	public Timestamp getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public String getCondicion() {
		return condicion;
	}
	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}
	public String getRecomendacion() {
		return recomendacion;
	}
	public void setRecomendacion(String recomendacion) {
		this.recomendacion = recomendacion;
	}
	public Float getImc() {
		return imc;
	}
	public void setImc(Float imc) {
		this.imc = imc;
	}

	
}
