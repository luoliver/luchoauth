package com.luchoauth.springbootauth.modelodatos.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity(name = "PERSONA")
public class Persona {

	@Id
	@Column(name = "PERSONA_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSONA_SEQ")
	@SequenceGenerator(sequenceName = "PERSONA_SEQ", allocationSize = 1, name = "PERSONA_SEQ")
	private Integer id;

	@Column(name = "PRIMER_NOMBRE", nullable = false)
	private String primerNombre;

	@Column(name = "SEGUNDO_NOMBRE", nullable = true)
	private String segundoNombre;

	@Column(name = "PRIMER_APELLIDO", nullable = false)
	private String primerApellido;

	@Column(name = "SEGUNDO_APELLIDO", nullable = true)
	private String segundoApellido;

	@ManyToOne
	@JoinColumn(name = "TIPO_DOCUMENTO",referencedColumnName = "CODIGO", nullable = false)
	private TipoDocumento tipoDocumento;

	@Column(name = "NUMERO_DOCUMENTO", nullable = false)
	private String numeroDocumento;

	@OneToOne
	@JoinColumn(name = "USUARIO",referencedColumnName = "USUARIO_ID", nullable = false)
	private Usuario usuario;

	@OneToMany(mappedBy = "persona")
	private List<RolPersona> listaRolPersona;

	public List<RolPersona> getListaRolPersona() {
		return listaRolPersona;
	}

	public void setListaRolPersona(List<RolPersona> listaRolPersona) {
		this.listaRolPersona = listaRolPersona;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
