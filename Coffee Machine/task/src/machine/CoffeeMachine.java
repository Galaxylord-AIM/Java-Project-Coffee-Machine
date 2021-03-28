package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Machine machine = new Machine(400, 540, 120, 9, 550);
        while (true) {
            machine.actionPerformed();
        }
    }
}

//declaring Machine class
class Machine {

    //declaring the initial values of the ingredients in the machine
    private int water;
    private int milk;
    private int coffeeBeans;
    private int disposableCups;
    private int cashInMachine;
    private String text;

    //Scanner class declaration
    static Scanner scanner = new Scanner(System.in);

    //declaring the main method
    public Machine(int water, int milk, int coffeeBeans, int disposableCups, int cashInMachine) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.disposableCups = disposableCups;
        this.cashInMachine = cashInMachine;
        text = "I have enough resources, making you a coffee!";
    }


    //declaring machineStatus method to show the current status of the machine
    public void machineStatus() {
        System.out.printf("The coffee machine has:%n%d of water%n%d of milk%n%d of coffee beans%n%d of disposable cups%n$%d of money%n",water,milk,coffeeBeans,disposableCups,cashInMachine);
    }

    //declaring actionPerformed method to show the current actions that can be done my the machine
    public void actionPerformed() {
        System.out.println("Write action (buy, fill, take, remaining, exit): ");
        String actionPerformed = scanner.next();
        switch (actionPerformed) {
            case "buy":
                buy();
                break;
            case "fill":
                fill();
                break;
            case "take":
                take();
                break;
            case "remaining":
                machineStatus();
                break;
            case "exit":
                System.exit(0);
                break;
            default:
                System.out.println("invalid input");
        }
    }

    //declaring buy method to allow 'customers' to buy coffees
    public void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String whatToBuy = scanner.next();
        switch (whatToBuy) {
            case "1":
                espresso();
                break;
            case "2":
                latte();
                break;
            case "3":
                cappuccino();
                break;
            case "back":
                actionPerformed();
                break;
            default:
                System.out.println("invalid input");
        }

    }

    //declaring espresso method to allow 'customers' to buy espresso coffees
    public void espresso() {
        String resourceCheckResult  = resourceCheck(250,0,16);
        if (resourceCheckResult.equals("I have enough resources, making you a coffee!")) {
            water -= 250;
            coffeeBeans -= 16;
            cashInMachine += 4;
            disposableCups--;
        }
        System.out.println(resourceCheckResult);
    }

    //declaring latte method to allow 'customers' to buy latte coffees
    public void latte() {
        String resourceCheckResult  = resourceCheck(350,75,20);
        if (resourceCheckResult.equals("I have enough resources, making you a coffee!")) {
            water -= 350;
            milk -= 75;
            coffeeBeans -= 20;
            cashInMachine += 7;
            disposableCups--;
        }
        System.out.println(resourceCheckResult);
    }

    //declaring cappuccino method to allow 'customers' to buy cappuccino coffees
    public void cappuccino() {
        String resourceCheckResult  = resourceCheck(200,100,12);
        if (resourceCheckResult.equals("I have enough resources, making you a coffee!")) {
            water -= 200;
            milk -= 100;
            coffeeBeans -= 12;
            cashInMachine += 6;
            disposableCups--;
        }
        System.out.println(resourceCheckResult);
    }

    //declaring espresso method to allow 'customers' to buy espresso coffees
    public String resourceCheck(int waterNeeded, int milkNeeded, int coffeeBeansNeeded) {
        if (water >= waterNeeded && milk >= milkNeeded && coffeeBeans >= coffeeBeansNeeded){
            text = "I have enough resources, making you a coffee!";
        } else if (water < waterNeeded) {
            text = "Sorry, not enough water!";
        } else if (milk < milkNeeded) {
            text = "Sorry, not enough milk!";
        } else if (coffeeBeans < coffeeBeansNeeded) {
            text = "Sorry, not enough coffee beans!";
        }
        return text;
    }

    //declaring fill method to allow 'special worker' to fill out all the supplies for the coffee machine
    public void fill() {
        //asking the values of the amount of ingredients to be added in the machine
        System.out.println("Write how many ml of water do you want to add: ");
        water += scanner.nextInt(); //ml
        System.out.println("Write how many ml of milk do you want to add: ");
        milk += scanner.nextInt(); //ml
        System.out.println("Write how many ml of coffee beans do you want to add: ");
        coffeeBeans += scanner.nextInt(); //grams
        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        disposableCups += scanner.nextInt();
    }

    //declaring take method to give 'another special worker' all the money that the machine earned from selling coffee
    public void take() {
        System.out.printf("I gave you $%d%n",cashInMachine);
        cashInMachine = 0;
    }
}
