package fr.istic.gli.tp.modele;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel{
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  /**
   * Parti utilsé pour la JTable
   */
  private final List<Item> items = new ArrayList<Item>();

  private final String[] entetes = {"Intitule", "Description", "Valeur"};
  private IModel model;


  public TableModel(IModel model) {
    super();
    this.model = model;

    for(int i = 0 ; i < this.model.getListItem().size(); i++){
      items.add(this.model.getListItem().get(i));
    }
  }


  @Override
  public int getColumnCount() {
    return entetes.length;
  }

  @Override
  public String getColumnName(int columnIndex) {
    return entetes[columnIndex];
  }

  @Override
  public int getRowCount() {
    return items.size();
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    switch(columnIndex){
      case 0:
        return items.get(rowIndex).getIntitule();
      case 1:
        return items.get(rowIndex).getDesc();
      case 2:
        return items.get(rowIndex).getValeur();
      default:
        return null; //Ne devrait jamais arriver
    }
  }
  
  @Override
  public boolean isCellEditable(int rowIndex, int columnIndex) {
      return true; 
  }
  
  @Override
  public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
      if(aValue != null){
          Item item = items.get(rowIndex);
   
          switch(columnIndex){
              case 0:
                  item.setIntitule((String)aValue);
                  break;
              case 1:
                  item.setDesc((String)aValue);
                  break;
              case 2:
                  item.setValeur(Integer.parseInt((String)aValue));
                  break;
          }
          model.changementTable(item, "update");
      }
  }

  public void addItem(Item i){
    items.add(i);

    fireTableRowsInserted(items.size() -1, items.size() -1);
    model.changementTable(i, "add");
  }

  public void removeItem(int rowIndex) {
    model.changementTable(items.get(rowIndex), "remove");
    items.remove(rowIndex);

    fireTableRowsDeleted(rowIndex, rowIndex);
  }
}
