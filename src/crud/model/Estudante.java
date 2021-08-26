package crud.model;


import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="estudante")

public class Estudante {

	@Id//estamos a referenciar a nossa chave primaria
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="numero_matricula")
	protected int numero_matricula;
	
	@Column(name="fk_identificacao_turma")
	protected int fk_identificacao_turma;
	
	@Column(name="nome")
	protected String nome;
	
	@Column(name="apelido")
	protected String apelido;
	
	@Column(name="telefone")
	protected int telefone;
	
	@Column(name="endereco")
	protected String endereco;
	
	public Estudante() {
		
	}
	 
	public Estudante(int fk_identificacao_turma, String nome, String apelido, int telefone, String endereco) {
		super();
		this.fk_identificacao_turma = fk_identificacao_turma;
		this.nome =  nome;
		this.apelido = apelido;
		this.telefone = telefone;
		this.endereco = endereco;
               			
	}
		public Estudante(int numero_matricula, int fk_identificacao_turma, String nome, String apelido, int telefone, String endereco) {
			super();
			this.numero_matricula = numero_matricula;
			this.fk_identificacao_turma = fk_identificacao_turma;
			this.nome =  nome;
			this.apelido = apelido;
			this.telefone = telefone;
			this.endereco = endereco;
                   			
			
		}

		public int getNumero_matricula() {
			return numero_matricula;
		}

		public void setNumero_matricula(int numero_matricula) {
			this.numero_matricula = numero_matricula;
		}

		public int getFk_identificacao_turma() {
			return fk_identificacao_turma;
		}

		public void setFk_identificacao_turma(int fk_identificacao_turma) {
			this.fk_identificacao_turma = fk_identificacao_turma;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getApelido() {
			return apelido;
		}

		public void setApelido(String apelido) {
			this.apelido = apelido;
		}

		public int getTelefone() {
			return telefone;
		}

		public void setTelefone(int telefone) {
			this.telefone = telefone;
		}

		public String getEndereco() {
			return endereco;
		}

		public void setEndereco(String endereco) {
			this.endereco = endereco;
		}
		
		
		
		
	}
	
	


