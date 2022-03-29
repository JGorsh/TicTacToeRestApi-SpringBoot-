package com.alex.tictactoe.view;

import com.alex.tictactoe.model.Model;
import com.alex.tictactoe.model.Player;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ViewResponse {

    private char[][] boardView;
    private Player winnerPlay;
    private String responseMessage;

    public ViewResponse() {
        this.boardView = Model.boardView;
        this.responseMessage = View.responseMessageView;
        this.winnerPlay = Model.winnerPlay;

    }
}
