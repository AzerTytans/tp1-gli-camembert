package fr.istic.gli.tp.modele;

import java.util.List;

import fr.istic.gli.tp.observateur.Observable;

public class Adapteur extends Observable implements IModel{
  private Model model;
  
  public Adapteur(Model model) {
    super();
    this.model = model;
  }

  @Override
  public void addItem(Item i) {
    model.addItem(i);
    this.notifierObservateurs();
  }

  @Override
  public void removeItem(Item i) {
   model.removeItem(i);
   this.notifierObservateurs();
  }

  @Override
  public List<Item> getListItem() {
    return model.getListItem();
  }

  @Override
  public void setTitre(String titre) {
    model.setTitre(titre);
    this.notifierObservateurs();
  }

  @Override
  public String getTitre() {
    return model.getTitre();
  }

  @Override
  public int getBudget() {
    return model.getBudget();
  }

}
