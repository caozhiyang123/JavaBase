package com.base.java.serializable;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class Order implements Serializable {
  private int id;
  private transient List<Item> items = new ArrayList<Item>();

  public Order(int id) {
    this.id = id;
  }

  public void addItem(Item i) {
    items.add(i);
  }

  public void getItem(int i) {
    items.get(i);
  }
  
  private void writeObject(ObjectOutputStream s) throws Exception{
	  s.defaultWriteObject();
	  s.writeInt(items.size());
	  for (Item item : items) {
		s.writeObject(item.getTitle());
	}
  }
  
  private void readObject(ObjectInputStream s)throws Exception{
	  s.defaultReadObject();
	  int size = s.readInt();
	  items = new ArrayList<Item>(size);
	  for (int i = 0; i < size; i++) {
		items.add(new Item(s.readObject().toString()));
	}
  }

@Override
public String toString() {
	return "Order [id=" + id + ", items=" + items + "]";
}
}