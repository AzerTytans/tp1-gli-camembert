package fr.istic.gli.tp.vue;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Arc2D;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComponent;

import fr.istic.gli.tp.controller.IController;
import fr.istic.gli.tp.modele.IModel;
import fr.istic.gli.tp.modele.Item;
import fr.istic.gli.tp.observateur.IObservateur;


public class Camembert extends JComponent implements MouseListener, IObservateur, ActionListener{

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  Graphics2D g2d; 
  IModel model;
  IController controller;
  Shape[] shapes;
  Shape whiteshape;
  Color[] color;
  double totale = 0;
  JButton gauche, droite;
  int num_seg = -1;

  public Camembert(IModel im, IController ic, JButton gauche, JButton droite) {
    model = im;
    controller = ic;
    this.gauche = gauche;
    this.droite = droite;

    init();
    initCamembert();

    addMouseListener(this);
    gauche.addActionListener(this);
    droite.addActionListener(this);
  }

  public void init(){
    /**
     * Initialisation
     */
    shapes = new Shape[this.model.getListItem().size()];
    color = new Color[this.model.getListItem().size()];

    Random rand = new Random();
    for(int i = 0 ; i < this.model.getListItem().size(); i++){
      color[i] = new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat());
    }
  };

  public void initCamembert(){

    /**
     * Camembert
     */
    num_seg = -1;
    Arc2D.Float arc = new Arc2D.Float(Arc2D.PIE);
    arc.setFrame(100, 150, 200, 200);


    double total = 0;
    for(Item it : this.model.getListItem()){
      total+=it.getValeur();
    }
    totale = total;

    double currentValue = 0;
    int angleDepart = 0;
    int i = 0;
    for(Item it : this.model.getListItem()){
      angleDepart = (int) (currentValue * 360 / total);
      int arcAngle = (int) (it.getValeur() * 360 / total);

      shapes[i] = new Arc2D.Double(100, 150, 200, 200, angleDepart, arcAngle, Arc2D.PIE);

      currentValue += it.getValeur();
      i++;
    }
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    if(this.model.getListItem().size() != color.length){
      this.init();
    }

    g2d = (Graphics2D) g;

    for(int i = 0 ; i < shapes.length ; i++){
      g.setColor(Color.gray);
      ((Graphics2D) g).draw(shapes[i]);
      g.setColor(color[i]);
      ((Graphics2D) g).fill(shapes[i]);
    }

    // Initialisation du rond budget
    whiteshape = new Arc2D.Double(130, 180, 140, 140, 0, 360, Arc2D.PIE);
    g.setColor(Color.white);
    ((Graphics2D) g).fill(whiteshape);
    g.setColor(Color.white);
    ((Graphics2D) g).draw(whiteshape);

    g.setColor(Color.YELLOW);
    g.fillOval(145, 195, 110, 110);
    g.setColor(Color.gray);
    g.drawOval(145, 195, 110, 110);

    g.setColor(Color.BLACK);
    g.drawString("Budget", 180, 240);
    g.drawString(""+totale, 180, 260);

    if(num_seg != -1){
      g.setColor(Color.YELLOW);
      g.fillRect(20, 20, 360, 85);
      g.setColor(Color.black);
      g.drawRect(20, 20, 360, 85);
      g.drawString("Intitule : ", 25, 35);
      g.drawString(this.model.getListItem().get(num_seg).getIntitule(), 80, 35);
      g.drawString("Descritpion : ", 25, 50);
      g.drawString(this.model.getListItem().get(num_seg).getDesc(), 25, 65);
      g.drawString("Valeur : ", 25, 95);
      g.drawString(String.valueOf(this.model.getListItem().get(num_seg).getValeur()), 75, 95);
    }
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    initCamembert();
    for (int i = 0; i < shapes.length; i++) {
      Shape shape = shapes[i];
      if (shape.contains(e.getPoint()) && !whiteshape.contains(e.getPoint())) {
        controller.onPieClick(i);
        break;
      }
    }   
    repaint();
  }

  public void drawShapeRect(int i) {
    initCamembert();
    Arc2D arc = (Arc2D) shapes[i];
    Arc2D newarc = new Arc2D.Double(75, 125, 250, 250, arc.getAngleStart(), arc.getAngleExtent(), Arc2D.PIE);
    shapes[i] = newarc;
    num_seg = i;
    repaint();
  }

  @Override
  public void mouseEntered(MouseEvent arg0) {
    // TODO Auto-generated method stub

  }

  @Override
  public void mouseExited(MouseEvent arg0) {
    // TODO Auto-generated method stub

  }

  @Override
  public void mousePressed(MouseEvent arg0) {
    // TODO Auto-generated method stub

  }

  @Override
  public void mouseReleased(MouseEvent arg0) {
    // TODO Auto-generated method stub

  }

  @Override
  public void notifier(String action) {
    if (action.equals("all")){
      init();
    }
    initCamembert();
    repaint();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if(num_seg != -1){
      if(e.getSource() == gauche){
        controller.buttonPressed("gauche", num_seg);
      }
      else if(e.getSource() == droite){
        controller.buttonPressed("droite", num_seg);
      }
    }
  }

  public Shape[] getListShape(){
    return this.shapes;
  }
}
