package fr.istic.gli.tp.modele;

import java.util.ArrayList;
import java.util.List;

public class Model{
  private String titre;
  private List<Item> lesitems;

  public Model(String titre) {
    super();
    this.titre = titre;
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
 
}
