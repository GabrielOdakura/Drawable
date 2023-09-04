package ponto.Circulo;

import ponto.Ponto;

public class Circulo {
    private Ponto ponto1;
    private Ponto ponto2;
    private int raio;

    // Construtores
    /**
     * CirculoGr - Constroi uma circulo com valores p e diametro
     *
     * @param p int. Coordenada ponto inicial
     * @param diametro int. Diametro da circunferencia
     */
    public Circulo(Ponto p, int diametro){
        this.ponto1 = p;
        this.raio = diametro / 2;
    }

    /**
     * Constroi um circulo com valores de x1, y1 e x2, y2
     *
     * @param x1 coordenada x de p1
     * @param y1 coordenada y de p1
     * @param x2 coordenada x de p2
     * @param y2 coordenada y de p2
     */
    public Circulo(int x1, int y1, int x2, int y2){
        this.ponto1 = new Ponto(x1, y1);
        this.ponto2 = new Ponto(x2, y2);
        this.raio = (int) Math.sqrt(Math.pow((x1 - x2),2) + Math.pow((y1 - y2),2));
        if(this.raio < 0) this.raio = this.raio * -1;
    }


    /**
     * Constroi um circulo com valores de x1, y1 e x2, y2
     *
     * @param x1 coordenada x de p1
     * @param y1 coordenada y de p1
     * @param x2 coordenada x de p2
     * @param y2 coordenada y de p2
     */
    public Circulo(double x1, double y1, double x2, double y2){
        this.ponto1 = new Ponto((int) x1, (int) y1);
        this.ponto2 = new Ponto( (int) x2, (int) y2);
        this.raio = (int) Math.sqrt(Math.pow((x1 - x2),2) + Math.pow((y1 - y2),2));
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

    public int getRaio() {
        return raio;
    }

    public void setRaio(int raio) {
        this.raio = raio;
    }
}
