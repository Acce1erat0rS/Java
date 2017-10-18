# Compile the source filei
echo "Compiling..."
javac Interface.java

echo "------------------ Test Starting ----------------------"
echo "java Interface" 

START=`date +%s%N`;
echo "Result:" `java Interface`
END=`date +%s%N`;
time=$((END-START))
time=`expr $time / 1000000`
echo "Elapsed time:" $time "ms"
echo "---------------------- Test Ends ----------------------"



