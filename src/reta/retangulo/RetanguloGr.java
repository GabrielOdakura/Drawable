/**
 * Implementacao da classe retangulo grafico
 *
 * @author Breno Rodrigues, Bruno Novo, Gabriel Odakura
 * @version 20230810
 */
package reta.retangulo;

import reta.RetaGr;

import java.awt.*;

public class RetanguloGr extends Retangulo{

    private String nome;
    private int espessura;
    private Color corAtual;

    /**
     * RetanguloGr - Constroi uma reta grafica
     *
     * @param x1 int. Coordenada x1
     * @param y1 int. Coordenada y1
     * @param x2 int. Coordenada x2
     * @param y2 int. Coordenada y2
     * @param corAtual Color. Cor da reta
     * @param nome String. Nome da reta
     * @param espessura int. Espessura da reta
     */
    public RetanguloGr(int x1, int y1, int x2, int y2, String nome, int espessura, Color corAtual){
        super(x1, y1, x2, y2);
        this.nome = nome;
        this.espessura = espessura;
        this.corAtual = corAtual;
    }

    /**
     * RetanguloGr - Constroi uma reta grafica
     *
     * @param x1 double Coordenada x1
     * @param y1 double Coordenada y1
     * @param x2 double Coordenada x2
     * @param y2 double Coordenada y2
     * @param corAtual Color. Cor da reta
     * @param nome String. Nome da reta
     * @param espessura int. Espessura da reta
     */
    public RetanguloGr(double x1, double y1, double x2, double y2, String nome, int espessura, Color corAtual){
        super(x1, y1, x2, y2);
        this.nome = nome;
        this.espessura = espessura;
        this.corAtual = corAtual;
    }

    /**
     * Usa os dois pontos feitos pelo usuario mais os dois calculados para
     * desenhar um retangulo na tela
     *
     * @param g Graphics. Classe com os metodos graficos do Java
     */
    public void desenharRetangulo(Graphics g){
        RetaGr reta1 = new RetaGr( (int) getPonto1().getX(), (int) getPonto1().getY(),(int) getPonto3().getX(), (int) getPonto3().getY(),corAtual,nome,espessura);
        RetaGr reta2 = new RetaGr( (int) getPonto3().getX(), (int) getPonto3().getY(),(int) getPonto2().getX(), (int) getPonto2().getY(),corAtual,nome,espessura);
        RetaGr reta3 = new RetaGr( (int) getPonto2().getX(), (int) getPonto2().getY(),(int) getPonto4().getX(), (int) getPonto4().getY(),corAtual,nome,espessura);
        RetaGr reta4 = new RetaGr( (int) getPonto4().getX(), (int) getPonto4().getY(),(int) getPonto1().getX(), (int) getPonto1().getY(),corAtual,nome,espessura);
        reta1.desenharReta(g);
        reta2.desenharReta(g);
        reta3.desenharReta(g);
        reta4.desenharReta(g);
    }
}
