package app.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class IngredientRepository {
	protected static Logger logger = Logger.getLogger(IngredientRepository.class);
	
	private IngredientRepository ingredientRepository;
	
	@Autowired
	public IngredientRepository(IngredientRepository ingredientRepository) {
		this.ingredientRepository = ingredientRepository;
	}
	
}
