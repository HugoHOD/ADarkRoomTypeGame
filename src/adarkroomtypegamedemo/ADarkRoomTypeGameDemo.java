//This is a demo that will be continually worked on over the next few months
package adarkroomtypegamedemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ADarkRoomTypeGameDemo {

    static Scanner input = new Scanner(System.in);
    static Random rand = new Random();
    public static int charLevel = 1; //up to 99, determines how stats increase among other things
    public static int experiencePoints = 0; //up to ???, determines when level ups occur
    public static int healthPoints = 0; //up to 9999, determines amount of health 
    public static int magicPoints = 0; //up to 999, determines amount of magic allowed to be used 
    public static int strength = 0; //up to 150, determines the amount of physical damage the character does
    public static int defence = 0; //up to 150, determines how much damage an incoming attack will do to the character
    public static int magic = 0; //up to 150, determines the amount of magic damage the character does
    public static int accuracy = 0; //up to 100, determines whether the character hits the opponent
    public static int evasion = 0; //up to 80, determines whether the opponet hits the character or the character dodges
    public static int luck = 0; //up to 50, determines critical hits, helps increase evasion and accuracy and other perks
    public static String playerWeapon = ""; //used for certain situations where the weapon needs to be announced in-game
    public static int enemyHealth = 0; //determines the health of the enemy
    public static boolean anyTech = false; //if there are any techs avaliable
    public static boolean anySpell = false; //if there are any spells avaliable
    public static boolean ifGuard = false; //if the player is guarding
    public static ArrayList<String> techniques = new ArrayList<>(); //list of techniques
    public static ArrayList<String> spells = new ArrayList<>(); //list of spells
    public static ArrayList<String> inventory = new ArrayList<>();
    public static boolean bossBattleIndi = false; //determines if the current battle is a boss battle and therefore, if the player can flee

    public static void baseSwordStats(String weapon) { //the glass cannon
        healthPoints = 400;
        magicPoints = 30;
        strength = 20;
        defence = 10;
        magic = 5;
        accuracy = 65;
        evasion = 10;
        luck = 3;
        playerWeapon = "sword";

    }

    public static void baseShieldStats(String weapon) { //the best offence is a good defense
        healthPoints = 600;
        magicPoints = 20;
        strength = 15;
        defence = 20;
        magic = 5;
        accuracy = 65;
        evasion = 5;
        luck = 3;
        playerWeapon = "shield";

    }

    public static void baseStaffStats(String weapon) { //the one pretentious friend in your friend group that always wants to be the mage because they think they know the meta of the game and that the mage is actually the strongest class in the game and brings it up whenever we play any class-based games when in fact, jacob, you're a prick and none of us like you
        healthPoints = 350;
        magicPoints = 50;
        strength = 10;
        defence = 10;
        magic = 30;
        accuracy = 65;
        evasion = 8;
        luck = 3;
        playerWeapon = "staff";

    }

    public static void baseSpoonStats(String weapon) { //when an invalid input is used for the intro choice
        healthPoints = 400;
        magicPoints = 20;
        strength = 5;
        defence = 5;
        magic = 5;
        accuracy = 90;
        evasion = 5;
        luck = 20;
        playerWeapon = "spoon";
    }

    public static int physicalDamage() { //calculates how much the attack input will damage for
        int baseDamage = (strength + ((strength + charLevel) / 32) * ((strength * charLevel) / 32));
        int maxDamage = ((312 * baseDamage) / (100));
        int randDamage = rand.nextInt(225);
        int actualDamage = (maxDamage * (3841 + randDamage) / 4096);
        return actualDamage;
    }

    public static void playersTurn() throws InterruptedException { //what happens on the players turn
        boolean continuedTurn = true;
        while (continuedTurn = true) {
            ifGuard = false;
            System.out.println("\nAttack");
            System.out.println("Techniques");
            System.out.println("Spells");
            System.out.println("Guard");
            System.out.println("Items");
            System.out.println("Run");
            String playersChoice = input.next();
            if (playersChoice.equalsIgnoreCase("attack")) {
                continuedTurn = false;
                System.out.println("You attack the enemy");
                int attackDamage = physicalDamage();
                System.out.println(attackDamage + " HP dealt!");
                enemyHealth = enemyHealth - attackDamage;
                return;

            }
            if (playersChoice.equalsIgnoreCase("techniques") || (playersChoice.equalsIgnoreCase("technique")) || (playersChoice.equalsIgnoreCase("techs")) || (playersChoice.equalsIgnoreCase("tech"))) {
                if (techniques.isEmpty()) {
                    System.out.println("You don't have any techniques unlocked yet!");
                }

                //if (anyTech = true) {
                //System.out.println(techniques);
                //System.out.println("Type 'back' to exit the menu");
                //String techChoice = input.next();
                //figure this out fully later, when all techs have been figured out
                //}
            }
            if (playersChoice.equalsIgnoreCase("spells") || (playersChoice.equalsIgnoreCase("spell"))) {
                if (spells.isEmpty()) {
                    System.out.println("You don't have any spells avaliable");
                }
                
                //if (anySpell = true) {
                //System.out.println(spells);
                //System.out.println("Type 'back' to exit the menu");
                //String spellChoice = input.next();
                //figure this out fully later, when all magic has been figured out

            }

            if (playersChoice.equalsIgnoreCase("guard")) {
                System.out.println("Guarding!");
                ifGuard = true;
                return;
            }
            if (playersChoice.equalsIgnoreCase("items")) {
                if (inventory.isEmpty()) {
                    System.out.println("You have no items");
                }
                if (!inventory.isEmpty()) {
                    for (int i=0; i<inventory.size(); i++) {
                        System.out.println(inventory.get(i).toString());
                    } 
                        
                }
            
                //System.out.println(inventory);
                //figure this out fully later
            }
            if (playersChoice.equalsIgnoreCase("run")) {
                if (bossBattleIndi = true) {
                    System.out.println("You cannot run from this one!");
                }
                if (bossBattleIndi = false) {
                    System.out.println("Trying to flee...");
                    int randFlee = rand.nextInt(40);
                    int fullRandFlee = randFlee + (luck / 3);
                    if (fullRandFlee >= 25) {
                        System.out.println("You have escaped!");
                        continuedTurn = false;
                        return;
                    }
                    if (fullRandFlee < 25) {
                        System.out.println("Escape attempt failed!");
                        continuedTurn = false;
                        return;
                    }
                }

            }
        }

    }

    public static void tutorialBeastsMove() throws InterruptedException {
        int beastsMove = rand.nextInt(5);
        if ((beastsMove == 0) || (beastsMove == 1) || (beastsMove == 2)) {
            System.out.println("The beast swings it's arm at you!");
            TimeUnit.MILLISECONDS.sleep(750);
            int armSwing = rand.nextInt((50 - 20) + 1) + 20;
            if (ifGuard == true) {
                armSwing = armSwing / 2;
            }
            System.out.println(armSwing + " HP dealt!");
            TimeUnit.MILLISECONDS.sleep(750);
            healthPoints = healthPoints - armSwing;
            return;
        }
        if (beastsMove == 3) {
            System.out.println("The beast uses Demi!");
            TimeUnit.MILLISECONDS.sleep(750);
            System.out.println(healthPoints / 4 + " HP dealt!");
            TimeUnit.MILLISECONDS.sleep(750);
            healthPoints = healthPoints / 4;
            return;
        }
        if (beastsMove == 4) {
            System.out.println("The beast summons shadows!");
            int shadowOne = rand.nextInt(10);
            int shadowTwo = rand.nextInt(10);
            int shadowThree = rand.nextInt(10);
            int shadowFour = rand.nextInt(10);
            int shadowFive = rand.nextInt(25);
            int shadowFinal = shadowOne + shadowTwo + shadowThree + shadowFour + shadowFive;
            if (ifGuard = false) {
                System.out.println(shadowOne + " HP dealt!");
                TimeUnit.MILLISECONDS.sleep(250);
                System.out.println(shadowTwo + " HP dealt!");
                TimeUnit.MILLISECONDS.sleep(250);
                System.out.println(shadowThree + " HP dealt!");
                TimeUnit.MILLISECONDS.sleep(250);
                System.out.println(shadowFour + " HP dealt!");
                TimeUnit.MILLISECONDS.sleep(250);
                System.out.println(shadowFive + " HP dealt!");
                TimeUnit.MILLISECONDS.sleep(750);
                healthPoints = healthPoints - shadowFinal;
            }
            if (ifGuard = true) {
                System.out.println(shadowOne / 2 + " HP dealt!");
                TimeUnit.MILLISECONDS.sleep(250);
                System.out.println(shadowTwo / 2 + " HP dealt!");
                TimeUnit.MILLISECONDS.sleep(250);
                System.out.println(shadowThree / 2 + " HP dealt!");
                TimeUnit.MILLISECONDS.sleep(250);
                System.out.println(shadowFour / 2 + " HP dealt!");
                TimeUnit.MILLISECONDS.sleep(250);
                System.out.println(shadowFive / 2 + " HP dealt!");
                TimeUnit.MILLISECONDS.sleep(750);
                shadowFinal = shadowFinal / 2;
                healthPoints = healthPoints - shadowFinal;
            }
            return;

        }
    }

    public static void death() {
        System.out.println("\nYou become too weak to continue\nYou fall to the ground and your eyes become too heavy to keep open\nIt feels as if all your efforts have amounted to nothing");
        System.out.println("Game Over.");
        System.exit(0);
    }

    public static void tutorialInBattle() throws InterruptedException {
        System.out.println("\nA large, menacing creature of a shape and size you cannot comprehend stands before you");
        TimeUnit.MILLISECONDS.sleep(1500);
        System.out.print("!");
        TimeUnit.MILLISECONDS.sleep(950);
        System.out.print("!");
        TimeUnit.MILLISECONDS.sleep(950);
        System.out.println("!");
        TimeUnit.MILLISECONDS.sleep(1500);
        System.out.println("Ready your weapon!\n");
        TimeUnit.MILLISECONDS.sleep(300);
        System.out.println("Attack");
        System.out.println("Techniques");
        System.out.println("Spells");
        System.out.println("Guard");
        System.out.println("Items");
        System.out.println("Run");
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("\nWhen a battle is started, some menu choices will appear:\n");
        TimeUnit.MILLISECONDS.sleep(1700);
        System.out.println("Attack allows you to damage the enemy with physical damage");
        TimeUnit.MILLISECONDS.sleep(1750);
        System.out.println("Techniques are special physical attacks that do extra damage but they cost MP to use");
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("Spells lets you use magical attacks to damage the opponent (or benefit yourself!) but they cost MP to use");
        TimeUnit.MILLISECONDS.sleep(2200);
        System.out.println("Guard reduces the amount of damage the next enemy attack will do, but it uses your turn");
        TimeUnit.MILLISECONDS.sleep(2100);
        System.out.println("Items lets you use special items that can benefit you or damage/disadvantage your opponent");
        TimeUnit.MILLISECONDS.sleep(2100);
        System.out.println("Run allows you to run away from the battle (You cannot run from boss fights)\n");
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("Whilst inside a menu, type 'back' to exit the current selection you're in");
        TimeUnit.MILLISECONDS.sleep(1800);
        boolean compliance = false;
        enemyHealth = 250;
        while (compliance == false) {
            System.out.println("Try attacking the beast! (Use the command!)");
            String tutorialAttack = input.next();
            if (tutorialAttack.equalsIgnoreCase("Attack")) {
                int playerDamage = physicalDamage();
                System.out.println(playerDamage + " HP dealt!");
                TimeUnit.MILLISECONDS.sleep(500);
                enemyHealth = enemyHealth - playerDamage;
                compliance = true;
            }

        }
        tutorialBeastsMove();
        System.out.println("Now, defeat the beast!");
        TimeUnit.MILLISECONDS.sleep(1000);
        while (healthPoints > 0 && enemyHealth > 0) {
            playersTurn();

            if (healthPoints <= 0) {
                death();
            }
            if (enemyHealth <= 0) {
                System.out.println("\nThe beast creates an unholy noise as it kneels to the ground in pain\nIt fades from existence, as if it never existed...");
                System.out.println("The beast dropped a key");
                return;
            }

            tutorialBeastsMove();

            if (healthPoints <= 0) {
                death();
            }
            if (enemyHealth <= 0) {
                System.out.print("!");
                TimeUnit.MILLISECONDS.sleep(950);
                System.out.print("!");
                TimeUnit.MILLISECONDS.sleep(950);
                System.out.print("!");
                TimeUnit.MILLISECONDS.sleep(1000);
                System.out.println("\nThe beast creates an unholy noise as it kneels to the ground in pain\nIt fades from existence, as if it never existed...");
                TimeUnit.MILLISECONDS.sleep(2000);
                System.out.println("The beast dropped a key! Added to your inventory.");
                return;
            }

        }

    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Welcome");
        TimeUnit.MILLISECONDS.sleep(1250);
        System.out.println("Press any key to start");
        String start = input.next();
        System.out.println("Enter your name: ");
        String playerName = input.next();
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("\nYou awake in a heavenly space");
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println("You know nought of this dimension or your purpose here");
        TimeUnit.MILLISECONDS.sleep(1500);
        System.out.println("You have no recollection of entering");
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println("By an other-wordly aura that you cannot comprehend, three weapons are presented to you");
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("A sword");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("A shield");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("A staff");
        TimeUnit.MILLISECONDS.sleep(1500);
        System.out.println("You feel inclined to choose one");
        String weaponChoice = input.next();

        if (weaponChoice.equalsIgnoreCase("sword") || (weaponChoice.equalsIgnoreCase("a sword"))) {
            baseSwordStats(weaponChoice);
            TimeUnit.MILLISECONDS.sleep(1000);
            System.out.println("\nYou reach down and take the sword from it's stand, it fits perfectly in your hand\nThe stand disappears as if it never existed");
            TimeUnit.MILLISECONDS.sleep(3000);
        } else if (weaponChoice.equalsIgnoreCase("shield") || (weaponChoice.equalsIgnoreCase("a shield"))) {
            baseShieldStats(weaponChoice);
            TimeUnit.MILLISECONDS.sleep(1000);
            System.out.println("\nYou reach down and take the shield from it's stand, it fits perfectly on your arm\nThe stand disappears as if it never existed");
            TimeUnit.MILLISECONDS.sleep(3000);
        } else if (weaponChoice.equalsIgnoreCase("staff") || (weaponChoice.equalsIgnoreCase("a staff"))) {
            baseStaffStats(weaponChoice);
            TimeUnit.MILLISECONDS.sleep(1000);
            System.out.println("\nYou reach down and take the staff from it's stand, it fits perfectly in your hand\nThe stand disappears as if it never existed");
            TimeUnit.MILLISECONDS.sleep(3000);
        } else {
            baseSpoonStats(weaponChoice);
            TimeUnit.MILLISECONDS.sleep(1000);
            System.out.println("You don't trust the options given to you\nIn rebellion, you search for other options\nYou reach into your pocket and develop....a spoon?");
            TimeUnit.MILLISECONDS.sleep(3000);
        }

        System.out.println("\nA striking pain afflicts you in your forehead");
        TimeUnit.MILLISECONDS.sleep(1500);
        System.out.println("You sink to the floor in agony as confusion fills your mind");
        TimeUnit.MILLISECONDS.sleep(1500);
        System.out.println("The arena where you once stood had become blindingly white");
        TimeUnit.MILLISECONDS.sleep(1500);
        System.out.println("You seem to stand on a marble stage");
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println("You muster the strength to stand up");
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println("You hear a voice that seems to have no origin");
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println("\"Defend yourself\"");
        TimeUnit.MILLISECONDS.sleep(750);
        tutorialInBattle();

        System.out.println("\nYou put your " + playerWeapon + " down after your first fight, relived, yet tired");
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("You notice a bright light coming from your pockets, it's the key! But now its glowing a hot red in your palm");
        TimeUnit.MILLISECONDS.sleep(2500);
        System.out.println("Suddenly, the key vanished in your fingers and the dimention around you started to crack like ice");
        TimeUnit.MILLISECONDS.sleep(2200);
        System.out.println("It's like you're being sucked through a vaccum, you can't feel your face");
        TimeUnit.MILLISECONDS.sleep(2000);
    }

}
