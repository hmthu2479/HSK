package e1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cal1 extends JFrame {
	private JTextField number1TextField;
	private JTextField number2TextField;
	private JTextField resultTextField;

	public Cal1() {
		setTitle("Calculator");

		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

		JPanel number1Panel = new JPanel();
		number1TextField = new JTextField(10);
		number1Panel.add(new JLabel("Number 1:"));
		number1Panel.add(number1TextField);

		JPanel number2Panel = new JPanel();
		number2TextField = new JTextField(10);
		number2Panel.add(new JLabel("Number 2:"));
		number2Panel.add(number2TextField);

		JPanel resultPanel = new JPanel();
		resultTextField = new JTextField(10);
		resultTextField.setEditable(false);
		resultPanel.add(new JLabel("Result:"));
		resultPanel.add(resultTextField);

		centerPanel.add(Box.createVerticalGlue());
		centerPanel.add(number1Panel);
		centerPanel.add(number2Panel);
		centerPanel.add(resultPanel);

		JPanel southPanel = new JPanel();
		JButton plusButton = new JButton("Plus");
		JButton minusButton = new JButton("Minus");
		JButton closeButton = new JButton("Close");

		plusButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				calculateResult("+");
			}
		});

		minusButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				calculateResult("-");
			}
		});

		closeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		southPanel.add(plusButton);
		southPanel.add(minusButton);
		southPanel.add(closeButton);

		add(centerPanel, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);

		pack();
		setLocationRelativeTo(null);
		setResizable(true);
		setVisible(true);
	}

	private void calculateResult(String operator) {
		try {
			int number1 = Integer.parseInt(number1TextField.getText());
			int number2 = Integer.parseInt(number2TextField.getText());
			int result;

			if (operator.equals("+")) {
				result = number1 + number2;
			} else {
				result = number1 - number2;
			}

			resultTextField.setText(String.valueOf(result));
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Invalid input! Please enter numbers only.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Cal1();
			}
		});
	}
}
