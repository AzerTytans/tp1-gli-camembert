package fr.istic.gli.tp.modele;

public class Item {
  private String intitule;
  private String desc;
  private int valeur;
  
  public Item(String intitule, String desc, int valeur) {
    super();
    this.intitule = intitule;
    this.desc = desc;
    this.valeur = valeur;
  }

  public String getIntitule() {
    return intitule;
  }

  public void setIntitule(String intitule) {
    this.intitule = intitule;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public int getValeur() {
    return valeur;
  }

  public void setValeur(int valeur) {
    this.valeur = valeur;
  }
  
  
}
