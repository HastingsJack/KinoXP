package org.example.kinoxp.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.kinoxp.models.Actor;
import org.example.kinoxp.models.Movie;
import org.example.kinoxp.repositories.ActorRepository;
import org.example.kinoxp.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashSet;
import java.util.Set;

@Service
public class MovieService {
    private final MovieRepository movieRepository;
    private final ActorRepository actorRepository;
    private final String apiKey;

    public MovieService(MovieRepository movieRepository, ActorRepository actorRepository, @Value("${tmdb.api-key}") String API_KEY) {
        this.movieRepository = movieRepository;
        this.actorRepository = actorRepository;
        this.apiKey = API_KEY;

    }

    public Movie fetchAndSaveMovie(long movieId) {
        String url = "https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apiKey + "&language=en-US";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();

        try {

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            ObjectMapper mapper = new ObjectMapper();
            JsonNode json = mapper.readTree(response.body());
            if (json.get("id") == null || json.get("id").isNull()) {
                return null;
            }

            Movie movie = new Movie();
            movie.setId(json.get("id").asLong());
            movie.setTitle(json.get("title").asText());
            movie.setDescription(json.get("overview").asText());
            movie.setMovieLength(json.get("runtime").asInt());
            movie.setMovieImg("https://image.tmdb.org/t/p/w500" + json.get("backdrop_path").asText());


            Set<String> genres = new HashSet<>();
            json.get("genres").forEach(g -> genres.add(g.get("name").asText()));
            movie.setGenres(genres);

            String ageLimit = fetchContentRating(movieId);
            String convertedAgeLimit = convertAgeLimitFromUSAStandard(ageLimit);
            movie.setAgeLimit(convertedAgeLimit);

            movie.setActors(fetchActorsForMovie(movieId));

            return movieRepository.save(movie);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String fetchContentRating(long movieId) {
        String url = "https://api.themoviedb.org/3/movie/" + movieId + "/release_dates?api_key=" + apiKey;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            ObjectMapper mapper = new ObjectMapper();
            JsonNode json = mapper.readTree(response.body());


            for (JsonNode result : json.get("results")) {
                if (result.get("iso_3166_1").asText().equals("US")) {
                    JsonNode releaseDates = result.get("release_dates");
                    for (JsonNode rd : releaseDates) {
                        String cert = rd.get("certification").asText();
                        if (!cert.isEmpty()) {
                            return cert;
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "NR";
    }

    public String convertAgeLimitFromUSAStandard(String ageLimit) {
        return switch (ageLimit) {
            case "G" -> "A";
            case "PG" -> "7";
            case "PG-13" -> "11";
            case "R", "NR" -> "15";
            default -> "18";
        };
    }

    public Set<Actor> fetchActorsForMovie(long movieId) {
        String url = "https://api.themoviedb.org/3/movie/" + movieId + "/credits?api_key=" + apiKey;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            ObjectMapper mapper = new ObjectMapper();
            JsonNode json = mapper.readTree(response.body());

            Set<Actor> actors = new HashSet<>();
            json.get("cast").forEach(node -> {
                long actorID = node.get("id").asLong();
                Actor actor = actorRepository.findById(actorID)
                                .orElseGet(() -> {
                                    Actor newActor = new Actor();
                                    newActor.setId(actorID);
                                    newActor.setName(node.get("name").asText());
                                    return newActor;
                                        });
                actors.add(actor);
            });

            actorRepository.saveAll(actors);

            return actors;

        } catch (Exception e) {
            e.printStackTrace();
            return new HashSet<>();
        }
    }


}
