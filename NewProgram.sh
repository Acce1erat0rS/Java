mkdir $1
sed 's/<programName>/'$1'/g' .stash/run.sh > $1/run.sh 
touch $1/$1.java
chmod +x $1/run.sh

