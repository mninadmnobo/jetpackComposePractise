const express = require("express")

const app = express();
app.listen(3000, "0.0.0.0", () => {
  console.log("Server is listening...");
});

app.use(express.json());

const users = [
  {
    username: "abcd",
    password: "123"
  },
  {
    username: "hello",
    password: "world"
  },
  {
    username: "irtiaz",
    password: "kabir"
  }
]

app.get("/users", (_, res) => {
  console.log("/users");
  res.send(users);
});


app.post("/login", (req, res) => {
  console.log("/login");
  for (const user of users) {
    if (user.username == req.body.username && user.password == req.body.password) {
      res.send({
        success: true
      });
      return;
    }
  }

  res.send({
    success: false
  });
});
