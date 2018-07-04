module.exports = (db) => {
    db.stateRepository.hasMany(db.districtRepository, { as: 'Districts' });
}