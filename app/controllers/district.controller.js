const db = require("../config/db.config");
const districtRepository = db.districtRepository;
const stateRepository = db.stateRepository;

//Post a State
exports.create = (req, res) => {
    
    var districtObj=districtRepository.build(req.body);

    districtRepository.create(req.body)
        .then(response => {
            res.send(response);
        });
}
//List a State
exports.findAll = (req, res) => {
    districtRepository.findAll().then(districts => {
        res.status(200).send(districts);
    });
};
