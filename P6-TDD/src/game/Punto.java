package game;

public class Punto {

	private int posicionX;
	private int posicionY;

	public Punto(int x, int y) {
		posicionX = x;
		posicionY = y;
	}

	public int getPosicionX() {
		return posicionX;
	}

	public void setPosicionX(int posicionX) {
		this.posicionX = posicionX;
	}

	public int getPosicionY() {
		return posicionY;
	}

	public void setPosicionY(int posicionY) {
		this.posicionY = posicionY;
	}

}
