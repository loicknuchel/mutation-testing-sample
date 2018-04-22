#!/usr/bin/env bash
mvn org.pitest:pitest-maven:mutationCoverage
xdg-open target/pit-reports/$(ls target/pit-reports | sort -V | tail -n 1)/index.html
