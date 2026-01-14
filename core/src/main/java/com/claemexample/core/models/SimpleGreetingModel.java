package com.claemexample.core.models;

import com.claemexample.core.services.GreetingServices;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;

/**
 * Sling Model for the Simple Greeting Component.
 * Adapts the resource and provides data for the HTL script.
 */
@Model(adaptables = Resource.class)
public class SimpleGreetingModel {

    @OSGiService
    private GreetingService greetingService;

    /**
     * The name property from the component's dialog.
     * Defaults to "World" if not specified.
     */
    @ValueMapValue
    @Default(values = "World")
    private String name;

    private String message;
    private String date;
    private String referenceId;

    /**
     * PostConstruct initialization method.
     * Combines data from the OSGi service and the JCR property to prepare model fields.
     */
    @PostConstruct
    protected void init() {
        message = greetingService.getGreeting() + " Special hello to " + name + "!";
        date = greetingService.getTodaysDate();
        referenceId = greetingService.getReferenceId();
    }

    public String getMessage() {
        return message;
    }

    public String getDate() {
        return date;
    }

    public String getReferenceId() {
        return referenceId;
    }
}
