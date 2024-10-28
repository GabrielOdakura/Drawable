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
 * Cria a interface de rotação do Triangulo e rotaciona o Triangulo desejado pelo usuario.
 *
 * @author Breno Rodrigues, Bruno Novo, Gabriel Odakura, Julio Arakaki
 * @version 20231101
 */
public class SelecionarTrianguloRot {

   private PainelDesenho areaDesenho;
   private JFrame telaRotacionar = new JFrame("Rotacionar Triangulo");
   private JPanel caixa3 = new JPanel();
   private JPanel caixa4 = new JPanel();
   private JLabel nomeTriangulo = new JLabel();
   private JTextArea textoPonto = new JTextArea();
   private JButton jbVoltar = new JButton("◀");
   private JButton jbVai = new JButton("▶");
   private JButton jbRotacao = new JButton("Rotacionar o Triangulo");
   private static final Color corDeFundo = new Color(238,238,238);

    private Color corRoxo = new Color(174,55,255);
    private Armazenador atual;
    private boolean visible = false;
    private boolean pintarSaida = true;
    private int indiceAtual = 0;

    private double entradaAngulo = 0;

    //variavel para previnir multiplas abas sendo abertas pelo bug criado pela biblioteca AWT
    private static boolean flipflop = false;

   public SelecionarTrianguloRot(PainelDesenho me){
       this.areaDesenho = me;
       if(!flipflop) {
           flipflop = true;
           if(getAngulo()) {
               JOptionPane.showMessageDialog(null, "Clique em um ponto na tela e depois \nclique no" +
                       " botão de transformar triângulo");
               construirTela2();
           } else {
               pintarSaida = false;
               flipflop = false;
               this.telaRotacionar.dispatchEvent(new WindowEvent(telaRotacionar, WindowEvent.WINDOW_CLOSING));
           }
       }
   }

   private boolean getAngulo(){
       boolean sinal = false;
       do{
           String entradaUser;
           entradaUser = JOptionPane.showInputDialog("Angulo de Rotação: ");
           if(entradaUser == null) {
               sinal = false;
               JOptionPane.showMessageDialog(null, "Operação Cancelada!");
                break;
           }else{
               try{
                   entradaAngulo = Double.parseDouble(entradaUser);
                   sinal = true;
                   break;
               }catch (Exception e){
                   JOptionPane.showMessageDialog(null, "Valor Invalido tente novamente (apenas numeros)!");
                   System.out.println("Valor não double inserido!");
                   sinal = true;
               }
           }
       }while(sinal);
       return sinal;
   }

   private void construirTela2(){

       flipflop = true;

       //sets iniciais
       Dimension dim = new Dimension(400,230);
       telaRotacionar.setMinimumSize(dim);
       telaRotacionar.setLocation((dim.width / 2) - (100 / 2), (dim.height / 2) + (500 / 2));
       telaRotacionar.setSize(dim);
       telaRotacionar.addWindowListener(new WindowAdapter() {
           @Override
           public void windowClosing(WindowEvent e) {//evento para fechar a tela
               areaDesenho.setX(0);
               areaDesenho.setY(0);
               if(pintarSaida) pintarPontosPadraoTri();
               super.windowClosing(e);
               flipflop = false;
           }
       });

       telaRotacionar.setResizable(false);

       configurarElemento();
       pintarPontosTri();


       //adicionar elementos no painel (caixa3)
       caixa3.add(nomeTriangulo, BorderLayout.WEST);
       caixa3.add(textoPonto, BorderLayout.CENTER);
       caixa3.add(jbRotacao, BorderLayout.EAST);

       //adicionar botoes ao painel 2 (caixa2)
       caixa4.add(jbVoltar, BorderLayout.WEST);
       caixa4.add(jbVai, BorderLayout.EAST);

       telaRotacionar.add(caixa3, BorderLayout.NORTH);
       telaRotacionar.add(caixa4, BorderLayout.SOUTH);

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
           if(areaDesenho.buscarED(indiceAtual).getTipo() == TipoPrimitivo.TRIANGULO){
               jbRotacao.setEnabled(true);
           }else jbRotacao.setEnabled(false);
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
           if(areaDesenho.buscarED(indiceAtual).getTipo() == TipoPrimitivo.TRIANGULO){
               jbRotacao.setEnabled(true);
           }else jbRotacao.setEnabled(false);

       });

       jbRotacao.addActionListener(e ->{
           if(areaDesenho.retrocederVazia()){
               nomeTriangulo.setText("Sem Elementos Restantes");
               textoPonto.setVisible(false);
               pintarSaida = false;
               jbRotacao.setEnabled(false);
               jbRotacao.setVisible(false);
               jbVai.setEnabled(false);
               jbVoltar.setEnabled(false);
           }else {
               if(areaDesenho.getX() != 0 && areaDesenho.getY() != 0) {
                   Armazenador temp = areaDesenho.buscarED(indiceAtual);
                   TransfTriangulo rotacionar = new TransfTriangulo(areaDesenho.getX(), areaDesenho.getY());
                   Armazenador transformado = rotacionar.rotacionarTriangulo(entradaAngulo, temp);
                   areaDesenho.deletarEspecifico(indiceAtual);
                   areaDesenho.inserirED(transformado);
                   areaDesenho.redesenharTrianguloTransf();
                   pintarSaida = false;
                   areaDesenho.setTipo(TipoPrimitivo.ROTACAO);
                   this.telaRotacionar.dispatchEvent(new WindowEvent(telaRotacionar, WindowEvent.WINDOW_CLOSING));
               }else {
                   JOptionPane.showMessageDialog(null, "Selecione um ponto primeiro!");
               }
           }


       });
       if(areaDesenho.buscarED(indiceAtual).getTipo() == TipoPrimitivo.TRIANGULO){
           jbRotacao.setEnabled(true);
       }else jbRotacao.setEnabled(false);
       telaRotacionar.setVisible(true);
   }

    private void configurarElemento() {
        atual = areaDesenho.buscarED(indiceAtual);
        String caixaDeTexto;
        if(atual.getTipo() == TipoPrimitivo.TRIANGULO){
            nomeTriangulo.setText("Triangulo");
            caixaDeTexto = "Ponto 1 X: " + atual.getPonto1().getX() + "\n" +  "Ponto 1 Y: " + + atual.getPonto1().getY() + "\n"
                    + "Ponto 2 X: " + atual.getPonto2().getX() + "\n" +  "Ponto 2 Y: " + + atual.getPonto2().getY() + "\n"
                    + "Ponto 3 X: " + atual.getPonto3().getX() + "\n" +  "Ponto 3 Y: " + + atual.getPonto3().getY() + "\n";
            textoPonto.setText(caixaDeTexto);
        }else textoPonto.setText("Não é um triangulo");
    }

   public void toggleVisible(){
       telaRotacionar.setVisible(false);
   }

   public void fecharTela(){
       pintarSaida = false;
       this.telaRotacionar.dispatchEvent(new WindowEvent(telaRotacionar, WindowEvent.WINDOW_CLOSING));
   }

    public void pintarPontosTri(){
        Graphics g = areaDesenho.getGraphics();
        if (atual.getTipo() == TipoPrimitivo.TRIANGULO) {
            FiguraPontos.desenharPonto(g, (int) atual.getPonto1().getX(), (int) atual.getPonto1().getY(),
                    "", atual.getEspessura(), corRoxo);
            FiguraPontos.desenharPonto(g, (int) atual.getPonto2().getX(), (int) atual.getPonto2().getY(),
                    "", atual.getEspessura(), corRoxo);
            FiguraPontos.desenharPonto(g, (int) atual.getPonto3().getX(), (int) atual.getPonto3().getY(),
                    "", atual.getEspessura(), corRoxo);
        }
    }

    public void pintarPontosPadraoTri(){
        Graphics g = areaDesenho.getGraphics();
        if (atual.getTipo() == TipoPrimitivo.TRIANGULO) {
            FiguraPontos.desenharPonto(g, (int) atual.getPonto1().getX(), (int) atual.getPonto1().getY(),
                    "", atual.getEspessura(), atual.getCorFigura());
            FiguraPontos.desenharPonto(g, (int) atual.getPonto2().getX(), (int) atual.getPonto2().getY(),
                    "", atual.getEspessura(), atual.getCorFigura());
            FiguraPontos.desenharPonto(g, (int) atual.getPonto3().getX(), (int) atual.getPonto3().getY(),
                    "", atual.getEspessura(), atual.getCorFigura());
        }
    }
}
