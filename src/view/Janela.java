package view;

import java.awt.*;

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
        setContentPane(this.contentPane);
    }

    public void adicionarTela(String nome, JPanel tela) {
        this.contentPane.add(tela, nome);
    }

    public void mostrarTela(String nome) {
		this.cardLayout.show(contentPane, nome);
        JPanel telaAtual = null;

        for (Component component : contentPane.getComponents()) {
            if (component.isVisible() && component instanceof JPanel) {
                telaAtual = (JPanel) component;
                break;
            }
        }
        if (telaAtual != null) {
            this.setSize(telaAtual.getPreferredSize());
            this.revalidate();
            this.repaint();
        }
	}

}
