package com.alex.tictactoe.controller;

import com.alex.tictactoe.model.Adapter;
import com.alex.tictactoe.model.Model;
import com.alex.tictactoe.repository.SaveParseInterface;
import com.alex.tictactoe.repository.SaveParseXML;


public class XMLParser {
    public static void main(String[] args)  {

        SaveParseInterface saveParseXML = new SaveParseXML();
        saveParseXML.parse(Model.url);
        Model.listHandler(Adapter.listHandlerAdapter(Model.stepList));
    }


}
