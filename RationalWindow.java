import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class RationalWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton addButton;
	private JButton subtractButton;
	private JButton multiplyButton;
	private JButton divideButton;
	
	private JLabel firstFractionLabel;
	private JLabel secondFractionLabel;
	private JTextField firstFractionTextField;
	private JTextField secondFractionTextField;
	private JPanel firstFractionPanel;
	private JPanel secondFractionPanel;
	private JPanel resultFractionPanel;
	
	private JTextField resultTextField;
	
	private JPanel operationPanel;
	private JPanel fractionPanel;
	
	public RationalWindow() 
	{
		this.operationPanel = new JPanel();
		this.firstFractionPanel = new JPanel();
		this.secondFractionPanel = new JPanel();
		this.resultFractionPanel = new JPanel();
		this.fractionPanel = new JPanel();
		
		this.addButton = new JButton("+");
		this.subtractButton = new JButton("-");
		this.multiplyButton = new JButton("*");
		this.divideButton = new JButton("/");
		

		operationPanel.add(addButton);
		operationPanel.add(subtractButton);
		operationPanel.add(multiplyButton);
		operationPanel.add(divideButton);
		
		firstFractionLabel = new JLabel("Fraction 1: ");
		secondFractionLabel = new JLabel("Fraction 2: ");
		firstFractionTextField = new JTextField(20);
		secondFractionTextField = new JTextField(20);
		
		resultTextField = new JTextField(20);
		resultTextField.setEnabled(false);
		
		firstFractionPanel.add(firstFractionLabel);
		firstFractionPanel.add(firstFractionTextField);
		secondFractionPanel.add(secondFractionLabel);
		secondFractionPanel.add(secondFractionTextField);
		resultFractionPanel.add(resultTextField);
		
		firstFractionTextField.setHorizontalAlignment(JTextField.CENTER);
		secondFractionTextField.setHorizontalAlignment(JTextField.CENTER);
		resultTextField.setHorizontalAlignment(JTextField.CENTER);
		
		fractionPanel.setLayout(new BoxLayout(fractionPanel, BoxLayout.Y_AXIS));
		fractionPanel.add(firstFractionPanel);
		fractionPanel.add(secondFractionPanel);
		fractionPanel.add(resultFractionPanel);
		
		this.setSize(400, 160);
		this.setTitle("Rational Calculator");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		getContentPane().add(fractionPanel, BorderLayout.NORTH);
		getContentPane().add(operationPanel, BorderLayout.SOUTH);
		
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					resultTextField.setText(getFraction(firstFractionTextField).add(getFraction(secondFractionTextField)).toString());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
					JOptionPane.showMessageDialog(null, "Error: " + e1.getMessage());
				}
				
			}
		});
		
		subtractButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					resultTextField.setText(getFraction(firstFractionTextField).subtract(getFraction(secondFractionTextField)).toString());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
					JOptionPane.showMessageDialog(null, "Error: " + e1.getMessage());
				}
				
			}
		});
		
		multiplyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					resultTextField.setText(getFraction(firstFractionTextField).multiply(getFraction(secondFractionTextField)).toString());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
					JOptionPane.showMessageDialog(null, "Error: " + e1.getMessage());
				}
				
			}
		});
		
		divideButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					resultTextField.setText(getFraction(firstFractionTextField).divide(getFraction(secondFractionTextField)).toString());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
					JOptionPane.showMessageDialog(null, "Error: " + e1.getMessage());
				}
				
			}
		});
		
		this.setVisible(true);
	}
	
	public Rational getFraction(JTextField field) throws NumberFormatException, Exception
	{
		String[] n = field.getText().split("/");
		if (n.length == 1)
		{
			return new Rational(Integer.parseInt(n[0]), 1);
		}
		else if (n.length == 2)
		{
			return new Rational(Integer.parseInt(n[0]), Integer.parseInt(n[1]));
		}
		return null;
	}
	
	public static void main(String[] args)
	{
		new RationalWindow();
	}
}
