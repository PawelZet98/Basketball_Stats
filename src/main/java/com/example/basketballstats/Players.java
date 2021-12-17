package com.example.basketballstats;

public class Players
{
    private String name;
    private String surname;
    private int number;
    private int points;
    private int rebounds;
    private int assists;
    private int steals;
    private int blocks;
    private int missTwo;
    private int missThree;
    private int missOne;
    private int turnovers;
    private int madeOne;
    private int madeTwo;
    private int madeThree;


    public Players(String name, String surname, int number, int points, int rebounds,
                   int assists, int steals, int blocks, int missTwo, int missThree,
             int missOne, int turnovers, int madeOne, int madeTwo, int madeThree)
    {
        this.name = name;
        this.surname = surname;
        this.number = number;
        this.points = points;
        this.rebounds = rebounds;
        this.assists = assists;
        this.steals = steals;
        this.blocks = blocks;
        this.missTwo = missTwo;
        this.missThree = missThree;
        this.missOne = missOne;
        this.turnovers = turnovers;
        this.madeOne = madeOne;
        this.madeTwo = madeTwo;
        this.madeThree = madeThree;
    }




    public int getAssists() {
        return assists;
    }

    public int getSteals() {
        return steals;
    }

    public int getBlocks() {
        return blocks;
    }

    public int getMissTwo() {
        return missTwo;
    }

    public int getMissThree() {
        return missThree;
    }

    public int getMissOne() {
        return missOne;
    }

    public int getTurnovers() {
        return turnovers;
    }

    public int getMadeOne() {
        return madeOne;
    }

    public int getMadeTwo() {
        return madeTwo;
    }

    public int getMadeThree() {
        return madeThree;
    }

    public String getName()
    {
        return name;
    }

    public String getSurname()
    {
        return surname;
    }

    public int getNumber()
    {
        return number;
    }

    public int getPoints()
    {
        return points;
    }

    public int getRebounds() { return rebounds; }

}
