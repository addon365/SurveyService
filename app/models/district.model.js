module.exports = (sequelize, Sequelize) => {
    const DistrictRepository = sequelize.define('district', {
        name: {
            type: Sequelize.STRING
        },
        code: {
            type: Sequelize.STRING
        }
    });
    return DistrictRepository;
}
