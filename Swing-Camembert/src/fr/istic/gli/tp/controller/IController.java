package fr.istic.gli.tp.controller;

import fr.istic.gli.tp.vue.Camembert;

public interface IController{

  abstract public void onPieClick(int i);
  abstract public void setVue(Camembert vue);
  public abstract void buttonPressed(String string, int num_seg);
}
