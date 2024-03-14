import java.awt.*;
import javax.swing.JFrame;

/**
 * @author Ting Zhang
 * 
 * The class to display the fractal pattern
 * 
 */

public class Main {
	public static void main(String [] args) {
		
		JFrame frame = new JFrame("Triangel Fractal");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        Canvas canvas = new TriangleGUI();
        canvas.setPreferredSize(new Dimension(450, 400));
        canvas.setBackground(Color.WHITE);
        
        frame.add(canvas);		
        frame.pack();
        frame.setVisible(true);
	}

}
