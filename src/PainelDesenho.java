import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import Mandala.FiguraMandalas;
import armazenador.Armazenador;
import ponto.Circulo.FiguraCirculos;
import ponto.FiguraPontos;
import reta.FiguraRetas;
import reta.retangulo.FiguraRetangulos;
import reta.triangulo.FiguraTriangulos;
import tipoPrimitivo.TipoPrimitivo;

/**
 * Cria desenhos de acordo com o tipo e eventos do mouse
 * 
 * @author Breno Rodrigues, Bruno Novo, Gabriel Odakura, Julio Arakaki 
 * @version 20230905
 */
public class PainelDesenho extends JPanel implements MouseListener, MouseMotionListener {

    private JLabel msg;           // Label para mensagens
    private TipoPrimitivo tipo; // Tipo do primitivo
    private Graphics gAux = getGraphics();
    private Color corAtual;       // Cor atual do primitivo
    private Color primeiraCorMandala;// Cor das retas da Mandala
    private Color segundaCorMandala; // Cor Circulo Mandala
    private Color corDeFundo = new Color(238,238,238);
    private int esp;              // Diametro do ponto

    // Para ponto
    private int x, y;

    // Para reta, retangulo e triangulo
    private int x1, y1, x2, y2, x3, y3;

    // selecionar primeiro click do mouse
    private boolean primeiraVez = true;
    private boolean segundaVez = false;

    // Estrutura de dados para aramzenar os pontos
    private ArrayList<Object> estruturaDados = new ArrayList<>();
    private Armazenador auxiliar;
    private Stack<Object> retrocederStack = new Stack<>();
    
    /**
     * Constroi o painel de desenho
     *
     * @param msg mensagem a ser escrita no rodape do painel
     * @param tipo tipo atual do primitivo
     * @param corAtual cor atual do primitivo
     * @param esp espessura atual do primitivo
     */
    public PainelDesenho(JLabel msg, TipoPrimitivo tipo, Color corAtual, int esp){
        setTipo(tipo);
        setMsg(msg);
        setCorAtual(corAtual);
        setEsp(esp);

        // Adiciona "ouvidor" de eventos de mouse
        this.addMouseListener(this); 
        this.addMouseMotionListener(this);

    }

    /**
     * Altera o tipo atual do primitivo
     *
     * @param tipo tipo do primitivo
     */
    public void setTipo(TipoPrimitivo tipo){
        this.tipo = tipo;
        primeiraVez = true;
        segundaVez = false;
    }

    /**
     * Retorna o tipo do primitivo
     *
     * @return tipo do primitivo
     */
    public TipoPrimitivo getTipo(){
        return this.tipo;
    }

    /**
     * Altera a espessura do primitivo
     *
     * @param esp espessura do primitivo
     */
    public void setEsp(int esp){
        this.esp = esp;
    }

    /**
     * Retorna a espessura do primitivo
     *
     * @return espessura do primitivo
     */
    public int getEsp(){
        return this.esp;
    }

    /**
     * Altera a cor atual do primitivo
     *
     * @param corAtual cor atual do primitivo
     */
    public void setCorAtual(Color corAtual){
        this.corAtual = corAtual;
    }

    /**
     * retorna a cor atual do primitivo
     *
     * @return cor atual do primitivo
     */
    public Color getCorAtual(){
        return this.corAtual;
    }

    /**
     * Altera a msg a ser apresentada no rodape
     *
     * @param msg mensagem a ser apresentada
     */
    public void setMsg(JLabel msg){
        this.msg = msg;
    }

    public Graphics pegarGraphics(){
        return this.gAux;
    }

    /**
     * Retorna a mensagem
     *
     * @return mensagem as ser apresentada no rodape
     */
    public JLabel getMsg(){
        return this.msg;
    }

    public Color getSegundaCorMandala() {
        return segundaCorMandala;
    }

    public void setSegundaCorMandala(Color segundaCorMandala) {
        this.segundaCorMandala = segundaCorMandala;
    }
    
    public Color getPrimeiraCorMandala() {
		return primeiraCorMandala;
	}

	public void setPrimeiraCorMandala(Color primeiraCorMandala) {
		this.primeiraCorMandala = primeiraCorMandala;
	}

	/**
     * Metodo chamado quando o paint eh acionado
     *
     * @param g biblioteca para desenhar em modo grafico
     */
    public void paintComponent(Graphics g) {   
        desenharPrimitivos(g);
    }

    
    /**
     * Evento: pressionar do mouse
     *
     * @param e dados do evento
     */
    public void mousePressed(MouseEvent e) {
        Graphics g = getGraphics();  
        if (tipo == TipoPrimitivo.PONTO){
            x1 = e.getX();
            y1 = e.getY();
            auxiliar = new Armazenador(x1, y1, tipo, esp, corAtual);
            estruturaDados.add(auxiliar);
            retrocederStack.clear();
            paint(g);
        } else if (tipo == TipoPrimitivo.RETA){

            if (primeiraVez == true) {
                x1 = (int)e.getX();
                y1 = (int)e.getY();
                primeiraVez = false;
            } else {
                x2 = (int)e.getX();
                y2 = (int)e.getY();
                primeiraVez = true;
                auxiliar = new Armazenador(x1, y1, x2, y2, tipo, esp, corAtual, null);
                estruturaDados.add(auxiliar);
                retrocederStack.clear();
                paint(g);
            }
        }else if(tipo == TipoPrimitivo.RETANGULO){
            if (primeiraVez == true) {
                x1 = (int)e.getX();
                y1 = (int)e.getY();
                primeiraVez = false;
//                System.out.println("valor primeira vez: " + primeiraVez);
//                System.out.println("Valor de X1: " + x1 + " Valor de Y1: " + y1);
            } else {
                x2 = (int)e.getX();
                y2 = (int)e.getY();
                primeiraVez = true;
//                System.out.println("valor primeira vez: " + primeiraVez);
//                System.out.println("Valor de X2: " + x2 + " Valor de Y2: " + y2);
                auxiliar = new Armazenador(x1, y1, x2, y2, tipo, esp, corAtual, null);
                estruturaDados.add(auxiliar);
                retrocederStack.clear();
                paint(g);
            }
        } else if (tipo == TipoPrimitivo.TRIANGULO) {
            if (primeiraVez == true) {
                x1 = (int)e.getX();
                y1 = (int)e.getY();
                primeiraVez = false;
            } else if(primeiraVez == false && segundaVez == false){
                x2 = (int)e.getX();
                y2 = (int)e.getY();
                segundaVez = true;
            }else if(segundaVez == true){
                x3 = (int)e.getX();
                y3 = (int)e.getY();
                primeiraVez = true;
                segundaVez = false;
                auxiliar = new Armazenador(x1, y1, x2, y2, x3, y3, tipo, esp, corAtual);
                estruturaDados.add(auxiliar);
                retrocederStack.clear();
                paint(g);
            }
        }
        else if(tipo == TipoPrimitivo.CIRCULO){
            if(primeiraVez == true) {
                x1 = (int) e.getX();
                y1 = (int) e.getY();
                primeiraVez = false;
            }else if(primeiraVez == false) {
                x2 = (int) e.getX();
                y2 = (int) e.getY();
                primeiraVez = true;
                auxiliar = new Armazenador(x1, y1, x2, y2, tipo, esp, corAtual, null);
                estruturaDados.add(auxiliar);
                retrocederStack.clear();
                paint(g);
            }
        }else if(tipo == TipoPrimitivo.MANDALA){
            if(primeiraVez == true) {
                x1 = (int) e.getX();
                y1 = (int) e.getY();
                primeiraVez = false;
            }else if(primeiraVez == false){
                x2 = (int) e.getX();
                y2 = (int) e.getY();
                primeiraVez = true;
                auxiliar = new Armazenador(x1, y1, x2, y2, tipo, esp, primeiraCorMandala, segundaCorMandala);
                estruturaDados.add(auxiliar);
                retrocederStack.clear();
                paint(g);
            }
        }
    }     

    public void mouseReleased(MouseEvent e) { 
    }           

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
    }

    /**
     * Evento mouseMoved: escreve mensagem no rodape (x, y) do mouse
     *
     * @param e dados do evento do mouse
     */
    public void mouseMoved(MouseEvent e) {
        this.msg.setText("("+e.getX() + ", " + e.getY() + ") - " + getTipo());
    }

    public void printArmazenador(){
        Graphics g = getGraphics();
        int i = 0;
        Armazenador temporario;
        if(estruturaDados.isEmpty()){
            System.out.println("Nao existem registros para carregar");
        }else {
            while (estruturaDados.size() != i) {
                System.out.println(estruturaDados.get(i));
                i++;
            }
        }
    }

    public void limparED(){
        estruturaDados.clear();
    }
    
    public void limparStack() {
    	retrocederStack.clear();
    }

    /** getTamanhoED - pega o numero de elementos existentes na ArrayList
     *
     * @return int - numero de elementos na ArrayList
     */
    public int getTamanhoED(){
        return estruturaDados.size();
    }


    public Armazenador buscarED(int indice){
        return (Armazenador) estruturaDados.get(indice);// pega o indice da busca e procura na ArrayList
    }

    /** deletarEspecifico - deleta o elemento especifico da ED e coloca na Stack para voltar
     *                      caso o usuário desejar
     *
     */
    public void deletarEspecifico(int indice){
        Armazenador temp = (Armazenador) estruturaDados.get(indice);
        estruturaDados.remove(indice);
        retrocederStack.add(temp);
        limparTela();
        redesenharED();
    }

    /**retroceder - Função de Control + Z
     * 
     */
    public void retroceder(){ 
        	primeiraVez = true;
            segundaVez = false;
            retrocederStack.add(estruturaDados.get(estruturaDados.size()));//pega o ultimo elemento da estrutura de dados
            estruturaDados.remove(estruturaDados.size());
            redesenharED();
    }
   
    /**retrocederVazia - checa se já existe algum elemento na ED
     * 
     * @return Boolean -  true: lista vazia 
     * 					 false: lista contem elementos
     */
    public boolean retrocederVazia() {
    	return estruturaDados.isEmpty();
    }
    
    /** recuperar - Função que restaura um elementro do Control + Z
     * 
     * 
     */
    public void recuperar() {
    	if(!retrocederStack.empty()) {
    		estruturaDados.add(retrocederStack.peek());
    		redesenharElemento();
    		retrocederStack.pop();
    	}else {
    		System.out.println("Nao existem elementos para recuperar");
    	}
    }
    
    /** redesenharElemento - redesenha um elemento armazenado na stack
     * 
     */
    public void redesenharElemento(){
    	Armazenador temporario;
    	Graphics g = getGraphics();
    		temporario = (Armazenador) retrocederStack.peek();
    			x1 = (int) temporario.getPonto1().getX();
    			y1 = (int) temporario.getPonto1().getY();
    		if(temporario.getPonto2() != null){
    			x2 = (int) temporario.getPonto2().getX();
            	y2 = (int) temporario.getPonto2().getY();
    		}
    		if(temporario.getPonto3() != null) {
    			x3 = (int) temporario.getPonto3().getX();
            	y3 = (int) temporario.getPonto3().getY();
    		}
    		esp = temporario.getEspessura();
    		tipo = temporario.getTipo();
    		corAtual = temporario.getCorFigura();
    		if (temporario.getTipo() == TipoPrimitivo.MANDALA){
    			segundaCorMandala = temporario.getSegundaCorMandala();
    		}
        desenharPrimitivos(g);
    }
    
    public void redesenharED(){
        Graphics g = getGraphics();
        int i = 0;
        Armazenador temporario;
        if(estruturaDados.isEmpty()){
            System.out.println("Nao existem registros para carregar");
        }else {
            while (estruturaDados.size() != i) {
                temporario = (Armazenador) estruturaDados.get(i);
                x1 = (int) temporario.getPonto1().getX();
                y1 = (int) temporario.getPonto1().getY();
                if(temporario.getPonto2() != null){
                    x2 = (int) temporario.getPonto2().getX();
                    y2 = (int) temporario.getPonto2().getY();
                }
                if(temporario.getPonto3() != null) {
                    x3 = (int) temporario.getPonto3().getX();
                    y3 = (int) temporario.getPonto3().getY();
                }
                esp = temporario.getEspessura();
                tipo = temporario.getTipo();
                corAtual = temporario.getCorFigura();
                if (temporario.getTipo() == TipoPrimitivo.MANDALA){
                    segundaCorMandala = temporario.getSegundaCorMandala();
                }
                desenharPrimitivos(g);
                i++;
            }
        }
    }

    /**
     * Desenha os primitivos
     *
     * @param g biblioteca para desenhar em modo grafico
     */
    public void desenharPrimitivos(Graphics g){
        if (tipo == TipoPrimitivo.PONTO){
            FiguraPontos.desenharPonto(g, x1, y1, "", getEsp(), getCorAtual());
            //FiguraPontos.desenharPontos(g, 50, 20);
        }else if (tipo == TipoPrimitivo.RETA){
            FiguraRetas.desenharReta(g, x1, y1, x2, y2, "", getEsp(), getCorAtual());
            //FiguraRetas.desenharRetas(g, 10, 3);
        }else if (tipo == TipoPrimitivo.CIRCULO){
            FiguraCirculos.desenharCirculo(g, x1, y1, x2, y2, "", getEsp(), getCorAtual());
        }else if(tipo == TipoPrimitivo.RETANGULO){
            FiguraRetangulos.desenharRetangulo(g, x1, y1, x2, y2,  "", getEsp(), getCorAtual());
        }else if(tipo == TipoPrimitivo.TRIANGULO){
            FiguraTriangulos.desenharTriangulo(g, x1, y1, x2, y2, x3, y3,  "", getEsp(), getCorAtual());
        }else if(tipo == TipoPrimitivo.MANDALA){
            FiguraMandalas.desenharMandala(g, x1,y1,x2,y1,"", getEsp(),primeiraCorMandala, segundaCorMandala);
        }
    }
    
    public void limparTela() {
    	Graphics g = getGraphics();
    	FiguraPontos.desenharPonto(g, 350, 350,"",1000,corDeFundo);
    }
}
