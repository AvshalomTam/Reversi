package Game;

import java.io.*;

public class GameSettings {
    private int board_size;
    private String p1Name;
    private String p2Name;
    private String p_starter;
    private cell starter;

    private static GameSettings ourInstance = new GameSettings();

    public static GameSettings getInstance() {
        return ourInstance;
    }

    /**
     * Initializes all members for the game settings.
     * If the file 'settings.txt' exists, it reads from it the settings.
     * Otherwise it creates a default game, and creates default 'settings.txt'.
     */
    private GameSettings() {
        try {
            FileReader reader = new FileReader("settings.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.startsWith("size")) {
                    this.board_size = Integer.parseInt(line.split(":")[1]);
                }
                if (line.startsWith("color_pl1")) {
                    this.p1Name = line.split(":")[1];
                }
                if (line.startsWith("color_pl2")) {
                    this.p2Name = line.split(":")[1];
                }
                if (line.startsWith("starting")) {
                    this.p_starter = line.split(":")[1];
                    if (this.p_starter.equals("1st Player")) {
                        this.starter = cell.first_player;
                    }
                    else {
                        this.starter = cell.second_player;
                    }
                }
            }
            bufferedReader.close();
        } catch (FileNotFoundException noFile) {
            saveToFile(8, "Black", "White", "1st Player");
        } catch (Exception error) {
            System.out.println(error.getMessage());
            System.exit(0);
        }
    }

    /**
     * Saving the new settings to a file 'settings.txt'.
     * @param size integer, size of board
     * @param p1 String, color for first player
     * @param p2 String, color for second player
     * @param starter String, "1st Player" -> first player starting. "2nd Player" -> second player starting
     */
    public void saveToFile(int size, String p1, String p2, String starter) {
        this.board_size = size;
        this.p1Name = p1;
        this.p2Name = p2;
        this.p_starter = starter;

        if (starter.equals("1st Player")) {
            this.starter = cell.first_player;
        }
        else {
            this.starter = cell.second_player;
        }

        try {
            FileWriter writer = new FileWriter("settings.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write("size:" + size);
            bufferedWriter.newLine();
            bufferedWriter.write("color_pl1:" + p1);
            bufferedWriter.newLine();
            bufferedWriter.write("color_pl2:" + p2);
            bufferedWriter.newLine();
            bufferedWriter.write("starting:" + starter);
            bufferedWriter.close();

        } catch (Exception error) {
            System.out.println(error.getMessage());
            System.exit(0);
        }
    }

    public int getBoardSize() {
        return this.board_size;
    }

    public String getPl1() {
        return this.p1Name;
    }

    public String getPl2() {
        return this.p2Name;
    }

    public String getStarterName() {
        return this.p_starter;
    }

    public cell getStarter() {
        return this.starter;
    }
}
