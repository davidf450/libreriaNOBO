/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TableRenders;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Analía Santomé
 */
public class StatusColumnCellRendererCliente extends DefaultTableCellRenderer{
    @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {

            //Cells are by default rendered as a JLabel.
            JLabel l = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);

            //Get the status for the current row.
            
            l.setBackground(Color.GREEN);
            
            //Get the status for the current row.
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            
            if (tableModel.getValueAt(row, col).equals("No")) {
              l.setBackground(Color.RED);
            } else if(tableModel.getValueAt(row, col).equals("Si")){
              l.setBackground(Color.GREEN);
            }/* else if(tableModel.getValueAt(row, col).equals("Anulada")){
                l.setBackground(Color.LIGHT_GRAY);
            } else if(tableModel.getValueAt(row, col).equals("Correcta")){
                l.setBackground(Color.GREEN);
            }*/
            //Return the JLabel which renders the cell.
            return l;
        }
}
