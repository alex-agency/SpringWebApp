package app.domain;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import app.mongo.anotation.CascadeSave;

@Document(collection = "categories")
public class Category {
	
	@Id
	private String id;
	@NotEmpty
	private String name;	
	@DBRef
    @CascadeSave
	private List<Recipe> recipes = new ArrayList<Recipe>();
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}
	
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", recipes=" + recipes
				+ "]";
	}
	
}
