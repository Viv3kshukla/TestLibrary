(function() {
  define(function() {
    var SumWebSocket;
    return SumWebSocket = (function() {
      function SumWebSocket(password) {
        this.ws = new WebSocket("ws://localhost:9000/sum/" + password);
      }

      SumWebSocket.prototype.onConnected = function(callback) {
        return this.ws.onopen = callback;
      };

      SumWebSocket.prototype.onClose = function(callback) {
        return this.ws.onclose = callback;
      };

      SumWebSocket.prototype.disconnect = function() {
        return this.ws.close();
      };

      SumWebSocket.prototype.sum = function(values) {
        return this.ws.send(JSON.stringify({
          values: values
        }));
      };

      SumWebSocket.prototype.onResult = function(callback) {
        return this.ws.onmessage = function(msg) {
          var result;
          result = JSON.parse(msg.data);
          return callback(result.sum);
        };
      };

      return SumWebSocket;

    })();
  });

}).call(this);

//# sourceMappingURL=SumWebSocket.js.map
