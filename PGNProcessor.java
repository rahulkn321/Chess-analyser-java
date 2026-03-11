package chessanalyser;

import com.github.bhlangonijr.chesslib.Board;

//import javafx.scene.control.ProgressBar;

public class PGNProcessor {

    public static void processMoves(String moves) throws Exception {

        Board board = new Board();
        
//        ProgressBarUI evalbar = new ProgressBarUI();
        
        String whitePlayer = "";
        String blackPlayer = "";

        if (moves.contains("[White")) {
            whitePlayer = moves.split("\\[White \"")[1].split("\"\\]")[0];
        }

        if (moves.contains("[Black")) {
            blackPlayer = moves.split("\\[Black \"")[1].split("\"\\]")[0];
        }
             
        moves = moves.replaceAll("(?s)\\[.*?\\]", "");
        String clean = moves.replaceAll("\\d+\\.", "");
        clean = clean.replace("1-0", "");
		clean = clean.replace("0-1", "");
		clean = clean.replace("1/2-1/2", "");
		
        String[] moveList = clean.trim().split("\\s+");
        
        StockfishEngine engine= new StockfishEngine();
        
        engine.startEngine();
        

        double preveval=0;
        int i=1;
        for (String move : moveList) {

        	String classify="";
        	
            board.doMove(move);

            String fen = board.getFen();
            
            double evaluation = engine.evaluatePosition(fen);
            String bestmove = engine.bestmove(fen);

             
            double drop=0;
            if(i%2!=0) {
            	drop = preveval- evaluation;
                }
                else {
                drop = evaluation - preveval;
                }
//            System.out.println("preveval:"+preveval);
            preveval=evaluation;
            
            if(drop<=0 && drop>=-1) {
            	classify="Best*";
            }
            
            else if(drop>0 && drop<=0.2) {
            	classify="Excellent!!";
            }
            
            else if(drop>0.2 && drop<=0.5) {
            	classify="Good!";
            }
            
            else if(drop>0.5 && drop<=1.0) {
            	classify="Inaccuracy?!";
            }
            
            else if(drop>1.0 && drop<=2.5) {
            	classify="Mistake?";
            }
            
            else if(drop>2.5) {
            	classify="Blunder??";
            }
            
            else if(drop<-1) {
            	classify="Great!!!";
            }
            System.out.println("drop:"+drop);
    
            
            if(i%2!=0) {
                System.out.println((i++)+". "+"White:"+whitePlayer);
                }
                else {
                System.out.println((i++)+". "+"Black:"+blackPlayer);
                }
                System.out.println("Move: " + move);
                System.out.println("FEN: " + fen);
                System.out.println("Evaluation: " + evaluation);
            
            
            
//            System.out.println("evalution:"+evaluation);
            
            System.out.println("Classification: "+classify);
            
            System.out.println("BestMove:"+bestmove);

            System.out.println();
        }
    }
}
