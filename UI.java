import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class UI extends JFrame {
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				UI a = new UI();
				a.setTitle("Employee Input");
				a.setSize(300,300);
				a.setVisible(true);
			}
		});
	
	}
		
	public UI(){	
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
				
		JButton submit = new JButton("Submit");
		submit.setForeground(Color.BLUE);
		submit.addActionListener(new SubmitListener());
			
		JButton exit = new JButton("Exit");
		exit.setForeground(Color.RED);
		exit.addActionListener(new ExitListener());
		p.add(submit);
		p.add(exit);
		
		//Lay out the panel.
		SpringUtilities.makeCompactGrid(p,
		                                numPairs + 1, 2, //rows, cols
		                                6, 6,        //initX, initY
		                                6, 6);       //xPad, yPad

		this.setContentPane(p);
		
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	private class ExitListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			 System.exit(0);
		}
	}
	
	private class SubmitListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
}


