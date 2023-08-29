package reta;
import java.awt.Color;
import java.awt.Graphics;

import ponto.PontoGr;

/**
 * Implementacao da classe reta grafica.
 *
 * @author Breno Rodrigues, Bruno Novo, Gabriel Odakura, Julio Arakaki
 * @version 230810
 */
public class RetaGr extends Reta{
    // Atributos da reta grafica
    Color corReta = Color.BLACK;   // cor da reta
    String nomeReta = ""; // nome da reta
    Color corNomeReta  = Color.BLACK;
    int espReta = 1; // espessura da reta

    // Construtores
    /**
     * RetaGr - Constroi uma reta grafica
     *
     * @param x1 int. Coordenada x1
     * @param y1 int. Coordenada y1
     * @param x2 int. Coordenada x2
     * @param y2 int. Coordenada y2
     * @param cor Color. Cor da reta
     * @param nome String. Nome da reta
     * @param esp int. Espessura da reta
     */
    public RetaGr(int x1, int y1, int x2, int y2, Color cor, String nome, int esp){
        super (x1, y1, x2, y2);
        setCorReta(cor);
        setNomeReta(nome);
        setEspReta(esp);
    }

    /**
     * RetaGr - Constroi uma reta grafica
     *
     * @param x1 double Coordenada x1
     * @param y1 double Coordenada y1
     * @param x2 double Coordenada x2
     * @param y2 double Coordenada y2
     * @param cor Color. Cor da reta
     * @param nome String. Nome da reta
     * @param esp int. Espessura da reta
     */
    public RetaGr(double x1, double y1, double x2, double y2, Color cor, String nome, int esp){
        super (x1, y1, x2, y2);
        setCorReta(cor);
        setNomeReta(nome);
        setEspReta(esp);
    }

    /**
     * RetaGr - Constroi uma reta grafica
     *
     * @param x1 int. Coordenada x1
     * @param y1 int. Coordenada y1
     * @param x2 int. Coordenada x2
     * @param y2 int. Coordenada y2
     * @param cor Color. Cor da reta
     */
    public RetaGr(int x1, int y1, int x2, int y2, Color cor){
        super (x1, y1, x2, y2);
        setCorReta(cor);
        setNomeReta("");
    }   

    /**
     * RetaGr - Constroi uma reta grafica
     *
     * @param x1 int. Coordenada x1
     * @param y1 int. Coordenada y1
     * @param x2 int. Coordenada x2
     * @param y2 int. Coordenada y2
     * @param cor Color. Cor da reta
     * @param esp int. Espessura da reta
     */
    public RetaGr(int x1, int y1, int x2, int y2, Color cor, int esp){
        super (x1, y1, x2, y2);
        setCorReta(cor);
        setNomeReta("");
        setEspReta(esp);
    }   

    /**
     * RetaGr - Constroi uma reta grafica
     *
     * @param x1 int. Coordenada x1
     * @param y1 int. Coordenada y1
     * @param x2 int. Coordenada x2
     * @param y2 int. Coordenada y2
     */
    public RetaGr(int x1, int y1, int x2, int y2){
        super (x1, y1, x2, y2);
        setCorReta(Color.black);
        setNomeReta("");
    }   

    /**
     * RetaGr - Constroi uma reta grafica
     *
     * @param p1 PontoGr. Ponto grafico p1 (x1, y1)
     * @param p2 PontoGr. Ponto grafico p2 (x2, y2)
     */
    public RetaGr(PontoGr p1, PontoGr p2){
        super(p1, p2);
        setCorReta(Color.black);
        setNomeReta("");
    }    

    /**
     * RetaGr - Constroi uma reta grafica
     *
     * @param p1 PontoGr. Ponto grafico p1 (x1, y1)
     * @param p2 PontoGr. Ponto grafico p2 (x2, y2)
     * @param cor Color. Cor da reta
     */
    public RetaGr(PontoGr p1, PontoGr p2, Color cor){
        super(p1, p2);
        setCorReta(cor);
        setNomeReta("");
    }    

    /**
     * RetaGr - Constroi uma reta grafica
     *
     * @param p1 PontoGr. Ponto grafico p1 (x1, y1)
     * @param p2 PontoGr. Ponto grafico p2 (x2, y2)
     * @param cor Color. Cor da reta
     */
    public RetaGr(PontoGr p1, PontoGr p2, Color cor, String str){
        super(p1, p2);
        setCorReta(cor);
        setNomeReta(str);
    }    

    /**
     * Altera a cor da reta.
     *
     * @param cor Color. Cor da reta.
     */
    public void setCorReta(Color cor) {
        this.corReta = cor;
    }

    /**
     * Altera o nome da reta.
     *
     * @param str String. Nome da reta.
     */
    public void setNomeReta(String str) {
        this.nomeReta = str;
    }

    /**
     * Altera a espessura da reta.
     *
     * @param esp int. Espessura da reta.
     */
    public void setEspReta(int esp) {
        this.espReta = esp;
    }

    /**
     * Retorna a espessura da reta.
     *
     * @return int. Espessura da reta.
     */
    public int getEspReta() {
        return(this.espReta);
    }

    /**
     * Retorna a cor da reta.
     *
     * @return Color. Cor da reta.
     */
    public Color getCorReta() {
        return corReta;
    }

    /**
     * Retorna o nome da reta.
     *
     * @return String. Nome da reta.
     */
    public String getNomeReta() {
        return nomeReta;
    }

    /**
     * @return the corNomeReta
     */
    public Color getCorNomeReta() {
        return corNomeReta;
    }

    /**
     * @param corNomeReta the corNomeReta to set
     */
    public void setCorNomeReta(Color corNomeReta) {
        this.corNomeReta = corNomeReta;
    }

    /**
     * Desenha reta grafica utilizando a equacao da reta: y = mx + b
     *
     * @param g Graphics. Classe com os metodos graficos do Java
     */
    public void desenharReta(Graphics g){

        // calcula m e b da equacao da reta y = mx + b
        double m = calcularM();
        double b = calcularB();
        int distanciaY = 40;// para caso o delta X for muito pequeno

        // Variaveis auxiliares 
        PontoGr ponto; 
        double x, y;
        
        int y1 = (int) getP1().getY();
        int y2 = (int) getP2().getY();

        double pIni;
        double pFim;

        // desenha nome do ponto
        g.setColor(getCorNomeReta());
        g.drawString(getNomeReta(), (int)getP1().getX() + getEspReta(), (int)getP1().getY());

        // percorre de x1 ate x2. 
        // y é calculado pela equacao: y = mx + b
        pIni = p1.getX();
        pFim = p2.getX();
        if(pIni == pFim) {
        	desenharRetaVertical(g);
        }else if(y1 == y2) {
        	desenharRetaHorizontal(g);
        }else if ((y1 - y2) < (pIni - pFim)) {
        	if(y1 > y2) {
            	for (y = y2; y <= y1; y++) {
                    // Calculo de x pela equacao da reta
                    x = (y - b) / m;

                    // Define ponto grafico
                    ponto = new PontoGr((int) x, (int) y, getCorReta(), getEspReta());

                    // Desenha ponto grafico
                    ponto.desenharPonto(g);
                }
            } else { 
                for (y = y1; y <= y2; y++) {
                    // Calculo de x pela equacao da reta
                    x = (y - b) / m;

                    // Define ponto grafico
                    ponto = new PontoGr((int) x, (int) y, getCorReta(), getEspReta());

                    // Desenha ponto grafico
                    ponto.desenharPonto(g);
                }
            }
        }else {
        	if(pIni < pFim) {
        		for (x = pIni; x <= pFim; x++) {
                    // Calculo de y pela equacao da reta
                    y = (m * x + b);

                    // Define ponto grafico
                    ponto = new PontoGr((int) x, (int) y, getCorReta(), getEspReta());

                    // Desenha ponto grafico
                    ponto.desenharPonto(g);
                }
        	}else {
        		for (x = pFim; x <= pIni; x++) {
                    // Calculo de y pela equacao da reta.
                    y = (m * x + b);

                    // Define ponto grafico
                    ponto = new PontoGr((int) x, (int) y, getCorReta(), getEspReta());

                    // Desenha ponto grafico
                    ponto.desenharPonto(g);
                }
        	}
        }
    }

    /**
     * Desenha a reta sem mudanca no valor de x, somente no de y
     *
     * @param g Graphics. Classe com os metodos graficos do Java
     */
    public void desenharRetaVertical(Graphics g){
        // Variaveis auxiliares
        PontoGr ponto;
        double y;

        double pIni;
        double pFim;

        // desenha nome do ponto
        g.setColor(getCorNomeReta());

        // percorre de x1 ate x2 verticalmente.
        pIni = p1.getY();
        pFim = p2.getY();
        if(pIni < pFim) {
            for (y = pIni; y <= pFim; y++) {
                // Calculo de y pela equacao da reta
                // Define ponto grafico
                ponto = new PontoGr((int) p1.getX(), (int) y, getCorReta(), getEspReta());

                // Desenha ponto grafico
                ponto.desenharPonto(g);
            }
        }else {
            for (y = pFim; y <= pIni; y++) {
                // Define ponto grafico
                ponto = new PontoGr((int) p1.getX(), (int) y, getCorReta(), getEspReta());

                // Desenha ponto grafico
                ponto.desenharPonto(g);
            }
        }
    }

    /**
     * Desenha a reta sem mudanca no valor de y, somente no de x
     *
     * @param g Graphics. Classe com os metodos graficos do Java
     */
    public void desenharRetaHorizontal(Graphics g){
        // Variaveis auxiliares
        PontoGr ponto;
        double x;

        double pIni;
        double pFim;

        // desenha nome do ponto
        g.setColor(getCorNomeReta());

        // percorre de x1 ate x2 verticalmente.
        pIni = p1.getX();
        pFim = p2.getX();
        if(pIni < pFim) {
            for (x = pIni; x <= pFim; x++) {
                // Calculo de x pela equacao da reta
                // Define ponto grafico
                ponto = new PontoGr((int) x, (int) p1.getY(), getCorReta(), getEspReta());

                // Desenha ponto grafico
                ponto.desenharPonto(g);
            }
        }else {
            for (x = pFim; x <= pIni; x++) {
                // Define ponto grafico
                ponto = new PontoGr((int) x, (int) p1.getY(), getCorReta(), getEspReta());

                // Desenha ponto grafico
                ponto.desenharPonto(g);
            }
        }
    }
}

