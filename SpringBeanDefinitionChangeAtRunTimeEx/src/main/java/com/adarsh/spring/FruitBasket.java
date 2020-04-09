package com.adarsh.spring;

import com.adarsh.spring.bean.Fruit;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class FruitBasket {
	
	private Fruit fruit;
	
	public FruitBasket() {
	}
	
	public Fruit getFruit() {
		return fruit;
	}
	public void setFruit(Fruit fruit) {
		this.fruit = fruit;
	}
}
