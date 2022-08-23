const http = require("http");
const app = require("express")();
app.get("/", (req,res)=> res.sendFile("../menu2.jsp"));
app.listen(9091, () => console.log("Listening on http port"));
const webSocketServer = require("websocket").server;
const httpServer = http.createServer();
httpServer.listen(8080, () => console.log("listening on 9090..."));
const clients = {};

const wsServer = new webSocketServer({
    "httpServer": httpServer
})

wsServer.on("request", request => {
    const connection = request.accept(null, request.origin);
    connection.on("open", () => console.log("opened!"))
    connection.on("close", () => console.log("closed!"))
    connection.on("message", message => {

        const result = JSON.parse(message.utf8Data)
        console.log(result)
    })

    const clientID = guid;
    clients[clientID] = {
        "connection": connection
    };

    const payLoad = {
        "method": "connect",
        "cliendID": clientID
    }

    connection.send(JSON.stringify(payLoad))

})

function S4() {
    return (((1+Math.random())*0x10000)|0).toString(16).substring(1);
}

const guid = () => (S4() + S4() + "-" + S4() + "-4" + S4().substr(0,3) + "-" + S4() + "-" + S4() + S4() + S4()).toLowerCase();