package com.alex.tictactoe.controller;

import com.alex.tictactoe.model.Model;
import com.alex.tictactoe.repository.SaveParseInterface;
import com.alex.tictactoe.repository.SaveParseJSON;


public class JsonParse {
    public static void main(String[] args){

        SaveParseInterface saveParseJSON = new SaveParseJSON();
        saveParseJSON.parse("alexey и nastya 2022_03_20  00_03_46.json");
        Model.listHandler(Model.stepList);
    }
}
