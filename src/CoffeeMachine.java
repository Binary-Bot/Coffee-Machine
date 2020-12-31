import java.util.Scanner;

public class CoffeeMachine {
    final static Scanner scanner = new Scanner(System.in);

    int moneyAmount;
    int waterLevel;
    int milkLevel;
    int gramsAmount;
    int cupsAmount;

    public CoffeeMachine(int water, int milk, int beans, int cups, int dollars){
        waterLevel = water;
        milkLevel = milk;
        gramsAmount = beans;
        cupsAmount = cups;
        moneyAmount = dollars;
    }

    public void fill(){
        System.out.println("Write how many ml of water do you want to add:");
        waterLevel += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        milkLevel += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        gramsAmount += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        cupsAmount += scanner.nextInt();
    }

    public void take(){
        System.out.println("I gave you $" + moneyAmount);
        moneyAmount = 0;
    }

    public void buy(){
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino or back:");
        String option = scanner.next();

        switch (option) {
            case "1":
                if (ingredientsCheck(250, 0, 16, 1)){
                    waterLevel -= 250;
                    gramsAmount -= 16;
                    cupsAmount -= 1;
                    moneyAmount += 4;
                }
                break;

            case "2":
                if (ingredientsCheck(350, 75, 20, 1)){
                    waterLevel -= 350;
                    milkLevel -= 75;
                    gramsAmount -= 20;
                    cupsAmount -= 1;
                    moneyAmount += 7;
                }
                break;

            case "3":
                if (ingredientsCheck(200, 100, 12, 1)){
                    waterLevel -= 200;
                    milkLevel -= 100;
                    gramsAmount -= 12;
                    cupsAmount -= 1;
                    moneyAmount += 6;
                }
                break;

            case "back":
                break;
        }
    }

    public boolean ingredientsCheck(int water, int milk, int beans, int cups){
        if (waterLevel >= water && milkLevel >= milk && gramsAmount >= beans && cupsAmount >= cups){
            System.out.println("I have enough resources, making you a coffee!");
            return true;
        }
        else {
            if (waterLevel < water){ System.out.println("Sorry, not enough water!");}
            else if (milkLevel < milk) { System.out.println("Sorry, not enough milk!");}
            else if (gramsAmount < beans) {System.out.println("Sorry, not enough coffee beans!");}
            else { System.out.println("Sorry, not enough cups!");}
            return false;
        }
    }

    public void status(){
        System.out.println("The coffee machine has:");
        System.out.printf("%d of water\n%d of milk\n%d of coffee beans" +
                "\n%d of disposable cups\n$%d of money\n\n", waterLevel, milkLevel, gramsAmount, cupsAmount, moneyAmount);
    }

    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine(400, 540, 120, 9, 550);
        String action;
        do {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            action = scanner.next();
            switch (action) {
                case "fill":
                    machine.fill();
                    break;
                case "take":
                    machine.take();
                    break;
                case "buy":
                    machine.buy();
                    break;
                case "remaining":
                    machine.status();
                case "exit":
                    break;
                default:
                    System.out.println("Wrong input!");
            }
        } while (!action.equals("exit"));
    }
}
