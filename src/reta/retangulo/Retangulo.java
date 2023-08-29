/**
 * Calcula e salva os pontos de um retangulo baseados em pontos
 * definidos pelo usuario
 *
 * @author Breno Rodrigues, Bruno Novo, Gabriel Odakura
 * @version 20230810
 */

package reta.retangulo;

import ponto.*;

public class Retangulo {

    private Ponto ponto1;
    private Ponto ponto2;
    private Ponto ponto3;
    private Ponto ponto4;

    /**
     * Constroi uma reta com valores (int) de x1, y1 e x2, y2
     *
     * @param x1 coordenada x de p1
     * @param y1 coordenada y de p1
     * @param x2 coordenada x de p2
     * @param y2 coordenada y de p2
     */
    public Retangulo(int x1, int y1, int x2, int y2){
        ponto1 = new Ponto(x1,y1);
        ponto2 = new Ponto(x2,y2);
        ponto3 = new Ponto(calcularPonto3());
        ponto4 = new Ponto(calcularPonto4());
    }

    /**
     * Constroi uma reta com valores (double) de x1, y1 e x2, y2
     *
     * @param x1 coordenada x de p1
     * @param y1 coordenada y de p1
     * @param x2 coordenada x de p2
     * @param y2 coordenada y de p2
     */
    public Retangulo(double x1, double y1, double x2, double y2){
        ponto1 = new Ponto(x1,y1);
        ponto2 = new Ponto(x2,y2);
        ponto3 = new Ponto(calcularPonto3());
        ponto4 = new Ponto(calcularPonto4());
    }

    /** calcularPonto3 - Calcula um dos pontos do retangulo baseado nos
     *                   pontos definidos pelo usuário
     *
     * @return Ponto - Retorna um dos pontos para desenhar o retangulo
     */
    private Ponto calcularPonto3(){
        Ponto temp = new Ponto(ponto2.getX(), ponto1.getY());
        return temp;
    }

    /** calcularPonto4 - Calcula um dos pontos do retangulo baseado nos
     *                   pontos definidos pelo usuário
     *
     * @return Ponto - Retorna um dos pontos para desenhar o retangulo
     */
    private Ponto calcularPonto4(){
        Ponto temp = new Ponto(ponto1.getX(), ponto2.getY());
        return temp;
    }

    //getters e setters
    public Ponto getPonto1() {
        return ponto1;
    }

    public Ponto getPonto2() {
        return ponto2;
    }

    public Ponto getPonto3() {
        return ponto3;
    }

    public Ponto getPonto4() {
        return ponto4;
    }
}
