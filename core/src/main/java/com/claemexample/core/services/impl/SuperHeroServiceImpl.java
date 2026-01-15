package com.claemexample.core.services.impl;

import com.claemexample.core.services.SuperHeroService;
import org.osgi.service.component.annotations.Component;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Implementation of the {@link SuperHeroService}.
 * Registered as an OSGi component.
 */
@Component(service = SuperHeroService.class, immediate = true)
public class SuperHeroServiceImpl implements SuperHeroService {

    private static final List<String> SUPER_HEROES = Arrays.asList(
            "Superman",
            "Batman",
            "Wonder Woman",
            "Spider-Man",
            "Iron Man",
            "Thor",
            "Hulk",
            "Black Widow",
            "Captain America",
            "Black Panther");

    private final Random random = new Random();

    /**
     * {@inheritDoc}
     */
    @Override
    public String getRandomSuperHeroName() {
        return SUPER_HEROES.get(random.nextInt(SUPER_HEROES.size()));
    }
}
