package com.alex.tictactoe.controller;


import com.alex.tictactoe.model.Model;
import com.alex.tictactoe.repository.ParseHTTP;
import com.alex.tictactoe.repository.SaveParseInterface;

import java.net.MalformedURLException;

public class ParseHTTPController {

    public static void main(String[] args) throws MalformedURLException {

        SaveParseInterface parseHTTP = new ParseHTTP();
        parseHTTP.parse("https://raw.githubusercontent.com/JGorsh/TicTacToe/JsonSaveParse/1%20%D0%B8%202%202022_03_20%20%2016_32_05.json");
        Model.listHandler(Model.stepList);
    }
}
