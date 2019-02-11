import com.java8.training.streams.Movie;
import com.java8.training.streams.Videotheque;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class VideothequeTest {

    private Videotheque videotheque = new Videotheque();

    @Test
    public void should_get_movies_with_max_length() {
        Assertions.assertThat(videotheque.getMoviesWithMaxLength(90))
                .contains("Million Dollar Baby", "Reservoir Dogs", "Burn After Reading");
    }

    @Test
    public void should_get_total_length_for_director() {
        Assertions.assertThat(videotheque.getTotalLengthForDirector("Eastwood")).isEqualTo(510);
    }

    @Test
    public void should_sort_by_director() {
        Map<String, List<Movie>> results = videotheque.sortByDirector();

        Assertions.assertThat(results).containsKeys("Eastwood", "Tarantino", "Cameron", "Cohen Brothers");

        Assertions.assertThat(results.get("Eastwood")).contains(
                new Movie("Eastwood", "Sur la route de Madison", "Western", 180),
                new Movie("Eastwood", "Impitoyable", "Western", 240),
                new Movie("Eastwood", "Million Dollar Baby", "Drama", 90)
        );

        Assertions.assertThat(results.get("Tarantino")).contains(
                new Movie("Tarantino", "Django Unchained", "Western", 180),
                new Movie("Tarantino", "Reservoir Dogs", "Drama", 90)
        );

        Assertions.assertThat(results.get("Cameron")).contains(
                new Movie("Cameron", "Titanic", "Drama", 180)
        );
        Assertions.assertThat(results.get("Cohen Brothers")).contains(
                new Movie("Cohen Brothers", "Burn After Reading", "Comedy", 90)
        );
    }


    @Test
    public void should_sort_by_genre_and_director() {
        Map<String, Map<String, List<String>>> results = videotheque.sortByGenreAndDirector();

        Assertions.assertThat(results).containsKeys("Western", "Drama", "Comedy");

        Assertions.assertThat(results.get("Western")).containsKeys("Eastwood", "Tarantino");
        Assertions.assertThat(results.get("Western").get("Tarantino")).contains("Django Unchained");
        Assertions.assertThat(results.get("Western").get("Eastwood")).contains("Sur la route de Madison", "Impitoyable");

        Assertions.assertThat(results.get("Drama")).containsKeys("Eastwood", "Tarantino", "Cameron");
        Assertions.assertThat(results.get("Drama").get("Eastwood")).contains("Million Dollar Baby");
        Assertions.assertThat(results.get("Drama").get("Tarantino")).contains("Reservoir Dogs");
        Assertions.assertThat(results.get("Drama").get("Cameron")).contains("Titanic");

        Assertions.assertThat(results.get("Comedy")).containsKeys("Cohen Brothers");
        Assertions.assertThat(results.get("Comedy").get("Cohen Brothers")).contains("Burn After Reading");

    }




}
