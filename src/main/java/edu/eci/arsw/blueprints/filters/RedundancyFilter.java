package edu.eci.arsw.blueprints.filters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;

@Component
@Profile("redundancy")
public class RedundancyFilter implements BlueprintsFilter {

    @Override
    public Blueprint filter(Blueprint blueprint) {
        List<Point> original = blueprint.getPoints();
        List<Point> filtered = new ArrayList<>();

        for (int i = 0; i < original.size(); i++) {
            Point current = original.get(i);
            if (i == 0 || !current.equals(original.get(i - 1))) {
                filtered.add(current);
            }
        }

        Blueprint result = new Blueprint(blueprint.getAuthor(), blueprint.getName(), List.of());
        filtered.forEach(result::addPoint);
        return result;
    }
}