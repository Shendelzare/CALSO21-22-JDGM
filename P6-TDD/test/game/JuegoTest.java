package game;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import game.Juego.JugadoresEnum;

public class JuegoTest {

	private Juego juego;

	@Before
	public void setUp() {
		juego = new Juego();
	}

	/*
	 * Tests para requisito 1
	 */
	@Test
	public void testGetTablero() {

		assertNotNull(juego.getTablero());
	}

	@Test(expected = IllegalMoveException.class)
	public void testPosicionarFueraTableroArriba() throws IllegalMoveException {
		juego.jugar(1, 5);
	}

	@Test(expected = IllegalMoveException.class)
	public void testPosicionarFueraTableroAbajo() throws IllegalMoveException {
		juego.jugar(1, 0);
	}

	@Test(expected = IllegalMoveException.class)
	public void testPosicionarFueraTableroDerecha() throws IllegalMoveException {
		juego.jugar(5, 1);
	}

	@Test(expected = IllegalMoveException.class)
	public void testPosicionarFueraTableroIzquierda() throws IllegalMoveException {
		juego.jugar(0, 1);
	}

	@Test(expected = IllegalMoveException.class)
	public void testIsCasillaVacia() throws IllegalMoveException {
		juego.jugar(3, 1);
		juego.jugar(JugadoresEnum.NEGRAS,3, 1);
	}

	@Test
	public void iniciaJuego() {
		juego = new Juego(JugadoresEnum.BLANCAS);
	}
	
	@Test(expected = IllegalMoveException.class)
	public void jugarNegras() throws IllegalMoveException {
		juego = new Juego(JugadoresEnum.BLANCAS);
		juego.jugar(JugadoresEnum.NEGRAS, 2, 3);
	}

	@Test
	public void jugarNegras1() throws IllegalMoveException {
		juego = new Juego(JugadoresEnum.NEGRAS);
		juego.jugar(JugadoresEnum.NEGRAS, 2, 3);
	}

	@Test(expected = IllegalMoveException.class)
	public void jugarBlancas() throws IllegalMoveException {
		juego = new Juego(JugadoresEnum.NEGRAS);
		juego.jugar(JugadoresEnum.BLANCAS, 2, 3);
	}

	@Test
	public void jugarBlancas1() throws IllegalMoveException {
		juego.jugar(JugadoresEnum.BLANCAS, 2, 3);
	}
	@Test(expected = IllegalMoveException.class)
	public void superarTorresPermitidas() throws IllegalMoveException {
		juego.jugar(1, 1);
		juego.jugar(1, 2);
		juego.jugar(1, 3);
		juego.jugar(1, 4);
		juego.jugar(2, 1);
	}
}
