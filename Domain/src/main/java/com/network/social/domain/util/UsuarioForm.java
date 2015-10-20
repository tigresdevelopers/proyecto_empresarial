package com.network.social.domain.util;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.network.social.domain.entities.BaseBean;
import com.network.social.domain.entities.Rol;
import com.network.social.domain.entities.Situacion;
/**
 * 
 * @author :Alexander Chavez Simbron
 * @date   :19/10/2015
 * @time   :17:25 P.M
 */
public class UsuarioForm extends BaseBean {
	private static final long serialVersionUID = 1L;

	private Integer idusuario;
	private Situacion situacionSentimental;
	private String nombre;
	private String apePaterno;
	private String apeMaterno;
	private Date fechaNacimiento;
	private String email;
	private String clave;
	private String celular;
	private Integer sexo;
	private Date fechaRegistro;
	private char estado;
	private String theme;
	private Set<Rol> roles;
	
	public UsuarioForm() {
		
	}

	public UsuarioForm(String email, String clave) {
		super();
		this.email = email;
		this.clave = clave;
	}

	public Integer getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}

	public Set<Rol> getRoles() {
		this.roles=new HashSet<>(0);
		roles.add(UtilUser.ROLES[0]);
		roles.add(UtilUser.ROLES[1]);
		return roles;
	}

	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}

	public Situacion getSituacionSentimental() {
		return situacionSentimental;
	}

	public void setSituacionSentimental(Situacion situacionSentimental) {
		this.situacionSentimental = situacionSentimental;
	}

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

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Integer getSexo() {
		return sexo;
	}

	public void setSexo(Integer sexo) {
		this.sexo = sexo;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public char getEstado() {
		return estado;
	}

	public void setEstado(char estado) {
		this.estado = estado;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	
}
