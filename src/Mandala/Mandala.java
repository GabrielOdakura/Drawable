/**
 * implementacao da classe mandala
 *
 * @author Breno Rodrigues, Bruno Novo, Gabriel Odakura
 * @version 20230905
 */
package Mandala;

import ponto.Ponto;

public class Mandala {

    private Ponto ponto1;
    private Ponto ponto2;
    private Ponto ponto3;
    private Ponto ponto4;
    private Ponto ponto5;
    private Ponto ponto6;
    private Ponto ponto7;
    private Ponto ponto8;
    private Ponto ponto9;
    private Ponto ponto10;
    private Ponto ponto11;
    private Ponto ponto12;
    private Ponto ponto13;
    public Mandala(int x1, int y1, int x2, int y2){
    	if(x1<x2) { // caso os pontos sejam da esquerda pra direita
    		this.ponto1 = (new Ponto(x1,y1));
    		this.ponto2 = (new Ponto(x2,y2));
    	}else { // caso os pontos sejam da direita pra esquerda
    		this.ponto2 = (new Ponto(x1,y1));
            this.ponto1 = (new Ponto(x2,y2));
    	}
        calcularPontos();
    }

    /** calcularPontos - Calcula os pontos necessários para a construção da mandala
     *
     */
    private void calcularPontos(){
        int distancia;
        int diferencaXY; // serve para calcular os pontos diretamente abaixo e em cima de P1
        distancia = (int) getPonto1().getX() - (int)  getPonto2().getX();
        diferencaXY = (int) (distancia - (distancia * 12.1) /100);
        if(distancia < 0) distancia = distancia * -1;
        this.ponto3 = (new Ponto((getPonto1().getX() + (distancia / 2)),(getPonto1().getY() - diferencaXY)));
        this.ponto4 = (new Ponto((getPonto3().getX() + (distancia)), getPonto3().getY()));
        this.ponto5 = (new Ponto((getPonto3().getX() - distancia), getPonto3().getY()));
        this.ponto6 = (new Ponto((getPonto5().getX() - (distancia)), getPonto3().getY()));
        this.ponto7 = (new Ponto(ponto1.getX(), (ponto1.getY() - (2 * diferencaXY))));
        this.ponto8 = (new Ponto((getPonto1().getX() - distancia), getPonto1().getY()));
        this.ponto9 = (new Ponto(getPonto6().getX(), (getPonto1().getY() + diferencaXY)));
        this.ponto10 = (new Ponto((getPonto9().getX() + distancia),(getPonto9().getY())));
        this.ponto11 = (new Ponto((getPonto10().getX() + distancia),(getPonto9().getY())));
        this.ponto12 = (new Ponto((getPonto4().getX()),(getPonto9().getY())));
        this.ponto13 = (new Ponto(ponto1.getX(), (ponto1.getY() + (2 * diferencaXY))));
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

    public Ponto getPonto4() {
        return ponto4;
    }

    public void setPonto4(Ponto ponto4) {
        this.ponto4 = ponto4;
    }

    public Ponto getPonto5() {
        return ponto5;
    }

    public void setPonto5(Ponto ponto5) {
        this.ponto5 = ponto5;
    }

    public Ponto getPonto6() {
        return ponto6;
    }

    public void setPonto6(Ponto ponto6) {
        this.ponto6 = ponto6;
    }

    public Ponto getPonto7() {
        return ponto7;
    }

    public void setPonto7(Ponto ponto7) {
        this.ponto7 = ponto7;
    }

    public Ponto getPonto8() {
        return ponto8;
    }

    public void setPonto8(Ponto ponto8) {
        this.ponto8 = ponto8;
    }

    public Ponto getPonto9() {
        return ponto9;
    }

    public void setPonto9(Ponto ponto9) {
        this.ponto9 = ponto9;
    }

    public Ponto getPonto10() {
        return ponto10;
    }

    public void setPonto10(Ponto ponto10) {
        this.ponto10 = ponto10;
    }

    public Ponto getPonto11() {
        return ponto11;
    }

    public void setPonto11(Ponto ponto11) {
        this.ponto11 = ponto11;
    }

    public Ponto getPonto12() {
        return ponto12;
    }

    public void setPonto12(Ponto ponto12) {
        this.ponto12 = ponto12;
    }

    public Ponto getPonto13() {
        return ponto13;
    }

    public void setPonto13(Ponto ponto13) {
        this.ponto13 = ponto13;
    }
}
