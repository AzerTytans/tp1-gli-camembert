package fr.istic.gli.tp.observateur;

import java.util.ArrayList;
import java.util.List;

public class Observable {
  private List<IObservateur> lesobservateurs;
  
  public Observable(){
    super();
    lesobservateurs = new ArrayList<IObservateur>();
  }
  
  public void notifierObservateurs() {
    for(IObservateur i : lesobservateurs)
      i.notifier();
  }

  public void ajouterObservateur(IObservateur observateur){
    lesobservateurs.add(observateur);
  }

  void supprimerObservateur(IObservateur observateur){ 
    lesobservateurs.remove(observateur);
  }
}
