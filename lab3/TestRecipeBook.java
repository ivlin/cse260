public class TestRecipeBook{

    public static void main(String[]args){
	Ingredient i1 = new Ingredient("Carrots","stalks",20);
	Ingredient i2 = new Ingredient("Bacon","strips",12);
	RecipeIngredient r1 = new RecipeIngredient("Chicken","lbs",30,4);
	CookingRecipe recipe1 = new CookingRecipe("Meat and Stuff");
	recipe1.addOrUpdateRecipeIngredient(i1, 3);
	recipe1.addOrUpdateRecipeIngredient(i2, 4);
	System.out.println(recipe1);
	recipe1.addOrUpdateRecipeIngredient(i1, 5);
	recipe1.addOrUpdateRecipeIngredient(i2, 2);
	recipe1.removeRecipeIngredient(i2);
	System.out.println(recipe1);

	RecipeBook newRecipeBook = new RecipeBook("Food");
	newRecipeBook.addRecipe("Vegetables and Stuff",new RecipeIngredient[]{recipe1.getRecipeIngredient(i1), recipe1.getRecipeIngredient(i2)});
	newRecipeBook.addRecipe("Vegetables and Stuff",new RecipeIngredient[]{recipe1.getRecipeIngredient(i1), recipe1.getRecipeIngredient(i2), r1});
	System.out.println(newRecipeBook);
	System.out.println(newRecipeBook.findRecipes(new RecipeIngredient[]{recipe1.getRecipeIngredient(i1), recipe1.getRecipeIngredient(i2)}));
	System.out.println(newRecipeBook.findRecipes(new RecipeIngredient[]{r1}));
	System.out.println(newRecipeBook.findRecipesWithFewIngredients(2));
	System.out.println(newRecipeBook.findRecipesLowCalories());
    }

}
