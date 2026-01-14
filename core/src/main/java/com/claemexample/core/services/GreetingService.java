package com.claemexample.core.services;

/**
 * Service interface for providing greeting-related data.
 * Used to demonstrate OSGi service injection in Sling Models.
 */
public interface GreetingService {

    /**
     * Returns a static greeting message.
     * @return the greeting string
     */
    String getGreeting();

    /**
     * Returns the current date formatted as "Day, dd Month yyyy".
     * @return the formatted date string
     */
    String getTodaysDate();

    /**
     * Returns a unique reference ID for tracking.
     * @return a random reference ID string
     */
    String getReferenceId();
}
