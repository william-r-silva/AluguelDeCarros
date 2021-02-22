package com.faraorock.CarroDePrograma.View;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainView {
    
    private static JTextField txtTitulo = new JTextField();
    private static JButton btCadastrar = new JButton("Salvar");
    private static JButton btListar = new JButton("Listar");
    
    public static JFrame criaUI() {
        JFrame janela = new JFrame();
        janela.setSize(1080, 720);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);

        JPanel painel1 = new JPanel();
        painel1.setLayout(new GridLayout(2, 0));
        painel1.add(btCadastrar);
        painel1.add(btListar);
        janela.add(painel1);
        
        JPanel painel2 = new JPanel();
        painel2.setLayout(new GridLayout(2, 0));
        painel2.add(btCadastrar);
        painel2.add(btListar);
        janela.add(painel2);

        janela.revalidate();

        return janela;
    }
    
    public void startEventsListeners(){
        btListar.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {

                    }


            });

            btCadastrar.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                            // click
                            String titulo = txtTitulo.getText();


//                            f.setTitulo( titulo );;
//
//                            fr.save( f );
//
//                            JOptionPane.showMessageDialog(null, "Filme cadastrado");
                    }

            });
    }

    public JTextField getTxtTitulo() {
        return txtTitulo;
    }

    public void setTxtTitulo(JTextField txtTitulo) {
        this.txtTitulo = txtTitulo;
    }

    public JButton getBtCadastrar() {
        return btCadastrar;
    }

    public void setBtCadastrar(JButton btCadastrar) {
        this.btCadastrar = btCadastrar;
    }

    public JButton getBtListar() {
        return btListar;
    }

    public void setBtListar(JButton btListar) {
        this.btListar = btListar;
    }
    
    
}
