import javax.xml.stream.events.Characters;
import java.util.Scanner;

public class Mini {

    public static void main(String[] args) throws Exception {
        String[] tiles = { " ","0" };
        MapGerator(map(), tiles);
        characterGenerate();
        Questions();
    }

    public static int Lives(int pos) {
        int lives = 5;
        return lives;
    }

    public static void PrtColor(String string, int color) {
        String TextColor = "";
        if (color < 0 || color > 7) {
            prt("invalid number");
        } else {
            TextColor = "\u001B[3" + color + "m";
        }
        prt("" + TextColor + "" + string + "\u001B[37m");
    }

    public static void MapGerator(int[][] map, String[] tiles) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                int tileCode = map[i][j];
                if(tileCode == 1 ){
                  prt("\u001B[42m ");  
                } else {
                    prt("\u001B[40m ");
                }
    

            }
            System.out.println();
        }
    }

    public static void characterGenerate() throws InterruptedException {
        int num = 0;
        String[][] Characters = new String[][] {
                { "encounter ", "run Into ", "find ", "come accros ", "meet " },
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

    public static void Questions() throws InterruptedException {
        int num = GetRandomInt(0, 7);
        Scanner sc = new Scanner(System.in);
        String[][] QA = new String[][] {
                {"If you had a triangular sandwich with a height of 6\", and a bace of 3\". what would the area be?","9" },
                {"What does DNA stad for?", "Deoxyribonucleic acid" },
                {"What is the main gas that makes up the Earth's atmosphere?","Nitrogen"},
                {"What was the most profitable movie of all time?","Avatar"},
                {"How may power strokes does a four cycle engine have in one full engine cycle?","1"},
                {"Forward, I am heavy; backward, I am not. What am I?","a ton"},
                {"The more you take, the more you leave behind. What am I?","Footsteps"},
                {"Waht Is your Credit Card Number?"}
        };
        sPrt("" + QA[num][0] + "\n:", 100);
        String awnser = sc.nextLine();
        if(awnser.equalsIgnoreCase(QA[num][1])){
            sPrt("Stuff", 100);
        }
    }

    public static int GetRandomInt(int low, int high) {
        int range = high - low;
        int RandomInt = (int) (range * Math.random());
        return RandomInt;
    }

    public static int[][] map() {
        int[][] map = new int[][] {
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {1,1,1,1,0,1,1,1,1,1,0,0,0,0,0,0,0,1,1,1,0,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,0},
                {0,0,0,1,0,1,1,1,1,1,0,0,0,0,0,0,0,1,0,1,0,1,0,1,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,1,0},
                {0,1,0,1,0,1,1,1,1,1,0,0,0,0,0,0,0,1,0,1,1,1,0,1,0,1,0,1,1,1,0,1,1,1,1,1,1,1,0,1,0,1,0},
                {0,1,0,1,0,1,1,1,1,1,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,1,0,1,0,0,0,1,1,1,1,1,1,1,0,1,0,1,0},
                {0,1,1,1,0,1,1,1,1,1,1,1,0,0,0,0,0,1,1,1,0,0,0,1,1,1,0,1,1,1,0,1,1,1,1,1,1,1,0,1,1,1,0},
                {0,1,0,0,0,1,1,1,1,1,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,1,0,1,1,1,1,1,1,1,0,0,0,1,0},
                {0,1,0,0,0,1,1,1,1,1,0,1,1,1,0,1,1,1,0,1,0,1,1,1,1,1,1,1,0,1,0,1,1,1,1,1,1,1,0,1,1,1,0},
                {0,1,0,0,0,0,0,1,0,0,0,0,0,1,0,1,0,1,0,1,0,1,1,1,1,1,1,1,0,1,0,1,1,1,1,1,1,1,0,1,0,0,0},
                {0,1,0,1,1,1,1,1,0,1,1,1,1,1,0,1,0,1,1,1,0,1,1,1,1,1,1,1,0,1,0,1,1,1,1,1,1,1,0,1,1,1,0},
                {0,1,0,1,1,1,1,1,0,1,0,0,0,0,0,1,0,0,0,0,0,1,1,1,1,1,1,1,0,1,0,0,0,0,0,0,0,1,0,0,0,1,0},
                {0,1,0,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1,1,0,1,1,1,0,0,0,0,0,1,1,1,1,1,0},
                {0,1,0,1,1,1,1,1,0,1,0,0,0,1,0,0,0,1,0,1,0,0,0,1,0,0,0,0,0,1,0,1,0,0,0,0,0,1,1,1,1,1,0},
                {0,1,0,1,1,1,1,1,0,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,0},
                {0,1,0,1,1,1,1,1,0,0,0,1,0,0,0,0,0,0,0,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,0},
                {0,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1,1,0,1,0,1,0,0,0,1,1,1,1,1,0,1,1,1,1,1,0},
                {0,1,0,0,0,0,0,0,0,1,1,1,1,1,1,1,0,0,0,1,1,1,1,1,0,1,0,1,0,0,0,1,1,1,1,1,0,1,1,1,1,1,0},
                {0,1,1,1,1,0,0,0,0,1,1,1,1,1,1,1,0,0,0,1,1,1,1,1,1,1,0,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,0},
                {0,0,0,0,1,0,0,0,0,1,1,1,1,1,1,1,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,1,1,1,1,1,0,0,0,0,0,0,0},
                {0,1,1,1,1,0,0,0,0,1,1,1,1,1,1,1,0,0,0,1,1,1,1,1,1,1,0,1,1,1,0,1,1,1,1,1,1,1,0,0,0,0,0},
                {0,1,0,0,0,0,0,0,0,1,1,1,1,1,1,1,0,0,0,1,1,1,1,1,1,1,0,1,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0},
                {0,1,1,1,1,0,0,0,0,1,1,1,1,1,1,1,0,0,0,1,1,1,1,1,1,1,0,1,0,0,0,1,1,1,1,1,0,1,1,1,1,1,0},
                {0,0,0,0,1,0,0,0,0,1,1,1,1,1,1,1,0,0,0,1,1,1,1,1,1,1,0,1,0,0,0,1,1,1,1,1,0,1,0,0,0,1,0},
                {0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,0,1,0,0,0,1,1,1,1,1,0,1,1,1,1,1,0},
                {0,0,0,0,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1,1,1,1,0,0,0,0,0},
                

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
