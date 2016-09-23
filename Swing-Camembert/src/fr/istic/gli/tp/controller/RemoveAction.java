package fr.istic.gli.tp.controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JTable;

import fr.istic.gli.tp.modele.TableModel;

public class RemoveAction extends AbstractAction{
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private JTable tableau;
  private TableModel tab;
  
  public RemoveAction(JTable tableau, TableModel tab) {
    super("Supprimmer");
    this.tableau = tableau;
    this.tab = tab;
  }
  
  public void actionPerformed(ActionEvent e) {
    int[] selection = tableau.getSelectedRows();

    for(int i = selection.length - 1; i >= 0; i--){
      tab.removeItem(selection[i]);
    }
  }
}
