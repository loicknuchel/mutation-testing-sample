#!/usr/bin/env bash

cd scala/
sbt clean
sbt mutationTest
cp -r target/mutation-analysis-report ../reports/getPrice/4-tests/scala
xdg-open ../reports/getPrice/4-tests/scala/overview.html

cd ../javascript/
./node_modules/.bin/stryker run
cp -r reports/mutation/html ../reports/getPrice/4-tests/javascript
xdg-open ../reports/getPrice/4-tests/javascript/index.html
