import java.awt.Color;
import javax.swing.JFrame;

public class DrawApp
{
	public static void main(String[] args)
	{
		
		JFrame frame = new JFrame("Drawing on a JPanel");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DrawPanel drawPanel = new DrawPanel();
		drawPanel.setBackground(Color.WHITE);
		frame.add(drawPanel);
		frame.setSize(200, 200);
		frame.setVisible(true);
		
	}
	
}