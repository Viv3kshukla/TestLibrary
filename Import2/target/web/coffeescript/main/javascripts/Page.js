(function() {
  define(["jquery"], function($) {
    return {
      showLogin: function() {
        return $("#login").show();
      },
      showConnecting: function() {
        return $("#connecting").show();
      },
      showSum: function() {
        return $("#sum").show();
      },
      hideLogin: function() {
        return $("#login").hide();
      },
      hideConnecting: function() {
        return $("#connecting").hide();
      },
      hideSum: function() {
        return $("#sum").hide();
      },
      onConnectClicked: function(cb) {
        return $("#connect").click(cb);
      },
      onDisconnectClicked: function(cb) {
        return $("#disconnect").click(cb);
      },
      onSubmitSum: function(cb) {
        return $("#submitSum").click(cb);
      },
      getPassword: function() {
        return $("#password").val();
      },
      getSumValues: function() {
        return $("#sumValues").val();
      },
      setSumResult: function(result) {
        return $("#sumResult").text(result);
      }
    };
  });

}).call(this);

//# sourceMappingURL=Page.js.map
