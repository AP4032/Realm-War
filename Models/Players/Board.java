package Models.Players;

import Models.Blocks.Blocks;
import Models.Blocks.EmptyBlock;
import Models.Blocks.ForestBlock;
import Models.Structures.TownHall;

import java.util.Random;

public class Board {
   public Blocks[][] blocks = new Blocks[12][12];
   public void run() {
      for (int p = 0; p < 12; p++) {
         for (int j = 0; j < 12; j++) {
            blocks[p][j] = new EmptyBlock();
         }
      }

      Random rand = new Random();
      int temp = rand.nextInt(20,30) ;
      for (int p = 0; p < temp; p++) {
         if(blocks[rand.nextInt(10)][rand.nextInt(10)] instanceof EmptyBlock){
            blocks[rand.nextInt(1,11)][rand.nextInt(1,11)] = new ForestBlock();
            }
         else{ p--;
         }
      }
      }

      //      TownHall townHall1 = new TownHall() ;
//      TownHall townHall2 = new TownHall() ;
//      blocks[0][0].setStructure(townHall1);
//      blocks[9][9].setStructure(townHall2);


   }



