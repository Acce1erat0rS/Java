#!/usr/bin/env bash

#$regex = "\'s\/<TOBEREPLACED>\/${2}/\'"
#echo $regex
# sed 's/<TOBEREPLACED>/${2}/' func.stash > 'demo.stash'

echo 's/<TOBEREPLACED>/'$1'/'
sed 's/<TOBEREPLACED>/'$1'/' ./Exp5/func.stash > ./Exp5/func.java
javac func.java
