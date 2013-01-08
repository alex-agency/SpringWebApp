package app;

import java.util.HashMap;
import java.util.Map;

public class Recipe {
	
	private Map<String, Object> recipe = new HashMap<String, Object>();	
	
	public static final String ID = new String("id");
	public static final String TITLE = new String("title");
	public static final String CATEGORY = new String("category");
	public static final String INGREDIENTS = new String("ingredients");
	public static final String RECIPE = new String("recipe");
	
	
	public Map<String, Object> getMap() {
		return recipe;
	}
	
	public void setMap(Map<String, Object> recipe) {
		this.recipe = recipe;
	}
}
