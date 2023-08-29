/**
 * Desenha retangulos na tela
 *
 * @author Breno Rodrigues, Bruno Novo, Gabriel Odakura
 * @version 20230810
 */
package reta.retangulo;

import java.awt.*;

public class FiguraRetangulos {

    /**
     * Desenha um retangulo de acordo com os pontos p1 e p2
     *
     * @param g biblioteca para desenhar o primitivo grafico
     * @param x1 coordenada x de p1
     * @param y1 coordenada y de p1
     * @param x2 coordenada x de p2
     * @param y2 coordenada y de p2
     * @param nome nome da reta
     * @param espessura espessura da reta
     * @param corAtual cor da reta
     */
    public static void desenharRetangulo(Graphics g, int x1, int y1, int x2, int y2,String nome, int espessura, Color corAtual){
        RetanguloGr retangulo = new RetanguloGr(x1,y1,x2,y2,nome,espessura,corAtual);
//        System.out.println("Valor de X3: " + retangulo.getPonto3().getX() + " Valor de Y3: " + retangulo.getPonto3().getY()
//                + " Valor de X4: " + retangulo.getPonto4().getX() + " Valor de Y4: " + retangulo.getPonto4().getY());
        retangulo.desenharRetangulo(g);
    }
}
