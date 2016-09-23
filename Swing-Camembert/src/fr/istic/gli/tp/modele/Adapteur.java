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
    this.notifierObservateurs("all");
  }

  @Override
  public void removeItem(Item i) {
    model.removeItem(i);
    this.notifierObservateurs("all");
  }

  @Override
  public List<Item> getListItem() {
    return model.getListItem();
  }

  @Override
  public void setTitre(String titre) {
    model.setTitre(titre);
    this.notifierObservateurs("all");
  }

  @Override
  public String getTitre() {
    return model.getTitre();
  }

  @Override
  public void changementTable(Item i, String action){
    if(action.equals("remove")){
      model.removeItem(i);
      this.notifierObservateurs("all");
    }
    else if (action.equals("add")){
      model.addItem(i);
      this.notifierObservateurs("all");
    }
    else if (action.equals("update"))
      this.notifierObservateurs("");

  }

}
