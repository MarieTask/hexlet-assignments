@import exercise.dto.users.UsersPage
@param UsersPage page

<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>List of Users</title>
</head>
<body>
<h1>List of Users</h1>
@if(page.getUsers().isEmpty())
    <p>There is no user!</p>
@else
    <table>
        <caption>Users</caption>
        <thead>
            <tr>
                <th>ID</th>
                <th>FirstName</th>
                <th>LastName</th>
                <th>Email</th>
            </tr>
        </thead>
    @for(var user : page.getUsers())
        <tbody>
            <tr>
                <div>
                    <td>${user.getId()}</td>
                    <td>${user.getFirstName()}</td>
                    <td>${user.getLastName()}</td>
                    <td>${user.getEmail()}</td>
                </div>
                @endfor
            </tr>
        </tbody>
    </table>
@endif
</body>
</html>