package fr.istic.gli.tp.controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.istic.gli.tp.modele.Item;
import fr.istic.gli.tp.modele.TableModel;

public class AddAction extends AbstractAction {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private TableModel tab;
  
  public AddAction(TableModel tab) {
    super("Ajouter");
    this.tab = tab;
  }

  public void actionPerformed(ActionEvent e) {
    tab.addItem(new Item("Aucun", "Aucune", 0));
  }

}
