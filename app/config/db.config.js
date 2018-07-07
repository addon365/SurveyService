const env = require('./env.js');

const Sequelize = require('sequelize');
const sequelize = new Sequelize(env.database, env.username, env.password, {
  host: env.host,
  dialect: env.dialect,
  operatorsAliases: false,

  pool: {
    max: env.max,
    min: env.pool.min,
    acquire: env.pool.acquire,
    idle: env.pool.idle
  },
  dialectOptions: {
    encrypt: true
  }
});

const db = {};

db.Sequelize = Sequelize;
db.sequelize = sequelize;

//Models/tables
db.customers = require('../models/customer.model.js')(sequelize, Sequelize);
db.stateRepository = require('../models/state.model.js')(sequelize, Sequelize);
db.districtRepository = require('../models/district.model.js')(sequelize, Sequelize);
require('../models/relations.js')(db);

module.exports = db;