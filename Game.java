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
       printPuzzleData();
       printPlayers();

       for (int i = 0; i < numPuzzlesToSolve; i++)
       {
           Puzzle p = getPuzzleToSolve();
           
           for (int j = 0; j < players.length; j++)
           {
               if (!p.solved)
               {
                   solvePuzzle(p, players[j]);
               }
           }
       }
   }
   
   public void solvePuzzle(Puzzle puzzle, Player player)
   {
       System.out.println("Asking player (" + player.name + ") to spin or solve the puzzle: " + puzzle.toString());
       player.spinOrSolve(puzzle);
   }
   
   public Puzzle getPuzzleToSolve()
   {
       int randomCategory = getRandomCategory();
       Puzzle p = getRandomPuzzle(randomCategory);
       
       System.out.println(p.toString());
       return p;
   }
   
   public Puzzle getRandomPuzzle(int category)
   {
       int randomPuzzleNumber = 0;
       
       switch(category)
       {
        case 1: 
            randomPuzzleNumber = Tester.randomNumber(0, 5);
            break;
        case 2: 
            randomPuzzleNumber = Tester.randomNumber(6, 10);
            break;
        case 3: 
            randomPuzzleNumber = Tester.randomNumber(11, 15);
            break;
        case 4: 
            randomPuzzleNumber = Tester.randomNumber(16, 20);
            break;
        case 5: 
            randomPuzzleNumber = Tester.randomNumber(21, 25);
            break;
       }
       
       return puzzles[randomPuzzleNumber];
   }
   
   public int getRandomCategory()
   {
       int categoryNumber = Tester.randomNumber(5);
       System.out.println("Random category for this game: " + categoryNumber);
       
       return categoryNumber;
   }
   public void printPuzzleData()
   {
       System.out.println(" ");
       System.out.println("Puzzles loaded from file: ");
       for (int i = 0; i < puzzles.length; i++)
       {
           System.out.println("Phrase " + i + ": " + puzzles[i].phrase + ", Category: " + puzzles[i].category);
       }
       System.out.println(" ");
   }
   
   public void printPlayers()
   {
       System.out.println(" ");
       System.out.println("Players: ");
       for (int i = 0; i < players.length; i++)
       {
           System.out.println(players[i].name);
       }
       System.out.println(" ");
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
