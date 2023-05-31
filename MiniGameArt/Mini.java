import javax.xml.stream.events.Characters;
import java.util.Scanner;

public class Mini {

    public static void main(String[] args) throws Exception {
        // Kinda works now!
        playMovement();

    }

    /*
     * TextColor, the returnd color string
     * 
     * @param string, the string to be colored
     * 
     * @param color, number of color you decide
     */
    public static void PrtColor(String string, int color) { // takes a string and adds color to it
        String TextColor = "";
        if (color < 0 || color > 7) {
            prt("invalid number");
        } else {
            TextColor = "\u001B[3" + color + "m";
        }
        prt("" + TextColor + "" + string + "\u001B[37m");
    }

    /*
     * tileCode, is the value of the char at map[][]
     * pram@ xMove, is the x pos of the player sprite
     * pram@ yMove, is the y pos of the player sprite
     * pram@ map, is the map array
     * MapGenarator, prints map and pos of player sprite
     */
    public static void MapGenarator(int[][] map, int yMove, int xMove) throws InterruptedException {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (i == xMove && j == yMove) {
                    map[i][j]++;
                }
                int tileCode = map[i][j];
                if (tileCode == 0) {
                    prt("\u001B[40m ");
                } else if (tileCode == 1) {
                    prt("\u001B[42m ");
                } else if (tileCode == 2) {
                    prt("\u001B[43m ");
                }

            }

            System.out.println("\033[0m");
        }

    }

    /*
     * userInput, userInput
     * xAxis, movement value depending on userinput "x"
     * yAxis, movement value depending on userinput "y"
     * xMove, player movemnt if movecheck = true
     * yMove, player movemnt if movecheck = true
     * xTemp, temp storage of xAxis
     * yTemp, temp storage of yAxis
     * playMovment, takes userinput and turns into playerMovment
     */
    public static void playMovement() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        String userInput = "";
        int xAxis = 1;
        int yAxis = 1;
        int xMove = 0;
        int yMove = 0;
        int xTemp = 0;
        int yTemp = 0;
        int num = 0;
        int life = 5;

        do {
            num = GetRandomInt(0, 50);
            prt("\033[H\033[2J");
            yTemp = yAxis;
            xTemp = xAxis;
            if (userInput.equalsIgnoreCase("d")) {
                yAxis++;
            } else if (userInput.equalsIgnoreCase("a")) {
                yAxis--;
            } else if (userInput.equalsIgnoreCase("s")) {
                xAxis++;
            } else if (userInput.equalsIgnoreCase("w")) {
                xAxis--;
            }
            if (moveCheck(map(), yAxis, xAxis) == true) {
                xMove = xAxis;
                yMove = yAxis;
            } else {
                xAxis = xTemp;
                yAxis = yTemp;
            }
            prt("\033[2J\033[H");
            if (num == 10) {
                Boolean awnser = true;
                prt("\033[H\033[2J");
                characterGenerate();
                awnser = Questions();
                if (awnser = false) {
                    life--;
                }
            }
            prt("\033[2J\033[H");
            MapGenarator(map(), yAxis, xAxis);
            userInput = sc.nextLine();
        } while (life != 0);
    }

    /*
     * int[][] map, is map
     * xAxis, movement value depending on userinput "x"
     * yAxis, movement value depending on userinput "y"
     * maPos, value of map char @ map[xAxis][yAxis]
     * moveCheck, Sees if player is in bounds
     */
    public static boolean moveCheck(int[][] map, int xAxis, int yAxis) {
        int maPos = map[yAxis][xAxis];
        if (maPos == 0) {
            return false;
        } else {
            return true;
        }

    }

    /*
     * Characters, is "random" selcetion of Charters
     * num, is a random int
     * characterGenerate, creates a Charter within the string bounds
     */
    public static void characterGenerate() throws InterruptedException {
        int num = 0;
        String[][] Characters = new String[][] {
                { "encounter ", "run Into ", "find ", "come accros ", "meet ", },
                { "an ", "a ", "a ", "a ", "a ", "a ", "a " },
                { "Ogar ", "Troll ", "Phoenix ", "Unicorn ", "Dragon ", "Werewolf ", "Gnome " },
                { "Tim ", "Kevin ", "Harold ", "Tessa ", "Paige ", "Leah ", "Jasper " },
                { "He ", "He ", "He ", "She ", "She ", "She ", "She ", "He " },
        };
        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                num = GetRandomInt(0, 5);
                sPrt("you " + Characters[0][num], 100);
            } else if (i == 1) {
                num = GetRandomInt(0, 7);
                sPrt("" + Characters[1][num] + Characters[2][num] + "", 100);
            } else if (i == 2) {
                num = GetRandomInt(0, 7);
                sPrt("Named " + Characters[3][num] + Characters[4][num] + "asks you \n", 100);
            }

        }

    }

    /*
     * Questions, asks a random question and checks to see if awnser is correct.
     * QA, the list of Questions and Awnsers
     * awnser, is the user input
     * num, is a random int
     */
    public static boolean Questions() throws InterruptedException {
        int num = GetRandomInt(0, 8);
        Scanner sc = new Scanner(System.in);
        int lives = 0;
        boolean wright = true;
        String[][] QA = new String[][] {
                { "If you had a triangular sandwich with a height of 6\", and a bace of 3\". what would the area be?",
                        "9" },
                { "What does DNA stad for?", "Deoxyribonucleic acid" },
                { "What is the main gas that makes up the Earth's atmosphere?", "Nitrogen" },
                { "What was the most profitable movie of all time?", "Avatar" },
                { "How may power strokes does a four cycle engine have in one full engine cycle?", "1" },
                { "Forward, I am heavy; backward, I am not. What am I?", "a ton" },
                { "The more you take, the more you leave behind. What am I?", "Footsteps" },
                { "Waht Is your Credit Card Number?" }
        };
        sPrt("" + QA[num][0] + "\n:", 100);
        String awnser = sc.nextLine();
        if (awnser.equalsIgnoreCase(QA[num][1])) {
            sPrt("That is correct you may pass", 100);
        } else {
            sPrt("that is incorect lose a life", 100);
             wright = false;
        }
        return wright;
    }

    /*
     * high, Highest int in range
     * low, lowest int in range
     * range, range crated from high and low
     * RandomInt, random number selected baced on range
     * GetRandomInt, gets a random int baced on the given range
     */
    public static int GetRandomInt(int low, int high) {
        int range = high - low;
        int RandomInt = (int) (range * Math.random());
        return RandomInt;
    }

    /*
     * map, is the map
     */
    public static int[][] map() {
        int[][] map = new int[][] {
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                        0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                        1, 1, 1, 1, 1, 1, 0, 1, 0 },
                { 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0,
                        0, 0, 0, 0, 0, 1, 0, 1, 0 },
                { 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1,
                        1, 1, 1, 1, 0, 1, 0, 1, 0 },
                { 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1,
                        1, 1, 1, 1, 0, 1, 0, 1, 0 },
                { 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1,
                        1, 1, 1, 1, 0, 1, 1, 1, 0 },
                { 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1,
                        1, 1, 1, 1, 0, 0, 0, 1, 0 },
                { 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1,
                        1, 1, 1, 1, 0, 1, 1, 1, 0 },
                { 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1,
                        1, 1, 1, 1, 0, 1, 0, 0, 0 },
                { 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1,
                        1, 1, 1, 1, 0, 1, 1, 1, 0 },
                { 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0,
                        0, 0, 0, 1, 0, 0, 0, 1, 0 },
                { 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0,
                        0, 0, 0, 1, 1, 1, 1, 1, 0 },
                { 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0,
                        0, 0, 0, 1, 1, 1, 1, 1, 0 },
                { 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1,
                        1, 1, 0, 1, 1, 1, 1, 1, 0 },
                { 0, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1,
                        1, 1, 0, 1, 1, 1, 1, 1, 0 },
                { 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1,
                        1, 1, 0, 1, 1, 1, 1, 1, 0 },
                { 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1,
                        1, 1, 0, 1, 1, 1, 1, 1, 0 },
                { 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1,
                        1, 1, 1, 1, 1, 1, 1, 1, 0 },
                { 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1,
                        1, 1, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1,
                        1, 1, 1, 1, 0, 0, 0, 0, 0 },
                { 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0,
                        0, 1, 0, 1, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1,
                        1, 1, 0, 1, 1, 1, 1, 1, 0 },
                { 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1,
                        1, 1, 0, 1, 0, 0, 0, 1, 0 },
                { 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1,
                        1, 1, 0, 1, 1, 1, 1, 1, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1,
                        1, 1, 1, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }

        };
        return map;
    }

    public static <T> void prt(T stuff) {
        System.out.print(stuff);
    }

    public static void sPrt(String text, int milli) throws InterruptedException {
        for (int i = 0; i < text.length(); i++) {
            System.out.print(text.charAt(i));
            Thread.sleep(milli);
        }
    }

}
