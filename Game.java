package wheeloffortune;

import java.util.Scanner;

public class Game 
{
    Player[] players;
    Puzzle[] puzzles;

    public Game()
    {
        
    }
    
    public Game(int numberOfPlayers, int numberOfPuzzles)
    {
        setPlayersAndPuzzles(numberOfPlayers, numberOfPuzzles);
        beginGame();
    }
    
    public void setPlayersAndPuzzles(int numberOfPlayers, int numberOfPuzzles)
    {
        players = new Player[numberOfPlayers];
        puzzles = new Puzzle[numberOfPuzzles];
    }
    
    public void beginGame()
    {
        for(int i = 0; i < puzzles.length; i++)
        {
            solveThePuzzle(puzzles[i]);
        }
    }
    
    public void solveThePuzzle(Puzzle p)
    {
        for(int i = 0; i < players.length; i++)
        {
            players[i].spinOrSolve(p);
        }
    }
}
