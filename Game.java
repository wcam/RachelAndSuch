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
   public Game() { }
   
   public Game(Player[] players, Puzzle[] puzzles) 
   {
       this.puzzles = puzzles;
       this.players = players;
       
       beginGame();
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
