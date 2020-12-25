package com.base.java.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		ObjectOutputStream write = null;
		ObjectInputStream read = null;
		try {
			List<Order> orders = new ArrayList<Order>();
			Order order1 = new Order(1);
			order1.addItem(new Item("a"));
			orders.add(order1);
			
			Order order2 = new Order(2);
			order2.addItem(new Item("b"));
			orders.add(order2);
			
			Order order3 = new Order(3);
			order3.addItem(new Item("c"));
			orders.add(order3);
			write = new ObjectOutputStream(new FileOutputStream("output.text"));
			write.writeObject(orders);
			
			read = new ObjectInputStream(new FileInputStream("output.text"));
			List<Order> orders2 = (List<Order>)read.readObject();
			System.out.print(orders2.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				write.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
