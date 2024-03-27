package Sach;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class Frm_LopHoc extends JFrame implements ActionListener, MouseListener{
	private JLabel lb_title;
	private JLabel lb_maLop;
	private JLabel lb_tenLop;
	private JLabel lb_gvcn;
	private JTextField ip_maLop;
	private JTextField ip_tenLop;
	private JTextField ip_gvcn;
	private JButton l1;
	private JLabel lb1;
	private JButton l2;
	private JButton l3;
	private JButton l4;
	private JButton r1;
	private JButton r2;
	private JButton r3;
	private JButton r4;
	private DefaultTableModel model;
	private JTable table;
	private JButton btnXem;
	ListLopHoc dslh = new ListLopHoc();
	public Frm_LopHoc() {
		setTitle("Thong tin lop hoc");
		setSize(900, 600);
		JPanel jpN = new JPanel();	
		jpN.add(lb_title = new JLabel("THÔNG TIN LỚP HỌC")); 
		lb_title.setFont(new Font("Arial",Font.BOLD,20));
		
		JPanel jpC = new JPanel();	
		JPanel jpTTin = new JPanel();	
		JPanel jpBtn = new JPanel();	
		jpC.add(jpBtn);
		jpC.add(jpTTin);
		
		JPanel jpTTin_lb = new JPanel();
		jpTTin_lb.setLayout(new BoxLayout(jpTTin_lb, BoxLayout.Y_AXIS));
		jpTTin_lb.add(lb_maLop = new JLabel("Mã lớp:"));
		jpTTin_lb.add(lb_tenLop = new JLabel("Tên lớp:"));
		jpTTin_lb.add(lb_gvcn = new JLabel("Giáo viên chủ nhiệm:"));

		JPanel jpTTin_tf = new JPanel();
		jpTTin_tf.setLayout(new BoxLayout(jpTTin_tf, BoxLayout.Y_AXIS));
		jpTTin_tf.add(ip_maLop = new JTextField(70));
		jpTTin_tf.add(ip_tenLop = new JTextField(70));
		jpTTin_tf.add(ip_gvcn = new JTextField(70));

		
		jpTTin.add(jpTTin_lb);
		jpTTin.add(jpTTin_tf);
		
		JPanel jpBtn2 = new JPanel();	
		jpBtn2.add(r1 = new JButton("Thêm"));
		jpBtn2.add(r2 = new JButton("Lưu"));
		jpBtn2.add(r3 = new JButton("Sửa"));
		jpBtn2.add(r4 = new JButton("Xóa"));
		jpC.add(jpBtn2);
		
		//table
		String[] columnNames = {"Mã số lớp", "Tên lớp", "Giáo viên chủ nhiệm"};
        model = new DefaultTableModel(columnNames,0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        jpC.add(scrollPane);
        scrollPane.setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.gray, 1), "Danh sách lớp học", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Arial", Font.BOLD, 14), Color.GRAY));
        scrollPane.setPreferredSize(new Dimension(870, 370));
        
        JPanel jpS = new JPanel();
        jpS.setLayout(new FlowLayout(FlowLayout.RIGHT));
        jpS.add(btnXem = new JButton("Xem danh sách sinh viên của lớp hiện tại"));
        btnXem.setForeground(Color.red);
        
        add(jpN, BorderLayout.NORTH);
        add(jpC, BorderLayout.CENTER);
        add(jpS, BorderLayout.SOUTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		
		db.getInstance().connect();
		
		r1.addActionListener(this);
		r2.addActionListener(this);
		r3.addActionListener(this);
		r4.addActionListener(this);
		table.addMouseListener(this);
		
		updateTableData();
	}

	public static void main(String[] args) {
		new Frm_LopHoc();	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		//Lưu
		if(o.equals(r2)) {
			lopHoc lh = new lopHoc(ip_maLop.getText(),ip_tenLop.getText(),ip_gvcn.getText());
			if(dslh.create(lh)) {
				Object[] rowData = {ip_maLop.getText(),ip_tenLop.getText(),ip_gvcn.getText()};
				model.addRow(rowData);
			}
		}
		//Sửa
		else if (o.equals(r3)) {
			int row = table.getSelectedRow();
			if(row>=0) {
				lopHoc lh = new lopHoc(ip_maLop.getText(),ip_tenLop.getText(),ip_gvcn.getText());
				if(dslh.update(lh)) {
					table.setValueAt(ip_tenLop.getText(), row, 1);
					table.setValueAt(ip_gvcn.getText(), row, 2);
				}
			}
			
		}
		//Xóa
		else if (o.equals(r4)) {
			int row = table.getSelectedRow();
			if(row>=0) {
				//lopHoc lh = new lopHoc(ip_maLop.getText(),ip_tenLop.getText(),ip_gvcn.getText());
				String maLop = (String) table.getValueAt(row, 0);
				if(dslh.delete(maLop)) {
					model.removeRow(row);
					
				}
			}
		}
		//Thêm
		else if (o.equals(r1)) {
			String maLop = ip_maLop.getText();
	        String tenLop = ip_tenLop.getText();
	        String gvcn = ip_gvcn.getText();
	        Object[] rowData = { maLop, tenLop, gvcn };
	        model.addRow(rowData);
	        xoaRong();
		}
	}
	private void xoaRong() {
		ip_gvcn.setText("");
		ip_maLop.setText("");
		ip_tenLop.setText("");
		ip_maLop.requestFocus();
	}
	
	private void updateTableData() {
		ListLopHoc list = new ListLopHoc();
		List<lopHoc> ds = list.docTuBang();
		for(lopHoc s : ds) {
			String [] rowData = {s.getMaLop(),s.getTenLop(),s.getGvcn()};
			model.addRow(rowData);
		}
		table.setModel(model);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		ip_maLop.setText(table.getValueAt(row, 0).toString());
		ip_tenLop.setText(table.getValueAt(row, 1).toString());
		ip_gvcn.setText(table.getValueAt(row, 2).toString());
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
