package exercise;

import io.javalin.Javalin;
import io.javalin.validation.ValidationException;
import java.util.List;
import java.util.Objects;

import exercise.model.Article;
import exercise.dto.articles.ArticlesPage;
import exercise.dto.articles.BuildArticlePage;
import static io.javalin.rendering.template.TemplateUtil.model;
import static java.util.function.Predicate.not;

import io.javalin.rendering.template.JavalinJte;

import exercise.repository.ArticleRepository;
import org.eclipse.jetty.http.HttpStatus;

public final class App {

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        app.get("/articles", ctx -> {
            List<Article> articles = ArticleRepository.getEntities();
            var page = new ArticlesPage(articles);
            ctx.render("articles/index.jte", model("page", page));
        });

        // BEGIN
        app.get("/articles/build", ctx -> {
            ctx.render("articles/build.jte", model("page", new BuildArticlePage()));
        });

        app.post("/articles", ctx -> {
            String title = ctx.formParam("title");
            String content = ctx.formParam("content");

            try {
                title = ctx.formParamAsClass("title", String.class)
                        .check(value -> value.length() >= 2, "Название не должно быть короче двух символов")
                        .check(not(ArticleRepository::existsByTitle)::test,
                                "Статья с таким названием уже существует")
                        .get();
                content = ctx.formParamAsClass("content", String.class)
                        .check(Objects::nonNull, "Статья должна быть не короче 10 символов")
                        .check(value -> value.length() >= 10, "Статья должна быть не короче 10 символов")
                        .get();
                var article = new Article(title, content);
                ArticleRepository.save(article);
                ctx.redirect("/articles");
            } catch (ValidationException e) {
                var page = new BuildArticlePage(title, content, e.getErrors());
                ctx.status(HttpStatus.UNPROCESSABLE_ENTITY_422);
                ctx.render("articles/build.jte", model("page", page));
            }
        });
        // END

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
