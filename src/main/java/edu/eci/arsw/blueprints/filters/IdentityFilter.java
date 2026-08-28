package edu.eci.arsw.blueprints.filters;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import edu.eci.arsw.blueprints.model.Blueprint;

@Component
@Primary
@Profile("default")
public class IdentityFilter implements BlueprintsFilter {
    @Override
    public Blueprint filter(Blueprint blueprint) {
        return blueprint;
    }
}