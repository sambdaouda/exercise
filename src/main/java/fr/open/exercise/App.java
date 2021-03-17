package fr.open.exercise;

import java.util.Timer;

import fr.open.exercise.schedule.ScheduledTask;

/**
 * Classe designant le point d'entrée de l'application
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Timer timer = new Timer();
        ScheduledTask scheduledTask = new ScheduledTask();
        timer.schedule(scheduledTask, 0, 3600000);
    }
}
