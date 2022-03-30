package dominio;

public class Curso extends Conteudo {
	
	private int cargaHoraria;
	
	@Override
	public double calcularXP() {
		
		return XP_PADRAO * cargaHoraria;
	}
	
	// construtor	
	public Curso() {
		super();
	}
	
	
	
	public int getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	
	@Override
	public String toString() {
		return "\n\n Curso: \n T�tulo = " + getTitulo() + "\n Descri��o = " + getDescricao() + "\n Carga Hor�ria = " + cargaHoraria ;
	}



	
}
