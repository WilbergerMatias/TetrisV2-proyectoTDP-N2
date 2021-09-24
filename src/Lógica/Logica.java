package L�gica;

import Gui.GUI;
import java.util.Random;

public class Logica {
	protected int puntaje;
	protected Tetrimino tetriminoActual;
	protected Tetrimino tetriminoProximo;
	protected Tetrimino[] misTetriminos;
	protected int velocidad = 1;
	protected int contador;
	protected Grilla miGrilla;
	protected Reloj reloj;
	protected GUI Gui;
	protected Random randi = new Random();


	public Logica() {

		Gui = new GUI();

		Bloque[][] miTablero = Gui.getTableroGrafico();

		miGrilla = new Grilla(miTablero);

		misTetriminos[0] = new TetriminoI(miGrilla.obtenerBloque(0, 5), miGrilla.obtenerBloque(1, 5), miGrilla.obtenerBloque(2, 5), miGrilla.obtenerBloque(3, 5));
		misTetriminos[1] = new TetriminoL(miGrilla.obtenerBloque(0, 6), miGrilla.obtenerBloque(1, 4), miGrilla.obtenerBloque(1, 5), miGrilla.obtenerBloque(1, 6));
		misTetriminos[2] = new TetriminoLReves(miGrilla.obtenerBloque(0, 4), miGrilla.obtenerBloque(1, 4), miGrilla.obtenerBloque(1, 5), miGrilla.obtenerBloque(1, 6));
		misTetriminos[3] = new TetriminoT(miGrilla.obtenerBloque(0, 5), miGrilla.obtenerBloque(1, 4), miGrilla.obtenerBloque(1, 5), miGrilla.obtenerBloque(1, 6));
		misTetriminos[4] = new TetriminoS(miGrilla.obtenerBloque(1, 4), miGrilla.obtenerBloque(1, 5), miGrilla.obtenerBloque(0, 5), miGrilla.obtenerBloque(0, 6));
		misTetriminos[5] = new TetriminoZ(miGrilla.obtenerBloque(0, 4), miGrilla.obtenerBloque(0, 5), miGrilla.obtenerBloque(1, 5), miGrilla.obtenerBloque(1, 6));
		misTetriminos[6] = new TetriminoO(miGrilla.obtenerBloque(0, 5), miGrilla.obtenerBloque(0, 6), miGrilla.obtenerBloque(1, 5), miGrilla.obtenerBloque(1, 6));
		
		
	}

	public void iniciarJuego() {
		
	}
	
	public int getPuntaje() {
		return puntaje;
	}
	
	public Tetrimino getProxima() {
		return tetriminoProximo;
	}
	
	public void aumentarVelocidad() {
		this.velocidad++;
	}

	public void bajarTetrimino(){
		Bloque[] bloques = tetriminoActual.getBloques();
		if (miGrilla.puedeDescender(tetriminoActual)){

			Bloque[][] tableroGrafico = Gui.getTableroGrafico();

			Gui.pintarFondo(bloques);

			bloques[0] = tableroGrafico[bloques[0].getPosicionFila() + 1][bloques[0].getPosicionColumna()];
			bloques[1] = tableroGrafico[bloques[1].getPosicionFila() + 1][bloques[1].getPosicionColumna()];	
			bloques[2] = tableroGrafico[bloques[2].getPosicionFila() + 1][bloques[2].getPosicionColumna()];	
			bloques[3] = tableroGrafico[bloques[3].getPosicionFila() + 1][bloques[3].getPosicionColumna()];	

			Gui.pintarNuevo(bloques, tetriminoActual.color);

		}else{
			actualizarTetriminoActual();
			actualizarTetriminoProximo();
		}
	}
	
	public void actualizarTetriminoActual (){
		this.tetriminoActual = this.tetriminoProximo;
	}
	
	public void actualizarTetriminoProximo(){
		this.tetriminoProximo = misTetriminos[randi.nextInt(7)];
	}
	
	public void moverDerecha(){
		Bloque[] bloques = tetriminoActual.getBloques();
		if (miGrilla.puedoMoverDerecha(this.tetriminoActual)){
			
			Bloque[][] tableroGrafico = Gui.getTableroGrafico();

			Gui.pintarFondo(bloques);

			bloques[0] = tableroGrafico[bloques[0].getPosicionFila()][bloques[0].getPosicionColumna() + 1];
			bloques[1] = tableroGrafico[bloques[1].getPosicionFila()][bloques[1].getPosicionColumna() + 1];	
			bloques[2] = tableroGrafico[bloques[2].getPosicionFila()][bloques[2].getPosicionColumna() + 1];	
			bloques[3] = tableroGrafico[bloques[3].getPosicionFila()][bloques[3].getPosicionColumna() + 1];	

			Gui.pintarNuevo(bloques, tetriminoActual.color);

			bloques[1].setPosicionFila(bloques[1].getPosicionFila()+1);
		    bloques[2].setPosicionFila(bloques[2].getPosicionFila()+1);
			bloques[3].setPosicionFila(bloques[3].getPosicionFila()+1);
		}
	}
	
	public void moverIzquierda(){
		Bloque[] bloques = tetriminoActual.getBloques();
		if (miGrilla.puedoMoverIzquierda(this.tetriminoActual)){
						
			Bloque[][] tableroGrafico = Gui.getTableroGrafico();

			Gui.pintarFondo(bloques);

			bloques[0] = tableroGrafico[bloques[0].getPosicionFila()][bloques[0].getPosicionColumna() - 1];
			bloques[1] = tableroGrafico[bloques[1].getPosicionFila()][bloques[1].getPosicionColumna() - 1];	
			bloques[2] = tableroGrafico[bloques[2].getPosicionFila()][bloques[2].getPosicionColumna() - 1];	
			bloques[3] = tableroGrafico[bloques[3].getPosicionFila()][bloques[3].getPosicionColumna() - 1];	

			Gui.pintarNuevo(bloques, tetriminoActual.color);

			bloques[1].setPosicionFila(bloques[1].getPosicionFila()+1);
		    bloques[2].setPosicionFila(bloques[2].getPosicionFila()+1);
			bloques[3].setPosicionFila(bloques[3].getPosicionFila()+1);
		}
	}
}
