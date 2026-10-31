package ventanaPrincipal;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;

public class JButtonRound extends JButton{
	//Hecho con IA
	private static final long serialVersionUID = 1L;
	

	public JButtonRound(String text) {
        super(text);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
    }
	
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);

        super.paintComponent(g);
        g2.dispose();
    }
}
