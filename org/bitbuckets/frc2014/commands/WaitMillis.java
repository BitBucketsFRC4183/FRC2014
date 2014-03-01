/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bitbuckets.frc2014.commands;

/**
 *
 * @author James Wyeth
 */
public class WaitMillis extends CommandBase {
    /** The time at the beginning of the command. **/
    private long timeInit;
    /** The time to wait for. **/
    private int time;
    
    /**
     * Constructor. Sets the time to wait for.
     * 
     * @param timeMillis  The time to wait.
     */
    public WaitMillis(int timeMillis) {
        time = timeMillis;
    }

    /**
     * Called at the beginning of the command.
     */
    protected void initialize() {
        timeInit = System.currentTimeMillis();
    }

    /**
     * Called continuously while the command is running. Does nothing.
     */
    protected void execute() {
    }

    /**
     * Tells the command whether the tame has passed yet.
     * 
     * @return Whether the time has passed.
     */
    protected boolean isFinished() {
        return System.currentTimeMillis() - timeInit >= time;
    }

    /**
     * Called when <code>isFinished</code> returns false.
     */
    protected void end() {
    }

    /**
     * Called if something else needs the required subsystem. Never called in this command.
     */
    protected void interrupted() {
    }
}