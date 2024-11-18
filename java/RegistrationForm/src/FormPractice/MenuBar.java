package FormPractice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MenuBar extends JPanel {
    public MenuBar(JFrame frame, JPanel mainPan){
        JMenuBar menuBar = new JMenuBar();


        // region File
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        JMenuItem closeItem = new JMenuItem("Close");
        fileMenu.add(closeItem);
        //endregion

        //region Edit
        JMenu editMenu = new JMenu("Edit");
        menuBar.add(editMenu);

        JMenuItem clearItem = new JMenuItem("Clear");
        editMenu.add(clearItem);

        //endregion

        //region Help
        JMenu helpMenu = new JMenu("Help");
        menuBar.add(helpMenu);

        JMenuItem version = new JMenuItem("Version");
        helpMenu.add(version);
        JMenuItem about = new JMenuItem("About");
        helpMenu.add(about);
        //endregion

        //region Context Menu
        JPanel pan = new JPanel();
        JPopupMenu contextMenu = new JPopupMenu();

        JMenuItem bgBlue = new JMenuItem("Blue");
        bgBlue.addActionListener((ActionEvent e) -> {
            mainPan.setBackground(Color.BLUE);
        });

        JMenuItem bgGreen = new JMenuItem("Green");
        bgGreen.addActionListener((ActionEvent e) -> {
            mainPan.setBackground(Color.GREEN);
        });

        JMenuItem bgRed = new JMenuItem("Red");
        bgRed.addActionListener((ActionEvent e) -> {
            mainPan.setBackground(Color.RED);
        });

        JMenuItem reset = new JMenuItem("Reset");
        reset.addActionListener((ActionEvent e) -> {

            mainPan.setBackground(new Color(240, 240, 240));
        });



        contextMenu.add(bgBlue);
        contextMenu.add(bgGreen);
        contextMenu.add(bgRed);
        contextMenu.addSeparator();
        contextMenu.add(reset);
        //endregion



        pan.setComponentPopupMenu(contextMenu);
        frame.setJMenuBar(menuBar);
        frame.setContentPane(pan);

    }
}
