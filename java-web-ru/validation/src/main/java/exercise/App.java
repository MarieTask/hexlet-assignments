package exercise;

import io.javalin.Javalin;
import io.javalin.validation.ValidationException;

import java.util.ArrayList;
import java.util.List;
import exercise.model.Article;
import exercise.dto.articles.ArticlesPage;
import exercise.dto.articles.BuildArticlePage;
import static io.javalin.rendering.template.TemplateUtil.model;
import io.javalin.rendering.template.JavalinJte;

import exercise.repository.ArticleRepository;

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
        app.post("/articles", ctx -> {
            var title = ctx.formParamAsClass("title", String.class).getOrDefault("");
            var content = ctx.formParamAsClass("content", String.class).getOrDefault("");
            var errors = new ArrayList<String>();

            if (title.length() < 2) {
                errors.add("Название не должно быть короче двух символов");
            }
            if (content.length() < 10) {
                errors.add("Содержимое статьи должно быть не короче 10 символов");
            }
            if (ArticleRepository.existsByTitle(title)) {
                errors.add("Статья с таким названием уже существует");
            }

            if (errors.isEmpty()) {
                var article = new Article(title, content);
                ArticleRepository.save(article);
                ctx.redirect("/articles");
            } else {
                var page = new BuildArticlePage(title, content, errors);
                ctx.status(422);
                ctx.render("articles/build.jte", model("page", page));
            }
        });

        app.get("/articles/build", ctx -> {
            var article = new BuildArticlePage();
            ctx.render("articles/build.jte", model("article", article));
        });
        // END

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
