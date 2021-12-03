package game;

/*
 * Clase Juego tiene la responsabilidad de ofrecer las funcionalidades básicas del juego de tablero descrito en
 * el enunciado de la práctica. Inicialmente no se implementa funcionalidad alguna y el estado de la programación de la clase es inicial
 * No se recogen ni estructras de datos ni métodos que deberán incorprarse de forma progresiva.
 * 
 * IMPORTANTE: recordad el ciclo TDD: Test->Código->Refactorización->Test->...
 */

public class Juego {

	private int[][] tablero;
	private static final int TAMANO_TABLERO = 4;
	private JugadoresEnum proximoTurno;
	
	public enum JugadoresEnum{BLANCAS,NEGRAS}

	public Juego() {
		tablero = new int[TAMANO_TABLERO][TAMANO_TABLERO];
	}
	
	public Juego(JugadoresEnum turno) {
		this();
		setProximoTurno(turno);
	
	}

	public int[][] getTablero() {
		return tablero;
	}

	public void setTablero(int[][] tablero) {
		this.tablero = tablero;
	}

	/*
	 * Método de inicio asociado al requisito 1 donde se implementa la funcionalidad
	 * básica de posicionar una pieza en el tablero.
	 * 
	 * @param x fila de la casilla en la que se desea incorporar la pieza
	 * 
	 * @param y columna de la casilla en la que se desea indorporar la pieza
	 */
	public void jugar(int x, int y) {
		checkLimites(x, y);
		if (isCasillaVacia(x, y)) {
			throw new IllegalArgumentException("Posicion ocupada");
		}

	}

	private void checkLimites(int x, int y) {
		if (x > TAMANO_TABLERO || x <= 0 || y > TAMANO_TABLERO || y <= 0) {
			throw new IllegalArgumentException("Sobrepasado limite del tablero");
		}
	}

	private boolean isCasillaVacia(int x, int y) {
		return tablero[x][y] == 0;
	}

	public JugadoresEnum getProximoTurno() {
		return proximoTurno;
	}

	public void setProximoTurno(JugadoresEnum proximoTurno) {
		this.proximoTurno = proximoTurno;
	}
}
