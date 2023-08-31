package armazenador;

import ponto.Ponto;
import tipoPrimitivo.TipoPrimitivo;

public class Armazenador {
	private Ponto ponto1;
	private Ponto ponto2;
	private Ponto ponto3;
	private TipoPrimitivo tipo;
	private int espessura;
	
	public Armazenador(int x1, int y1, TipoPrimitivo tipo, int esp) {
		this.ponto1 = new Ponto(x1,y1);
		this.tipo = tipo;
		this.espessura = esp;
	}
	
	public Armazenador(int x1, int y1, int x2, int y2, TipoPrimitivo tipo, int esp) {
		this.ponto1 = new Ponto(x1,y1);
		this.ponto2 = new Ponto(x2,y2);
		this.tipo = tipo;
		this.espessura = esp;
	}
	
	public Armazenador(int x1, int y1, int x2, int y2, int x3, int y3, TipoPrimitivo tipo, int esp) {
		this.ponto1 = new Ponto(x1,y1);
		this.ponto2 = new Ponto(x2,y2);
		this.ponto3 = new Ponto(x3,y3);
		this.tipo = tipo;
		this.espessura = esp;
	}

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

	@Override
	public String toString() {
		return "{Ponto 1: " + this.ponto1 + "}" +
				"{Ponto 2: " + this.ponto2 + "}" +
				"{Ponto 3: " + this.ponto3 + "}" +
				"{" + "Tipo:" + this.tipo + "}";
	}
}
