package com.werner.pojo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Student {
	
	private String name;
	private Address address;
	private String[] books;
	private List<String> hobbies;
	private Map<String, String> card;
	private Set<String> games;
	private Properties properties;
	private String wife;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String[] getBooks() {
		return books;
	}
	public void setBooks(String[] books) {
		this.books = books;
	}
	public List<String> getHobbies() {
		return hobbies;
	}
	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}
	public Map<String, String> getCard() {
		return card;
	}
	public void setCard(Map<String, String> card) {
		this.card = card;
	}
	public Set<String> getGames() {
		return games;
	}
	public void setGames(Set<String> games) {
		this.games = games;
	}
	public Properties getProperties() {
		return properties;
	}
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	public String getWife() {
		return wife;
	}
	public void setWife(String wife) {
		this.wife = wife;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", address=" + address + ", books=" + Arrays.toString(books) + ", hobbies="
				+ hobbies + ", card=" + card + ", games=" + games + ", properties=" + properties + ", wife=" + wife
				+ "]";
	}
	

	
	
	
}
