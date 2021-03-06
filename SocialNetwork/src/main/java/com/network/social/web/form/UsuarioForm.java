package com.network.social.web.form;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
/**
 * 
 * @author :Alexander Chavez Simbron
 * @date   :19/10/2015
 * @time   :17:25 P.M
 */
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class,property="idusuario")
@JsonIgnoreProperties(
{	"listaContactoses","solicitudsForIdusuarioReceiver","albums","contactosForMyid",
	"comentarios","publicacionsForIdusuarioReceiver","solicitudsForIdusuario",
	"contactosForIdusuario","grupoUsuarios","likes","idiomas","etiquetas",
	"publicacionsForIdusuario"
})
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
	private String segundonombre;
	private String nickname;
	private String direccion;
	private String compania;
	private String biografia;
	private String idstipos;
	private String idslistas;
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

	
	public UsuarioForm(Integer idusuario) {
		super();
		this.idusuario = idusuario;
	}

	public UsuarioForm(Integer idusuario, SituacionForm situacionSentimental,
			String nombre, String apePaterno, String apeMaterno,
			Date fechaNacimiento, String email, String clave, String celular,
			Integer sexo, Date fechaRegistro, char estado, String theme,
			Set<ListaContactoForm> listaContactoses,
			Set<SolicitudForm> solicitudsForIdusuarioReceiver,
			Set<AlbumForm> albums, Set<ContactoForm> contactosForMyid,
			Set<ComentarioForm> comentarios,
			Set<PublicacionForm> publicacionsForIdusuarioReceiver,
			Set<SolicitudForm> solicitudsForIdusuario,
			Set<ContactoForm> contactosForIdusuario,
			Set<GrupoUsuarioForm> grupoUsuarios, Set<LikeForm> likes,
			Set<IdiomaForm> idiomas, Set<EtiquetaForm> etiquetas,
			Set<PublicacionForm> publicacionsForIdusuario, Set<RolForm> roles) {
		super();
		this.idusuario = idusuario;
		this.situacionSentimental = situacionSentimental;
		this.nombre = nombre;
		this.apePaterno = apePaterno;
		this.apeMaterno = apeMaterno;
		this.fechaNacimiento = fechaNacimiento;
		this.email = email;
		this.clave = clave;
		this.celular = celular;
		this.sexo = sexo;
		this.fechaRegistro = fechaRegistro;
		this.estado = estado;
		this.theme = theme;
		this.listaContactoses = listaContactoses;
		this.solicitudsForIdusuarioReceiver = solicitudsForIdusuarioReceiver;
		this.albums = albums;
		this.contactosForMyid = contactosForMyid;
		this.comentarios = comentarios;
		this.publicacionsForIdusuarioReceiver = publicacionsForIdusuarioReceiver;
		this.solicitudsForIdusuario = solicitudsForIdusuario;
		this.contactosForIdusuario = contactosForIdusuario;
		this.grupoUsuarios = grupoUsuarios;
		this.likes = likes;
		this.idiomas = idiomas;
		this.etiquetas = etiquetas;
		this.publicacionsForIdusuario = publicacionsForIdusuario;
		this.roles = roles;
	}

	public Integer getIdusuario() {
		return idusuario;
	}
	public String getIdstipos() {
		return idstipos;
	}
	
	public void setIdstipos(String idstipos) {
		this.idstipos = idstipos;
	}

	public String getIdslistas() {
		return idslistas;
	}

	public void setIdslistas(String idslistas) {
		this.idslistas = idslistas;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}

	@JsonIdentityReference(alwaysAsId=true)
	public SituacionForm getSituacionSentimental() {
		return situacionSentimental;
	}

	public void setSituacionSentimental(SituacionForm situacionSentimental) {
		this.situacionSentimental = situacionSentimental;
	}

	@JsonSetter
	public void setSituacionSentimental(Integer id) {
		if (id!=null) {
			this.situacionSentimental = new SituacionForm();
			this.situacionSentimental.setIdsituacion(id);
		}
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
	
	public String getSegundonombre() {
		return segundonombre;
	}

	public void setSegundonombre(String segundonombre) {
		this.segundonombre = segundonombre;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCompania() {
		return compania;
	}

	public void setCompania(String compania) {
		this.compania = compania;
	}

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
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

	public void setSolicitudsForIdusuarioReceiver(
			Set<SolicitudForm> solicitudsForIdusuarioReceiver) {
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

	public void setPublicacionsForIdusuarioReceiver(
			Set<PublicacionForm> publicacionsForIdusuarioReceiver) {
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

	public void setPublicacionsForIdusuario(
			Set<PublicacionForm> publicacionsForIdusuario) {
		this.publicacionsForIdusuario = publicacionsForIdusuario;
	}
	
	public Set<RolForm> getRoles() {
		return roles;
	}

	public void setRoles(Set<RolForm> roles) {
		this.roles = roles;
	}

	
	
}
