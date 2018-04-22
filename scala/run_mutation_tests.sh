#!/usr/bin/env bash
sbt mutationTest
xdg-open target/mutation-analysis-report/overview.html
