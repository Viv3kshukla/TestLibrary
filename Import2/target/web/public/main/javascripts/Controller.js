(function() {
  define(["page", "sumWebSocket"], function(page, sumWebSocket) {
    var bind, ws;
    ws = void 0;
    bind = function() {
      page.showLogin();
      page.hideConnecting();
      page.hideSum();
      page.onConnectClicked(function() {
        page.hideLogin();
        page.showConnecting();
        ws = new sumWebSocket(page.getPassword());
        ws.onConnected(function() {
          page.hideConnecting();
          return page.showSum();
        });
        ws.onResult(function(result) {
          return page.setSumResult(result);
        });
        return ws.onClose(function() {
          page.showLogin();
          page.hideSum();
          return page.hideConnecting();
        });
      });
      page.onSubmitSum(function() {
        var valueInts, values;
        values = page.getSumValues().split(/[, ]+/);
        valueInts = values.map(function(v) {
          return parseInt(v);
        }).filter(function(v) {
          return !isNaN(v);
        });
        return ws.sum(valueInts);
      });
      return page.onDisconnectClicked(function() {
        ws.disconnect();
        page.hideSum();
        return page.showLogin();
      });
    };
    return {
      bind: bind
    };
  });

}).call(this);

//# sourceMappingURL=Controller.js.map
