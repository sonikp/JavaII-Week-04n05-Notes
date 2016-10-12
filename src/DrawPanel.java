import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawPanel extends JPanel
{
	public void paintComponent( Graphics g )
	{
		super.paintComponent( g ); 	// invoke the superclass paintComponent
		this.setBackground ( Color.CYAN);
		g.setColor ( Color.ORANGE );
		g.fillOval(50, 50, 90, 60);
	}
}