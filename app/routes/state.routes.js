module.exports = function(app) {
    const stateController = require("../controllers/state.controller.js");

    //Create a State
    app.post('/api/states', stateController.create);

    //List a states
    app.get("/api/states", stateController.findAll);
}
