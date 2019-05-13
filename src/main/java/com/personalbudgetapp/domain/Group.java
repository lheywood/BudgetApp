package com.personalbudgetapp.domain;

import java.util.Set;
import java.util.TreeSet;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity 
@Table(name="groupss")
public class Group implements Comparable<Group>{
	
	private Long id;
	private String name;
	private Budget budget;
	private Set<Category> categories = new TreeSet<>();
	
	
	//Getters&Setters
	@Id @GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@ManyToOne
	public Budget getBudget() {
		return budget;
	}
	public void setBudget(Budget budget) {
		this.budget = budget;
	}
	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER, mappedBy="group")
	public Set<Category> getCategories() {
		return categories;
	}
	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
	@Override
	public int compareTo(Group o) {
		
		int compareTo = 0;
		if (this.getId() != null && o.getId() != null) {
			 compareTo = this.getId().compareTo(o.getId());
			return compareTo;
		}
		return compareTo;
		
	}
	

	

}
