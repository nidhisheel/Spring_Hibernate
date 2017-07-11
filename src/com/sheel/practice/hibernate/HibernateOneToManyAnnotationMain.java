package com.sheel.practice.hibernate;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HibernateOneToManyAnnotationMain {
	public static void saveCart()
	{
		Cart1 cart = new Cart1();
		cart.setName("MyCart1");
		Items1 item1 = new Items1("I10", 10, 1, cart);
		Items1 item2 = new Items1("I20", 20, 2, cart);
		Set<Items1> itemsSet = new HashSet<Items1>();
		itemsSet.add(item1); itemsSet.add(item2);
		
		cart.setItems1(itemsSet);
		cart.setTotal(10*1 + 20*2);
		
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try{
		//Get Session
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		System.out.println("Session created");
		//start transaction
		tx = session.beginTransaction();
		//Save the Model object
		session.save(cart);
		session.save(item1);
		System.out.println("item1"+ item1.getItemId());
		session.save(item2);
		//Commit transaction
		tx.commit();
		
		Cart1 cart2=(Cart1)session.get(Cart1.class,new Long(13));
		System.out.println("cart2"+cart2.getId());
	Set<Items1> item=cart2.getItems1();
	 System.out.println(item.getClass().getName());
		System.out.println("Cart1 ID="+cart.getId());
		System.out.println("item1 ID="+item1.getId()+", Foreign Key Cart ID="+item1.getCart1().getId());
		System.out.println("item2 ID="+item2.getId()+", Foreign Key Cart ID="+item1.getCart1().getId());
		
		}catch(Exception e){
			System.out.println("Exception occured. "+e.getMessage());
			e.printStackTrace();
		}finally{
			if(!sessionFactory.isClosed()){
				System.out.println("Closing SessionFactory");
				sessionFactory.close();
			}
		}
	
	}
		
	
	
	public static void main(String[] args) {
		saveCart();
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		Cart1 cart1=(Cart1)session.get(Cart1.class, new Long(13));
		System.out.println(cart1.getItems1());

	
	}

}