package com.alex.tictactoe.controller;


import com.alex.tictactoe.model.*;
import com.alex.tictactoe.repository.SaveParseJSON;
import com.alex.tictactoe.view.GameBoard;
import com.alex.tictactoe.view.View;
import com.alex.tictactoe.view.ViewResponse;
import org.springframework.web.bind.annotation.*;
import java.util.*;


@RestController
public class RestApiController {

    GamePlay gameplay = new GamePlay();
    Step step = new Step();


    @RequestMapping(value = "/gameplay", method = RequestMethod.GET)
    public String getGameplay (){

        return "Введите в Body request (/gameplay/onePlayer), (/gameplay/twoPlayer) id, name, symbol игроков в JSON формате ";
    }

    @RequestMapping(value = "/gameplay/onePlayer", method = RequestMethod.POST)
    public List<Player> getOnePlayer (@RequestBody Player player){
        Model.onePlay = player;
        gameplay.getPlayers().add(Model.onePlay);
        Model.firstPlayer =  Model.onePlay.getName();
        return gameplay.getPlayers();
    }

    @RequestMapping(value = "/gameplay/twoPlayer", method = RequestMethod.POST)
    public List<Player> getTwoPlayer (@RequestBody Player player){
        Model.twoPlay = player;
        gameplay.getPlayers().add(Model.twoPlay);
        Model.secondPlayer =  Model.twoPlay.getName();
        return gameplay.getPlayers();
    }

    @RequestMapping(value = "/gameplay/game", method = RequestMethod.GET)
    public char[][] getGame (){
        return Model.boardView;
    }

    @RequestMapping(value = "/gameplay/game/{currentPlayer}/{position}", method = RequestMethod.GET)
    public ViewResponse getGamePosition (@PathVariable String currentPlayer, @PathVariable int position){

        if (currentPlayer.equals(Model.firstPlayer)){
             step = new Step(Model.onePlay,position);
        }
        else if (currentPlayer.equals(Model.secondPlayer)){
             step = new Step(Model.twoPlay, position);
        }

        Model.stepList.add(step);
        Model.choicePosition(Model.boardView, position, currentPlayer);
        Model.moveList.add(position);
        SaveParseJSON saveParseJSON = new SaveParseJSON();

        if (Model.checkProgress('X')) {
            Model.winner = Model.firstPlayer;
            Model.winnerPlay = Model.onePlay;
            saveParseJSON.save();
            View.responseMessageView = "Победил первый игрок! Результаты игры сохранены!";
        }

        if (Model.checkProgress('0')) {
            Model.winner = Model.secondPlayer;
            Model.winnerPlay = Model.twoPlay;
            saveParseJSON.save();
            View.responseMessageView = "Победил второй игрок! Результаты игры сохранены!";
        }

        if (Model.moveList.size() == 9) {
            Model.winner = "Ничья!";
            Model.winnerPlay = null;
            saveParseJSON.save();
            View.responseMessageView = "Ничья! Результаты игры сохранены!";
        }

        ViewResponse view = new ViewResponse();
        return view;
    }

    @RequestMapping(value = "/gameplay/init", method = RequestMethod.GET)
    public String initGame () {
        Model.initBoard();
        gameplay= new GamePlay();
        Model.winnerPlay = null;
        View.responseMessageView = "Продолжаем игру!";
        return "Можно начать новую игру!";
    }

}
