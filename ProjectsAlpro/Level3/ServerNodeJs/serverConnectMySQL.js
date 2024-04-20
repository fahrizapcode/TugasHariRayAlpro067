const http = require("http");
const mysql = require("mysql");
const url = require("url");

// Koneksi ke database MySQL
const connection = mysql.createConnection({
  host: "localhost",
  user: "Pribadi",
  password: "Pribadi",
  database: "Pribadi",
});
connection.connect((err) => {
  if (err) {
    console.error("Error connecting to MySQL:", err);
    return;
  }
  console.log("Connected to MySQL database");
});

// Membuat server HTTP
const server = http.createServer((req, res) => {
  // Mendapatkan path dan parameter dari URL
  const { pathname, query } = url.parse(req.url, true);

  res.setHeader("Access-Control-Allow-Origin", "*");
  res.setHeader(
    "Access-Control-Allow-Headers",
    "Origin, X-Requested-With, Content-Type, Accept"
  );

  if (req.method === "GET" && pathname === "/products") {
    // Mengambil nilai kategori dari parameter URL
    const kategori = query.kategori || "gadget";

    // Melakukan query ke database dengan kategori yang sesuai
    connection.query(
      `SELECT * FROM ddProducts WHERE kategori = ?`,
      [kategori],
      (err, results) => {
        if (err) {
          console.error("Error fetching products:", err);
          res.writeHead(500, { "Content-Type": "application/json" });
          res.end(JSON.stringify({ error: "Internal Server Error" }));
          return;
        }
        // Mengonversi hasil query menjadi string JSON dan mengirimkannya sebagai respons
        res.writeHead(200, { "Content-Type": "application/json" });
        res.end(JSON.stringify(results));
      }
    );
  } else if (req.method === "POST" && pathname === "/messages") {
    // Menangani permintaan POST untuk membuat pesan baru
    let body = "";
    req.on("data", (chunk) => {
      body += chunk.toString();
    });

    req.on("end", () => {
      try {
        const message = JSON.parse(body); // Parse JSON dari body

        // Memeriksa apakah 'message_from' disediakan, jika tidak, set nilai default
        const from = message.from || "Anonymous";

        // Melakukan insert pesan ke database
        connection.query(
          `INSERT INTO ddmessage (message_content, message_from) VALUES (?, ?)`,
          [message.content, from], // Gunakan message.content dan from
          (err, results) => {
            if (err) {
              console.error("Error creating message:", err);
              res.writeHead(500, { "Content-Type": "application/json" });
              res.end(JSON.stringify({ error: "Internal Server Error" }));
              return;
            }
            // Mengirim respons bahwa pesan telah berhasil dibuat
            res.writeHead(201, { "Content-Type": "application/json" });
            res.end(
              JSON.stringify({ message: "Message created successfully" })
            );
          }
        );
      } catch (error) {
        console.error("Error parsing JSON:", error);
        res.writeHead(400, { "Content-Type": "application/json" });
        res.end(JSON.stringify({ error: "Invalid JSON" }));
      }
    });
  } else if (req.method === "GET" && pathname === "/messages") {
    connection.query(`Select * FROM ddMessage`, (err, results) => {
      if (err) {
        console.error("Error fetching messages:", err);
        res.writeHead(500, { "Content-Type": "application/json" });
        res.end(JSON.stringify({ error: "Internal Server Error" }));
        return;
      }
      res.writeHead(200, { "Content-Type": "application/json" });
      res.end(JSON.stringify(results));
    });
  } else if (req.method === "GET" && pathname === "/famousProducts") {
    connection.query(
      "SELECT * FROM ddProducts WHERE rating > 47 || sold > 8000",
      (err, results) => {
        if (err) {
          console.error("Error fetching famous  products", err);
          res.writeHead(500, { "Content-Type": "application/json" });
          res.end(JSON.stringify({ error: "Internal Server Error" }));
          return;
        }
        res.writeHead(200, { "Content-Type": "application/json" });
        res.end(JSON.stringify(results));
      }
    );
  } else {
    // Menangani permintaan yang tidak dikenali
    res.writeHead(404, { "Content-Type": "text/plain" });
    res.end("Not Found");
  }
});

// Mendengarkan pada port tertentu
const PORT = 3000;
server.listen(PORT, () => {
  console.log(`Server berjalan di http://localhost:${PORT}`);
});
