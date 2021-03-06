package com.network.social.domain.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.network.social.domain.util.UtilUser;
/**
 * 
 * @author :Alexander Chavez Simbron
 * @date   :19/10/2015
 * @time   :17:25 P.M
 */
@Entity
@Table(name = "USUARIO")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class,property="idusuario")
public class Usuario extends BaseBean {
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
	private Set<ListaContacto> listaContactoses = new HashSet<ListaContacto>(0);
	private Set<Solicitud> solicitudsForIdusuarioReceiver = new HashSet<Solicitud>(0);
	private Set<Album> albums = new HashSet<Album>(0);
	private Set<Contacto> contactosForMyid = new HashSet<Contacto>(0);
	private Set<Comentario> comentarios = new HashSet<Comentario>(0);
	private Set<Publicacion> publicacionsForIdusuarioReceiver = new HashSet<Publicacion>(0);
	private Set<Solicitud> solicitudsForIdusuario = new HashSet<Solicitud>(0);
	private Set<Contacto> contactosForIdusuario = new HashSet<Contacto>(0);
	private Set<GrupoUsuario> grupoUsuarios = new HashSet<GrupoUsuario>(0);
	private Set<Like> likes = new HashSet<Like>(0);
	private Set<Idioma> idiomas = new HashSet<Idioma>(0);
	private Set<Etiqueta> etiquetas = new HashSet<Etiqueta>(0);
	private Set<Publicacion> publicacionsForIdusuario = new HashSet<Publicacion>(0);
	@Transient
	public Rol[] roles=UtilUser.ROLES;
	
	private String segundonombre;
	private String nickname;
	private String direccion;
	private String compania;
	private String biografia;
	private String idstipos;
	private String idslistas;
	
	public Usuario() {
	}
	
	public Usuario(Integer idusuario) {
		super();
		this.idusuario = idusuario;
	}

	public Usuario(Integer idusuario, Situacion situacionSentimental, String nombre, String apePaterno,
			String apeMaterno, Date fechaNacimiento, String email, Integer sexo, Date fechaRegistro,
			char estado) {
		this.idusuario = idusuario;
		this.situacionSentimental = situacionSentimental;
		this.nombre = nombre;
		this.apePaterno = apePaterno;
		this.apeMaterno = apeMaterno;
		this.fechaNacimiento = fechaNacimiento;
		this.email = email;
		this.sexo = sexo;
		this.fechaRegistro = fechaRegistro;
		this.estado = estado;
	}

	public Usuario(Integer idusuario, Situacion situacionSentimental, String nombre, String apePaterno,
			String apeMaterno, Date fechaNacimiento, String email, String clave, String celular,
			Integer sexo, Date fechaRegistro, char estado, String theme,
			Set<ListaContacto> listaContactoses, Set<Solicitud> solicitudsForIdusuarioReceiver, Set<Album> albums,
			Set<Contacto> contactosForMyid, Set<Comentario> comentarios,
			Set<Publicacion> publicacionsForIdusuarioReceiver, Set<Solicitud> solicitudsForIdusuario,
			Set<Contacto> contactosForIdusuario, Set<GrupoUsuario> grupoUsuarios, Set<Like> likes, Set<Idioma> idiomas,
			Set<Etiqueta> etiquetas, Set<Publicacion> publicacionsForIdusuario) {
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
	}

	@Id
	@GenericGenerator(name="SQ_GENERATOR",strategy="sequence",parameters={@Parameter(name="sequence",value="SQ_USUARIO")})
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SQ_GENERATOR")
	@Column(name = "IDUSUARIO", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getIdusuario() {
		return this.idusuario;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}

	@JsonIdentityReference(alwaysAsId=true)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDSITUACION")
	public Situacion getSituacionSentimental() {
		return this.situacionSentimental;
	}

	public void setSituacionSentimental(Situacion situacionSentimental) {
		this.situacionSentimental = situacionSentimental;
	}
	
	@JsonSetter
	public void setSituacionSentimental(Integer id) {
		if (id!=null) {
			this.situacionSentimental =new Situacion();
			this.situacionSentimental.setIdsituacion(id);
		}
	}
	

	@Column(name = "NOMBRE",length = 50)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "APE_PATERNO",length = 50)
	public String getApePaterno() {
		return this.apePaterno;
	}

	public void setApePaterno(String apePaterno) {
		this.apePaterno = apePaterno;
	}

	@Column(name = "APE_MATERNO",length = 50)
	public String getApeMaterno() {
		return this.apeMaterno;
	}

	public void setApeMaterno(String apeMaterno) {
		this.apeMaterno = apeMaterno;
	}

	@Column(name = "FECHA_NACIMIENTO")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Column(name = "EMAIL",length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "CLAVE", length = 60)
	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	@Column(name = "CELULAR", length = 11)
	public String getCelular() {
		return this.celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	@Column(name = "SEXO", precision = 22, scale = 0)
	public Integer getSexo() {
		return this.sexo;
	}

	public void setSexo(Integer sexo) {
		this.sexo = sexo;
	}

	@Column(name = "FECHA_REGISTRO")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Column(name = "ESTADO",length = 1)
	public char getEstado() {
		return this.estado;
	}

	public void setEstado(char estado) {
		this.estado = estado;
	}

	@Column(name = "THEME", length = 20)
	public String getTheme() {
		return this.theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}
	
	@Column(name="SEGUNDO_NOMBRE")
	public String getSegundonombre() {
		return segundonombre;
	}

	public void setSegundonombre(String segundonombre) {
		this.segundonombre = segundonombre;
	}

	@Column(name="NICKNAME")
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Column(name="DIRECCION")
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	@Column(name="COMPANIA")
	public String getCompania() {
		return compania;
	}

	public void setCompania(String compania) {
		this.compania = compania;
	}

	@Column(name="BIOGRAFIA")
	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	@Column(name="IDSTIPOS")
	public String getIdstipos() {
		return idstipos;
	}

	public void setIdstipos(String idstipos) {
		this.idstipos = idstipos;
	}

	@Column(name="IDSLISTAS")
	public String getIdslistas() {
		return idslistas;
	}

	public void setIdslistas(String idslistas) {
		this.idslistas = idslistas;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Set<ListaContacto> getListaContactoses() {
		return this.listaContactoses;
	}

	public void setListaContactoses(Set<ListaContacto> listaContactoses) {
		this.listaContactoses = listaContactoses;
	}
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuarioByIdusuarioReceiver")
	public Set<Solicitud> getSolicitudsForIdusuarioReceiver() {
		return this.solicitudsForIdusuarioReceiver;
	}

	public void setSolicitudsForIdusuarioReceiver(Set<Solicitud> solicitudsForIdusuarioReceiver) {
		this.solicitudsForIdusuarioReceiver = solicitudsForIdusuarioReceiver;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Set<Album> getAlbums() {
		return this.albums;
	}

	public void setAlbums(Set<Album> albums) {
		this.albums = albums;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuarioByMyid")
	public Set<Contacto> getContactosForMyid() {
		return this.contactosForMyid;
	}

	public void setContactosForMyid(Set<Contacto> contactosForMyid) {
		this.contactosForMyid = contactosForMyid;
	}
	
	@JsonIgnore
	@JsonBackReference(value="comentario-usuario")
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Set<Comentario> getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(Set<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuarioByIdusuarioReceiver")
	public Set<Publicacion> getPublicacionsForIdusuarioReceiver() {
		return this.publicacionsForIdusuarioReceiver;
	}

	public void setPublicacionsForIdusuarioReceiver(Set<Publicacion> publicacionsForIdusuarioReceiver) {
		this.publicacionsForIdusuarioReceiver = publicacionsForIdusuarioReceiver;
	}

	@JsonIgnore
	@JsonBackReference("solicitud-usuario")
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuarioByIdusuario")
	public Set<Solicitud> getSolicitudsForIdusuario() {
		return this.solicitudsForIdusuario;
	}

	public void setSolicitudsForIdusuario(Set<Solicitud> solicitudsForIdusuario) {
		this.solicitudsForIdusuario = solicitudsForIdusuario;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuarioByIdusuario")
	public Set<Contacto> getContactosForIdusuario() {
		return this.contactosForIdusuario;
	}

	public void setContactosForIdusuario(Set<Contacto> contactosForIdusuario) {
		this.contactosForIdusuario = contactosForIdusuario;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Set<GrupoUsuario> getGrupoUsuarios() {
		return this.grupoUsuarios;
	}

	public void setGrupoUsuarios(Set<GrupoUsuario> grupoUsuarios) {
		this.grupoUsuarios = grupoUsuarios;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Set<Like> getLikes() {
		return this.likes;
	}

	public void setLikes(Set<Like> likes) {
		this.likes = likes;
	}

	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "usuarios")
	public Set<Idioma> getIdiomas() {
		return this.idiomas;
	}

	public void setIdiomas(Set<Idioma> idiomas) {
		this.idiomas = idiomas;
	}

	@JsonBackReference
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Set<Etiqueta> getEtiquetas() {
		return this.etiquetas;
	}

	public void setEtiquetas(Set<Etiqueta> etiquetas) {
		this.etiquetas = etiquetas;
	}

	@JsonBackReference(value="publicacion-usuario")
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuarioByIdusuario")
	public Set<Publicacion> getPublicacionsForIdusuario() {
		return this.publicacionsForIdusuario;
	}

	public void setPublicacionsForIdusuario(Set<Publicacion> publicacionsForIdusuario) {
		this.publicacionsForIdusuario = publicacionsForIdusuario;
	}	
	
}
