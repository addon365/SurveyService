const db = require("../config/db.config");
const stateRepository = db.stateRepository;

//Post a State
exports.create = (req, res) => {
    stateRepository.create(req.body)
        .then(state => {
            res.status(201).send(state);
        })
        .catch(reason => {
            res.status(500).send(reason);
        });

}
//List a State
exports.findAll = (req, res) => {
    stateRepository.findAll().then(states => {
        res.status(200).send(states);
    });
};
