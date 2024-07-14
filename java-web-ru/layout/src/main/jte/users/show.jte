@import exercise.dto.users.UserPage
@param UserPage page

@template.layout.page(
    content = @`
        <h1 class="text-body-emphasis">User</h1>
        <body>
        <div class="col-lg-8 mx-auto p-4 py-md-5">
            <table>
                <caption align="top">User</caption>
                <thead>
                    <tr>
                        <th>First name</th>
                        <th>Last name</th>
                        <th>Email</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>${page.getUser().getFirstName()}</td>
                        <td>${page.getUser().getLastName()}</td>
                        <td>${page.getUser().getEmail()}</td>
                    </tr>
                </tbody>
            </table>
        </div>
        </body>
    `,
    footer = @`
        <p><a href="https://github.com/MarieTask">Welcome to my GitHub profile!</a></p>
    `
)