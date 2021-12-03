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

	@Test(expected = IllegalArgumentException.class)
	public void testPosicionarFueraTableroArriba() {
		juego.jugar(1, 5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPosicionarFueraTableroAbajo() {
		juego.jugar(1, 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPosicionarFueraTableroDerecha() {
		juego.jugar(5, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPosicionarFueraTableroIzquierda() {
		juego.jugar(0, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testIsCasillaVacia() {
		juego.jugar(3, 1);
	}

	@Test
	public void iniciaJuego() {
		juego = new Juego(JugadoresEnum.BLANCAS);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void jugarNegras() {
		juego.jugar(JugadoresEnum.NEGRAS, 2, 3);
	}

	@Test
	public void jugarNegras1() {
		juego.jugar(JugadoresEnum.NEGRAS, 2, 3);
	}

	@Test(expected = IllegalArgumentException.class)
	public void jugarBlancas() {
		juego.jugar(JugadoresEnum.BLANCAS, 2, 3);
	}

	@Test
	public void jugarBlancas1() {
		juego.jugar(JugadoresEnum.BLANCAS, 2, 3);
	}
}
