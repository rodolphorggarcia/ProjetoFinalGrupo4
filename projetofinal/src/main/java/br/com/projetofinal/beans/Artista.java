package br.com.projetofinal.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//

@Entity //indica para o Spring que essa classe tera um correspondente no banco de dados
@Table(name = "tb_artista")
public class Artista {

		@Id // primary key
		@GeneratedValue(strategy = GenerationType.IDENTITY) //auto incremento
		@Column(name="id")
		private int id;
		
		@Column(name="nomeArtistico", length=40)
		private String nomeArtistico;
		
		@Column(name="nacionalidade", length=20)
		private String nacionalidade;
		
		@OneToMany(mappedBy="artista", cascade= CascadeType.ALL) // A classe artista estao do lado "1" no SGBD relacional. -- Cascade: Qualquer alteracao que eu fizer na tabela primaria via ter efeito na tabela sedundaria
		@JsonIgnoreProperties("artista")
		private List<Musica> musicas;

		
		public Artista(int id, String nomeArtistico, String nacionalidade, List<Musica> musicas) {
			super();
			this.id = id;
			this.nomeArtistico = nomeArtistico;
			this.nacionalidade = nacionalidade;
			this.musicas = musicas;
		}

		public List<Musica> getMusicas() {
			return musicas;
		}

		public void setMusicas(List<Musica> musicas) {
			this.musicas = musicas;
		}

		@Override
		public String toString() {
			return "Artista [id=" + id + ", nomeArtistico=" + nomeArtistico + ", nacionalidade=" + nacionalidade + "]";
		}

		public Artista() {
			super();
		}

		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getNomeArtistico() {
			return nomeArtistico;
		}
		public void setNomeArtistico(String nomeArtistico) {
			this.nomeArtistico = nomeArtistico;
		}
		public String getNacionalidade() {
			return nacionalidade;
		}
		public void setNacionalidade(String nacionalidade) {
			this.nacionalidade = nacionalidade;
		}
		
		

		
}
		
		
	