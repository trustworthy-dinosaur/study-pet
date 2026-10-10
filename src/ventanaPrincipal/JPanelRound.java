package ventanaPrincipal;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class JPanelRound extends JPanel{

	private static final long serialVersionUID = 6262345517570519467L;

	public JPanelRound() {
		super();
        setOpaque(false);
    }
	
    public JPanelRound(BorderLayout borderLayout) {
    	super(borderLayout);
    	setOpaque(false);
	}

	@Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON
        );

        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);

        g2.dispose();

        super.paintComponent(g);
    }
}
