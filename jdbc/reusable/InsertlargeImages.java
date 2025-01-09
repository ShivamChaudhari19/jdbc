package jdbc.reusable;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertlargeImages {
    public static void main(String[] args) {
        try {
            //window to select file from the device
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.showOpenDialog(null);
            File file = jFileChooser.getSelectedFile();
            FileInputStream fileInputStream = new FileInputStream(file);
            Connection con = ConnectionProvider.getConnectionProvider();
            String q = "Insert Into images(pic) values(?);";
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setBinaryStream(1, fileInputStream, fileInputStream.available());
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Success.....");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
