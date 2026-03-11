# Java Chess Analyzer
A chess game analyzer built in Java that processes PGN games and evaluates moves using the Stockfish engine.

## Features
- PGN game parsing
- Move-by-move analysis
- Integration with Stockfish chess engine

## Project Structure
chessanalyser
- ChessAnalyser.java – Main program that starts the analysis  
- PGNProcessor.java – Parses PGN moves  
- StockfishEngine.java – Communicates with Stockfish engine  

## Requirements
- Java
- Stockfish chess engine
- chesslib library

## Setup
1. Clone or download the repository.
2. Download Stockfish from https://stockfishchess.org/download/
3. Place `stockfish.exe` in the project directory.
4. Compile and run the Java files.

## Future Improvements
- Move accuracy calculation
- Evaluation bar
- Graph of move quality
- JavaFX graphical interface
- Game statistics and blunder detection

## Credits
This project uses the chesslib Java library for chess board representation and move generation.

chesslib repository: https://github.com/bhlangonijr/chesslib  
License: Apache License 2.0

## Author
Rahul K
