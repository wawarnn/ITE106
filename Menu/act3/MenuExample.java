import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuExample {
    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Menu Example");
        frame.setSize(220, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
        JMenu fileMenu = new JMenu("File");
        fileMenu.add(new JMenuItem("New"));
        fileMenu.add(new JMenuItem("Open"));
        fileMenu.add(new JMenuItem("Close"));

        JMenu editMenu = new JMenu("Edit");
        editMenu.add(new JMenuItem("Undo"));
        editMenu.add(new JMenuItem("Redo"));
        editMenu.add(new JMenuItem("Cut"));
		
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(fileMenu); 
        menuBar.add(editMenu);  

        frame.setJMenuBar(menuBar);
        frame.setVisible(true);
    }
}
