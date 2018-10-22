import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 *  Code borrowed from the Horstmann textbook, 2nd edition
*/
public class ZoomTester {
	private static CarIcon icon;
	private static JLabel label;

	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		
		JButton inButton = new JButton("Zoom in");
		JButton outButton = new JButton("Zoom out");
		
		inButton.addActionListener(
		         createZoomButtonListener(1.1));
		outButton.addActionListener(
		         createZoomButtonListener(0.9));


		
		
		icon = new CarIcon(300);
		label = new JLabel(icon);
		frame.setLayout(new FlowLayout());
		
		frame.add(inButton);
		frame.add(outButton);
		frame.add(label);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
	}
	
	public static ActionListener createZoomButtonListener(final double n)
	{
		return new
		ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				int width = (int) (n*icon.getIconWidth());
				//sets the minimum width of the 
				if (width <10)
				{
					width = 10;
				}
				icon.setIconWidth(width);
				label.repaint();
			}
		};
	}
	
}