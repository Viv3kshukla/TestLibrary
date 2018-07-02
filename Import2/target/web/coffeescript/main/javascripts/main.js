(function() {
  require.config({
    paths: {
      page: "./Page",
      controller: "./Controller",
      sumWebSocket: "./SumWebSocket",
      jquery: "../lib/jquery/jquery"
    },
    shim: {
      bootstrap: {
        deps: ["jquery"]
      },
      jquery: {
        exports: "$"
      }
    }
  });

  require(["controller"], function(controller) {
    return controller.bind();
  });

}).call(this);

//# sourceMappingURL=main.js.map
