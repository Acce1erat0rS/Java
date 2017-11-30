# Compile the source filei
echo "Compiling..."
javac DivideBy3.java

echo "------------------ Test Starting ----------------------"
echo "java DivideBy3" 

START=`date +%s%N`;
echo "Result:" `java DivideBy3`
END=`date +%s%N`;
time=$((END-START))
time=`expr $time / 1000000`
echo "Elapsed time:" $time "ms"
echo "---------------------- Test Ends ----------------------"



