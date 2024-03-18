package e1;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class DemoSwing21 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JRadioButton rdbtnCong;
    private JRadioButton rdbtnTru;
    private JRadioButton rdbtnNhan;
    private JRadioButton rdbtnChia;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DemoSwing21 frame = new DemoSwing21();
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
    public DemoSwing21() {
        setTitle("AAA");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 423, 397);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(143, 188, 143));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Số 1");
        lblNewLabel.setBounds(68, 39, 64, 34);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
        contentPane.add(lblNewLabel);

        JLabel lblS = new JLabel("Số 2");
        lblS.setBounds(68, 91, 64, 34);
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

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(173, 151, 156, 34);
        textField_2.setFont(new Font("Arial", Font.BOLD, 18));
        textField_2.setHorizontalAlignment(JTextField.CENTER);
        contentPane.add(textField_2);

        rdbtnCong = new JRadioButton("Cộng");
        rdbtnCong.setHorizontalAlignment(SwingConstants.CENTER);
        rdbtnCong.setBackground(Color.WHITE);
        rdbtnCong.setFont(new Font("Tahoma", Font.BOLD, 19));
        rdbtnCong.setBounds(28, 216, 95, 34);
        contentPane.add(rdbtnCong);

        rdbtnTru = new JRadioButton("Trừ");
        rdbtnTru.setHorizontalAlignment(SwingConstants.CENTER);
        rdbtnTru.setFont(new Font("Tahoma", Font.BOLD, 19));
        rdbtnTru.setBackground(Color.WHITE);
        rdbtnTru.setBounds(120, 216, 86, 34);
        contentPane.add(rdbtnTru);

        rdbtnNhan = new JRadioButton("Nhân");
        rdbtnNhan.setHorizontalAlignment(SwingConstants.CENTER);
        rdbtnNhan.setFont(new Font("Tahoma", Font.BOLD, 19));
        rdbtnNhan.setBackground(Color.WHITE);
        rdbtnNhan.setBounds(195, 216, 103, 34);
        contentPane.add(rdbtnNhan);

        rdbtnChia = new JRadioButton("Chia");
        rdbtnChia.setHorizontalAlignment(SwingConstants.CENTER);
        rdbtnChia.setFont(new Font("Tahoma", Font.BOLD, 19));
        rdbtnChia.setBackground(Color.WHITE);
        rdbtnChia.setBounds(289, 216, 103, 34);
        contentPane.add(rdbtnChia);
        
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(rdbtnCong);
        buttonGroup.add(rdbtnTru);
        buttonGroup.add(rdbtnNhan);
        buttonGroup.add(rdbtnChia);

        JButton btnNewButton = new JButton("Giải");
        btnNewButton.setForeground(new Color(248, 248, 255));
        btnNewButton.setBounds(41, 281, 77, 35);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String num1 = textField.getText();
                String num2 = textField_1.getText();

                // Perform the calculation
                float result = 0;
                if (rdbtnCong.isSelected()) {
                    float sum = Float.parseFloat(num1) + Float.parseFloat(num2);
                    result = sum;
                } else if (rdbtnTru.isSelected()) {
                    float minus = Float.parseFloat(num1) - Float.parseFloat(num2);
                    result = minus;
                } else if (rdbtnNhan.isSelected()) {
                    float multiply = Float.parseFloat(num1) * Float.parseFloat(num2);
                    result = multiply;
                } else if (rdbtnChia.isSelected()) {
                    float divide = Float.parseFloat(num1) / Float.parseFloat(num2);
                    result = divide;
                }

                // Display the result in the text field
                textField_2.setText(Float.toString(result));
            }
        });
        btnNewButton.setBackground(new Color(112, 128, 144));
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 21));
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Xóa");
        btnNewButton_1.setBounds(157, 281, 85, 34);
        btnNewButton_1.setBackground(UIManager.getColor("Button.background"));
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 21));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
                textField_1.setText("");
                textField_2.setText("");
            }
        });
        contentPane.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("Thoát");
        btnNewButton_2.setBounds(275, 282, 104, 33);
        btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 21));
        btnNewButton_2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        contentPane.add(btnNewButton_2);

        JLabel lblKtQu = new JLabel("Kết quả");
        lblKtQu.setFont(new Font("Tahoma", Font.BOLD, 21));
        lblKtQu.setBounds(55, 149, 92, 34);
        contentPane.add(lblKtQu);
    }
}
