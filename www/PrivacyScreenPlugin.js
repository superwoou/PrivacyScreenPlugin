cordova.define("cordova/plugin/PrivacyScreenPlugin", function(require, exports, module) {
    var exec = require('cordova/exec');

    var PrivacyScreenPlugin = {
      activate : function(success, error) {
        exec(success, error, "PrivacyScreenPlugin", "activate", []);
      },
      deactivate : function(success, error) {
        exec(success, error, "PrivacyScreenPlugin", "deactivate", []);
      }
    };

    module.exports = PrivacyScreenPlugin;
});