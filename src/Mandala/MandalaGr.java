/**
 * implementacao da classe mandala grafico
 *
 * @author Breno Rodrigues, Bruno Novo, Gabriel Odakura
 * @version 20230821
 */
package Mandala;

import ponto.Circulo.CirculoGr;
import reta.RetaGr;
import reta.triangulo.TrianguloGr;

import java.awt.*;

public class MandalaGr extends Mandala{

    private String nome;
    private int espessura;
    private Color corAtual = Color.red;

    /**
     * MandalaGr - Constroi uma mandala grafica
     *
     * @param x1 int. Coordenada x1
     * @param y1 int. Coordenada y1
     * @param x2 int. Coordenada x2
     * @param y2 int. Coordenada y2
     * @param corAtual Color. Cor da reta
     * @param nome String. Nome da reta
     * @param espessura int. Espessura da reta
     */
    public MandalaGr(int x1, int y1, int x2, int y2, String nome, int espessura, Color corAtual){
        super(x1, y1, x2, y2);
        this.nome = nome;
        this.espessura = espessura;
//        this.corAtual = corAtual;
    }

    /** desenharMandala - Chama as outras funcoes que desenham a mandala
     *
     * @param g Graphics. Classe com os metodos graficos do Java
     */
    public void desenharMandala(Graphics g){
        desenharTriangulos(g);
        desenharRetas(g);
        desenharCirculos(g);
    }

    /** desenharTriangulos - Desenha todos os pontos compostos de triangulos
     *
     * @param g Graphics. Classe com os metodos graficos do Java
     */
    private void desenharTriangulos(Graphics g){
        TrianguloGr triangulo1 = new TrianguloGr(getPonto1().getX(), getPonto1().getY(),
                getPonto2().getX(), getPonto2().getY(),
                getPonto3().getX(), getPonto3().getY(),
                nome, espessura, corAtual);
        TrianguloGr triangulo2 = new TrianguloGr(getPonto1().getX(), getPonto1().getY(),
                getPonto3().getX(), getPonto3().getY(),
                getPonto5().getX(), getPonto5().getY(),
                nome, espessura, corAtual);
        TrianguloGr triangulo3 = new TrianguloGr(getPonto1().getX(), getPonto1().getY(),
                getPonto5().getX(), getPonto5().getY(),
                getPonto8().getX(), getPonto8().getY(),
                nome, espessura, corAtual);
        TrianguloGr triangulo4 = new TrianguloGr(getPonto1().getX(), getPonto1().getY(),
                getPonto8().getX(), getPonto8().getY(),
                getPonto10().getX(), getPonto10().getY(),
                nome, espessura, corAtual);
        TrianguloGr triangulo5 = new TrianguloGr(getPonto1().getX(), getPonto1().getY(),
                getPonto10().getX(), getPonto10().getY(),
                getPonto11().getX(), getPonto11().getY(),
                nome, espessura, corAtual);
        TrianguloGr triangulo6 = new TrianguloGr(getPonto1().getX(), getPonto1().getY(),
                getPonto2().getX(), getPonto2().getY(),
                getPonto11().getX(), getPonto11().getY(),
                nome, espessura, corAtual);
        TrianguloGr triangulo7 = new TrianguloGr(getPonto2().getX(), getPonto2().getY(),
                getPonto3().getX(), getPonto3().getY(),
                getPonto4().getX(), getPonto4().getY(),
                nome, espessura, corAtual);
        TrianguloGr triangulo8 = new TrianguloGr(getPonto2().getX(), getPonto2().getY(),
                getPonto4().getX(), getPonto4().getY(),
                getPonto12().getX(), getPonto12().getY(),
                nome, espessura, corAtual);
        TrianguloGr triangulo9 = new TrianguloGr(getPonto2().getX(), getPonto2().getY(),
                getPonto11().getX(), getPonto11().getY(),
                getPonto12().getX(), getPonto12().getY(),
                nome, espessura, corAtual);
        TrianguloGr triangulo10 = new TrianguloGr(getPonto4().getX(), getPonto4().getY(),
                getPonto6().getX(), getPonto6().getY(),
                getPonto7().getX(), getPonto7().getY(),
                nome, espessura, corAtual);
        TrianguloGr triangulo11 = new TrianguloGr(getPonto5().getX(), getPonto5().getY(),
                getPonto6().getX(), getPonto6().getY(),
                getPonto8().getX(), getPonto8().getY(),
                nome, espessura, corAtual);
        TrianguloGr triangulo12 = new TrianguloGr(getPonto6().getX(), getPonto6().getY(),
                getPonto8().getX(), getPonto8().getY(),
                getPonto9().getX(), getPonto9().getY(),
                nome, espessura, corAtual);
        TrianguloGr triangulo13 = new TrianguloGr(getPonto8().getX(), getPonto8().getY(),
                getPonto9().getX(), getPonto9().getY(),
                getPonto10().getX(), getPonto10().getY(),
                nome, espessura, corAtual);
        TrianguloGr triangulo14 = new TrianguloGr(getPonto9().getX(), getPonto9().getY(),
                getPonto12().getX(), getPonto12().getY(),
                getPonto13().getX(), getPonto13().getY(),
                nome, espessura, corAtual);
        triangulo1.desenharTriangulo(g);
        triangulo2.desenharTriangulo(g);
        triangulo3.desenharTriangulo(g);
        triangulo4.desenharTriangulo(g);
        triangulo5.desenharTriangulo(g);
        triangulo6.desenharTriangulo(g);
        triangulo7.desenharTriangulo(g);
        triangulo8.desenharTriangulo(g);
        triangulo9.desenharTriangulo(g);
        triangulo10.desenharTriangulo(g);
        triangulo11.desenharTriangulo(g);
        triangulo12.desenharTriangulo(g);
        triangulo13.desenharTriangulo(g);
        triangulo14.desenharTriangulo(g);
    }

    /** desenharRetas - Desenha todos os pontos compostos de retas
     *
     * @param g Graphics. Classe com os metodos graficos do Java
     */
    private void desenharRetas(Graphics g){
        RetaGr reta1 = new RetaGr(getPonto1().getX(), getPonto1().getY(),
                getPonto4().getX(), getPonto4().getY(),corAtual, nome, espessura);
        RetaGr reta2 = new RetaGr(getPonto1().getX(), getPonto1().getY(),
                getPonto6().getX(), getPonto6().getY(),corAtual, nome, espessura);
        RetaGr reta3 = new RetaGr(getPonto1().getX(), getPonto1().getY(),
                getPonto7().getX(), getPonto7().getY(),corAtual, nome, espessura);
        RetaGr reta4 = new RetaGr(getPonto1().getX(), getPonto1().getY(),
                getPonto9().getX(), getPonto9().getY(),corAtual, nome, espessura);
        RetaGr reta5 = new RetaGr(getPonto1().getX(), getPonto1().getY(),
                getPonto12().getX(), getPonto12().getY(),corAtual, nome, espessura);
        RetaGr reta6 = new RetaGr(getPonto1().getX(), getPonto1().getY(),
                getPonto13().getX(), getPonto13().getY(),corAtual, nome, espessura);
        RetaGr reta7 = new RetaGr(getPonto10().getX(), getPonto10().getY(),
                getPonto13().getX(), getPonto13().getY(),corAtual, nome, espessura);
        RetaGr reta8 = new RetaGr(getPonto11().getX(), getPonto11().getY(),
                getPonto13().getX(), getPonto13().getY(),corAtual, nome, espessura);
        RetaGr reta9 = new RetaGr(getPonto5().getX(), getPonto5().getY(),
                getPonto7().getX(), getPonto7().getY(),corAtual, nome, espessura);
        RetaGr reta10 = new RetaGr(getPonto3().getX(), getPonto3().getY(),
                getPonto7().getX(), getPonto7().getY(),corAtual, nome, espessura);
        reta1.desenharReta(g);
        reta2.desenharReta(g);
        reta3.desenharReta(g);
        reta4.desenharReta(g);
        reta5.desenharReta(g);
        reta6.desenharReta(g);
        reta7.desenharReta(g);
        reta8.desenharReta(g);
        reta9.desenharReta(g);
        reta10.desenharReta(g);
    }
    /** desenharCirculos - Desenha todos os circulos
     *
     * @param g Graphics. Classe com os metodos graficos do Java
     */
    private void desenharCirculos(Graphics g){
        CirculoGr circulo1 = new CirculoGr(getPonto1().getX(), getPonto1().getY(),
                getPonto2().getX(), getPonto2().getY(),nome, espessura, corAtual);
        CirculoGr circulo2 = new CirculoGr(getPonto3().getX(), getPonto3().getY(),
                getPonto1().getX(), getPonto1().getY(),nome, espessura, corAtual);
        CirculoGr circulo3 = new CirculoGr(getPonto5().getX(), getPonto5().getY(),
                getPonto1().getX(), getPonto1().getY(),nome, espessura, corAtual);
        CirculoGr circulo4 = new CirculoGr(getPonto10().getX(), getPonto10().getY(),
                getPonto1().getX(), getPonto1().getY(),nome, espessura, corAtual);
        CirculoGr circulo5 = new CirculoGr(getPonto11().getX(), getPonto11().getY(),
                getPonto1().getX(), getPonto1().getY(),nome, espessura, corAtual);
        CirculoGr circulo6 = new CirculoGr(getPonto2().getX(), getPonto2().getY(),
                getPonto1().getX(), getPonto1().getY(),nome, espessura, corAtual);
        CirculoGr circulo7 = new CirculoGr(getPonto8().getX(), getPonto8().getY(),
                getPonto1().getX(), getPonto1().getY(),nome, espessura, corAtual);
        circulo1.desenharCirculo(g);
        circulo2.desenharCirculo(g);
        circulo3.desenharCirculo(g);
        circulo4.desenharCirculo(g);
        circulo5.desenharCirculo(g);
        circulo6.desenharCirculo(g);
        circulo7.desenharCirculo(g);
    }

}
