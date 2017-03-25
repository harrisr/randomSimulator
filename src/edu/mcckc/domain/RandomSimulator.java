package edu.mcckc.domain;

import edu.mcckc.gui.AppPanel;
import org.apache.log4j.Logger;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by rharris on 3/25/2017.
 */
public class RandomSimulator
{
    private Random generatorR;
    private SecureRandom generatorS;
    private int runCount;
    private int numberCap;
    private int[] randomAccumulator;

    public enum RandomChooser { Random, SecureRandom, MathRandom};

    public RandomSimulator()
    {
        generatorR = new Random(System.currentTimeMillis());
        generatorS = new SecureRandom();

    }

    public void doSimulation(int runCount, int numberCap, RandomChooser choice)
    {
        Logger.getLogger(RandomSimulator.class.getName()).debug("INSIDE RANDOM SIMULATOR  doSimulation");
        Logger.getLogger(RandomSimulator.class.getName()).debug(String.format("using the %s generator", choice));
        int randomNumber = 0;
        this.runCount = runCount;
        this.numberCap = numberCap;
        randomAccumulator = new int[numberCap];
        for (int i=0; i<runCount; i++)
        {
            switch(choice)
            {
                case Random:
                    randomNumber = generatorR.nextInt(numberCap);
                    break;
                case SecureRandom:
                    randomNumber = generatorS.nextInt(numberCap);
                    break;
                case MathRandom:
                    randomNumber = (int)(Math.random()*numberCap);
                    break;
            }
            randomAccumulator[randomNumber]++;
        }
    }

    public void displayResults()
    {
        Logger.getLogger(RandomSimulator.class.getName()).debug(String.format("INSIDE RANDOM SIMULATOR  displayResults"));
        for (int i=0; i<numberCap; i++)
        {
            Logger.getLogger(RandomSimulator.class.getName()).debug(String.format("%d: %d", i, randomAccumulator[i]));
            System.out.println(String.format("%d: %d", i, randomAccumulator[i]));
        }
        System.out.println("-----");
    }

    public int[] getNumberArray()
    {
        return randomAccumulator;
    }
}
