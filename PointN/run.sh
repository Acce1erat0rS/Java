# Compile the source filei
echo "Compiling..."
javac PointN.java

echo "------------------ Test Starting ----------------------"
echo "java PointN" 

START=`date +%s%N`;
echo "Result:" `java PointN`
END=`date +%s%N`;
time=$((END-START))
time=`expr $time / 1000000`
echo "Elapsed time:" $time "ms"
echo "---------------------- Test Ends ----------------------"



