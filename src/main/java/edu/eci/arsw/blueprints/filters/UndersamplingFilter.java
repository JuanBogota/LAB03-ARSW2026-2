package edu.eci.arsw.blueprints.filters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;

@Component
@Profile("undersampling")
public class UndersamplingFilter implements BlueprintsFilter {

    @Override
    public Blueprint filter(Blueprint blueprint) {
        List<Point> original = blueprint.getPoints();
        List<Point> filtered = new ArrayList<>();

        for (int i = 0; i < original.size(); i++) {
            if (i % 2 == 0) {
                filtered.add(original.get(i));
            }
        }

        Blueprint result = new Blueprint(blueprint.getAuthor(), blueprint.getName(), List.of());
        filtered.forEach(result::addPoint);
        return result;
    }
}