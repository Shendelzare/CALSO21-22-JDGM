package game;

/*
 * Clase Juego tiene la responsabilidad de ofrecer las funcionalidades b�sicas del juego de tablero descrito en
 * el enunciado de la pr�ctica. Inicialmente no se implementa funcionalidad alguna y el estado de la programaci�n de la clase es inicial
 * No se recogen ni estructras de datos ni m�todos que deber�n incorprarse de forma progresiva.
 * 
 * IMPORTANTE: recordad el ciclo TDD: Test->C�digo->Refactorizaci�n->Test->...
 */

public class Juego {
	
	private int[][] tablero;
	private static final int TAMANO_TABLERO = 4;


	public Juego() {
		tablero = new int[TAMANO_TABLERO][TAMANO_TABLERO];
	}

	public int[][] getTablero() {
		return tablero;
	}

	public void setTablero(int[][] tablero) {
		this.tablero = tablero;
	}
	/*
	 * M�todo de inicio asociado al requisito 1 donde se implementa la funcionalidad
	 * b�sica de posicionar una pieza en el tablero.
	 * 
	 * @param x fila de la casilla en la que se desea incorporar la pieza
	 * 
	 * @param y columna de la casilla en la que se desea indorporar la pieza
	 */
	public void jugar(int x, int y) {
		if(x>TAMANO_TABLERO) {
			throw new IllegalArgumentException("Sobrepasado limite del tablero");
		}

	}

}
