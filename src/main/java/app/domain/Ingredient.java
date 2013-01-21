package app.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ingredients")
public final class Ingredient {
	
	@Id
	private String id;
	private String name;
	@DBRef
	private List<Recipe> recipes;
	
	public Ingredient(String name, List<Recipe> recipes) {
		this.name = name;
		this.recipes = recipes;
	}
	
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
		return "Ingredient [id=" + id + ", name=" + name + ", recipes="
				+ recipes + "]";
	}
	
}
