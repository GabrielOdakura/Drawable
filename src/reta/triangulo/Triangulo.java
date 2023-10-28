/**
 * implementacao da classe triangulo
 *
 * @author Breno Rodrigues, Bruno Novo, Gabriel Odakura
 * @version 20230810
 */
package reta.triangulo;

import ponto.Ponto;

public class Triangulo {

    private Ponto ponto1, ponto2, ponto3, pontoT;

    /**
     * Constroi uma reta com valores (int) de x1, y1 e x2, y2
     *
     * @param x1 coordenada x de p1
     * @param y1 coordenada y de p1
     * @param x2 coordenada x de p2
     * @param y2 coordenada y de p2
     * @param x3 coordenada y de p3
     * @param y3 coordenada y de p3
     */
    public Triangulo(int x1, int y1, int x2, int y2, int x3, int y3){
        ponto1 = new Ponto(x1,y1);
        ponto2 = new Ponto(x2,y2);
        ponto3 = new Ponto(x3,y3);
    }

    /**
     * Constroi uma reta com valores (double) de x1, y1 e x2, y2
     *
     * @param x1 coordenada x de p1
     * @param y1 coordenada y de p1
     * @param x2 coordenada x de p2
     * @param y2 coordenada y de p2
     * @param x3 coordenada y de p3
     * @param y3 coordenada y de p3
     */
    public Triangulo(double x1, double y1, double x2, double y2, double x3, double y3){
        ponto1 = new Ponto(x1,y1);
        ponto2 = new Ponto(x2,y2);
        ponto3 = new Ponto(x3,y3);
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
    
    public Ponto getPontoT() {
        return pontoT;
    }

    public void setPontoT(Ponto pontoT) {
        this.pontoT = pontoT;
    }
}
