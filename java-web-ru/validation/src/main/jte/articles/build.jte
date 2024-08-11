@import exercise.dto.articles.BuildArticlePage
@param BuildArticlePage page

@template.layout.page(
content = @`
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
                <textarea name="content" required>${page.getContent()}</textarea>
            </label>
        </div>
        <input type="submit" value="Download article" />
        @if(!page.getErrors().isEmpty())
            <ul>
                @for(var error : page.getErrors())
                    <li>${error}</li>
                @endfor
            </ul>
        @endif
    </form>
`
)