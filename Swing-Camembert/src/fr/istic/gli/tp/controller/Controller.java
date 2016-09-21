package fr.istic.gli.tp.controller;

import fr.istic.gli.tp.vue.Camembert;

public class Controller implements IController{
  private Camembert vue;

  @Override
  public void onPieClick(int i) {
    vue.drawShapeRect(i);
  }

  public void setVue(Camembert vue){
    this.vue = vue;
  }

  @Override
  public void buttonPressed(String string, int num_seg) {
    if(string.equals("gauche")){
      vue.drawShapeRect((num_seg+1)%vue.getListShape().length);
    }
    else if (string.equals("droite")){
      if(num_seg -1 < 0)
        num_seg += vue.getListShape().length;
      vue.drawShapeRect((num_seg-1)%vue.getListShape().length);
    }
  }
}
