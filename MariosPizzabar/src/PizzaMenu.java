import java.util.ArrayList;

public class PizzaMenu {
    ArrayList<Pizza> pizzaMenu = new ArrayList<>();

    public PizzaMenu() {
        // reference menu
        //https://www.colaccio.com/english-menu/
        pizzaMenu.add(new Pizza("Patrick´s heron special", 1, "Puppy eyes, heron meat, a whole kitten and a slice of parrot", 525));
        pizzaMenu.add(new Pizza("Tine special", 2, "Coffee and lots of it!", 65));
        pizzaMenu.add(new Pizza("Venezia", 3, "Salami, Pepper, Onion, Olive", 65));
        pizzaMenu.add(new Pizza("Fungi", 4, "Mushroom", 65));
        pizzaMenu.add(new Pizza("Pompei", 5, "Bacon, onions", 60));
        pizzaMenu.add(new Pizza("Marinara", 6, "Shrimp, Clam", 55));
        pizzaMenu.add(new Pizza("Pescatore", 7, "Salami, Bacon, Egg", 60));
        pizzaMenu.add(new Pizza("Bussola", 8, "Ham, Shrimp", 65));
        pizzaMenu.add(new Pizza("Vegetarian", 9, "Mushroom, Pepper, Onion, Artichole, Olive, Tomato", 75));
        pizzaMenu.add(new Pizza("Natural", 10, "Mushroom, Pepper, Onion, Artichoke, Olive, Pinapple", 80));
        pizzaMenu.add(new Pizza("Vesuvio", 11, "Ham", 55));
        pizzaMenu.add(new Pizza("Havanna", 12, "Shrimp, tuna", 70));
        pizzaMenu.add(new Pizza("Capricciosa", 13, "Ham, Mushroom", 80));
        pizzaMenu.add(new Pizza("Bologenese", 14, "Ground beef, Onion", 70));
        pizzaMenu.add(new Pizza("Calzone", 15, "(baked) Ham", 60));
        pizzaMenu.add(new Pizza("Minnen Athen", 16, "Ground beef, Tomato, Feta cheese", 140));
        pizzaMenu.add(new Pizza("Amore", 17, "Tuna, Mushroom", 120));
        pizzaMenu.add(new Pizza("Napolitana", 18, "Sardine, Olive", 155));
        pizzaMenu.add(new Pizza("Morzzarella", 19, "Mozzarella, Ruccola, Svartpeppar", 110));
        pizzaMenu.add(new Pizza("Colaccio", 20, "Ham, Shrimp, Mushroom", 120));
        pizzaMenu.add(new Pizza("Pepperoni", 21, "Pepperoni sausage, Salami, Olive, Pepper", 150));
        pizzaMenu.add(new Pizza("Tropicana", 22, "Ham, Banana, Pineapple, Curry", 145));
        pizzaMenu.add(new Pizza("Oxfilet Pizza", 23, "Fillet of beef, Mushroom, Tomato, Onions, Bearnaise sauce", 180));
        pizzaMenu.add(new Pizza("Quattro Stagioni", 24, "Ham, Shrimp, Clam, Mushroom, Artichoke, Olive", 120));
        pizzaMenu.add(new Pizza("Gorgonzola", 25, "Ham, Tomato, Gorgonzola", 130));
        pizzaMenu.add(new Pizza("Provencale", 26, "Pork, Mushroom, Garlic, Onion", 115));
        pizzaMenu.add(new Pizza("Mafioso", 27, "Salami, Tomato, Pepperoni, Onion, Cayenne pepper", 110));
        pizzaMenu.add(new Pizza("Pizza Carne", 28, "Ground beef, Pepper, Onion, Egg", 125));
        pizzaMenu.add(new Pizza("Melina", 29, "Mushroom, Tomato, Leek, Olive, Feta cheese", 130));
        pizzaMenu.add(new Pizza("Jens Special", 30, "Ham, Pineapple, Tomato, Cheese, Olive, Chili, Gorgonzola, Banana", 210));
    }

    public ArrayList<Pizza> getPizzaMenu() {
        return pizzaMenu;
    }
}
