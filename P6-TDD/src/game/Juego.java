package game;

import java.util.HashMap;
import java.util.Map;

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
	private static final int JUGADAS_DISPONIBLES = 2;

	private JugadoresEnum proximoTurno;
	private Map<JugadoresEnum, Integer> numeroJugadas;

	public enum JugadoresEnum {
		BLANCAS, NEGRAS
	}

	public Juego() {
		this(JugadoresEnum.BLANCAS);
	}

	public Juego(JugadoresEnum turno) {
		tablero = new int[TAMANO_TABLERO][TAMANO_TABLERO];
		setProximoTurno(turno);
		inicializaTablero();
		inicializaJugadas();
	}

	private void inicializaJugadas() {
		numeroJugadas = new HashMap<>();
		numeroJugadas.put(JugadoresEnum.BLANCAS, JUGADAS_DISPONIBLES);
		numeroJugadas.put(JugadoresEnum.NEGRAS, JUGADAS_DISPONIBLES);

	}

	private void inicializaTablero() {
		for (int i = 0; i < TAMANO_TABLERO; i++) {
			for (int j = 0; j < TAMANO_TABLERO; j++) {
				tablero[i][j] = -1;

			}
		}

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
	public void jugar(int x, int y) throws IllegalMoveException {
		jugar(proximoTurno, x, y);
	}

	public void jugar(JugadoresEnum jugador, int x, int y) throws IllegalMoveException {
		checkLimites(x, y);
		if (!isCasillaVacia(x, y)) {
			throw new IllegalMoveException("Posicion ocupada");
		}
		checkTurno(jugador);
		tablero[x][y] = jugador.ordinal();
		restaJugada(jugador);
	}

	private void restaJugada(JugadoresEnum jugador) throws IllegalMoveException  {
		int jugadasDisponibles =numeroJugadas.get(jugador)-1;
		if(jugadasDisponibles>0) {
			jugadasDisponibles-=1;
			numeroJugadas.put(jugador, jugadasDisponibles);
		}else {
			throw new IllegalMoveException("No quedan jugadas disponilbles jugador ".concat(jugador.toString()));
		}
		
		
	}

	private void checkTurno(JugadoresEnum jugador) throws IllegalMoveException {
		if (!jugador.equals(proximoTurno)) {
			throw new IllegalMoveException("No es tu turno :(");
		}

	}

	private void checkLimites(int x, int y) throws IllegalMoveException {
		if (x > TAMANO_TABLERO || x <= 0 || y > TAMANO_TABLERO || y <= 0) {
			throw new IllegalMoveException("Sobrepasado limite del tablero");
		}
	}

	private boolean isCasillaVacia(int x, int y) {
		return tablero[x][y] == -1;
	}

	public JugadoresEnum getProximoTurno() {
		return proximoTurno;
	}

	public void setProximoTurno(JugadoresEnum proximoTurno) {
		this.proximoTurno = proximoTurno;
	}
}
