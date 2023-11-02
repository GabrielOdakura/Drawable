package userInterface;
import armazenador.Armazenador;
import ponto.FiguraPontos;
import reta.triangulo.TransfTriangulo;
import tipoPrimitivo.TipoPrimitivo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Cria a interface de mudança da escala do Triangulo e Escalona o Triangulo desejado pelo usuario.
 *
 * @author Breno Rodrigues, Bruno Novo, Gabriel Odakura, Julio Arakaki
 * @version 20231101
 */
public class SelecionarEscala {

    private PainelDesenho areaDesenho;
    private JFrame telaEscala = new JFrame("Escalonar Triangulo");
    private JPanel caixa5 = new JPanel();
    private JPanel caixa6 = new JPanel();
    private JLabel nomeEscala = new JLabel();
    private JTextArea textoPonto = new JTextArea();
    private JButton jbVoltar = new JButton("◀");
    private JButton jbVai = new JButton("▶");
    private JButton jbEscalar = new JButton("Escalonação do Triangulo");
    private static final Color corDeFundo = new Color(238,238,238);

    private Color corRoxo = new Color(174,55,255);
    private Armazenador atual;
    private boolean visible = false;
    private boolean pintarSaida = true;
    private int indiceAtual = 0;
    private double entradaUserX, entradaUserY;

    private static boolean flipflop = false;

    public SelecionarEscala(PainelDesenho eme){
        this.areaDesenho = eme;
        if(!flipflop) {
            if(pegarEscalas()) {
                JOptionPane.showMessageDialog(null, "Clique em um ponto na tela e depois \nclique no" +
                        " botão de transformar triângulo");
                construirTela3();
            }
        }
    }

    private boolean pegarEscalas(){
        boolean sinal = false;
        String entradaX, entradaY;
        do {
            entradaX = JOptionPane.showInputDialog("Fator da Escala X: ");
            if(entradaX == null){
                sinal = false;
                JOptionPane.showMessageDialog(null, "Operação Cancelada!");
            }else{
                try{
                    entradaUserX = Double.parseDouble(entradaX);
                    sinal = true;
                    break;
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null, "Valor Invalido tente novamente (apenas numeros)!");
                    System.out.println("Valor não double inserido!");
                }
            }
        }while (true);
        if(sinal){
            do {
                entradaY = JOptionPane.showInputDialog("Fator da Escala Y: ");
                if(entradaY == null){
                    sinal = false;
                    JOptionPane.showMessageDialog(null, "Operação Cancelada!");
                }else{
                    try{
                        entradaUserY = Double.parseDouble(entradaY);
                        sinal = true;
                        break;
                    }catch (Exception e){
                        JOptionPane.showMessageDialog(null, "Valor Invalido tente novamente (apenas numeros)!");
                        System.out.println("Valor não double inserido!");
                    }
                }
            }while(sinal);
        }else sinal = false;
        return sinal;
    }
    private void construirTela3(){

        flipflop = true;

        //sets iniciais
        Dimension dim = new Dimension(400,230);
        telaEscala.setMinimumSize(dim);
        telaEscala.setLocation((dim.width / 2) - (100 / 2), (dim.height / 2) + (500 / 2));
        telaEscala.setSize(dim);
        telaEscala.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                areaDesenho.setX(0);
                areaDesenho.setY(0);
                if(pintarSaida) pintarPontosPadraoTri();
                super.windowClosing(e);
                flipflop = false;
            }
        });

        telaEscala.setResizable(false);

        configurarElemento();
        pintarPontosTri();

        //adicionar elementos no painel (caixa5)
        caixa5.add(nomeEscala, BorderLayout.WEST);
        caixa5.add(textoPonto, BorderLayout.CENTER);
        caixa5.add(jbEscalar, BorderLayout.EAST);

        //adicionar botoes ao painel 2 (caixa2)
        caixa6.add(jbVoltar, BorderLayout.WEST);
        caixa6.add(jbVai, BorderLayout.EAST);

        telaEscala.add(caixa5, BorderLayout.NORTH);
        telaEscala.add(caixa6, BorderLayout.SOUTH);

        //config Area de Texto
        textoPonto.setBackground(corDeFundo);
        textoPonto.setLineWrap(true);
        textoPonto.setEditable(false);

        jbVoltar.setEnabled(false);
        if (areaDesenho.getTamanhoED()<=1) jbVai.setEnabled(false);
        else  jbVai.setEnabled(true);

        jbVai.addActionListener(e ->{
            if(!(areaDesenho.getTamanhoED() == indiceAtual)){
                pintarPontosPadraoTri();
                indiceAtual++;
                configurarElemento();
                pintarPontosTri();
                jbVoltar.setEnabled(true);
            }
            if(areaDesenho.getTamanhoED() - 1 == indiceAtual){
                jbVai.setEnabled(false);
            }
        });

        jbVoltar.addActionListener(e ->{
            pintarPontosPadraoTri();
            indiceAtual--;
            configurarElemento();
            pintarPontosTri();
            jbVai.setEnabled(true);
            if (indiceAtual == 0){
                jbVoltar.setEnabled(false);
            }
        });

        jbEscalar.addActionListener(e ->{
            if(areaDesenho.retrocederVazia()){
                nomeEscala.setText("Sem Elementos Restantes");
                textoPonto.setVisible(false);
                pintarSaida = false;
                jbEscalar.setEnabled(false);
                jbEscalar.setVisible(false);
                jbVai.setEnabled(false);
                jbVoltar.setEnabled(false);
            }else {
                if (indiceAtual != 0) {
                    indiceAtual--;
                    if(indiceAtual == 0) {
                        jbVoltar.setEnabled(false);
                        jbVai.setEnabled(false);
                        if(areaDesenho.getTamanhoED() > 1) {
                            jbVai.setEnabled(true);
                        }
                    }
                }
                configurarElemento();
                pintarPontosTri();
                if(areaDesenho.getX() != 0 && areaDesenho.getY() != 0) {
                    Armazenador temp = areaDesenho.buscarED(indiceAtual);
                    TransfTriangulo rotacionar = new TransfTriangulo(areaDesenho.getX(), areaDesenho.getY());
                    int sX = (int) entradaUserX;
                    int sY = (int) entradaUserY;
                    Armazenador transformado = rotacionar.escalaTriangulo(temp, sX, sY);
                    areaDesenho.deletarEspecifico(indiceAtual);
                    areaDesenho.inserirED(transformado);
                    areaDesenho.redesenharTrianguloTransf();
                    areaDesenho.setTipo(TipoPrimitivo.ESCALA);
                    pintarSaida = false;
                    this.telaEscala.dispatchEvent(new WindowEvent(telaEscala, WindowEvent.WINDOW_CLOSING));
                }else {
                JOptionPane.showMessageDialog(null, "Selecione um ponto primeiro!");
                }
            }
        });

        telaEscala.setVisible(true);
    }

    private void configurarElemento() {
        atual = areaDesenho.buscarED(indiceAtual);
        String caixaDeTexto;
        if(atual.getTipo() == TipoPrimitivo.TRIANGULO){
            nomeEscala.setText("Triangulo");
            caixaDeTexto = "Ponto 1 X: " + atual.getPonto1().getX() + "\n" +  "Ponto 1 Y: " + + atual.getPonto1().getY() + "\n"
                    + "Ponto 2 X: " + atual.getPonto2().getX() + "\n" +  "Ponto 2 Y: " + + atual.getPonto2().getY() + "\n"
                    + "Ponto 3 X: " + atual.getPonto3().getX() + "\n" +  "Ponto 3 Y: " + + atual.getPonto3().getY() + "\n";
            textoPonto.setText(caixaDeTexto);
        }else textoPonto.setText("Não é um triangulo");
    }

    public void toggleVisible(){
        telaEscala.setVisible(false);
    }

    public void fecharTela(){
        pintarSaida = false;
        this.telaEscala.dispatchEvent(new WindowEvent(telaEscala, WindowEvent.WINDOW_CLOSING));
    }

    public void pintarPontosTri(){
        Graphics g = areaDesenho.getGraphics();
        if(atual.getTipo() == TipoPrimitivo.TRIANGULO){
            FiguraPontos.desenharPonto(g,(int) atual.getPonto1().getX(),(int) atual.getPonto1().getY(),
                    "", atual.getEspessura(), corRoxo);
            FiguraPontos.desenharPonto(g,(int) atual.getPonto2().getX(),(int) atual.getPonto2().getY(),
                    "", atual.getEspessura(), corRoxo);
            FiguraPontos.desenharPonto(g,(int) atual.getPonto3().getX(),(int) atual.getPonto3().getY(),
                    "", atual.getEspessura(), corRoxo);
        }
    }

    public void pintarPontosPadraoTri(){
        Graphics g = areaDesenho.getGraphics();
        if(atual.getTipo() == TipoPrimitivo.TRIANGULO){
            FiguraPontos.desenharPonto(g,(int) atual.getPonto1().getX(),(int) atual.getPonto1().getY(),
                    "", atual.getEspessura(), atual.getCorFigura());
            FiguraPontos.desenharPonto(g,(int) atual.getPonto2().getX(),(int) atual.getPonto2().getY(),
                    "", atual.getEspessura(), atual.getCorFigura());
            FiguraPontos.desenharPonto(g,(int) atual.getPonto3().getX(),(int) atual.getPonto3().getY(),
                    "", atual.getEspessura(), atual.getCorFigura());
        }
    }
}

