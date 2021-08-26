package com.luchoauth.springbootauth.seguridad;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.luchoauth.springbootauth.controller.dto.ProyectoDTO;
import com.luchoauth.springbootauth.controller.dto.RolDTO;
import com.luchoauth.springbootauth.controller.dto.RolUsuarioDTO;
import com.luchoauth.springbootauth.controller.dto.UsuarioDTO;
import com.luchoauth.springbootauth.utilidades.excepciones.ExcepcionesPersonalizadas;

public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String username;

	private RolDTO rolLogin;

	private ProyectoDTO proyectoDto;

	@JsonIgnore
	private String password;

	private Collection<? extends GrantedAuthority> authorities;

	public UserDetailsImpl(Integer id, String usuario, String contrasena, RolDTO rolDto, 
			Collection<? extends GrantedAuthority> authorities,ProyectoDTO proyectoDto) {
		this.id = id;
		this.username = usuario;
		this.password = contrasena;
		this.rolLogin = rolDto;
		this.proyectoDto = proyectoDto;
		this.authorities = authorities;
	}

	public static UserDetailsImpl build(UsuarioDTO usuarioDto,RolDTO rol, ProyectoDTO proyectoDto) throws ExcepcionesPersonalizadas {
		List<GrantedAuthority> authorities =  new ArrayList<>();
		RolDTO rolDto = null;
		for(RolUsuarioDTO rolUsuario :usuarioDto.getListaRolUsuarioDto())
			if(rolUsuario.getRolDto().getNombre().equals(rol.getNombre())) {
				authorities.add(new SimpleGrantedAuthority(rolUsuario.getRolDto().getNombre()));
				rolDto = rolUsuario.getRolDto();
			}
		if(rolDto == null) {
			throw new ExcepcionesPersonalizadas("El usuario no tiene el rol designado");
		}
		return new UserDetailsImpl(usuarioDto.getId(),usuarioDto.getUsuario()+";"+rolDto.getNombre()+";"+proyectoDto.getNombre(),usuarioDto.getContrasena(),rolDto,authorities,proyectoDto);

	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean equals(Object objeto) {
		if(this == objeto)
			return true;
		if(objeto == null || getClass() != objeto.getClass())
			return false;
		UserDetailsImpl usuario = (UserDetailsImpl) objeto;
		return Objects.equals(id, usuario.id);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	public RolDTO getRolLogin() {
		return rolLogin;
	}

	public void setRolLogin(RolDTO rolLogin) {
		this.rolLogin = rolLogin;
	}

	public ProyectoDTO getProyectoDto() {
		return proyectoDto;
	}

	public void setProyectoDto(ProyectoDTO proyectoDto) {
		this.proyectoDto = proyectoDto;
	}

}
