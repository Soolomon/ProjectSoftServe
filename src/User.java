import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


class User {
    private String name;
    private int age;
    private boolean sex;
    private final List<Movie> likeMovie = new ArrayList<>();

    User(String name, int age, boolean sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        if (age < 12) {
            Movie.addDependenciesPoint("Fantasy Comedy Anime");
        } else if (age > 12 && age < 18) {
            Movie.addDependenciesPoint("Fantasy Comedy Serial");
        } else if (age > 18 && age < 25) {
            Movie.addDependenciesPoint("Fantasy Action Adventure");
        } else {
            Movie.addDependenciesPoint("Biographical Documentary Historical");
        }
        if (sex) {
            Movie.addDependenciesPoint("Horror War Fantasy Western Fighter");
        } else {
            Movie.addDependenciesPoint("Melodram Epics Drama Adventure Romance");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public List<Movie> getLikeMovie() {
        return likeMovie;
    }

    public void choise() throws IOException {
        int choise;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please take choise " + this.name + "!");
        for (int h = 0; h < 3; h++) {
            for (int i = 0; i < Source.getSource().size(); i++) {
                System.out.println("#" + i + " " + Source.getSource().get(i).tittle);
            }
            choise = Integer.parseInt(reader.readLine());
            likeMovie.add(Source.getSource().get(choise));
            Source.getSource().remove(choise);

        }

    }

}