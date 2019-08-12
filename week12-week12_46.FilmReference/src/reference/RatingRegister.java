package reference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

public class RatingRegister {

    private Map<Film, List<Rating>> register;
    private Map<Person, Map<Film, Rating>> personalRatings;

    public RatingRegister() {
        register = new HashMap<Film, List<Rating>>();
        personalRatings = new HashMap<Person, Map<Film, Rating>>();
    }

    public void addRating(Film film, Rating rating) {
        if (!register.containsKey(film)) {
            register.put(film, new ArrayList<Rating>());
            register.get(film).add(rating);
        } else {
            register.get(film).add(rating);
        }
    }

    public List<Rating> getRatings(Film film) {
        return register.get(film);
    }

    public Map<Film, List<Rating>> filmRatings() {
        return register;
    }

    public void addRating(Person person, Film film, Rating rating) {
        if (!personalRatings.containsKey(person)) {
            personalRatings.put(person, new HashMap<Film, Rating>());
            personalRatings.get(person).put(film, rating);
        } else {
            personalRatings.get(person).put(film, rating);
        }

        if (!register.containsKey(film)) {
            register.put(film, new ArrayList<Rating>());
            register.get(film).add(rating);
        } else {
            register.get(film).add(rating);
        }
    }

    public Rating getRating(Person person, Film film) {
        if (!personalRatings.containsKey(person)) {
            return Rating.NOT_WATCHED;
        } else if (!personalRatings.get(person).containsKey(film)) {
            return Rating.NOT_WATCHED;
        }
        
        return personalRatings.get(person).get(film);
    }

    public Map<Film, Rating> getPersonalRatings(Person person) {
        if (personalRatings.containsKey(person)) {
            return personalRatings.get(person);
        }
        
        return new HashMap<Film, Rating>();
    }

    public List<Person> reviewers() {
        List<Person> reviewers = new ArrayList<Person>();

        for (Person person : personalRatings.keySet()) {
            reviewers.add(person);
        }

        return reviewers;
    }
}
