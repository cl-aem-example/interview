package com.claemexample.core.services.impl;

import com.claemexample.core.services.GreetingService;
import org.osgi.service.component.annotations.Component;

/**
 * Implementation of the {@link GreetingService}.
 * Registered as an OSGi component to be available for injection.
 */
@Component(service = GreetingService.class, immediate = true)
public class GreetingServiceImpl implements GreetingService {

    /**
     * {@inheritDoc}
     */
    @Override
    public String getGreeting() {
        return "Hello from the OSGi Service!";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getTodaysDate() {
        return java.time.format.DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy")
                .format(java.time.LocalDate.now());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getReferenceId() {
        return java.util.UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}
