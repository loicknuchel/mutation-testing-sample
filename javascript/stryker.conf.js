module.exports = function(config) {
  config.set({
    testRunner: "jest",
    mutator: "javascript",
    transpilers: [],
    reporter: ["html", "progress"],
    coverageAnalysis: "all",
    mutate: ["src/**/*.js"]
  });
};
