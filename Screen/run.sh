# Compile the source filei
echo "Compiling..."
javac Screen.java

echo "------------------ Test Starting ----------------------"
echo "java Screen" 

START=`date +%s%N`;
java Screen
END=`date +%s%N`;
time=$((END-START))
time=`expr $time / 1000000`
echo "Elapsed time:" $time "ms"
echo "---------------------- Test Ends ----------------------"



