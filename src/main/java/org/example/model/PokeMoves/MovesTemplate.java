package org.example.model.PokeMoves;

import java.util.Optional;

public class MovesTemplate {
    private String name;
    private int firstMoveRound,secondMoveRound,thirdMoveRound,fourthMoveRound;
    private PokeMoves firstMove,secondMove,thirdMove,fourthMove;

    public MovesTemplate(String name){
        this.name = name;
        firstMoveRound = 0;
        secondMoveRound = 0;
        thirdMoveRound = 0;
        fourthMoveRound = 0;
    }
    public boolean containsKey(int keyToCheck){
        if(firstMoveRound==keyToCheck){
            return true;
        } else if (secondMoveRound==keyToCheck) {
            return true;
        } else if (thirdMoveRound==keyToCheck) {
            return true;
        } else if (fourthMoveRound==keyToCheck) {
            return true;
        }
        return false;
    }
    public Optional<PokeMoves> getMove(int nrOfRound){
        if(firstMoveRound==nrOfRound){
            return Optional.ofNullable(firstMove);
        } else if (secondMoveRound==nrOfRound) {
            return Optional.ofNullable(secondMove);
        } else if (thirdMoveRound==nrOfRound) {
            return Optional.ofNullable(thirdMove);
        } else if (fourthMoveRound==nrOfRound) {
            return Optional.ofNullable(fourthMove);
        }
        return Optional.empty();
    }
    public String getName() {
        return name;
    }

    public void addFirstMove(int nrOfRound, PokeMoves pokeMoves){
        firstMoveRound = nrOfRound;
        firstMove = pokeMoves;
    }
    public void addSecondMove(int nrOfRound, PokeMoves pokeMoves){
        secondMoveRound = nrOfRound;
        secondMove = pokeMoves;
    }
    public void addThirdMove(int nrOfRound, PokeMoves pokeMoves){
        thirdMoveRound = nrOfRound;
        thirdMove = pokeMoves;
    }
    public void addFourthMove(int nrOfRound, PokeMoves pokeMoves){
        fourthMoveRound = nrOfRound;
        fourthMove = pokeMoves;
    }
}
