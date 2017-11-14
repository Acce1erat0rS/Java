#!/usr/bin/env bash

#$regex = "\'s\/<TOBEREPLACED>\/${2}/\'"
#echo $regex
# sed 's/<TOBEREPLACED>/${2}/' func.stash > 'demo.stash'

echo $1
sed 's/<TOBEREPLACED>/'$1'/' func.stash > func.java
javac func.java
