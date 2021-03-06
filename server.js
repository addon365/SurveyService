var express = require('express');
var app = express();
var bodyParser = require('body-parser');
app.use(bodyParser.json())
app.use(bodyParser.urlencoded({ extended: true }));
const db = require('./app/config/db.config.js');




// force: true will drop the table if it already exists
db.sequelize.sync({ force: true }).then(() => {
  console.log('Drop and Resync with { force: true }');
});

require('./app/routes/state.routes.js')(app);
require('./app/routes/customer.route.js')(app);
require('./app/routes/district.routes.js')(app);
// Create a Server
var server = app.listen(8081, function () {

  var host = server.address().address
  var port = server.address().port

  console.log("App listening at http://%s:%s", host, port)
})