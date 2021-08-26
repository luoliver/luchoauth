package com.luchoauth.springbootauth.service.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luchoauth.springbootauth.seguridad.JwtService;
import com.luchoauth.springbootauth.seguridad.UserDetailsImpl;
import com.luchoauth.springbootauth.service.request.AuthenticationRequest;
import com.luchoauth.springbootauth.service.response.AuthenticactionResponse;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class RestLoginService {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtService jwtService;
	
	/**
	 * 
	 * @param AuthenticationRequest
	 * @return
	 */
	@PostMapping("/login")
	public ResponseEntity<?> createToken(@RequestBody AuthenticationRequest authRequest) {
		try {
			List<GrantedAuthority> authorities =  new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority(authRequest.getRol()));
			
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUsuario()+";"+authRequest.getRol()+";"+authRequest.getProyecto(), authRequest.getContrasena(),authorities));
			SecurityContextHolder.getContext().setAuthentication(authentication);
			String jwt = jwtService.generateJwtToken(authentication);
			
			UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
			AuthenticactionResponse response = new AuthenticactionResponse(jwt, userDetails.getId(), userDetails.getUsername());
			return ResponseEntity.ok(response);
		} catch (Exception excepcion) {
			return new ResponseEntity<>(excepcion.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
