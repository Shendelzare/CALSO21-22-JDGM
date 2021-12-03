package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

	private List<Punto> torresNegras = new ArrayList<>();
	private List<Punto> torresBlancas = new ArrayList<>();;

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
	public void jugar(int x, int y) {
		jugar(proximoTurno, x, y);
	}

	public void jugar(JugadoresEnum jugador, int x, int y) {
		checkLimites(x, y);
		if (!isCasillaVacia(x, y)) {
			throw new IllegalMoveException("Posicion ocupada");
		}
		checkTurno(jugador);

		restaJugada(jugador);
		tablero[x][y] = jugador.ordinal();

		if (jugador.equals(JugadoresEnum.BLANCAS)) {
			torresBlancas.add(new Punto(x, y));
		} else {
			torresNegras.add(new Punto(x, y));

		}

	

	}

	private void restaJugada(JugadoresEnum jugador) {
		int jugadasDisponibles = numeroJugadas.get(jugador) - 1;
		if (jugadasDisponibles > 0) {
			jugadasDisponibles -= 1;
			numeroJugadas.put(jugador, jugadasDisponibles);

		} else {
			throw new IllegalMoveException("No quedan jugadas disponilbles jugador ".concat(jugador.toString()));
		}

	}

	private void checkTurno(JugadoresEnum jugador) {
		if (!jugador.equals(proximoTurno)) {
			throw new IllegalMoveException("No es tu turno :(");
		}

	}

	private void checkLimites(int x, int y) {
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

	public boolean existenAmenazas() {

		if (!(numeroJugadas.get(JugadoresEnum.NEGRAS) == 0 && numeroJugadas.get(JugadoresEnum.BLANCAS) == 0)) {
			throw new GameInProgressException("Aun quedan movimientos pendientes");
		}
		for (Punto estePunto : torresBlancas) {
			for (Punto otroPunto : torresNegras) {
				if (estePunto.getPosicionX() == otroPunto.getPosicionX()
						|| estePunto.getPosicionY() == otroPunto.getPosicionY()) {
					return true;
				}
			}
		}

		return false;
	}

	public List<Punto> getTorresNegras() {
		return torresNegras;
	}

	public void setTorresNegras(List<Punto> torresNegras) {
		this.torresNegras = torresNegras;
	}

	public List<Punto> getTorresBlancas() {
		return torresBlancas;
	}

	public void setTorresBlancas(List<Punto> torresBlancas) {
		this.torresBlancas = torresBlancas;
	}
}
