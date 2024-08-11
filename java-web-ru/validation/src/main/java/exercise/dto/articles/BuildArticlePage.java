package exercise.dto.articles;

import exercise.repository.ArticleRepository;
import io.javalin.validation.ValidationError;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;

// BEGIN
//Создаем дата-класс, который передает в шаблон данные формы и ошибки.
//Ошибки передаются в виде объекта, который формирует Javalin в случае ошибки валидации
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BuildArticlePage {
    private String title;
    private String content;
    private Map<String, List<ValidationError<Object>>> errors;
}
// END
