package org.example.model;


import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class PokeMoves implements Serializable {

    private String name;
    private String description;
    private int lvl;
    private PokeType type;
    private int valueOfAttackMove;
    private int valueOfBuffMoves;
    private int valueOfDebuffMoves;
    private String returnMessage;
    private PokeMovesType movesType;
    private PokeMovesScaleType pokeMovesScaleType;
    private PokeMovesBattleFlag pokeMovesBattleFlag;
    private BattleStat statToBuffOrDebuff;

    public PokeMoves(String name,String description, int lvl,PokeType type,int valueOfAttackMove,int valueOfBuffMoves,int valueOfDebuffMoves,PokeMovesType movesType,PokeMovesScaleType pokeMovesScaleType) {
        this.name=name;
        this.description=description;
        setLvl(lvl);
        this.type=type;
        this.valueOfAttackMove=valueOfAttackMove;
        this.valueOfBuffMoves=valueOfBuffMoves;
        this.valueOfDebuffMoves=valueOfDebuffMoves;
        this.movesType=movesType;
        this.pokeMovesScaleType=pokeMovesScaleType;
        this.pokeMovesBattleFlag=PokeMovesBattleFlag.NORMAL;
        this.statToBuffOrDebuff=BattleStat.NONE;
        returnMessage="";
    }
    public PokeMoves(String name,String description, int lvl,PokeType type,int valueOfAttackMove,int valueOfBuffMoves,int valueOfDebuffMoves,PokeMovesType movesType,PokeMovesScaleType pokeMovesScaleType,PokeMovesBattleFlag pokeMovesBattleFlag) {
        this.name=name;
        this.description=description;
        setLvl(lvl);
        this.type=type;
        this.valueOfAttackMove=valueOfAttackMove;
        this.valueOfBuffMoves=valueOfBuffMoves;
        this.valueOfDebuffMoves=valueOfDebuffMoves;
        this.movesType=movesType;
        this.pokeMovesScaleType=pokeMovesScaleType;
        this.pokeMovesBattleFlag=pokeMovesBattleFlag;
        this.statToBuffOrDebuff=BattleStat.NONE;
        returnMessage="";
    }
    public PokeMoves(String name,String description, int lvl,PokeType type,int valueOfAttackMove,int valueOfBuffMoves,int valueOfDebuffMoves,PokeMovesType movesType,PokeMovesScaleType pokeMovesScaleType,PokeMovesBattleFlag pokeMovesBattleFlag,BattleStat statToBuffOrDebuff) {
        this.name=name;
        this.description=description;
        setLvl(lvl);
        this.type=type;
        this.valueOfAttackMove=valueOfAttackMove;
        this.valueOfBuffMoves=valueOfBuffMoves;
        this.valueOfDebuffMoves=valueOfDebuffMoves;
        this.movesType=movesType;
        this.pokeMovesScaleType=pokeMovesScaleType;
        this.pokeMovesBattleFlag=pokeMovesBattleFlag;
        this.statToBuffOrDebuff=statToBuffOrDebuff;
        returnMessage="";
    }

    public PokeMoves(String urlName){
            try {
                ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("C:\\Users\\arti_\\IdeaProjects\\PokeSimulator\\src\\main\\resources\\PokeMoves\\"+urlName));
                PokeMoves pokeMoves = (PokeMoves) inputStream.readObject();
                name=pokeMoves.name;
                description=pokeMoves.description;
                lvl=pokeMoves.lvl;
                type=pokeMoves.type;
                valueOfAttackMove=pokeMoves.valueOfAttackMove;
                valueOfBuffMoves=pokeMoves.valueOfBuffMoves;
                valueOfDebuffMoves=pokeMoves.valueOfDebuffMoves;
                movesType=pokeMoves.movesType;
                pokeMovesScaleType=pokeMoves.pokeMovesScaleType;
                pokeMovesBattleFlag=pokeMoves.pokeMovesBattleFlag;
                statToBuffOrDebuff=pokeMoves.statToBuffOrDebuff;
                returnMessage="";
                inputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    public String doMoves(AbstractPokemon poke1, AbstractPokemon poke2){
        returnMessage += (poke1.getName() + " "+name+"\n");
        if(movesType.equals(PokeMovesType.Attack)) {
            returnMessage += poke2.getName() + " otrzymał " + poke2.takeSpecialHit(valueOfAttackMove) + " obazen\n";
        }
        if(movesType.equals(PokeMovesType.Buff)){
            buffStat(poke1);
        }
        if(movesType.equals(PokeMovesType.Debuff)){
            deBuffStat(poke2);
        }
        return returnMessage;
    }
    private void buffStat(AbstractPokemon poke){
        if(statToBuffOrDebuff.equals(BattleStat.ATTACK)){
            returnMessage+=poke.getName()+" wzmocnił swoj Atak\n";
        } else if (statToBuffOrDebuff.equals(BattleStat.SPECIAL_ATTACK)) {
            returnMessage+=poke.getName()+" wzmocnił swoj Specjal Atak\n";
        } else if (statToBuffOrDebuff.equals(BattleStat.DEFENSE)) {
            returnMessage+=poke.getName()+" wzmocnił swoja Obrone\n";
        } else if (statToBuffOrDebuff.equals(BattleStat.SPECIAL_DEFENSE)) {
            returnMessage+=poke.getName()+" wzmocnił swoja Obrone Specjalna\n";
        }
    }

    private void deBuffStat(AbstractPokemon poke){
        if(statToBuffOrDebuff.equals(BattleStat.ATTACK)){
            returnMessage+="Atak "+poke.getName()+" zostal oslabiony\n";
        } else if (statToBuffOrDebuff.equals(BattleStat.SPECIAL_ATTACK)) {
            returnMessage+="Specjal Atak "+poke.getName()+" zostal oslabiony\n";
        } else if (statToBuffOrDebuff.equals(BattleStat.DEFENSE)) {
            returnMessage+="Obrona "+poke.getName()+" zostala oslabiona\n";
        } else if (statToBuffOrDebuff.equals(BattleStat.SPECIAL_DEFENSE)) {
            returnMessage+="Obrona Specjalna "+poke.getName()+" zostala oslabiona\n";
        }
    }
    private void scale(){

    }

    private void setLvl(int lvl){
        if(lvl>0&&lvl<10){
            this.lvl=lvl;
        } else if (lvl>10) {
            this.lvl=10;
        }else {
            this.lvl=1;
        }

    }

    public int getValueOfAttackMove() {
        return valueOfAttackMove;
    }

    protected void setValueOfAttackMove(int valueOfAttackMove) {
        this.valueOfAttackMove = valueOfAttackMove;
    }

    public String getName(){
        return name;
    }

    public int getLvl() {
        return lvl;
    }
}
