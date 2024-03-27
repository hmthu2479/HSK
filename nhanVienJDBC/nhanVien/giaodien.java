package nhanVien;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class giaodien extends JFrame implements ActionListener{
	private JLabel lb_title;
	private JPanel jpMaNV;
	private JLabel lb_MaNV;
	private JTextField ijpMaNV;
	private JPanel jpHoTen;
	private JPanel jpho;
	private JLabel lb_ho;
	private JTextField ijpho;
	private JPanel jpten;
	private JLabel lb_ten;
	private JTextField ijpten;
	private JPanel jpTuoi;
	private JLabel lb_tuoi;
	private JTextField ijpTuoi;
	private JPanel jpTien;
	private JLabel lb_tien;
	private JTextField ijptien;
	private JPanel jpTuoi_Phai;
	private JPanel jpPhai;
	private JRadioButton nu;
	private JPanel jpS;
	private JPanel bTrai;
	private JPanel bPhai;
	private JLabel lb_Nhap;
	private JTextField ijpNhap;
	private JButton tim;
	private JButton them;
	private JButton xoaTrang;
	private JButton xoa;
	private JButton luu;
	private JPanel jpN;
	private JLabel phai;
	DefaultTableModel modelNV;
	private JTable tableNhanVien;
	private NhanVien_Collection listNV;
	private JRadioButton nam;

	public giaodien() {
		jpN = new JPanel();
		jpN.add(lb_title = new JLabel("THÔNG TIN NHÂN VIÊN"));	
		lb_title.setHorizontalAlignment(JLabel.CENTER);
		lb_title.setFont(new Font("Arial", Font.BOLD, 30));
		lb_title.setForeground(Color.BLUE);
		lb_title.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 50));
		
		jpN.setLayout(new BoxLayout(jpN, BoxLayout.Y_AXIS));
		
		jpN.add(jpMaNV = new JPanel());
			jpMaNV.add(lb_MaNV = new JLabel("Mã nhân viên: "));
			jpMaNV.add(ijpMaNV = new JTextField(40));
			ijpMaNV.requestFocusInWindow();
			
		jpN.add(jpHoTen = new JPanel());
			jpHoTen.add(jpho = new JPanel());
				jpho.add(lb_ho = new JLabel("Họ: "));
				jpho.add(ijpho = new JTextField(15));
			jpHoTen.add(jpten = new JPanel());
				jpten.add(lb_ten = new JLabel("Tên nhân viên: "));
				jpten.add(ijpten = new JTextField(20));
		jpN.add(jpTuoi_Phai = new JPanel());
			jpTuoi_Phai.add(jpTuoi = new JPanel());
				jpTuoi.add(lb_tuoi = new JLabel("Tuổi: "));
				jpTuoi.add(ijpTuoi = new JTextField(31));
			jpTuoi_Phai.add(jpPhai = new JPanel());	
				jpPhai.add(phai = new JLabel("Phái: "));				
				jpPhai.add(nu = new JRadioButton("Nữ"));
				jpPhai.add(nam = new JRadioButton("Nam"));
				ButtonGroup gr = new ButtonGroup();
				gr.add(nam);
				gr.add(nu);
				
		jpN.add(jpTien = new JPanel());
			jpTien.add(lb_tien = new JLabel("Tiền lương: "));
			jpTien.add(ijptien = new JTextField(42));
		jpN.add(tableNhanVien = new JTable());
		add(jpN, BorderLayout.NORTH);
		
		String[] columns = {
			"Mã NV", "Họ", "Tên", "Phái", "Tuổi", "Tiền lương" 	
		};
		modelNV = new DefaultTableModel(columns, 0);
		tableNhanVien = new JTable(modelNV);
		String[] luaChon = {"Nam", "Nữ"};
        TableColumn phaiColumn = tableNhanVien.getColumnModel().getColumn(3);
        phaiColumn.setCellEditor(new DefaultCellEditor(new JComboBox<>(luaChon)));
        
		add(new JScrollPane(tableNhanVien), BorderLayout.CENTER);
		listNV = new NhanVien_Collection();
				
				
		jpS = new JPanel();
		jpS.add(bTrai = new JPanel());
		bTrai.setLayout(new BoxLayout(bTrai, BoxLayout.X_AXIS));
			bTrai.add(lb_Nhap = new JLabel("Nhập mã số cần tìm: "));
			bTrai.add(ijpNhap = new JTextField(7));
			bTrai.add(tim = new JButton("Tìm"));
		
				
		jpS.add(bPhai = new JPanel());
		bPhai.setLayout(new BoxLayout(bPhai, BoxLayout.X_AXIS));
			bPhai.add(them = new JButton("Thêm"));
			bPhai.add(xoaTrang = new JButton("Xóa trắng"));
			bPhai.add(xoa = new JButton("Xóa"));
			bPhai.add(luu = new JButton("Lưu"));
		add(jpS, BorderLayout.SOUTH);
	
	
		xoaTrang.addActionListener(this);
		them.addActionListener(this);
		xoa.addActionListener(this);
		tim.addActionListener(this);
		luu.addActionListener(this);

		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setSize(580, 400);
		setLocationRelativeTo(null);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(them)) {
			String ma = ijpMaNV.getText();
			String ho = ijpho.getText();
			String ten = ijpten.getText();
			int tuoi = Integer.parseInt(ijpTuoi.getText());
			String phai_Nam_Nu = nam.isSelected()?"Nam" : nu.isSelected()?"Nữ":"";
			double luong = Double.parseDouble(ijptien.getText());
			
			NhanVien nv = new NhanVien(ma, ho, ten, phai_Nam_Nu, tuoi, luong);
			
			if(!listNV.themNV(nv)) {
				JOptionPane.showMessageDialog(this, "Trùng mã");
			}
			else {
				modelNV.addRow(new Object[] {nv.getMaNV(), nv.getHoNV(),
						nv.getTenNV(), phai_Nam_Nu,nv.getTuoi(), nv.getTienLuong()
				});
			}
		}
		if(o.equals(luu)) {
			if (o.equals(luu)) {
			    
			}
		}
		if (o.equals(xoa)) {
		    int r = tableNhanVien.getSelectedRow();
		    modelNV.removeRow(r);
		    NhanVien nv = listNV.getElement(r);
		    if (nv != null) {
		        listNV.xoaNV(nv.getMaNV());
		}
		if(o.equals(xoaTrang)) {
			ijpMaNV.setText("");
			ijpten.setText("");
			ijpho.setText("");
			nam.setSelected(false);
			nu.setSelected(false);
			ijpTuoi.setText("");
			ijptien.setText("");
			//đặt lại phương thức xóa trắng
    		ButtonGroup gr = new ButtonGroup();
			gr.add(nam);
			gr.add(nu);
			gr.clearSelection();
		}
		
		if (o.equals(tim)) {
            String maTim = ijpNhap.getText();
            if(maTim != null && maTim.trim().length() > 0) {
            	try {
            		NhanVien nvTim = listNV.tim(maTim);
            		if (nvTim != null) {
                        JOptionPane.showMessageDialog(this,
                                "Thông tin nhân viên:\nMã: " + nvTim.getMaNV() +
                                        "\nHọ: " + nvTim.getHoNV() +
                                        "\nTên: " + nvTim.getTenNV() +
                                        "\nTuổi: " + nvTim.getTuoi() +
                                        "\nPhái: " + nvTim.getPhai() +
                                        "\nTiền lương: " + nvTim.getTienLuong(),
                                "Tìm kiếm thành công", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "Không tìm thấy nhân viên có mã " + maTim, "Thông báo",
                                JOptionPane.ERROR_MESSAGE);
                    }
            	}catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Dữ liệu không hợp lệ");
				}
            }
		}
		}
	}

	public static void main(String[] args) {
	    SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	            new giaodien();
	        }
	    });
	}
}
