package control_0Pattern.observer.week9_poo;

public class Teste {
	public static void main(String[] args) {
		
		//TEST
		Observador observador = new Observador();
		Observado observado = new Observado();
		
		observado.addObserver(observador);
		
		observado.read();
	}
}
