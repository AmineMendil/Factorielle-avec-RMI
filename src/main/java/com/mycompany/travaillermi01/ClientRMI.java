/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.travaillermi01;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author amine
 */
public class ClientRMI extends JFrame {

    private JTextField field;
    private JTextArea area;
    private InterfaceRMI clRMI;

    //construction de la fenètre
    public ClientRMI() {

        //Titre de la fenètre
        setTitle("Réaliser par : MENDIL Amine G2 ASR");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //Composant de la fenètre
        field = new JTextField(20);
        area = new JTextArea(20, 30);
        area.setEditable(false);

        JScrollPane scroll = new JScrollPane(area);
        JButton calculer = new JButton("=");
        calculer.setPreferredSize(new Dimension(50, 20));

        calculer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                    if(field.getText().isEmpty()){
                        JOptionPane.showMessageDialog(null, "Le champs est vide", null, JOptionPane.ERROR_MESSAGE);
                        
                    }else{
                        try {
                            calculefact();
                        } catch (RemoteException ex) {
                            ex.printStackTrace();
                        }
                        
                    }
                    

            }
        });

        setLayout(new BorderLayout());
        JPanel pan1 = new JPanel();
        pan1.add(new JLabel("Entrez un nombre:"));
        pan1.add(field);
        add(pan1, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        JPanel pan2 = new JPanel();

        pan2.add(calculer);
        add(pan2, BorderLayout.SOUTH);

        try {
            Remote rm = Naming.lookup("rmi://localhost:1099/factorielle");
            clRMI = (InterfaceRMI) rm;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erreur de connexion au serveur", null, JOptionPane.ERROR_MESSAGE);
        }

    }

    private void calculefact() throws RemoteException {
        try {
            int nombre = Integer.parseInt(field.getText());

            if (nombre < 0) {
                JOptionPane.showMessageDialog(null, "veuillez saisir un entier positive", null, JOptionPane.ERROR_MESSAGE);

            } else {
                long resulat = clRMI.calculeFact(nombre);
                area.append(nombre + " ! = " + resulat + "\n");

            }

        } catch (NumberFormatException ne) {
            ne.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        ClientRMI c = new ClientRMI();
        c.setVisible(true);
    }

}
