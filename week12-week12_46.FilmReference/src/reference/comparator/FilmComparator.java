package reference.comparator;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import reference.domain.Film;
import reference.domain.Rating;

public class FilmComparator implements Comparator<Film> {
    private Map<Film, List<Rating>> ratings;
    
    public FilmComparator(Map<Film, List<Rating>> ratings) {
        this.ratings = ratings;
    }

    @Override
    public int compare(Film o1, Film o2) {
        int o1AverageRating = 0;
        int o2AverageRating = 0;
        
        for (Rating rating : ratings.get(o1)) {
            o1AverageRating += rating.getValue();
        }
        
        o1AverageRating /= ratings.size();
         
        for (Rating rating : ratings.get(o2)) {
            o2AverageRating += rating.getValue();
        }
        
        o2AverageRating /= ratings.size();
        
        return o2AverageRating - o1AverageRating;
    }    
}
