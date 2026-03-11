package chessanalyser;

import java.util.Scanner;

public class ChessAnalyser {
	static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {

    	
        StringBuilder moves = new StringBuilder();

        System.out.println("Paste the Game PGN here to analyse");	

        while (sc.hasNextLine()) {

            String line = sc.nextLine();

            moves.append(line).append("\n");

            if (line.contains("#") || line.contains(" 1-0") || line.contains(" 0-1") || line.contains(" 1/2-1/2")) {
                break;
            }
        }

        String pgn = moves.toString();


        PGNProcessor.processMoves(pgn);
    }
}
