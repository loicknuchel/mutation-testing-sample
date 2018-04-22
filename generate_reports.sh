#!/usr/bin/env bash

cd scala/
sbt clean
sbt mutationTest
cp -r target/mutation-analysis-report ../reports/getPrice/4-tests/scala
xdg-open ../reports/getPrice/4-tests/scala/overview.html
