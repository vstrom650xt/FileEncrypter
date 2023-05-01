package view;

import controler.Logic;

import javax.swing.*;
import java.awt.event.*;

public class Pantalla1 extends JDialog {
    private JPanel contentPane;
    private JButton buttonEncrypt;
    private JButton buttonDecrypt;

    public Pantalla1() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonEncrypt);

        buttonEncrypt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onEncrypt();
            }
        });

        buttonDecrypt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onDecrypt();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {

                dispose();

            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onDecrypt();

            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onEncrypt() {
        // add your code here
        Logic.encrypFilesAndDelete();
        dispose();


    }

    private void onDecrypt() {
        // add your code here if necessary
        Logic.dencrypFile();
        dispose();

    }

}
