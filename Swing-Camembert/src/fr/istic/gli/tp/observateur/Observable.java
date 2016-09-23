package fr.istic.gli.tp.observateur;

import java.util.ArrayList;
import java.util.List;

public class Observable {
  private List<IObservateur> lesobservateurs;
  
  public Observable(){
    super();
    lesobservateurs = new ArrayList<IObservateur>();
  }
  
  public void notifierObservateurs(String action) {
    for(IObservateur i : lesobservateurs)
      i.notifier(action);
  }

  public void ajouterObservateur(IObservateur observateur){
    lesobservateurs.add(observateur);
  }

  public void supprimerObservateur(IObservateur observateur){ 
    lesobservateurs.remove(observateur);
  }
}
