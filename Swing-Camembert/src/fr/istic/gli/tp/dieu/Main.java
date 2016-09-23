package fr.istic.gli.tp.dieu;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import fr.istic.gli.tp.controller.AddAction;
import fr.istic.gli.tp.controller.Controller;
import fr.istic.gli.tp.controller.IController;
import fr.istic.gli.tp.controller.RemoveAction;
import fr.istic.gli.tp.modele.Adapteur;
import fr.istic.gli.tp.modele.IModel;
import fr.istic.gli.tp.modele.Item;
import fr.istic.gli.tp.modele.Model;
import fr.istic.gli.tp.modele.TableModel;
import fr.istic.gli.tp.vue.Camembert;

public class Main {

  public static void main(String[] args) {
    Item i1 = new Item("Test", "Qualité", 100);
    Item i2 = new Item("Café", "Qualité et Quantité", 1000);
    Item i3 = new Item("Bouffe", "Beaucoup", 1000);
    Item i4 = new Item("Pizza", "Beaucoup", 200);
    Item i5 = new Item("Appartement", "pif", 2900);
    Item i6 = new Item("Internet", "important", 1300);
    Item i7 = new Item("Matériel scolaire", "...", 100);
    Model model = new Model("Sans Titre");
    model.addItem(i1);
    model.addItem(i2);
    model.addItem(i3);
    model.addItem(i4);
    model.addItem(i5);
    model.addItem(i6);
    model.addItem(i7);
    IController icontroller = new Controller();
    IModel imodel = new Adapteur(model);


    JButton gauche = new JButton("<-");
    JButton droite = new JButton("->");
    Camembert vue = new Camembert(imodel, icontroller, gauche, droite);
    icontroller.setVue(vue);
    JFrame jframe = new JFrame(model.getTitre());
    imodel.ajouterObservateur(vue);



    /**
     * JTable
     */
    TableModel tab = new TableModel(imodel);
    JTable tableau = new JTable(tab);
    JScrollPane jscroll = new JScrollPane(tableau);

    JPanel boutons = new JPanel();
    boutons.add(new JButton(new AddAction(tab)));
    boutons.add(new JButton(new RemoveAction(tableau, tab)));



    /**
     * Taille des elements
     */
    gauche.setBounds(10, 200, 50, 50);
    droite.setBounds(340, 200, 50, 50);
    jscroll.setBounds(20, 380, 360, 120);
    boutons.setBounds(130, 500, 130, 80);

    /**
     * Ajout des elements
     */
    jframe.add(gauche);
    jframe.add(boutons);
    jframe.add(jscroll);
    jframe.add(droite);
    jframe.getContentPane().add(vue);
    jframe.setSize(new Dimension(400, 600));
    jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jframe.setResizable(false);
    jframe.setVisible(true);
  }

}
