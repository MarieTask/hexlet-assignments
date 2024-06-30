@import exercise.dto.users.UserPage
@param UserPage page

<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>User</title>
</head>
<body>
<h1>User</h1>
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
        <tbody>
        <tr>
            <td>${page.getUser().getId()}</td>
            <td>${page.getUser().getFirstName()}</td>
            <td>${page.getUser().getLastName()}</td>
            <td>${page.getUser().getEmail()}</td>
        </tr>
        </tbody>
    </table>
</body>
</html>