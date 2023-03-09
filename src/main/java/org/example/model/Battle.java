package org.example.model;

public class Battle {

    private Pokemon pokemonFromTrainer;
    private WildPokemon wildPokemon;
    private String battleReport;
    private PokeWinner winnerPokemon;

    public Battle(Pokemon pokemonFromTrainer, WildPokemon wildPokemon){
        this.pokemonFromTrainer = pokemonFromTrainer;
        this.wildPokemon = wildPokemon;
        battleReport = "";
    }

    public String letsBattle(){
        startBattle();
        return battleReport;
    }
    private void startBattle(){
        battleReport += ("Rozpoczela się walka pomiedzy twoim "+pokemonFromTrainer.getName()+" a dzikim "+ wildPokemon.getName()+" !\n");
        Pokemon pokemonFromTrainerTemp = new Pokemon(pokemonFromTrainer);
        WildPokemon wildPokemonTemp = new WildPokemon(wildPokemon);
        duringBattle(pokemonFromTrainerTemp,wildPokemonTemp);
        pokemonFromTrainer.setHitPoint(pokemonFromTrainerTemp.getHitPoint());
        endBattle();
    }

    private void duringBattle(Pokemon pokeTr, WildPokemon pokeWild){
        for(int i=1;i<=10;i++){
            battleReport += ("Runda "+i+"\n");
            battleReport += ("   "+pokeTr.getName()+": "+pokeTr.getHitPoint()+" zdrowia\n");
            battleReport += ("   "+pokeWild.getName()+": "+pokeWild.getHitPoint()+" zdrowia\n");
            for(int j = 0;j<(pokeTr.getNumberOfAttack()+pokeWild.getNumberOfAttack());j++){
                if(pokeTr.getInitiative()>pokeWild.getInitiative()){ // atak pokemona gracza (wieksza inicjawtywa)
                    battleReport += ("      Twoj "+pokeTr.getName()+" zaatakował wrogiego "+pokeWild.getName()+" za "+pokeWild.takeHit(pokeTr.getAttack())+" obrazen.\n");
                    pokeTr.slowAfterAttack();
                    if(pokeWild.checkIfDefeated()){
                        winnerPokemon = PokeWinner.TRAINERS_POKEMON;
                        battleReport += ("      Dziki "+pokeWild.getName()+" zostal pokonany.\n");
                        return;
                    }
                } else if (pokeTr.getInitiative()==pokeWild.getInitiative()) {
                    if (pokeTr.getNumberOfAttack()>=pokeWild.getNumberOfAttack()){ // atak pokemona gracza (rowna inicjatywa ale wieksza badz rowna ilosc atakow)
                        battleReport += ("      Twoj "+pokeTr.getName()+" zaatakował wrogiego "+pokeWild.getName()+" za "+pokeWild.takeHit(pokeTr.getAttack())+" obrazen.\n");
                        pokeTr.slowAfterAttack();
                        if(pokeWild.checkIfDefeated()){
                            winnerPokemon = PokeWinner.TRAINERS_POKEMON;
                            battleReport += ("      Dziki "+pokeWild.getName()+" zostal pokonany.\n");
                            return;
                        }
                    } else { // atak dzikiego pokemona (rowna inicjawtywa i mniej atakow na runde)
                        battleReport += ("      Wrogi "+pokeWild.getName()+" zaatakowal twojego "+pokeTr.getName()+" za "+pokemonFromTrainer.takeHit(pokeWild.getAttack())+" obrazen.\n");
                        pokeWild.slowAfterAttack();
                        if(pokeTr.checkIfDefeated()){
                            winnerPokemon = PokeWinner.WILD_POKEMON;
                            battleReport += ("      Twoj "+pokeTr.getName()+" zostal pokonany.\n");
                            return;
                        }
                    }
                }
                else { // atak dzikiego pokemona(mniejsza inicjatywa)
                    battleReport += ("      Wrogi "+pokeWild.getName()+" zaatakowal twojego "+pokeTr.getName()+" za "+pokemonFromTrainer.takeHit(pokeWild.getAttack())+" obrazen.\n");
                    pokeWild.slowAfterAttack();
                    if(pokeTr.checkIfDefeated()){
                        winnerPokemon = PokeWinner.WILD_POKEMON;
                        battleReport += ("      Twoj "+pokeTr.getName()+" zostal pokonany.\n");
                        return;
                    }
                }
            }
//    End of round
            pokeTr.setInitiative(pokemonFromTrainer.getInitiative());
            pokeWild.setInitiative(wildPokemon.getInitiative());
        }
// End of battle
        winnerPokemon = PokeWinner.DRAW;
    }

    private void endBattle(){
        if (winnerPokemon.equals(PokeWinner.TRAINERS_POKEMON)) {
            battleReport += ("Twoj pokemon pokonal dzikiego " + wildPokemon.getName() + ".");
        } else if (winnerPokemon.equals(PokeWinner.WILD_POKEMON)) {
            battleReport += ("Twoj pokemon został pokonany przez dzikiego " + wildPokemon.getName() + ".");
        }else {
            battleReport += ("Walka zakonczyla sie remisem.");
        }
    }
    private enum PokeWinner{
        TRAINERS_POKEMON, WILD_POKEMON, DRAW
    }
}
