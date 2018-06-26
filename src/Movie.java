import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Movie {
    public String tittle;
    private int rank = 0;
    private final String fInfo;

    Movie(String fInfo) {
        this.fInfo = fInfo;
        Matcher takeTittle = Pattern.compile("(?<=Tittle:).*?(?=;)").matcher(fInfo);
        while (takeTittle.find()) {
            tittle = fInfo.substring(takeTittle.start(), takeTittle.end());
        }
    }

    public String getTittle() {
        return tittle;
    }

    public int getRank() {
        return rank;
    }

    public String getfInfo() {
        return fInfo;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    private static void calcPoint(User user) {
        for (int a = 0; a < user.getLikeMovie().size(); a++) {
            for (int b = 0; b < fMovie(user.getLikeMovie().get(a).fInfo).split(",").length; b++) {
                for (int c = 0; c < Source.getSource().size(); c++) {
                    if (Pattern.compile(fMovie(user.getLikeMovie().get(a).fInfo).split(",")[b])
                            .matcher(fMovie(Source.getSource().get(c).fInfo)).find()) {
                        Source.getSource().get(c).rank++;
                    }
                }
            }
        }
    }

    private static String fMovie(String film) {
        String dummy = null;
        Matcher findActors = Pattern.compile("(?<=Actors:).*?(?=; Des)").matcher(film);
        while (findActors.find()) {
            dummy = film.substring(findActors.start(), findActors.end()).replaceAll(";", "")
                    .replaceAll("Genre:|Studious:|Directors:", ",").replaceAll(" +", "").toLowerCase();
        }
        return dummy;
    }

    private static void calcRDF(User user) {
        int count_same_words = 0;
        for (int i = 0; i < user.getLikeMovie().size(); i++) {
            for (int j = 0; j < Source.getSource().size(); j++) {
                for (Map.Entry<String, Integer> step_user : user.getLikeMovie().get(i).frequencyWords().entrySet())
                    for (Map.Entry<String, Integer> step_next : Source.getSource().get(j).frequencyWords().entrySet())
                        if (step_user.getKey().equals(step_next.getKey()))
                            count_same_words++;
                Source.getSource().get(j).rank += count_same_words * 2;
            }
        }
    }

    // Finds frequency words in line
    private Map<String, Integer> frequencyWords() {
        Map<String, Integer> frequency = new HashMap<>();
        String s = null; // canonization
        Matcher Description = Pattern.compile("(?<=Description:).*?(?=;)").matcher(fInfo);
        while (Description.find()) {
            s = fInfo.substring(Description.start(), Description.end()).toLowerCase().replaceAll("[,.?:;\"!]", "");
        }

        String[] words = s.split(" ");

        for (String word : words) {
            if (word.length() > 3) {
                if (frequency.containsKey(word)) {
                    frequency.put(word, (frequency.get(word) + 1));
                } else {
                    frequency.put(word, 1);
                }
            }
        }
        Map<String, Integer> frequency1 = new HashMap<>();
        for (Map.Entry<String, Integer> step_user : frequency.entrySet())
            if (frequency.get(step_user.getKey()) > 2) {
                frequency1.put(step_user.getKey(), step_user.getValue());
            }
        return frequency1;
    }

    public static void pickUpFilms(User user) {
        calcPoint(user);
        calcRDF(user);
        Source.getSource().sort((a, b) -> b.rank - a.rank);
    }

    public static void addDependenciesPoint(String genre) {
        for (int i = 0; i < genre.split(" ").length; i++) {
            for (int j = 0; j < Source.getSource().size(); j++) {
                if (Pattern.compile(genre.split(" ")[i]).matcher(Source.getSource().get(j).fInfo).find())
                    Source.getSource().get(j).rank++;
            }
        }
    }

    @Override
    public String toString() {
        return "Movie [tittle=" + tittle + ", rank=" + rank + "]";
    }

}