import java.util.ArrayList;

public class ConsoleDisplay implements Display{


    @Override
    public void printCurrentBoard(Board board) {

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
        return null;
    }

    @Override
    public void printGameName(String name) {

    }

    @Override
    public String getGameName() {
        return null;
    }

    @Override
    public void presentPlayer(String name) {

    }
}

#ifndef ConsoleDisplay_H
        #define ConsoleDisplay_H

        #include <vector>
#include "Display.h"

/**
 * All the prints of the gameflow, using console.
 */
class ConsoleDisplay : public Display {
public:
        /**
         * Prints the current state of board.
         * @param board Board object
         */
        void printCurrentBoard(Board &board);
        /**
         * Prints the previous players move.
         * @param name of player
         * @param coordinate move
         */
        void printPreviousMove(string name, string coordinate);
        /**
         * Prints whos turn it is.
         * @param name of player
         */
        void printTurn(string name);
        /**
         * Prints a message that player has no move.
         */
        void printNoMove();
        /**
         * Prints the options for the player.
         * @param options list of coordinates
         */
        void printOptions(list<Coordinates> &options);
        /**
         * Asking player for a move.
         */
        void printMoveRequest();
        /**
         * Printing an error message in case of wrong input.
         * @param error
         */
        void printInputError(const char* error);
        /**
         * Prints the result of the game.
         * @param name of the winning player
         */
        void printResult(string name = "draw");
        /**
         * Printing an appropiate message.
         */
        void pcCalculating();
        /**
         * Gets an input from a (human) player and returns it as a string.
         * @return string
         */
        string input();
        /**
         * Prints a message to player that he needs to wait for the other player's move.
         */
        void waitingForPlayer();
        /**
         * Prints a message to player he needs to wait untill another player joins the game.
         */
        void waitForOtherPlayerConnect();
        /**
         * Prints a message to player that the server has been disconnected.
         * @param str an appropiate message
         */
        void serverDisconnect(const char *str);
        void printGameName(char* name);
        string getGameName();
        void printNameOccupied();
        void printUnableJoin();
        void pressAnyKey();
        void nonAvailable();
        void presentPlayer(string name);
        };

        #endif //ConsoleDisplay_H

//fhfhfhfhf

        #include <iostream>
#include "../include/ConsoleDisplay.h"

        void ConsoleDisplay::printCurrentBoard(Board &board) {
        cout << endl << "Current board:" << endl << endl;
        board.printBoard();
        cout << endl;
        }

        void ConsoleDisplay::printPreviousMove(string name, string coordinate) {
        cout << name << " played " << coordinate << endl << endl;
        }

        void ConsoleDisplay::printTurn(string name) {
        cout << name <<" it's your turn." << endl;
        }

        void ConsoleDisplay::printNoMove() {
        cout << "No possible moves. Play passes to the other player. Press ENTER to continue." << endl;
        cin.get();
        }

        void ConsoleDisplay::printOptions(list<Coordinates> &options) {
        //printing the player's options
        cout << "Your possible moves: ";
        for (list<Coordinates>::iterator it = options.begin(); it != options.end(); ++it) {
        if (it == options.begin()) {
        cout << it->move(Coordinates(1, 1)).toString();
        }
        else {
        cout << "," << it->move(Coordinates(1, 1)).toString();
        }
        }
        cout << endl;
        }

        void ConsoleDisplay::printMoveRequest() {
        cout << "Please enter your move row,col: ";
        }

        void ConsoleDisplay::printInputError(const char* error) {
        cout << endl << error << endl << endl;
        }

        void ConsoleDisplay::printResult(string name) {
        cout << endl << "G A M E   O V E R" << endl << endl;
        if (!name.compare("draw")) {
        cout << "DRAW GAME !!!!";
        }
        else {
        cout << name << " wins the game.";
        }
        cout << endl << endl;
        }

        void ConsoleDisplay::pcCalculating() {
        cout << "Computer is calculating a move. Press ENTER to continue.";
        cin.get();
        cout << endl;
        }

        string ConsoleDisplay::input() {
        string s;
        cin >> s;
        cin.get();
        return s;
        }

        void ConsoleDisplay::waitingForPlayer() {
        cout << "waiting for other player's move..." << endl << endl;
        }

        void ConsoleDisplay::waitForOtherPlayerConnect() {
        cout << "Waiting for other player to join..." << endl;
        }

        void ConsoleDisplay::serverDisconnect(const char *str) {
        cout << str << endl;
        }

        void ConsoleDisplay::printGameName(char* name) {
        cout << " - " << name << endl;
        }

        void ConsoleDisplay::pressAnyKey() {
        cout << "Press any key (then hit ENTER) to continue." << endl;
        char c;
        cin >> c;
        }

        string ConsoleDisplay::getGameName() {
        cout << "Please enter name of game: ";
        string name;
        cin >> name;
        cout << endl;
        return name;
        }

        void ConsoleDisplay::printNameOccupied() {
        cout << "Name of game already in use." << endl << endl;
        }

        void ConsoleDisplay::printUnableJoin() {
        cout << "Can't join this game." << endl << endl;
        }

        void ConsoleDisplay::nonAvailable() {
        cout << endl << "There are no available games." << endl << endl;
        }

        void ConsoleDisplay::presentPlayer(string name) {
        cout << endl << "\tYou play as " << name << endl;
        }
