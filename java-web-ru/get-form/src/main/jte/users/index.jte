@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
content = @`
    <body>
    <h1 class="text-body-emphasis">List of Users</h1>
    <form class="input-group" action="/users">
        <input type="search" class="form-control rounded" placeholder="Search" aria-label="Search" aria-describedby="search-addon" name="term" value="${page.getTerm()}" />
        <input type="submit" class="btn btn-outline-primary" value="Search">
    </form>
        <table class="table table-striped">
            <caption align="top">Users</caption>
            <thead>
            <tr>
                <th>Id</th>
                <th>First name</th>
                <th>Last Name</th>
            </tr>
            </thead>
            <tbody>
            @for(var user : page.getUsers())
            <tr>
                <div>
                    <td>${user.getId()}</td>
                    <td>${user.getFirstName()}</td>
                    <td>${user.getLastName()}</td>
                </div>
                @endfor
            </tr>
            </tbody>
        </table>
    </body>
`
)