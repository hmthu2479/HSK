package nhanVienFileIO;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class DataFileHandler {
    private static final String FILE_PATH = "src/data/nhanvien.txt";

    public static void saveDataToFile(giaodien frame) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (int row = 0; row < frame.modelNV.getRowCount(); row++) {
                String maNV = (String) frame.modelNV.getValueAt(row, 0);
                String ho = (String) frame.modelNV.getValueAt(row, 1);
                String ten = (String) frame.modelNV.getValueAt(row, 2);
                String phai = (String) frame.modelNV.getValueAt(row, 3);
                int tuoi = (int) frame.modelNV.getValueAt(row, 4);
                double luong = (double) frame.modelNV.getValueAt(row, 5);

                String line = maNV + "," + ho + "," + ten + "," + phai + "," + tuoi + "," + luong;
                writer.write(line);
                writer.newLine();
            }

            JOptionPane.showMessageDialog(frame, "Lưu thành công");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(frame, "Lỗi, lưu file không thành công");
        }
    }

    public static void loadDataFromFile(giaodien frame) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                
                if (data.length == 6) {  // Check if the data has the expected number of elements
                    String maNV = data[0];
                    String ho = data[1];
                    String ten = data[2];
                    String phai = data[3];
                    int tuoi = Integer.parseInt(data[4]);
                    double luong = Double.parseDouble(data[5]);
        
                    frame.modelNV.addRow(new Object[]{maNV, ho, ten, phai, tuoi, luong});
                } /*else {
                    System.err.println("Invalid data format: " + line);
                }*/
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(frame, "Lỗi khi đọc dữ liệu từ file.", "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
	    
    
}