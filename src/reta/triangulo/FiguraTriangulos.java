/**
 * Desenha triangulos na tela
 *
 * @author Breno Rodrigues, Bruno Novo, Gabriel Odakura
 * @version 20230810
 */
package reta.triangulo;

import java.awt.*;

/**
 * Contem metodos para desenhar um Triangulo.
 *
 * @author Breno Rodrigues, Bruno Novo, Gabriel Odakura
 * @version 20231031
 */
public class FiguraTriangulos {

    /**
     * Desenha um triangulo de acordo com os pontos p1, p2 e p3
     *
     * @param g biblioteca para desenhar o primitivo grafico
     * @param x1 coordenada x de p1
     * @param y1 coordenada y de p1
     * @param x2 coordenada x de p2
     * @param y2 coordenada y de p2
     * @param x3 coordenada x de p3
     * @param y3 coordenada y de p3
     * @param nome nome da reta
     * @param espessura espessura da reta
     * @param corAtual cor da reta
     */
    public static void desenharTriangulo(Graphics g,int x1, int y1, int x2, int y2, int x3, int y3,String nome, int espessura, Color corAtual){
        TrianguloGr triangulo = new TrianguloGr(x1,y1,x2,y2,x3,y3,nome,espessura,corAtual);
//        System.out.println("Valor de X1: " + triangulo.getPonto1().getX() + " Valor de Y1: " + triangulo.getPonto1().getY()
//                + " Valor de X2: " + triangulo.getPonto2().getX() + " Valor de Y2: " + triangulo.getPonto2().getY()
//                + " Valor de X3: " + triangulo.getPonto3().getX() + " Valor de Y3: " + triangulo.getPonto3().getY());
        triangulo.desenharTriangulo(g);
    }
}
