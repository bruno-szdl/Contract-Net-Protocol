package agents;

import java.util.Random;

public class Foods {
    private int maxValue;
    private int minValue;
    private String food;
    private static int nFood=10;

    Foods(){
        Random rand = new Random();
        int n = rand.nextInt(10);

        //Define the food
        switch(n){
            case 0:
                this.food = "pizza";
                this.minValue = 20;
                this.maxValue = 100;
                break;
            case 1:
                this.food = "hamburger";
                this.minValue = 10;
                this.maxValue = 50;
                break;
            case 2:
                this.food = "burrito";
                this.minValue = 18;
                this.maxValue = 50;
                break;
            case 3:
                this.food = "pastel";
                this.minValue = 5;
                this.maxValue = 35;
                break;
            case 4:
                this.food = "pasta";
                this.minValue = 20;
                this.maxValue = 140;
                break;
            case 5:
                this.food = "sushi";
                this.minValue = 70;
                this.maxValue = 200;
                break;
            case 6:
                this.food = "seafood";
                this.minValue = 20;
                this.maxValue = 120;
                break;
            case 7:
                this.food = "hotdog";
                this.minValue = 8;
                this.maxValue = 30;
                break;
            case 8:
                this.food = "salad";
                this.minValue = 15;
                this.maxValue = 40;
                break;
            case 9:
                this.food = "sfiha";
                this.minValue = 20;
                this.maxValue = 40;
                break;
        }
    }

    public String getFood(){
        return this.food;
    }

    public int getPrice(){
        Random rand = new Random();
        return (this.minValue + (int)((this.maxValue - this.minValue) * rand.nextFloat())); 
    }

    public int getTime(){
        // Random rand = new Random();
        // return (int)(this.workTime + 10 * rand.nextFloat()); 
        return 1;
    }

    public static int nFoods(){
        return nFood;
    }

    public static String num2food(int i){
        String f = "";
        //Define the restaurant's food
        switch(i){
            case 0:
                f = "pizza";
                break;
            case 1:
                f = "hamburger";
                break;
            case 2:
                f = "burrito";
                break;
            case 3:
                f = "pastel";
                break;
            case 4:
                f = "pasta";
                break;
            case 5:
                f = "sushi";
                break;
            case 6:
                f = "seafood";
                break;
            case 7:
                f = "hotdog";
                break;
            case 8:
                f = "salad";
                break;
            case 9:
                f =  "sfiha";
                break;
        }
        return f;
    }

}