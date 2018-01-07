package org.usfirst.frc.team5892.HEROcode.logging;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * A simple logging implementation that outputs to a file on the RoboRIO. Retrieve the log using an SSH application such as PuTTY.
 * I have yet to figure out where the file will be (because I am a lazy piece of trash who still has not tested this after how many months) but will add that asap.
 * Based on <a href="http://www.vogella.com/tutorials/Logging/article.html">http://www.vogella.com/tutorials/Logging/article.html</a>.
 * <br><br>
 * Note that as of now, it is still completely untested and I have no excuse.
 * @author Kai Page
 * 
 */
// TODO test it????????
public class RIOLogger {
    private FileHandler file;
    private SimpleFormatter format;
    
    private Logger logger;
    
    private String name;
    private Level level;
    
    private boolean isSetUp = false;
    
    /**
     * @param name The internal name of the logger. Log entries will be made at name.txt.
     * @param level The maximum level of severity for the logger. Attempts to log something below the current maximum will silently fail.
     */
    public RIOLogger(String name, Level level) {
    	this.name = name;
    	this.level = level;
    }
    
    /**
     * Sets up the logger. This should be clear, but other methods won't work until this one has.
     * @throws IOException if the file fails to open or something.
     */
    public void setup() throws IOException {
    	logger = Logger.getLogger(name);
    	logger.setLevel(level);
    	
    	file = new FileHandler(name + ".txt");
    	format = new SimpleFormatter();
    	file.setFormatter(format);
    	logger.addHandler(file);
    	
    	isSetUp = true;
    }
    
    /**
     * If you can't figure out what this does by the name then why are you even using it.
     * @param level The level of severity of your log entry. If it is below the current maximum, the method will silently fail.
     * @param msg What you intend to log in the first place.
     */
    public void log(Level level, String msg) {
    	if (isSetUp) logger.log(level, msg);
    }
    
    /**
     * Sets a new maximum level of severity for the logger. Attempts to log something below the current maximum will silently fail.
     * @param level The new maximum level of severity for the logger.
     */
    public void setLevel(Level level) {
    	this.level = level;
    	if (isSetUp) logger.setLevel(level);
    }
}
