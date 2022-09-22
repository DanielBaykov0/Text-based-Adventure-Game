import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // System objects
        Scanner in = new Scanner(System.in);
        Random random = new Random();

        // Game variables
        String[] enemies = {"Skeleton", "Zombie", "Warrior", "Assassin"};
        int maxEnemyHealth = 75;
        int enemyAttackDamage = 25;

        // Played variables
        int health = 100;
        int attackDamage = 35;
        int numHealthPotions = 3;
        int healthPotionHealAmount = 20;
        int healthPotionDropChance = 25; // Percentage

        boolean running = true;

        System.out.println("Welcome to the Dungeon!");

        GAME:
        while (running) {
            System.out.println("----------------------------------------------------------------");

            int enemyHealth = random.nextInt(maxEnemyHealth);
            String enemy = enemies[random.nextInt(enemies.length)];
            System.out.println("\t# " + enemy + " has appeared! #\n");

            while (enemyHealth > 0) {
                System.out.println("\t Your HP: " + health);
                System.out.println("\t " + enemy + "'s HP: " + enemyHealth);
                System.out.println("\n\t What would you like to do ?");
                System.out.println("\t 1. Attack");
                System.out.println("\t 2. Drink health potion");
                System.out.println("\t 3. Run!");

                String input = in.nextLine();
                if (input.equals("1")) {
                    int damageDealt = random.nextInt(attackDamage);
                    int damageTaken = random.nextInt(enemyAttackDamage);

                    enemyHealth -= damageDealt;
                    health -= damageTaken;

                    System.out.println("\t> You strike the " + enemy + " for " + damageDealt + " damage.");
                    System.out.println("\t> You receive " + damageTaken + " in retaliation!");

                    if (health < 1) {
                        System.out.println("\t You have taken too much damage, you are too weak to go on!");
                        break;
                    }

                } else if (input.equals("2")) {
                    if (numHealthPotions > 0) {
                        health += healthPotionHealAmount;
                        numHealthPotions--;
                        System.out.println("\t> You dring a health potion, healing yourself for " + healthPotionHealAmount + "."
                                            + "\n\t> You now have " + health + " HP."
                                            + "\n\t> You have " + numHealthPotions + " health potions left. \n");
                    } else {
                        System.out.println("\t> You have no health potions left! Defeat enemies for a chance to get one! \n");
                    }
                } else if (input.equals("3")) {
                    System.out.println("\t You run away from the " + enemy + "!");
                    continue GAME;
                }else {
                    System.out.println("\t Invalid command!");
                }
            }

            if (health < 1) {
                System.out.println("You limp out of the dungeon, weak from battle.");
                break;
            }

            System.out.println("----------------------------------------------------------------");

            System.out.println(" # " + enemy + " was defeated! #");
            System.out.println(" # You have " + health + " HP left #");

            if (random.nextInt(100) < healthPotionDropChance) {
                numHealthPotions++;
                System.out.println(" # The " + enemy + " dropped a health potion! #");
                System.out.println(" # You now have " + numHealthPotions + " health potion(s). #");
            }

            System.out.println("----------------------------------------------------------------");

            System.out.println("What would you like to do now ?");
            System.out.println("1. Continue fighting!");
            System.out.println("2. Exit dungeon");

            String input = in.nextLine();

            while (!input.equals("1") && !input.equals("2")) {
                System.out.println("Invalid command!");
                input = in.nextLine();
            }

            if (input.equals("1")) {
                System.out.println("You continue on your adventure!");
            } else if (input.equals("2")) {
                System.out.println("You exit the dungeon successful from you adventure!");
                break;
            }
        }

        System.out.println("#######################");
        System.out.println("# THANKS FOR PLAYING! #");
        System.out.println("#######################");
    }
}







































