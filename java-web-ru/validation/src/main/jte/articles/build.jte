@import exercise.dto.articles.BuildArticlePage
@param BuildArticlePage page

    @if(page.getErrors() != null)
        <ul xmlns="http://www.w3.org/1999/html">
            @for(var validator : page.getErrors().values())
                @for(var error : validator)
                    <li>${error.getMessage()}</li>
                @endfor
            @endfor
        </ul>
    @endif

    <form action="/articles" method="post">
        <div>
            <label>
                Title
                <input type="text" name="title" value="${page.getTitle()}" />
            </label>
        </div>
        <div>
            <label>
                Content
                <textarea name="content" value="${page.getContent()}"></textarea>
            </label>
        </div>
        <input type="submit" value="Add article" />
    </form>