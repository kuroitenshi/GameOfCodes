package com.misys.gameofcodes.model.bo;

import javax.xml.bind.annotation.XmlRootElement;

import com.misys.gameofcodes.model.Hero;
import com.misys.gameofcodes.model.House;

@XmlRootElement
public class AddHouseHeroes {

	private Hero hero;
	private House house;
	
	public Hero getHero() {
		return hero;
	}
	public void setHero(Hero hero) {
		this.hero = hero;
	}
	public House getHouse() {
		return house;
	}
	public void setHouse(House house) {
		this.house = house;
	}
	
	
}
