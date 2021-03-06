package pt.iscte.poo.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import pt.iscte.poo.graficos.Chart;
import pt.iscte.poo.instalacao.Instalacao;
import pt.iscte.poo.instalacao.Ligavel;
import pt.iscte.poo.instalacao.Linha;
import pt.iscte.poo.instalacao.eventos.Evento;

public class MainTests {

	public static void main(String[] args) {

		// MAIN ;-)
		JSONParser json = new JSONParser();
		try {
			Instalacao instalacao = Instalacao.getInstanciaUnica();

			Chart grafico = new Chart("Potencia por linha");

			// TO CREATE
			instalacao.addObserver(grafico);

			JSONArray objectos = (JSONArray) json.parse(new BufferedReader(new FileReader("instalacao.json")));
			instalacao.init(objectos);
			
			// TO PRINT
			 System.out.println("----------------PRINT_01_instalacao------------------");
			 for (Linha linha : instalacao.getListLinhas()) {
				 System.err.println(linha.toString());
			 }
			 paragraph();

			JSONArray listaAparelhos = (JSONArray) json.parse(new BufferedReader(new FileReader("aparelhos.json")));
			List<Ligavel> aparelhos = instalacao.lerAparelhos(listaAparelhos);

			// TO PRINT
			System.out.println("----------------PRINT_02_aparelhos------------------");
			for (Ligavel ligavel : instalacao.getLigaveis()) {
				System.out.println(ligavel);
			}
			 paragraph();				
			
			JSONArray listaLigacoes = (JSONArray) json.parse(new BufferedReader(new FileReader("ligacoes.json")));
			//TO CREATE
			instalacao.lerLigacoes(listaLigacoes, aparelhos);

			// TO PRINT
			System.out.println("----------------PRINT_03_ligacoes------------------");
			for (Ligavel ligavel : instalacao.getLigaveis()) {
				System.err.println("ligacao: " + ligavel.getId());
				System.err.println("-> " + ligavel.getPotenciaAparelho());
				
			}
			 paragraph();	
			 
			JSONArray listaEventos = (JSONArray) json.parse(new BufferedReader(new FileReader("eventos.json")));
			// TO CREATE
			instalacao.lerEventos(listaEventos);
			
			// TO PRINT
			 System.out.println("----------------PRINT_04_eventos------------------");
			 for (Evento evento : instalacao.getEventos()) {
				 System.out.println(evento.toString());
			 }
			 paragraph();

			long fim = Long.valueOf(JOptionPane.showInputDialog("Please enter the end time"));

			grafico.setVisible(true);
			instalacao.simula(fim);
			

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}
	
	public static void paragraph() {
		System.out.println("");
	}

}
