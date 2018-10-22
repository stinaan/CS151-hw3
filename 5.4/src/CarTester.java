import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.*;

public class CarTester extends JSlider{
	private static CarIcon icon;
	private static JLabel label;
	private static int value;
	private static final int CAR_SIZE = 50;
	private static final int FRAME_WIDTH = 200;
	private static final int FRAME_HEIGHT = 200;
	
	public static void main(String[] arg)
	{
		JFrame frame = new JFrame();
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		
		JSlider slide = new JSlider();
	//	slide.addChangeListener(this);

		slide.addChangeListener( createSliderListener(1.1));
		
		icon = new CarIcon(CAR_SIZE);
		label = new JLabel(icon);
		frame.setLayout(new FlowLayout());
		
		frame.add(label);
		frame.add(slide);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
	}
	
	
	public static ChangeListener createSliderListener(final double n)
	{
		return new
				ChangeListener(){
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		JSlider source = (JSlider)e.getSource();
		if(source.getValueIsAdjusting()==true)
		{
			icon.setIconWidth(source.getValue());
			
			label.repaint();
		}
		
		
			}
		};
	}

	
}
