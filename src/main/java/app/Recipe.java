package app;

import java.util.List;

public class Recipe {
	
	private String id;
	private String title;
	private String category;
	private List ingredients;
	private String recipe;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public List getIngredients() {
		return ingredients;
	}
	public void setIngredients(List ingredients) {
		this.ingredients = ingredients;
	}
	public String getRecipe() {
		return recipe;
	}
	public void setRecipe(String recipe) {
		this.recipe = recipe;
	}
}
