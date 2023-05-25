import javax.xml.stream.events.Characters;

public class Mini {

    public static void main(String[] args) throws Exception {
        level();
    }

    public static int Lives(int pos) {
        int lives = 5;
        return lives;
    }

    public static <T> void prt(T stuff) {
        System.out.print(stuff);
    }

    public static void sprite() {

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

    public static void level() {
        
        do {
            int num = GetRandomInt(1, 1000);
            String[] tiles = { " ", "_", ">", "(", ".", ")", "/","+" };
            if (num > 500) { 
                int[][] map = ground();
                display(map, tiles);
            } else {
                int[][] duck = Characters();
                display(duck, tiles);
            }
        } while (1 != 2);

    }

    public static int GetRandomInt(int low, int high) {
        int range = high - low;
        int RandomInt = (int) (range * Math.random() + 1);
        return RandomInt;
    }

  

    public static void display(int[][] map, String[] tiles) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                int tileCode = map[i][j];
                prt(tiles[tileCode]);
                
            }
          
        }
    }
}
