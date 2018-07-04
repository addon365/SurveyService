const db = require("../config/db.config");
const districtRepository = db.districtRepository;
const stateRepository = db.stateRepository;

//Post a State
exports.create = (req, res) => {
    var district = districtRepository.build(req.body);
    var state = stateRepository.build(req.body.state);
    district.setState(state)
        .then((districtResult) => {
            districtRepository.findById(districtResult.id,
                { include: { model: stateRepository } })
                .then(districtResult => {
                    res.status(201).send(districtResult);
                });
        });
}
//List a State
exports.findAll = (req, res) => {
    districtRepository.findAll({ include: { model: stateRepository } })
        .then(districts => {
            res.status(200).send(districts);
        });
};
