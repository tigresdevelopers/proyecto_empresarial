package com.network.social.domain.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
/**
 * 
 * @author :Alexander Chavez Simbron
 * @date   :19/10/2015
 * @time   :17:25 P.M
 */
@Embeddable
public class GrupoUsuarioId extends BaseBean {
	private static final long serialVersionUID = 1L;

	private Integer idgrupo;
	private Integer idusuario;

	public GrupoUsuarioId() {
	}

	public GrupoUsuarioId(Integer idgrupo, Integer idusuario) {
		this.idgrupo = idgrupo;
		this.idusuario = idusuario;
	}

	@Column(name = "IDGRUPO", nullable = false, precision = 22, scale = 0)
	public Integer getIdgrupo() {
		return this.idgrupo;
	}

	public void setIdgrupo(Integer idgrupo) {
		this.idgrupo = idgrupo;
	}

	@Column(name = "IDUSUARIO", nullable = false, precision = 22, scale = 0)
	public Integer getIdusuario() {
		return this.idusuario;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof GrupoUsuarioId))
			return false;
		GrupoUsuarioId castOther = (GrupoUsuarioId) other;

		return ((this.getIdgrupo() == castOther.getIdgrupo()) || (this.getIdgrupo() != null
				&& castOther.getIdgrupo() != null && this.getIdgrupo().equals(castOther.getIdgrupo())))
				&& ((this.getIdusuario() == castOther.getIdusuario()) || (this.getIdusuario() != null
						&& castOther.getIdusuario() != null && this.getIdusuario().equals(castOther.getIdusuario())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getIdgrupo() == null ? 0 : this.getIdgrupo().hashCode());
		result = 37 * result + (getIdusuario() == null ? 0 : this.getIdusuario().hashCode());
		return result;
	}

}
