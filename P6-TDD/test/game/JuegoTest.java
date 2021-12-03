package game;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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
	public void testPosicionarFueraTableroArriba()  {
		juego.jugar(1, 5);
	}

	@Test(expected = IllegalMoveException.class)
	public void testPosicionarFueraTableroAbajo()  {
		juego.jugar(1, 0);
	}

	@Test(expected = IllegalMoveException.class)
	public void testPosicionarFueraTableroDerecha()  {
		juego.jugar(5, 1);
	}

	@Test(expected = IllegalMoveException.class)
	public void testPosicionarFueraTableroIzquierda()  {
		juego.jugar(0, 1);
	}

	@Test(expected = IllegalMoveException.class)
	public void testIsCasillaVacia()  {
		juego.jugar(3, 1);
		juego.jugar(JugadoresEnum.NEGRAS,3, 1);
	}

	@Test
	public void iniciaJuego() {
		juego = new Juego(JugadoresEnum.BLANCAS);
	}
	
	@Test(expected = IllegalMoveException.class)
	public void jugarNegras()  {
		juego = new Juego(JugadoresEnum.BLANCAS);
		juego.jugar(JugadoresEnum.NEGRAS, 2, 3);
	}

	@Test
	public void jugarNegras1()  {
		juego = new Juego(JugadoresEnum.NEGRAS);
		juego.jugar(JugadoresEnum.NEGRAS, 2, 3);
	}

	@Test(expected = IllegalMoveException.class)
	public void jugarBlancas()  {
		juego = new Juego(JugadoresEnum.NEGRAS);
		juego.jugar(JugadoresEnum.BLANCAS, 2, 3);
	}

	@Test
	public void jugarBlancas1()  {
		juego.jugar(JugadoresEnum.BLANCAS, 2, 3);
	}
	@Test(expected = IllegalMoveException.class)
	public void superarTorresPermitidas()  {
		juego.jugar(1, 1);
		juego.jugar(1, 2);
		juego.jugar(1, 3);
		juego.jugar(1, 4);
		juego.jugar(2, 1);
	}
	@Test
	public void existenAmenazasTest() {
		assertTrue(juego.existenAmenazas());
	}
	
	@Test(expected = GameInProgressException.class)
	public void existenAmenazasTest1() {
		assertTrue(juego.existenAmenazas());
	}
	
}
