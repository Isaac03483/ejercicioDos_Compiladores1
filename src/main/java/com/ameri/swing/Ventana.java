package com.ameri.swing;


import com.ameri.jflex.Lexico;
import com.ameri.modelos.Numero;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class Ventana extends javax.swing.JFrame {

    /**
     * Creates new form Ventana
     */
    public Ventana() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        areaEntrada = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        areaSalida = new javax.swing.JTextArea();
        botonAnalizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        areaEntrada.setColumns(20);
        areaEntrada.setRows(5);
        jScrollPane1.setViewportView(areaEntrada);

        areaSalida.setColumns(20);
        areaSalida.setRows(5);
        jScrollPane2.setViewportView(areaSalida);

        botonAnalizar.setText("Analizar");
        botonAnalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAnalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(295, 295, 295)
                .addComponent(botonAnalizar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(botonAnalizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAnalizarActionPerformed

        this.areaSalida.setText("");
        Reader reader = new StringReader(this.areaEntrada.getText());
        Lexico lexico = new Lexico(reader);

        try {
            int salida = lexico.yylex();
            while(salida != Lexico.YYEOF){
                salida = lexico.yylex();
            }

            this.areaSalida.append("CANTIDAD DE PALABRAS CON UNA VOCAL: "+lexico.getContUnaV()+"\n");
            this.areaSalida.append("CANTIDAD DE PALABRAS CON DOS VOCALES: "+lexico.getContDosV()+"\n");
            this.areaSalida.append("CANTIDAD DE PALABRAS CON TRES VOCALES: "+lexico.getContTresV()+"\n");
            this.areaSalida.append("CANTIDAD DE PALABRAS CON CUATRO VOCALES: "+lexico.getContCuaV()+"\n");
            this.areaSalida.append("CANTIDAD DE PALABRAS CON CINCO VOCALES: "+lexico.getContCinV()+"\n");
            for(Numero numero: lexico.getLista()){
                this.areaSalida.append("NUMERO ENCONTRADO EN FILA: "+numero.getFila()+" COLUMNA: "+numero.getColumna()+"\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_botonAnalizarActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaEntrada;
    private javax.swing.JTextArea areaSalida;
    private javax.swing.JButton botonAnalizar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
