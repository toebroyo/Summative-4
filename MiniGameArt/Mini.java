import javax.xml.stream.events.Characters;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;

public class Mini {
    
    public static void main(String[] args) throws Exception {
        String[] tiles = { " ", "_", ">", "(", ".", ")", "/", "+" };
        int[][] map = new int[6][123]; 
        MapGerator(map,tiles);
    }

    public static int Lives(int pos) {
        int lives = 5;
        return lives;
    }

    public static <T> void prt(T stuff) {
        System.out.print(stuff);
    }

    public static void SrtingToInt() {

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

    public static void MapGerator(int[][] map, String[] tiles) throws IOException {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                int tileCode = map[i][j];
                prt(tiles[tileCode]);

            }
            System.out.println();
        }
    }

    public static int GetRandomInt(int low, int high) {
        int range = high - low;
        int RandomInt = (int) (range * Math.random() + 1);
        return RandomInt;
    }

    public static void SpriteMovement(int[][] map, int[][] sprite, boolean IsSprite) {
      if(IsSprite = true){
        for (int i = text.length() - 1; i >= 0; i--) {
            System.out.print(text.charAt(i));
            Thread.sleep(milli);
        }
      }
    }
}
