package Controller;

import Models.Blocks.ForestBlock;
import Models.Players.Board;
import View.MenuPanel;

import java.awt.*;

public class Merge {
    MenuPanel menuPanel ;
    Board board ;
public Merge(MenuPanel menuPanel) {
    this.menuPanel = menuPanel;
    board = new Board();
}
    public void test() {
board.run();
        for (int i = 0; i < 12 ; i++) {
            for (int j = 0; j < 12; j++) {
                if(board.blocks[i][j] instanceof ForestBlock){
                    menuPanel.button[i][j].setBackground(Color.GREEN);
                }
            }

        }
    }
}
