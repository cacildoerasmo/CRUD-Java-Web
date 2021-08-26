package crud.model;

import java.util.Set;

import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="turma")

public class Turma {

	@Id//estamos a referenciar a nossa chave primaria
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="identificacao")
	protected int identificacao;
	
	@Column(name="descricao")
	protected String descricao;
	

	
	public Turma() {
		
	}

	public Turma(String descricao) {
		super();
		this.descricao = descricao;

               			
	}
		public Turma(int identificacao, String descricao) {
			super();
            this.identificacao = identificacao;
            this.descricao = descricao;
                   			
			
		}

		public int getIdentificacao() {
			return identificacao;
		}

		public void setIdentificacao(int identificacao) {
			this.identificacao = identificacao;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

}