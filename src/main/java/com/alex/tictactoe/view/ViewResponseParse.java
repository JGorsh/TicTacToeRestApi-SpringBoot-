package com.alex.tictactoe.view;

import com.alex.tictactoe.model.Model;
import com.alex.tictactoe.model.Player;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ViewResponseParse {

    private List<char[][]> board;
    private Player winnerPlay;

    public ViewResponseParse() {

        this.board = GameBoard.list;
        this.winnerPlay = Model.winnerPlay;

    }

}
