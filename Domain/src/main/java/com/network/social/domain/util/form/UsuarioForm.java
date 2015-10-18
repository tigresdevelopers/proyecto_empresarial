package com.network.social.domain.util.form;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.network.social.domain.util.UtilUser;
/**
 * 
 * @author Pantera
 *
 */
public class UsuarioForm extends BaseForm {
	private static final long serialVersionUID = 1L;

	private Integer idusuario;
	private SituacionForm situacionSentimental;
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
	private Set<ListaContactoForm> listaContactoses = new HashSet<ListaContactoForm>(0);
	private Set<SolicitudForm> solicitudsForIdusuarioReceiver = new HashSet<SolicitudForm>(0);
	private Set<AlbumForm> albums = new HashSet<AlbumForm>(0);
	private Set<ContactoForm> contactosForMyid = new HashSet<ContactoForm>(0);
	private Set<ComentarioForm> comentarios = new HashSet<ComentarioForm>(0);
	private Set<PublicacionForm> publicacionsForIdusuarioReceiver = new HashSet<PublicacionForm>(0);
	private Set<SolicitudForm> solicitudsForIdusuario = new HashSet<SolicitudForm>(0);
	private Set<ContactoForm> contactosForIdusuario = new HashSet<ContactoForm>(0);
	private Set<GrupoUsuarioForm> grupoUsuarios = new HashSet<GrupoUsuarioForm>(0);
	private Set<LikeForm> likes = new HashSet<LikeForm>(0);
	private Set<IdiomaForm> idiomas = new HashSet<IdiomaForm>(0);
	private Set<EtiquetaForm> etiquetas = new HashSet<EtiquetaForm>(0);
	private Set<PublicacionForm> publicacionsForIdusuario = new HashSet<PublicacionForm>(0);
	private Set<RolForm> roles;
	
	
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


	public SituacionForm getSituacionSentimental() {
		return situacionSentimental;
	}


	public void setSituacionSentimental(SituacionForm situacionSentimental) {
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


	public Set<ListaContactoForm> getListaContactoses() {
		return listaContactoses;
	}


	public void setListaContactoses(Set<ListaContactoForm> listaContactoses) {
		this.listaContactoses = listaContactoses;
	}


	public Set<SolicitudForm> getSolicitudsForIdusuarioReceiver() {
		return solicitudsForIdusuarioReceiver;
	}


	public void setSolicitudsForIdusuarioReceiver(Set<SolicitudForm> solicitudsForIdusuarioReceiver) {
		this.solicitudsForIdusuarioReceiver = solicitudsForIdusuarioReceiver;
	}


	public Set<AlbumForm> getAlbums() {
		return albums;
	}


	public void setAlbums(Set<AlbumForm> albums) {
		this.albums = albums;
	}


	public Set<ContactoForm> getContactosForMyid() {
		return contactosForMyid;
	}


	public void setContactosForMyid(Set<ContactoForm> contactosForMyid) {
		this.contactosForMyid = contactosForMyid;
	}


	public Set<ComentarioForm> getComentarios() {
		return comentarios;
	}


	public void setComentarios(Set<ComentarioForm> comentarios) {
		this.comentarios = comentarios;
	}


	public Set<PublicacionForm> getPublicacionsForIdusuarioReceiver() {
		return publicacionsForIdusuarioReceiver;
	}
	public void setPublicacionsForIdusuarioReceiver(Set<PublicacionForm> publicacionsForIdusuarioReceiver) {
		this.publicacionsForIdusuarioReceiver = publicacionsForIdusuarioReceiver;
	}
	public Set<SolicitudForm> getSolicitudsForIdusuario() {
		return solicitudsForIdusuario;
	}
	public void setSolicitudsForIdusuario(Set<SolicitudForm> solicitudsForIdusuario) {
		this.solicitudsForIdusuario = solicitudsForIdusuario;
	}
	public Set<ContactoForm> getContactosForIdusuario() {
		return contactosForIdusuario;
	}
	public void setContactosForIdusuario(Set<ContactoForm> contactosForIdusuario) {
		this.contactosForIdusuario = contactosForIdusuario;
	}
	public Set<GrupoUsuarioForm> getGrupoUsuarios() {
		return grupoUsuarios;
	}
	public void setGrupoUsuarios(Set<GrupoUsuarioForm> grupoUsuarios) {
		this.grupoUsuarios = grupoUsuarios;
	}
	public Set<LikeForm> getLikes() {
		return likes;
	}
	public void setLikes(Set<LikeForm> likes) {
		this.likes = likes;
	}
	public Set<IdiomaForm> getIdiomas() {
		return idiomas;
	}
	public void setIdiomas(Set<IdiomaForm> idiomas) {
		this.idiomas = idiomas;
	}
	public Set<EtiquetaForm> getEtiquetas() {
		return etiquetas;
	}
	public void setEtiquetas(Set<EtiquetaForm> etiquetas) {
		this.etiquetas = etiquetas;
	}
	public Set<PublicacionForm> getPublicacionsForIdusuario() {
		return publicacionsForIdusuario;
	}
	public void setPublicacionsForIdusuario(Set<PublicacionForm> publicacionsForIdusuario) {
		this.publicacionsForIdusuario = publicacionsForIdusuario;
	}
	public Set<RolForm> getRoles() {
		this.roles=new HashSet<RolForm>(0);
		this.roles.add(UtilUser.ROLES[0]);
		this.roles.add(UtilUser.ROLES[1]);
		return roles;
	}
	public void setRoles(Set<RolForm> roles) {
		this.roles = roles;
	}

	

	
}
