package fr.istic.gli.tp.modele;

import java.util.List;

public interface IModel {
  /**
   * Liste d'item
   * @param item
   */
  public void addItem(Item i);
  public void removeItem(Item i);
  public List<Item> getListItem();
  
  /**
   * Titre
   * @param titre
   */
  public void setTitre(String titre);
  public String getTitre();
  
  public int getBudget();
}
