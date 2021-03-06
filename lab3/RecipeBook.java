import java.util.ArrayList;

public class RecipeBook{

    private ArrayList<CookingRecipe> recipes;
    private String name;
    
    
    public RecipeBook(String bookName){
	this.name = bookName;
	recipes = new ArrayList<CookingRecipe>();
    }

    public CookingRecipe addRecipe(String name, RecipeIngredient[] ingredients){
	if (getRecipe(name) == null){
	    return null;
	}
	else{
	    CookingRecipe newRecipe = new CookingRecipe(name);
	    for (RecipeIngredient i: ingredients){
		newRecipe.addOrUpdateRecipeIngredient(i, i.getQuantity());
	    }
	    recipes.add(newRecipe);
	    return newRecipe;
	}
    }

    public CookingRecipe getRecipe(String recipeName){
	for (CookingRecipe recipe: recipes){
	    if (recipe.getName().equals(recipeName)){
		return recipe;
	    }
	}
	return null;
    }

    public CookingRecipe removeRecipe(String name){
	CookingRecipe recipe = getRecipe(name);
	recipes.remove(recipe);
	return recipe;
    }

    public CookingRecipe[] findRecipes(RecipeIngredient[] ingredients){
	ArrayList<CookingRecipe> matchingRecipes = new ArrayList<CookingRecipe>();
	boolean hasIngredients=true;
	for (CookingRecipe recipe: recipes){
	    for (RecipeIngredient i: ingredients){
		hasIngredients = hasIngredients && recipe.getRecipeIngredient(i) != null;
	    }
	    if (hasIngredients){
		matchingRecipes.add(recipe);
	    }
	}
	if (matchingRecipes.size()>0){
	    return (CookingRecipe[])matchingRecipes.toArray();
	}
	else{
	    return null;
	}
    }

    public CookingRecipe[] findRecipesWithFewIngredients(int numberOfIngredients){
	ArrayList<CookingRecipe> matchingRecipes = new ArrayList<CookingRecipe>();
	for (CookingRecipe recipe: recipes){
	    if (recipe.getNumberOfIngredients() < numberOfIngredients){
		matchingRecipes.add(recipe);
	    }
	}
	if (matchingRecipes.size()>0){
	    return (CookingRecipe[])matchingRecipes.toArray();
	}
	else{
	    return null;
	}
    }

    public CookingRecipe[] findRecipesLowCalories(){
	ArrayList<CookingRecipe> matchingRecipes = new ArrayList<CookingRecipe>();
	float lowestCalories, currentCalories;
	if (recipes.size()>0){
	    lowestCalories = recipes.get(0).calculateCalories();
	    for (CookingRecipe recipe: recipes){
		currentCalories = recipe.calculateCalories();
		if (currentCalories < lowestCalories){
		    matchingRecipes.clear();
		    matchingRecipes.add(recipe);
		    lowestCalories = currentCalories;
		}
		else if (currentCalories == lowestCalories){
		    matchingRecipes.add(recipe);
		}
	    }
	    if (matchingRecipes.size()>0){
		return (CookingRecipe[])matchingRecipes.toArray();
	    }
	}
	return null;
    }

    public String toString(){
	String str = name;
	for (CookingRecipe r : recipes){
	    str+="\n"+r.toString()+"\n";
	}
	return str;
    }
}
