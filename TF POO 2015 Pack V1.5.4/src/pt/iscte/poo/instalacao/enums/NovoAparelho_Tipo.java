package pt.iscte.poo.instalacao.enums;

import org.json.simple.JSONObject;

import pt.iscte.poo.instalacao.Ligavel;
import pt.iscte.poo.instalacao.aparelhos.Computador;
import pt.iscte.poo.instalacao.aparelhos.Frigorifico;
import pt.iscte.poo.instalacao.aparelhos.Lampada;
import pt.iscte.poo.instalacao.aparelhos.MicroOndas;
import pt.iscte.poo.instalacao.aparelhos.Torradeira;

public enum NovoAparelho_Tipo {
	COMPUTADOR("computador"), FRIGORIFICO("frigorifico"), LAMPADA("lampada"), MICRO_ONDAS("microOndas"), TORRADEIRA("torradeira"), OTHERS("porCriar");;
	
	// ATTRIBUTES
	private String text;
	private static NovoAparelho_Potencia novoAparelhoPotencia;

	// CONSTRUCTOR
	private NovoAparelho_Tipo(String text) {
		this.text = text;
	}

	// TOSTRING
	@Override
	public String toString() {
		return "[TIPO: " + text + " -> POTENCIA: " + novoAparelhoPotencia + "]\n";
	}
	
	// STATIC METHOD (from the class, not the instance)
	/** Seleccao o tipo de potencia do novo aparelho (fixa ou variavel) */
	public static double selecionaNovoAparelhoPotencia(JSONObject obj) {
		//POWER 
		double potencia = -1;
		
		if(obj.get(NovoAparelho_Potencia.POTENCIA.toString()) != null) {
			potencia = (double)((long)obj.get(NovoAparelho_Potencia.POTENCIA.toString()));
			novoAparelhoPotencia = NovoAparelho_Potencia.POTENCIA;
			//System.out.println(potencia);
		}
		
		if(obj.get(NovoAparelho_Potencia.POTENCIA_MAXIMA.toString()) != null) {
			potencia = (double)obj.get(NovoAparelho_Potencia.POTENCIA_MAXIMA.toString());
			novoAparelhoPotencia = NovoAparelho_Potencia.POTENCIA_MAXIMA;
			//System.out.println(potencia);
		}
		return potencia;
	}
	
	// STATIC METHOD (from the class, not the instance)
	/** Seleccao do novo aparelho */
	public static Ligavel selecionaNovoAparelho(String tipo, String id, double potencia) {

		// .toUpperCase() lets you select type and still match
		String tipoUpperCase = tipo.toUpperCase();
		try {
			// Enum.valueOf() throws an exception if the input is not valid
			NovoAparelho_Tipo novo = NovoAparelho_Tipo.valueOf(tipoUpperCase);

			switch (novo) {
			case COMPUTADOR:
				Computador computador = new Computador(id, potencia);
				computador.setTipoAparelho(novo);
				computador.setPotenciaAparelho(novoAparelhoPotencia);
				
//				//TO DELETE
//				Instalacao.getInstanciaUnica().ligaAparelhoATomadaLivre(Instalacao.getInstanciaUnica().getListLinhas().get(2).getNome(), computador);
//				computador.liga();
				
				return computador;
			case FRIGORIFICO:
				Frigorifico frigorifico = new Frigorifico(id, potencia);
				frigorifico.setTipoAparelho(novo);
				frigorifico.setPotenciaAparelho(novoAparelhoPotencia);
				
//				//TO DELETE
//				Instalacao.getInstanciaUnica().ligaAparelhoATomadaLivre(Instalacao.getInstanciaUnica().getListLinhas().get(2).getNome(), frigorifico);
//				frigorifico.aumenta(100);
//				frigorifico.liga();
				
				return frigorifico;
			case LAMPADA:
				Lampada lampada = new Lampada(id, potencia);
				lampada.setTipoAparelho(novo);
				lampada.setPotenciaAparelho(novoAparelhoPotencia);
				//System.out.print(lampada.getTipoAparelho());
				return lampada;
			case MICRO_ONDAS:
				MicroOndas microOndas =  new MicroOndas(id, potencia);
				microOndas.setTipoAparelho(novo);
				microOndas.setPotenciaAparelho(novoAparelhoPotencia);
				//System.out.print(microOndas.getTipoAparelho());
				return microOndas;
			case TORRADEIRA:
				Torradeira torradeira = new Torradeira(id, potencia);
				torradeira.setTipoAparelho(novo);
				torradeira.setPotenciaAparelho(novoAparelhoPotencia);
				//System.out.print(torradeira.getTipoAparelho());
				return torradeira;
			case OTHERS:
				return null;
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			//System.out.println("Invalid color selection!");
		}
		return null;
	}

//	// MAIN FOR TESTS
//	public static void main(String[] args) throws InterruptedException {		
//		System.out.println("--------------PRINT1----------------");
//		System.out.println(NovoAparelho_Tipo.selecionaNovoAparelho("Computador", "comp", 35.0));
//		System.out.println("--------------SUCCESS----------------\n");
//		Thread.sleep(350); // pause
//		
//		System.err.println("--------------PRINT2----------------");
//		System.out.println(NovoAparelho_Tipo.selecionaNovoAparelho("FrigorIfico", "frigo", 70.0));
//		System.err.println("--------------SUCCESS----------------\n");
//	}
}
