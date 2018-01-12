/*
 * Author: Raymond Li
 * Date: 2017-12-24
 * Description: Allows entry of legs of a right triangle and calculates its hypotenuse via a GUI
 */

//Import java GUI classes
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//Main class with JFrame and ActionListener enabled
public class Calculator extends JFrame implements ActionListener {

	//Add JPanels, 'panel' used to hold everything for box layout
	JPanel panel = new JPanel();
	JPanel pan1 = new JPanel();
	JPanel pan2 = new JPanel();
	JPanel pan3 = new JPanel();
	JPanel pan4 = new JPanel();
	JPanel pan5 = new JPanel();
	JPanel pan6 = new JPanel();

	//Add JLabels, JButton, and JTextFields, 'hypotenuseLabel' will be changed and used to show final answer
	JLabel instr = new JLabel("Enter the lengths of legs 1 and 2 of a right triangle and click calculate to get the hypotenuse.", JLabel.LEFT);
	JLabel leg1Label = new JLabel("Length of 1st leg:", JLabel.LEFT);
	JTextField leg1Field = new JTextField ("", 3);
	JLabel leg2Label = new JLabel("Length of 2nd leg:", JLabel.LEFT);
	JTextField leg2Field = new JTextField ("", 3);
	JButton calcButton = new JButton("Calculate");
	JLabel hypotenuseLabel = new JLabel("Hypotenuse: ", JLabel.TRAILING);

	//Constructor
	public Calculator() {

		//Set title, size, and location of GUI window
		setTitle("Hypotenuse Calculator");
		setSize(560, 160);
		setLocationRelativeTo(null);

		//Create 3 different layouts
		GridLayout grid1 = new GridLayout(3,2);
		FlowLayout flow2 = new FlowLayout();
		BoxLayout box3 = new BoxLayout(panel, BoxLayout.Y_AXIS);

		//Assign layouts to each JPanel
		panel.setLayout(box3);
		pan1.setLayout(flow2);
		pan2.setLayout(grid1);
		pan3.setLayout(flow2);
		pan4.setLayout(flow2);
		pan5.setLayout(flow2);
		pan6.setLayout(flow2);

		//Add ActionListener to 'calcButton'
		calcButton.addActionListener(this);

		//add JLabels, JButton, and JTextFields to JPanels
		pan1.add(instr);
		pan3.add(calcButton);
		pan3.add(leg1Label);
		pan3.add(leg1Field);
		pan4.add(leg2Label);
		pan4.add(leg2Field);
		pan5.add(calcButton);
		pan6.add(hypotenuseLabel);

		//Add JPanels 3~6 to 'pan2'
		pan2.add(pan3);
		pan2.add(pan4);
		pan2.add(pan5);
		pan2.add(pan6);

		//Add JPanels 1 and 2 to 'panel'
		panel.add(pan1);
		panel.add(pan2);
		add(panel);

		//Set GUI window to visible and disable resizing
		setVisible(true);
		setResizable(false);

	}

	//Main method
	public static void main(String[] args) {

		//Creates GUI (Note: It is not needed to assign the GUI to a particular variable, as long as it is created.)
		new Calculator();

	}

	//Create event-handling method
	public void actionPerformed(ActionEvent event) {

		//Declare variables
		String command = event.getActionCommand();
		String legOne = leg1Field.getText();
		String legTwo = leg2Field.getText();
		double leg1 = 0, leg2 = 0, hypotenuse;

		//Surround everything in Try-Catch to handle exceptions
		try {

			//Parse lengths of legs (double) from JTextFields (String)
			leg1 = Double.parseDouble(legOne);
			leg2 = Double.parseDouble(legTwo);

			//Handle any invalid input errors
			if (leg1 <= 0 || leg2 <= 0)

				//Print in red
				System.err.println("Error detected, please enter a number greater than 0.");

			//Control what happens in case of 'Calculate' JButton pressed
			else if (command.equals("Calculate")) {

				//Print log
				System.out.println("Calculate button pressed.\nCalculating hypotenuse for legs " + leg1 + " and " + leg2 + "...");

				//Calculate for hypotenuse
				hypotenuse = Math.sqrt(leg1 * leg1 + leg2 * leg2);

				//Edit JLabel 'hypotenuseLabel' and add answer calculated
				hypotenuseLabel.setText("Hypotenuse: " + hypotenuse);

				//Print calculated hypotenuse length to log
				System.out.println("Hypotenuse: " + hypotenuse);

			}

			//Catch any number format exceptions
		} catch (NumberFormatException e) {

			//Print in red
			System.err.println("Error detected: Please enter a real number.");

		}

	}

}
