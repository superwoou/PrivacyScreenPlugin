var exec = require('cordova/exec');

exports.activate = function(success, error) {
  exec(success, error, "PrivacyScreenPlugin", "activate", []);
};

exports.deactivate = function(success, error) {
  exec(success, error, "PrivacyScreenPlugin", "deactivate", []);
};
