package fr.istic.gli.tp.modele;

import java.util.ArrayList;
import java.util.List;

public class Model{
  private String titre;
  private int budget;
  private List<Item> lesitems;
  
  public Model(String titre, int budget) {
    super();
    this.titre = titre;
    this.budget = budget;
    lesitems = new ArrayList<Item>();
  }
  
  public void addItem(Item i) {
    lesitems.add(i);
  }

  public void removeItem(Item i) {
    lesitems.remove(i);
  }

  public List<Item> getListItem() {
    return lesitems;
  }

  public void setTitre(String titre) {
    this.titre = titre;
  }

  public String getTitre() {
    return this.titre;
  }
  
  public int getBudget() {
    return this.budget;
  }
}
