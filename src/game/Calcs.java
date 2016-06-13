package game;

import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Calcs {
	/**Generates a random number between the parameters
	 * @param lowNum The lowest number that can be generated
	 * @param highNum The highest number that be generated
	 * @return A random number on or between the parameters
	 */
	public static int randGenerator(int lowNum, int highNum){
		int rand;
		
		rand = (int)((highNum - lowNum + 1) * Math.random() + lowNum);
		return(rand);
	}
	/**
	 * Rounds a number to a two decimal precision
	 * @param num The number to be rounded
	 * @return The number rounded
	 */
	public static double round(double num){
		double rounded;
		rounded = Math.round(num * 100.00) / 100.00;
		return(rounded);
	}
	/** Displays any information pushed to the contentPane
	 * @param frame The JFrame the content is to be pushed to
	 * @param contentPane The JPanel with the information on it
	 */
	public static void display(JFrame frame, JPanel contentPane){
		frame.setContentPane(contentPane);
		frame.pack();
		frame.setVisible(true);
	}
	/**
	 * Creates buttons
	 * @param names The button names
	 * @param cmds The button Action Commands
	 * @param aH The Action Handler
	 * @param contentPane The JPanel the buttons are to be put on
	 */
	public static void createButton(String[] names, String[] cmds, ActionHandler aH, JPanel contentPane){
		for(int i = 0; i < names.length; i++){
			final JButton button = new JButton(names[i]);
			button.setActionCommand(cmds[i]);
			button.addActionListener(aH);
			contentPane.add(button);
		}
	}
	/**
	 * Creates labels
	 * @param labels The label information
	 * @param contentPane The JPanel the labels are to be put on
	 */
	public static void createLabels(String[] labels, JPanel contentPane){
		for(int i = 0; i <labels.length; i++){
			final JLabel label = new JLabel(labels[i]);
			contentPane.add(label);
		}
	}
	/**
	 * Turns an array of Strings into a usable list interface for button action handling
	 * @param rep The array of strings
	 * @param num The number lock to be used
	 * @return The number locked string array
	 */
	public static String[] createNumLock(String[] rep, int num){
		String[] realRep = Arrays.copyOf(rep, rep.length);
		for(int i = 0; i < rep.length; i++){
			realRep[i] = num + realRep[i];
		}
		return(realRep);
	}
	
}