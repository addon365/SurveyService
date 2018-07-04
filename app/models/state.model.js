module.exports = (sequelize, Sequelize) => {
    const StateRepository = sequelize.define('state', {
        name: {
            type: Sequelize.STRING
        },
        code: {
            type: Sequelize.STRING
        }
    });
    return StateRepository;
}
