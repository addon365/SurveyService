const db = require("../config/db.config");
const districtRepository = db.districtRepository;
const stateRepository = db.stateRepository;

//Post a State
exports.create = (req, res) => {
    var tmpStateId = req.body.stateid;
    if (tmpStateId == -1) {
        res.status(400).send("State object not found");
    }
    stateRepository.findById(tmpStateId)
        .then(stateObj => {
            districtRepository.create(req.body)
                .then(districtObj => {
                    districtRepository.findById(districtObj.id,
                        { include: { model: { State } } })
                        .then(districtObjResult => {
                            res.status(201).send(districtObjResult);
                        });

                    // stateObj.addDistricts(districtObj)
                    //     .then(() => {
                    //         res.status(201).send(districtObj);
                    //     });
                });
        })
        .catch(message => {
            res.status(500).send(message);
        });
}
//List a State
exports.findAll = (req, res) => {
    districtRepository.findAll({ inclulde: { model: State } })
        .then(districts => {
            res.status(200).send(districts);
        });
};
