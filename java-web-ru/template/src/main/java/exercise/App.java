package exercise;

import io.javalin.Javalin;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import io.javalin.http.NotFoundResponse;
import exercise.model.User;
import exercise.dto.users.UserPage;
import exercise.dto.users.UsersPage;
import static io.javalin.rendering.template.TemplateUtil.model;
import io.javalin.rendering.template.JavalinJte;

public final class App {

    // Каждый пользователь представлен объектом класса User
    private static final List<User> USERS = Data.getUsers();
    private static final List<User> sortedUsers = USERS.stream()
            .sorted(Comparator.comparing(User::getId))
            .collect(Collectors.toList());

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        // BEGIN
        app.get("/users", ctx -> {
            var page = new UsersPage(sortedUsers);
            ctx.render("users/index.jte", model("page", page));
        });

        app.get("/users/{id}", ctx -> {
            int userNumber = ctx.pathParamAsClass("id", Integer.class).get();

            if (userNumber >= USERS.size() || userNumber < 0) {
                throw new NotFoundResponse("User not found");
            }

            var id = sortedUsers.get(userNumber - 1).getId();
            var firstName = sortedUsers.get(userNumber - 1).getFirstName();
            var lastName = sortedUsers.get(userNumber - 1).getLastName();
            var email = sortedUsers.get(userNumber - 1).getEmail();

            var resultUser = new User(id, firstName, lastName, email);
            UserPage page = new UserPage(resultUser);
            ctx.render("users/show.jte", model("page", page));
        });
        // END

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
