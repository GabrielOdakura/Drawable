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
 * @version 20231031
 */
public class SelecionarEscala {

    private PainelDesenho areaDesenho;
    private JFrame telaRotacionar = new JFrame("Escalonar Triangulo");
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

    public SelecionarEscala(PainelDesenho eme){
        this.areaDesenho = eme;
        construirTela3();
    }
    private void construirTela3(){

        Dimension dim = new Dimension(400,230);
        telaRotacionar.setMinimumSize(dim);
        telaRotacionar.setLocation((dim.width / 2) - (100 / 2), (dim.height / 2) + (500 / 2));
        telaRotacionar.setSize(dim);
        telaRotacionar.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if(pintarSaida) pintarPontosPadraoTri();
                super.windowClosing(e);
            }
        });

        telaRotacionar.setResizable(false);

        configurarElemento();

        String entradaUserX, entradaUserY;

        entradaUserX = JOptionPane.showInputDialog("Fator da Escala X: ");

        double i = Float.parseFloat(entradaUserX);

        entradaUserY = JOptionPane.showInputDialog("Fator da Escala Y: ");

        double l = Float.parseFloat(entradaUserY);



        //adicionar elementos no painel (caixa5)
        caixa5.add(nomeEscala, BorderLayout.WEST);
        caixa5.add(textoPonto, BorderLayout.CENTER);
        caixa5.add(jbEscalar, BorderLayout.EAST);

        //adicionar botoes ao painel 2 (caixa2)
        caixa6.add(jbVoltar, BorderLayout.WEST);
        caixa6.add(jbVai, BorderLayout.EAST);

        telaRotacionar.add(caixa5, BorderLayout.NORTH);
        telaRotacionar.add(caixa6, BorderLayout.SOUTH);

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
                Armazenador temp = areaDesenho.buscarED(indiceAtual);
                TransfTriangulo rotacionar = new TransfTriangulo(areaDesenho.getX1(), areaDesenho.getY1());
                int sX = Integer.parseInt(entradaUserX);
                int sY = Integer.parseInt(entradaUserY);
                Armazenador transformado = rotacionar.escalaTriangulo(temp, sX, sY);
                areaDesenho.deletarEspecifico(indiceAtual);
                areaDesenho.inserirED(transformado);
                areaDesenho.redesenharTrianguloTransf(transformado);
            }
        });

        pintarPontosTri();
        telaRotacionar.setVisible(true);
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
        }
    }

    public void toggleVisible3(){
        telaRotacionar.setVisible(false);
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

