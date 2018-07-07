const env = {
    database: 'survey',
    username: 'root',
    password: 'p244w0rd',
    host: 'addonmysql.ceceqnse9grp.ap-southeast-1.rds.amazonaws.com',
    dialect: 'mysql',
    pool: {
        max: 5,
        min: 0,
        acquire: 30000,
        idle: 10000
    }
  };
   
  module.exports = env;