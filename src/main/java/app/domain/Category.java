package app.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import app.mongo.CascadeSave;

@Document(collection = "categories")
public class Category {
	
	@Id
	private String id;
	private String name;	
	@DBRef
    @CascadeSave
	private Recipe recipe;
	
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
	public Recipe getRecipe() {
		return recipe;
	}
	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", recipe=" + recipe
				+ "]";
	}
	
}
