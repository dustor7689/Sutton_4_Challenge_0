package coby.s_game;

import java.util.Scanner;

public class CobyS_Game {

    static Scanner Hue = new Scanner(System.in);
    static Scanner Maze = new Scanner(System.in);
    static String response;
    static String move;
    static String reset;

    public static void main(String[] args) {
        origin();
        game();
    }

    public static void origin() {
        System.out.println("Do you want to play a game?");
        response = Hue.nextLine();
        if (response.contains("y")) {
            System.out.println("Very good.");
        }
        if (response.contains("n")) {
            System.out.println("What a shame...");
        }
    }

    public static void game() {
        System.out.println("You awake in a foggy forest upon a stone slab with a symbol of a sheild and a sword and a key shaped hilt engraved on it. What do you do?" + " Go back to sleep " + "or explore?");
        response = Hue.nextLine();
        if (response.contains("s")) {
            System.out.println("While sleeping you dream of cupcakes, unicorns, and rainbows. You never woke up from the cand filled wonderland...");
            endd();
        }
        if (response.contains("e")) {
            System.out.println("While exploring the forest you notice a two way path. Left or right?");
            response = Hue.nextLine();
            if (response.contains("l")) {
                left();
            }
            if (response.contains("r")) {
                right();
            }
        }
    }

    public static void left() {
        System.out.println("After a while of traveling the pathway you notice a cave blocking your path upon entering you notice a sword with a hilt resembling a key and a note attatched to it." + "Take sword or read note?");
        response = Hue.nextLine();
        if (response.contains("s")) {
            System.out.println("You obtained: The Sword!");
            sword();
        }
        if (response.contains("n")) {
            System.out.println("It reads:'It's dangerous to go alone. Take this! After reading the note you take he take the sword. You obtained: The Sword!");
            sword();
        }
    }

    public static void sword() {
        System.out.println(" A sudden bubbly noise makes you spin around sword in hand only to see a glowing orb that grew in sheer luminescence till it burned the color white into you eyes. Blinking away the spots from your vision you notice the change of scenary. From rock and dirt floors to stone masonry."
                + " There is only one way from here, forward. Atleast till you reached a split in the path forward or right?");
        move = Maze.nextLine();
        int m = 0;
        if (move.contains("f")) {
            System.out.println("You walk forward");
            while (m < 10) {
                System.out.println("some more...");
                System.out.println("While walking forward you hear the sound of screeching stone. Looking behind you you notice a stone wall rushing towards you and it never started loosing its speed. Picking up the pace you rush down the corridor until you hit a dead end. Spinning on your heels you turn to meet the aproaching wall."
                        + "Looking upon your empending doom you notice what seemed to be some form of keyslot about chest high. Stab the wall or get squashed?");
                if (move.contains("w")) {
                    System.out.println("When you stabbed the wall it stopped and a door appeared in its place. The bricks that constructed the wall desolve and you find your eye lids growing heavy. Sleep or sleep? ");
                } else if (move.contains("s")) {
                    doorsw();
                }
            }
        }
    }

    public static void right() {
        System.out.println("As you walk along the pathway you see a brick house to the side of the path. Ignore the house or enter the house");
        response = Hue.nextLine();
        if (response.contains("i")) {
            path();
        }
        if (response.contains("e")) {
            System.out.println("The house seemed to be an abandonded armorer shop. Sadly everything inside is destroyed excluding a sheild. Steal sheild or go back to the path?");
            if (response.contains("p")) {
                path(); //No chance to win this path 
            } else if (response.contains("s")) {
                System.out.println("You obatined: The Sheild!");
                sheildp();
            }
        }
    }

    public static void path() {
        System.out.println("You decide not to steal from the amorer and head back to the path. Without a form of guidance and they growing darkness you are soon lost and without a light. After a while of wandering aimlessly without sight you catch a glimmer of light far off in the distance and run towards it from sheer excitement. Atleast until you fell face first through a hole and into a spike fall trap.");
        endb();
    }

    public static void sheildp() {
        System.out.println(" Sheild in hand you head back to the path and find the already gloomy pathway growing darker by the second. Without a glimmer of hope you throw a fit and swing the sheild wildy barely taking notice of the sheild's shining light when faced towards a specific direction. Without much of a choice of where to go besides roaming the darkness you venture forth with your sheild as your guide and only source of light."
                + "As you followed the sheild's guiding light it begins to increases until it blinds you completely.  ");
        Moaze();
    }

    public static void Moaze() {
        System.out.println("");
        if (move.contains("f")) {
            System.out.println("You walk forward");
            int e = 0;
            while (e < 10) {
                System.out.println("some more...");
                System.out.println("While walking forward you hear the sound of screeching stone. Looking behind you you notice a stone wall rushing towards you and it never started loosing its speed. Picking up the pace you rush down the corridor until you hit a dead end. Spinning on your heels you turn to meet the aproaching wall."
                        + "Looking upon your empending doom you notice what seemed to be some form of shape resembling a sheild about chest high. Hit the wall with the sheild or get squashed?");
                if (move.contains("w")) {
                    System.out.println("When you hit the wall it stopped and a door appeared in its place. You find yourself growing tired. Enter the door or sleep?");
                    if (move.contains("d")) {
                        System.out.println("Deciding that you wanted to not let the door wait you try to open the door but it wont budge. Sighing in frustration you decide to have a nap anyways. When you awake the door is more accepting and opens");
                        doors();
                    }
                    if (move.contains("s")) {
                        System.out.println("Deciding a quick nap wont hurt you quickly pass out. Then you awake rested and ready to open the door.");
                        doors();
                    }
                } else if (move.contains("s")) {
                    ends();
                }
            }
            int ri = 0;
            if (move.contains("r")) {
                while (ri < 10) {
                    System.out.println("Another split left or right?");
                }
                if (move.contains("l")) {
                    System.out.println("Another split forward or right?");

                } else if (move.contains("r")) {
                    System.out.println("Dead end. Turning around you notice the way back is blocked. Sitting down you find yourself waiting for minutes for something to change. The minutes changed to hours, hours to days till you couldn't wait any longer. ");
                    endb();
                }
            }
        }
    }

    public static void doorsw() {
        System.out.println("Upon waking up you notice your are laying on the couch of your house. Before you have the time to form a thought of what is going on a voice eminates from the air.");
        endg();
    }

    public static void doors() {
        System.out.println("Upon walking through the door you notice your are laying on the couch of your house. Before you have the time to form a thought of what is going on a voice eminates from the air.");
        endg();
    }

    public static void ends() {
        System.out.println("The wall squishes you into dust. Bad end. If you want to have another go enter ''restart'' to restart.");

    }

    public static void endd() {
        System.out.println("Good dreams end. If you want to restart enter ''restart''");
        if (move.contains("restart")) {
            game();
        }
    }

    public static void endb() {
        System.out.println("Bad end/Bad fin     If you want to restart enter ''restart''");
        if (move.contains("restart")) {
            game();
        }
    }

    public static void endg() {
        System.out.println(" Congrats, you win!*Insert confetti here*. You truly are the ephitomy of *Insert species name here* and are the pride of *Insert hometown here*. Would you like to start the game over? If you want to restart just type ''restart'.");
        if (move.contains("restart")) {
            game();
        }
    }
}
