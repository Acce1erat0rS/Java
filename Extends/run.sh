# Compile the source filei
echo "Compiling..."
javac Extends.java

echo "------------------ Test Starting ----------------------"
echo "java Extends" 

START=`date +%s%N`;
java Extends
END=`date +%s%N`;
time=$((END-START))
time=`expr $time / 1000000`
echo "Elapsed time:" $time "ms"
echo "---------------------- Test Ends ----------------------"



