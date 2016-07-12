import foods.*;

public class FoodFactory {

    public static Food create(String food) {
        Food foodToReturn;
        switch (food.trim().toLowerCase()) {
            case "cram":
                foodToReturn = new CramFood();
                break;
            case "apple":
                foodToReturn = new Apple();
                break;
            case "honeycake":
                foodToReturn = new HoneyCake();
                break;
            case "melon":
                foodToReturn = new Melon();
                break;
            case "mushrooms":
                foodToReturn = new Mushroom();
                break;
            case "lembas":
                foodToReturn = new LembasFood();
                break;
            default:
                foodToReturn = new OtherFood();
                break;

        }
        return foodToReturn;
    }
}
