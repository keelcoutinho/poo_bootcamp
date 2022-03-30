package dominio;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Dev {
	
	private String nome;
	private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
	private Set<Conteudo> conteudosConcluidos= new LinkedHashSet<>();
	/* utiliza��o do Set e n�o o ArrayList porque um Dev s� pode participar uma vez de um bootcamp, 
	n�o aceitando duplicidade.*/
	
	public void inscreverBootcamp(Bootcamp bootcamp) {
		// Pega todos os bootcamps e adiciona no campo conteudos inscritos
		this.conteudosInscritos.addAll(bootcamp.getConteudos());
		//Pega todos os Devs inscritos no bootcamp
		bootcamp.getDevsInscritos().add(this);
		
	}
	
	public void progredir() {
		// findFirst retorna o optional que serve para resolver retornos null
		Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
		if (conteudo.isPresent()) {
			this.conteudosConcluidos.add(conteudo.get()); // inserir os conteudos concluidos
			this.conteudosInscritos.remove(conteudo.get()); // remover os conteudos que foram conclu�dos da lista de conte�dos inscritos.
		} else {
			System.err.println("Voc� n�o est� matriculado em nenhum conte�do!");
		}
	}
	
	
	public double calcularTotalXp() {
		// paga o conteudo de cada conteudo concluido e o xp de cada conteudo e soma
		return this.conteudosConcluidos.stream().mapToDouble(conteudo -> conteudo.calcularXP()).sum();
	}

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Conteudo> getConteudosInscritos() {
		return conteudosInscritos;
	}

	public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
		this.conteudosInscritos = conteudosInscritos;
	}

	public Set<Conteudo> getConteudosConcluidos() {
		return conteudosConcluidos;
	}

	public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
		this.conteudosConcluidos = conteudosConcluidos;
	}

	
	// � necess�rio implementar o equals e o hasCode por estar utilizando o LinkedHashSet;
	@Override
	public int hashCode() {
		return Objects.hash(conteudosConcluidos, conteudosInscritos, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dev other = (Dev) obj;
		return Objects.equals(conteudosConcluidos, other.conteudosConcluidos)
				&& Objects.equals(conteudosInscritos, other.conteudosInscritos) && Objects.equals(nome, other.nome);
	}
	
	
		

}
