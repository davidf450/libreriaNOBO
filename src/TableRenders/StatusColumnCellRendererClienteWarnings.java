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
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Analía Santomé
 */
public class StatusColumnCellRendererClienteWarnings extends DefaultTableCellRenderer{
    @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {

            //Cells are by default rendered as a JLabel.
            JLabel l = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);

            //Get the status for the current row.
            
            
            //Get the status for the current row.
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            Double montoMaximo = (double)tableModel.getValueAt(row, 3);
            Double montoActual = (double)tableModel.getValueAt(row, 4);
            if (montoActual>montoMaximo) {
              l.setBackground(Color.RED);
            } else if(montoActual>montoMaximo*0.8){
              l.setBackground(Color.YELLOW);
            }else if(montoActual<montoMaximo*0.8){
                l.setBackground(Color.GREEN);
            }
            //Return the JLabel which renders the cell.
            return l;
        }
}
