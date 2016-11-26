package wheeloffortune;

import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Game 
{
   public Player[] players;
   public Puzzle[] puzzles;
   public ArrayList<Integer> playedPuzzles;
   public Game() { }
   public boolean done;
   public int numPuzzlesToSolve;
   
   public Game(Player[] players, Puzzle[] puzzles) 
   {
       setNumPuzzlesToSolve();
       this.puzzles = puzzles;
       this.players = players;
       done = false;
       
       beginGame();
   }
   
   public void beginGame()
   {
       for (int i = 0; i < numPuzzlesToSolve; i++)
       {
           // TODO:  start with player 0, and continue until the puzzle is solved
       }
   }
   
   public void solveThePuzzle(Puzzle p)
   {
       for(int i = 0; i < players.length; i++)
       {
           players[i].spinOrSolve(p);
       }
   }
   
   public void setNumPuzzlesToSolve()
   {
       this.numPuzzlesToSolve = Tester.getUserInt("Enter the number of puzzles to solve: ");
   }
}
