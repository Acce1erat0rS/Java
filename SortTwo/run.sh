# Compile the source filei
echo "Compiling..."
javac SortTwo.java

echo "------------------ Test Starting ----------------------"
echo "java SortTwo" 

START=`date +%s%N`;
java SortTwo
END=`date +%s%N`;
time=$((END-START))
time=`expr $time / 1000000`
echo "Elapsed time:" $time "ms"
echo "---------------------- Test Ends ----------------------"



