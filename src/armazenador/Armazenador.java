package armazenador;

import ponto.Ponto;
import tipoPrimitivo.TipoPrimitivo;

import java.awt.*;

/**
 * Local de armazenamento dos dados de cada desenho.
 *
 * @author Breno Rodrigues, Bruno Novo, Gabriel Odakura
 * @version 20231031
 */
public class Armazenador {
	private Ponto ponto1;
	private Ponto ponto2;
	private Ponto ponto3;
	private TipoPrimitivo tipo;
	private int espessura;
	private Color corFigura;
	private Color segundaCorMandala;
	
	
	/**
     * Guarda o ponto
     *
     * @param x1 coordenada x de p1
     * @param y1 coordenada y de p1
     * @param esp espessura da figura
     * @param corFigura cor da figura
     */
	public Armazenador(int x1, int y1, TipoPrimitivo tipo, int esp, Color corFigura) {
		this.ponto1 = new Ponto(x1,y1);
		this.tipo = tipo;
		this.espessura = esp;
		this.corFigura = corFigura;
	}
	
	/**
     * Guarda figura de dois pontos
     *
     * @param x1 coordenada x de p1
     * @param y1 coordenada y de p1
     * @param x2 coordenada x de p2
     * @param y2 coordenada y de p2
     * @param esp espessura da figura
     * @param corFigura cor da figura
     */
	public Armazenador(int x1, int y1, int x2, int y2, TipoPrimitivo tipo, int esp, Color corFigura, Color segundaCorMandala) {
		this.ponto1 = new Ponto(x1,y1);
		this.ponto2 = new Ponto(x2,y2);
		this.tipo = tipo;
		this.espessura = esp;
		this.corFigura = corFigura;
		this.segundaCorMandala = segundaCorMandala;
	}
	
	/**
     * Guarda figura de três pontos
     *
     * @param x1 coordenada x de p1
     * @param y1 coordenada y de p1
     * @param x2 coordenada x de p2
     * @param y2 coordenada y de p2
     * @param x3 coordenada x de p3
     * @param y3 coordenada y de p3
     * @param esp espessura da figura
     * @param corFigura cor da figura
     */
	public Armazenador(int x1, int y1, int x2, int y2, int x3, int y3, TipoPrimitivo tipo, int esp, Color corFigura) {
		this.ponto1 = new Ponto(x1,y1);
		this.ponto2 = new Ponto(x2,y2);
		this.ponto3 = new Ponto(x3,y3);
		this.tipo = tipo;
		this.espessura = esp;
		this.corFigura = corFigura;
	}

	//getters e setters
	public Ponto getPonto1() {
		return ponto1;
	}

	public void setPonto1(Ponto ponto1) {
		this.ponto1 = ponto1;
	}

	public Ponto getPonto2() {
		return ponto2;
	}

	public void setPonto2(Ponto ponto2) {
		this.ponto2 = ponto2;
	}

	public Ponto getPonto3() {
		return ponto3;
	}

	public void setPonto3(Ponto ponto3) {
		this.ponto3 = ponto3;
	}

	public TipoPrimitivo getTipo() {
		return tipo;
	}

	public void setTipo(TipoPrimitivo tipo) {
		this.tipo = tipo;
	}

	public int getEspessura() {
		return espessura;
	}

	public void setEspessura(int espessura) {
		this.espessura = espessura;
	}

	public Color getCorFigura() {
		return corFigura;
	}

	public void setCorFigura(Color corFigura) {
		this.corFigura = corFigura;
	}

	public Color getSegundaCorMandala() {
		return segundaCorMandala;
	}

	public void setSegundaCorMandala(Color segundaCorMandala) {
		this.segundaCorMandala = segundaCorMandala;
	}

	@Override
	public String toString() {
		return "{Ponto 1: " + this.ponto1 + "}" +
				"{Ponto 2: " + this.ponto2 + "}" +
				"{Ponto 3: " + this.ponto3 + "}" +
				"{" + "Tipo:" + this.tipo + "}";
	}
}
