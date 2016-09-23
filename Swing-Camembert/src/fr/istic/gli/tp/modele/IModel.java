package fr.istic.gli.tp.modele;

import java.util.List;

import fr.istic.gli.tp.observateur.IObservateur;

public interface IModel{
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

  public void changementTable(Item i, String action);
  
  /**
   * Observateur
   */
  public void ajouterObservateur(IObservateur observateur);
  public void notifierObservateurs(String action);
  public void supprimerObservateur(IObservateur observateur);
}
