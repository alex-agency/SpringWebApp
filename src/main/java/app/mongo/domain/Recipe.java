package app.mongo.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "recipes")
public class Recipe {

	@Id
	private String id;
	private String title;
	private String category;
	@DBRef
	private List<Ingredient> ingredients;
	private String recipe;
	
	public String getId() {
		return id;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}
	
	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;	
	}
}
