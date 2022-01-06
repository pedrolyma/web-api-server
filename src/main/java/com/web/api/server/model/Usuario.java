package com.web.api.server.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "Tb_Usuario")
public class Usuario implements UserDetails {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Idusuario;
	@NotNull
	private String Nomeusuario;
	private String emailusuario;
	@NotNull
    private String Senhausuario;
	@JoinColumn(name = "id_empresa")
	@ManyToOne
	private EmpresaModel empresaModel;
	
	@ManyToMany(fetch = FetchType.EAGER)  // quando carregar usuario carregar perfil
	private List<Perfil> perfis = new ArrayList<>();
	
	public Long getIdusuario() {
		return Idusuario;
	}
	public void setIdusuario(Long idusuario) {
		Idusuario = idusuario;
	}
	public String getNomeusuario() {
		return Nomeusuario;
	}
	public void setNomeusuario(String nomeusuario) {
		Nomeusuario = nomeusuario;
	}
	public String getEmailusuario() {
		return emailusuario;
	}

	public void setEmailusuario(String emailusuario) {
		this.emailusuario = emailusuario;
	}
	public String getSenhausuario() {
		return Senhausuario;
	}
	public void setSenhausuario(String senhausuario) {
		Senhausuario = senhausuario;
	}
	
	public EmpresaModel getEmpresaModel() {
		return empresaModel;
	}

	public void setEmpresaModel(EmpresaModel empresaModel) {
		this.empresaModel = empresaModel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Idusuario == null) ? 0 : Idusuario.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (Idusuario == null) {
			if (other.Idusuario != null)
				return false;
		} else if (!Idusuario.equals(other.Idusuario))
			return false;
		return true;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.perfis;
	}

	@Override
	public String getPassword() {
		return this.Senhausuario;
	}

	@Override
	public String getUsername() {
		return this.emailusuario;
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
	
}
