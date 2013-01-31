package app.domain;

import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.hibernate.search.annotations.Indexed;

import app.mongo.CascadeSave;

@Document(collection = "categories")
@Indexed
public class Category {
	
	@Id
	private String id;
	@NotEmpty
	private String name;	
	@DBRef
    @CascadeSave
	private List<Recipe> recipes;
	
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((recipes == null) ? 0 : recipes.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Category)) {
			return false;
		}
		Category other = (Category) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (recipes == null) {
			if (other.recipes != null) {
				return false;
			}
		} else if (!recipes.equals(other.recipes)) {
			return false;
		}
		return true;
	}
}
