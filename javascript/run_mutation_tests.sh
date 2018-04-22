#!/usr/bin/env bash
./node_modules/.bin/stryker run
xdg-open reports/mutation/html/index.html
