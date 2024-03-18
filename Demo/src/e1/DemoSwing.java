package e1;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class DemoSwing extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame frame = new DemoSwing();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DemoSwing() {
		setTitle("AAA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 414, 297);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Số 1");
		lblNewLabel.setBounds(81, 39, 77, 34);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		contentPane.add(lblNewLabel);
		
		JLabel lblS = new JLabel("Số 2");
		lblS.setBounds(81, 94, 77, 34);
		lblS.setFont(new Font("Tahoma", Font.BOLD, 21));
		contentPane.add(lblS);
		
		textField = new JTextField();
		textField.setBounds(173, 42, 156, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setFont(new Font("Arial", Font.BOLD, 16));
		textField.setHorizontalAlignment(JTextField.CENTER);
		
		textField_1 = new JTextField();
		textField_1.setBounds(173, 94, 156, 34);
		textField_1.setColumns(10);
		textField_1.setFont(new Font("Arial", Font.BOLD, 16));
		textField_1.setHorizontalAlignment(JTextField.CENTER);
		contentPane.add(textField_1);
		
		JButton btnNewButton = new JButton("Giải");
		btnNewButton.setBounds(38, 207, 77, 35);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {{
	                String num1 = textField.getText();
	                String num2 = textField_1.getText();

	                // Perform the calculation
	                float sum = Float.parseFloat(num1)+ Float.parseFloat(num2);

	                // Display the result in the text field
	                textField_2.setText(Float.toString(sum));
	            }
			}
		});
		btnNewButton.setBackground(UIManager.getColor("Button.background"));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 21));
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Xóa");
		btnNewButton_1.setBounds(140, 207, 85, 34);
		btnNewButton_1.setBackground(UIManager.getColor("Button.background"));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
                textField_1.setText("");
            }
        });
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Thoát");
		btnNewButton_2.setBounds(248, 208, 104, 33);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnNewButton_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();			}
		});
		contentPane.add(btnNewButton_2);
		
		JLabel lblKtQu = new JLabel("Kết quả");
		lblKtQu.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblKtQu.setBounds(66, 149, 92, 34);
		contentPane.add(lblKtQu);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(173, 151, 156, 34);
		textField_2.setFont(new Font("Arial", Font.BOLD, 18));
		textField_2.setHorizontalAlignment(JTextField.CENTER);;
		contentPane.add(textField_2);
	}
}
