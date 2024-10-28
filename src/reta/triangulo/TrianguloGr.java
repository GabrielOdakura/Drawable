/**
 * implementacao da classe triangulo grafico
 *
 * @author Breno Rodrigues, Bruno Novo, Gabriel Odakura
 * @version 20230821
 */
package reta.triangulo;

import reta.RetaGr;

import java.awt.*;

/**
 * Implementacao da classe Triangulo grafico.
 *
 * @author Breno Rodrigues, Bruno Novo, Gabriel Odakura
 * @version 20231031
 */
public class TrianguloGr extends Triangulo{
    private String nome;
    private int espessura;
    private Color corAtual;

    /**
     * TrianguloGr - Constroi um triangulo grafico
     *
     * @param x1 int. Coordenada x1
     * @param y1 int. Coordenada y1
     * @param x2 int. Coordenada x2
     * @param y2 int. Coordenada y2
     * @param x3 int. Coordenada x3
     * @param y3 int. Coordenada y3
     * @param corAtual Color. Cor da reta
     * @param nome String. Nome da reta
     * @param espessura int. Espessura da reta
     */
    public TrianguloGr(int x1, int y1, int x2, int y2, int x3, int y3, String nome, int espessura, Color corAtual){
        super(x1, y1, x2, y2, x3, y3);
        this.nome = nome;
        this.espessura = espessura;
        this.corAtual = corAtual;
    }

    /**
     * TrianguloGr - Constroi um triangulo grafico
     *
     * @param x1 int. Coordenada x1
     * @param y1 int. Coordenada y1
     * @param x2 int. Coordenada x2
     * @param y2 int. Coordenada y2
     * @param x3 int. Coordenada x3
     * @param y3 int. Coordenada y3
     * @param corAtual Color. Cor da reta
     * @param nome String. Nome da reta
     * @param espessura int. Espessura da reta
     */
    public TrianguloGr(double x1, double y1, double x2, double y2, double x3, double y3, String nome, int espessura, Color corAtual){
        super(x1, y1, x2, y2, x3, y3);
        this.nome = nome;
        this.espessura = espessura;
        this.corAtual = corAtual;
    }

    /**
     * Usa os tres pontos que sao salvos pelo construtor para criar tres retas ligando em um triangulo
     *
     * @param g Graphics. Classe com os metodos graficos do Java
     */
    public void desenharTriangulo(Graphics g){
        RetaGr reta1 = new RetaGr((int) getPonto1().getX(),(int) getPonto1().getY(),
                (int) getPonto2().getX(),(int) getPonto2().getY(),corAtual,nome, espessura);
        RetaGr reta2 = new RetaGr((int) getPonto2().getX(),(int) getPonto2().getY(),
                (int) getPonto3().getX(),(int) getPonto3().getY(),corAtual,nome, espessura);
        RetaGr reta3 = new RetaGr((int) getPonto1().getX(),(int) getPonto1().getY(),
                (int) getPonto3().getX(),(int) getPonto3().getY(),corAtual,nome, espessura);
        reta1.desenharReta(g);
        reta2.desenharReta(g);
        reta3.desenharReta(g);
    }
    
    
}
