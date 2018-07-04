


module.exports = function(app) {
    const districtController = require("../controllers/district.controller.js");

    //Create a State
    app.post('/api/districts', districtController.create);

    //List a states
    app.get("/api/districts", districtController.findAll);
}
