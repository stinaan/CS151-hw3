import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

/**
6 This program implements an animation that moves
7 a car shape.
8 */
public class AnimationTester2 
{
public static void main(String[] args)
{
JFrame frame = new JFrame();
 ArrayList<ShapeIcon> shapeList = new ArrayList<ShapeIcon>();

final MoveableShape shape = new CarShape(0, 0, CAR_WIDTH);

ShapeIcon icon = new ShapeIcon(shape, ICON_WIDTH, ICON_HEIGHT);
shapeList.add(icon);
final JLabel label = new JLabel(icon);
//frame.setLayout(new FlowLayout());


//---------

final MoveableShape shape1 = new CarShape(0, 100, CAR_WIDTH);

ShapeIcon icon1 = new ShapeIcon(shape1, ICON_WIDTH, ICON_HEIGHT);
shapeList.add(icon1);

final JLabel label1 = new JLabel(icon1);

//---------

final MoveableShape shape2 = new CarShape(0, 100, CAR_WIDTH);

ShapeIcon icon2 = new ShapeIcon(shape2, ICON_WIDTH, ICON_HEIGHT);
shapeList.add(icon2);

final JLabel label2 = new JLabel(icon2);



frame.setLayout(new FlowLayout());

frame.add(label);
//frame.add(label1);
//frame.add(label2);

System.out.println(icon2.getIconWidth());
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.pack();
frame.setVisible(true);



final int DELAY = 100;
// Milliseconds between timer ticks
Timer t = new Timer(DELAY, event ->
	{
		for (ShapeIcon s: shapeList)
		{
			CarShape c = (CarShape) s.getShape();
			c.move();
			if (c.getX()==ICON_HEIGHT)
			{
				c.setX(-ICON_HEIGHT);
			}
		}
		
	label.repaint();
	label1.repaint();
	label2.repaint();
	});
	t.start();
	}

private static final int ICON_WIDTH = 400;
private static final int ICON_HEIGHT = 120;
private static final int CAR_WIDTH = 100;
}
