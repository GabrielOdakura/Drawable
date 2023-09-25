import ponto.FiguraPontos;
import tipoPrimitivo.TipoPrimitivo;

import java.awt.*;


import javax.swing.*;
//import javax.swing.JPopupMenu;

@SuppressWarnings("serial")
/**
 * Cria a interface com o usuario (GUI)
 *
 * @author Breno Rodrigues, Bruno Novo, Gabriel Odakura, Julio Arakaki
 * @version 20230905
 */
class Gui extends JFrame {
    // Tipo Atual de primitivo
    private TipoPrimitivo tipoAtual = TipoPrimitivo.PONTO;

    // Cor atual
    private Color corAtual = Color.BLACK;

    // Espessura atual do primitivo
    private int espAtual = 3;

    // Componentes de GUI
    // barra de menu (inserir componente)
    private JToolBar barraComandos = new JToolBar();

    // Mensagens
    private JLabel msg = new JLabel("Msg: ");

    // Painel de desenho
    private PainelDesenho areaDesenho = new PainelDesenho(msg, tipoAtual, corAtual, 10);

    // Botoes
    private JButton jbPonto = new JButton("°");
    private JButton jbReta = new JButton("——");
    private JButton jbRetangulo = new JButton("□");
    private JButton jbTriangulo = new JButton("△");
    private JButton jbCirculo = new JButton("◯");
    private JButton jbMandala = new JButton("Mandala");
    private JButton jbRedesenhar = new JButton("Redesenhar");
    private JButton jbLimpar = new JButton("Limpar");
    private JButton jbCor = new JButton("Cor");
    private JButton jbSair = new JButton("Sair");

    // Entrada (slider) para definir espessura dos primitivos
    private JLabel jlEsp = new JLabel("   Espessura: " + String.format("%-5s", 3));
    private JSlider jsEsp = new JSlider(3, 50, 3);
    
    // Itens relacionados ao menuPopup
    private JMenuItem limpezaTotal = new JMenuItem("Limpar Tudo");
    private JMenuItem confirmar = new JMenuItem("Limpar Tela");
    private JMenuItem limparED = new JMenuItem("Limpar Estrutura de Dados");
    private JMenuItem recusar = new JMenuItem("Cancelar");
    private JPopupMenu popupMenu = new JPopupMenu();

    /**
     * Constroi a GUI
     *
     * @param larg largura da janela
     * @param alt altura da janela
     */
    public Gui(int larg, int alt) {
        /**
         * Definicoes de janela
         */
        super("Testa Primitivos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(larg, alt);
        setVisible(true);
        setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((dim.width / 2) - (larg / 2), (dim.height / 2) - (alt / 2));
        
        
        // PopUp de Confirmação
        popupMenu.setVisible(false);
        popupMenu.setEnabled(false);
        popupMenu.setLocation((dim.width / 2) - (100 / 2), (dim.height / 2) - (50 / 2));
        popupMenu.setBorder(BorderFactory.createLineBorder(Color.black));


        // Adicionando os componentes
        barraComandos.add(jbPonto);
        barraComandos.add(jbReta);
        barraComandos.add(jbRetangulo);
        barraComandos.add(jbTriangulo);
        barraComandos.add(jbCirculo);
        barraComandos.add(jbMandala);
        barraComandos.add(jbRedesenhar);
        barraComandos.add(jbLimpar); // Botao de Limpar
        barraComandos.add(jbCor); // Botao de Cores

        barraComandos.add(jlEsp); // Label para espessura
        barraComandos.add(jsEsp);    // Slider para espacamento
        areaDesenho.setEsp(espAtual); // define a espessura inicial
        barraComandos.add(jbSair); // Botao de Cores

        barraComandos.setFloatable(false);//faz a barra nao poder ser mais arrastada

        // Área do PopUp
        popupMenu.add(limpezaTotal);
        popupMenu.add(confirmar);
        popupMenu.add(limparED);
        popupMenu.add(recusar);

        this.add(popupMenu);

        // adiciona os componentes com os respectivos layouts
        add(barraComandos, BorderLayout.NORTH);                
        add(areaDesenho, BorderLayout.CENTER);                
        add(msg, BorderLayout.SOUTH);

        // Adiciona "tratador" ("ouvidor") de eventos para 
        // cada componente
        jbPonto.addActionListener(e -> {
            tipoAtual = TipoPrimitivo.PONTO;
            areaDesenho.setTipo(tipoAtual);
        });                             
        jbReta.addActionListener(e -> {
            tipoAtual = TipoPrimitivo.RETA;
            areaDesenho.setTipo(tipoAtual);
        });
        jbRetangulo.addActionListener(e -> {
            tipoAtual = TipoPrimitivo.RETANGULO;
            areaDesenho.setTipo(tipoAtual);
        });
        jbTriangulo.addActionListener(e -> {
            tipoAtual = TipoPrimitivo.TRIANGULO;
            areaDesenho.setTipo(tipoAtual);
        });
        jbCirculo.addActionListener(e -> {
            tipoAtual = TipoPrimitivo.CIRCULO;
            areaDesenho.setTipo(tipoAtual);
        });
        jbMandala.addActionListener(e ->{
            tipoAtual = TipoPrimitivo.MANDALA;
            areaDesenho.setPrimeiraCorMandala(JColorChooser.showDialog(null, "Escolha a cor das retas", msg.getForeground()));
            areaDesenho.setSegundaCorMandala(JColorChooser.showDialog(null, "Escolha a cor dos circulos", msg.getForeground()));
            areaDesenho.setTipo(tipoAtual);
        });
        jbRedesenhar.addActionListener(e ->{
            areaDesenho.redesenharED();
        });
        jbLimpar.addActionListener(e -> {
            popupMenu.setVisible(true);
            popupMenu.setEnabled(true);
            limpezaTotal.addActionListener(i -> {
            	areaDesenho.removeAll();
                jsEsp.setValue(1); // inicia slider (necessario para limpar ultimo primitivo da tela)
                //repaint();
                jsEsp.setValue(3);
                areaDesenho.limparTela();
            	areaDesenho.limparED();
                popupMenu.setVisible(false);
            });
            confirmar.addActionListener(i -> {
                areaDesenho.removeAll();
                jsEsp.setValue(1); // inicia slider (necessario para limpar ultimo primitivo da tela)
                //repaint();
                jsEsp.setValue(3);
                areaDesenho.limparTela();
                popupMenu.setVisible(false);
            });
            limparED.addActionListener(i ->{
                areaDesenho.limparED();
                popupMenu.setVisible(false);
            });
            recusar.addActionListener(i ->{
                popupMenu.setVisible(false);
            });

        });        
        jbCor.addActionListener(e -> {
            Color c = JColorChooser.showDialog(null, "Escolha uma cor", msg.getForeground()); 
            if (c != null){ 
                corAtual = c; // pega do chooserColor 
            }
            areaDesenho.setCorAtual(corAtual); // cor atual
        });  
        jsEsp.addChangeListener(e -> {
            espAtual = jsEsp.getValue();
            jlEsp.setText("   Espessura: " + String.format("%-5s", espAtual));
            areaDesenho.setEsp(espAtual);        
        });        

        jbSair.addActionListener(e -> {
            System.exit(0);
        });        
    }
}
