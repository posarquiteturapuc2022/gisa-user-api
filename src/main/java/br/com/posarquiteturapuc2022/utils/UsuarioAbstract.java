package br.com.posarquiteturapuc2022.utils;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class UsuarioAbstract  extends EntityAbstract implements Serializable{

	private static final long serialVersionUID = 5685983049806518143L;
	
    private String nome;
    private String cpf;
    private String email;
    private String password;
    
    public UsuarioAbstract() {

	}

	public UsuarioAbstract(UUID id) {
		super(id);
	}
	
	public UsuarioAbstract(UUID id, String nome) {
		super(id);
		this.nome = nome;
	}

	public UsuarioAbstract(UUID id, String nome, String cpf, String email, String password) {
		super(id);
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.password = password;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setPassword(String passaword) {
		this.password = passaword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
