import java.util.ArrayList;

public class CookingRecipe{

    private ArrayList<RecipeIngredient> ingredients;
    private String name;
    
    public CookingRecipe(String name){
	this.name = name;
	ingredients = new ArrayList<RecipeIngredient>();
    }

    public void addOrUpdateRecipeIngredient(Ingredient ingredient, float quantity){
	RecipeIngredient i = getRecipeIngredient(ingredient);
	//System.out.println(i);
	if (i == null){
	    ingredients.add(new RecipeIngredient(ingredient.getName(), ingredient.getMeasuringUnit(), ingredient.getCaloriesPerUnit(), quantity));
	}
	else{
	    i.setQuantity(quantity);
	}
    }

    public RecipeIngredient getRecipeIngredient(Ingredient ingredient){
	for (RecipeIngredient addedIngredient: ingredients){
	    if (addedIngredient.getName().equals(ingredient.getName())){
		return addedIngredient;
	    }
	}
	return null;
    }

    public RecipeIngredient removeRecipeIngredient(Ingredient ingredient){
	RecipeIngredient i = getRecipeIngredient(ingredient);
	ingredients.remove(i);
	return i;
    }

    public float calculateCalories(){
	float totalCalories = 0;
	for (RecipeIngredient i: ingredients){
	    totalCalories+= i.getCaloriesPerUnit() * i.getQuantity();
	}
	return totalCalories;
    }

    public String getName(){
	return name;
    }
    
    public String toString(){
	String recipeString = getName();
	for (RecipeIngredient ingredient: ingredients){
	    recipeString+="\n" + ingredient.getName() + "," + ingredient.getQuantity(); 
	}
	return recipeString+"\n";
    }

    public int getNumberOfIngredients(){
	return ingredients.size();
    }
}
