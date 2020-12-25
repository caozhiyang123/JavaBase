package com.base.java.serializable;
final class Item {
  String title;

  public Item(String title) {
    this.title = title;
  }

  String getTitle() {
    return title;
  }

@Override
public String toString() {
	return "Item [title=" + title + "]";
}
}