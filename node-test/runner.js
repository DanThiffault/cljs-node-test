(function () {
  var path = require("path"),
  fs = require("fs"),
  args = process.argv.slice(3),
  base = path.join(process.cwd(), process.argv[2]);

  require(path.join(base, "/goog/bootstrap/nodejs"));

  args.forEach(function(arg) {
    var file = path.join(base, arg);
    try {
      require(file);
    } catch (e) {
      console.log(e);
    }
  });

  require(path.join(base, "/cljs/test"));
  require(path.join(base, "/test_runner"));

  var results = test_runner.runner();

  if(results != 0) {
    console.log("Tests failed");
    process.exit(1);
  } else {
    console.log("Tests succeeded");
    process.exit(0)
  }
})();
