# Compile the source filei
echo "Compiling..."
javac <programName>.java

echo "------------------ Test Starting ----------------------"
echo "java <programName>" 

START=`date +%s%N`;
echo "Result:" `java <programName>`
END=`date +%s%N`;
time=$((END-START))
time=`expr $time / 1000000`
echo "Elapsed time:" $time "ms"
echo "---------------------- Test Ends ----------------------"



