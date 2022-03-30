package dominio;
import java.time.LocalDate;

import dominio.Bootcamp;
import dominio.Curso;
import dominio.Dev;
import dominio.Mentoria;

public class Main {
	public static void main(String[] args) {
		
		Curso curso1 = new Curso();
		
		curso1.setTitulo("Curso Java");
		curso1.setDescricao("Aperfei�oamento em Java, trabalhando com Poo.");
		curso1.setCargaHoraria(8);
		
		Curso curso2 = new Curso();
		
		curso2.setTitulo("Curso Js");
		curso2.setDescricao("Aperfei�oamento em Js.");
		curso2.setCargaHoraria(8);
						
		Mentoria mentoria = new Mentoria();
		mentoria.setTitulo("mentoria java");
		mentoria.setDescricao("Mentoria voltada para conte�dos do curso de Java");
		mentoria.setData(LocalDate.now());
		
		
		/*System.out.println("\n "+curso1);
		System.out.println("\n "+curso2);
		System.out.println("\n "+mentoria);*/
		
		Bootcamp bootcamp = new Bootcamp();
		bootcamp.setNome("Bootcamp Java Developer");
		bootcamp.setDescricao("Bootcamp para aperfei�oamento do seu conhecimento sobre Java");
		bootcamp.getConteudos().add(curso1);
		bootcamp.getConteudos().add(curso2);
		bootcamp.getConteudos().add(mentoria);
		
		Dev devAna = new Dev();
		devAna.setNome("Ana");
		devAna.inscreverBootcamp(bootcamp);
		System.out.println("\n Conte�dos inscritos Ana: "+devAna.getConteudosInscritos());
		
		System.out.println("\n -------------------------------------------------------------");
		devAna.progredir();	
		devAna.progredir();	
		System.out.println("\n Conte�dos conclu�dos Ana: "+devAna.getConteudosConcluidos());
		System.out.println("\n -------------------------------------------------------------");
		System.out.println("\n Conte�dos que ainda faltam ser conclu�dos Ana: "+devAna.getConteudosInscritos());
		
		System.err.println("\n __________");
		System.err.println("\n XP: "+ devAna.calcularTotalXp());
		System.err.println(" __________");

		
		System.out.println("\n -------------------------------------------------------------");
		
		Dev devAhsoka = new Dev();
		devAhsoka.setNome("Ahsoka");
		devAhsoka.inscreverBootcamp(bootcamp);
		System.out.println("\n Conte�dos inscritos Ahsoka: "+devAhsoka.getConteudosInscritos());
		
		System.out.println("\n -------------------------------------------------------------");
		devAhsoka.progredir();
		System.out.println("\n Conte�dos conclu�dos Ahsoka: "+devAna.getConteudosConcluidos());
		System.out.println("\n -------------------------------------------------------------");
		System.out.println("\n Conte�dos que ainda faltam ser conclu�dos Ahsoka: "+devAhsoka.getConteudosInscritos());
		
		System.err.println("\n __________");
		System.err.println("\n XP: "+ devAhsoka.calcularTotalXp());
		System.err.println(" __________");
	}

}
