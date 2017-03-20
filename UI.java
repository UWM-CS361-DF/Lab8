import javax.swing.*;
import javax.swing.SpringLayout;

public class UI {
	
	public static void main(String[] args) {
		
		JFrame f = new JFrame();
		f.setSize(500,500);
		String[] labels = {"First Name: ", "Last Name: ", "Department: ", "Phone: "};
		int numPairs = labels.length;
	
		//Create and populate the panel.
		JPanel p = new JPanel(new SpringLayout());
		for (int i = 0; i < numPairs; i++) {
		    JLabel l = new JLabel(labels[i], JLabel.TRAILING);
		    p.add(l);
		    JTextField textField = new JTextField(10);
		    l.setLabelFor(textField);
		    p.add(textField);
		}
		
		String[] buttons = {"Submit", "Exit"};
		int numButtons = buttons.length;
		
		for (int i = 0; i < numButtons; i++) {
			JButton button = new JButton(buttons[i]);
			p.add(button);
		}
			
	
		//Lay out the panel.
		SpringUtilities.makeCompactGrid(p,
		                                numPairs + 1, 2, //rows, cols
		                                6, 6,        //initX, initY
		                                6, 6);       //xPad, yPad
		f.add(p);

		f.setVisible(true);
	}
}


