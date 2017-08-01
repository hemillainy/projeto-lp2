package principal;

import java.util.HashMap;
import java.util.Map;

public class Usuario {
	private String nome;
	private String email;
	private String telefone;
	private Map<String, Item> itens;
	
	public Usuario(String nome, String celular, String email) {
		this.nome = nome;
		this.telefone = celular;
		this.email = email;
		itens = new HashMap<>();
	}
	public String getEmail(){
		return this.email;
	}
	public String getNome(){
		return this.nome;
	}
	public String getTelefone(){
		return this.telefone;
	}
	public void setEmail(String email){
		this.email = email;
	}
	public void setTelefone(String telefone){
		this.telefone = telefone;
	}
	public String toString(){
		return this.nome + ", " + this.email + ", " + this.telefone;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
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
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}
}
