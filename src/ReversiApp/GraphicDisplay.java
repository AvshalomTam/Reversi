package ReversiApp;

import Game.Board;
import Game.Coordinates;
import Game.Display;

import java.util.ArrayList;
import java.util.Scanner;

public class GraphicDisplay implements Display {
    private ReversiBoard controll_board;

    public GraphicDisplay(ReversiBoard controller) {
        this.controll_board = controller;
    }

    @Override
    public void printCurrentBoard(Board board) {
        this.controll_board.printBoard();
    }

    @Override
    public void printPreviousMove(String name, String coordinate) {

    }

    @Override
    public void printTurn(String name) {

    }

    @Override
    public void printNoMove() {

    }

    @Override
    public void printOptions(ArrayList<Coordinates> options) {

    }

    @Override
    public void printMoveRequest() {

    }

    @Override
    public void printInputError(String error) {

    }

    @Override
    public void printResult(String name) {

    }

    @Override
    public String input() {
        /*Coordinates input = this.controll_board.getClick();
        return input.move(new Coordinates(-1, -1)).toString();*/
        return null;
    }
}
