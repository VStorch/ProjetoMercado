package view;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Janela extends JFrame {

	private JPanel contentPane;
	private CardLayout cardLayout;
	
	public Janela() {
		setTitle("Sistema de mercado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 370);
		setLocationRelativeTo(null);
		
		this.cardLayout = new CardLayout();
		
		this.contentPane = new JPanel(this.cardLayout);
		this.contentPane.setPreferredSize(new Dimension(400, 200));
        setContentPane(this.contentPane);
    }

    public void adicionarTela(String nome, JPanel tela) {
        this.contentPane.add(tela, nome);
    }

    public void mostrarTela(String nome) {
		this.cardLayout.show(contentPane, nome);
        this.pack();
	}

}
