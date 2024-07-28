@template.layout.page(
    content = @`
        <form action="/users" method="post">
            <div>
                <label>
                    first name
                    <input type="text" required name="firstName" />
                </label>
            </div>
            <div>
                <label>
                    last name
                    <input type="text" required name="lastName" />
                </label>
            </div>
            <div>
                <label>
                    email
                    <input type="email" required name="email" />
                </label>
            </div>
            <div>
                <label>
                    password
                    <input type="password" required name="password" />
                </label>
            </div>
            <input type="submit" value="Зарегистрировать" />
        </form>
    `
)