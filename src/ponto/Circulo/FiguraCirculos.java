/**
 * Desenha um circulo na tela
 *
 * @author Breno Rodrigues, Bruno Novo, Gabriel Odakura
 * @version 20230905
 */
package ponto.Circulo;
import java.awt.Color;
import java.awt.*;

/**
 * Contem metodos para desenhar figuras com Circulo
 *
 * @author Breno Rodrigues, Bruno Novo, Gabriel Odakura
 * @version 20231031
 */
public class FiguraCirculos {
	/**
     * Desenha um circulo de acordo com os pontos p1 e p2
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
	public static void desenharCirculo(Graphics g, int x1, int y1, int x2, int y2, String nome, int espessura, Color corAtual){
        CirculoGr circulo = new CirculoGr(x1, y1, x2, y2, nome, espessura, corAtual);
        circulo.desenharCirculo(g);
        
    }
}
