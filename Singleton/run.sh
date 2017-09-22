# Compile the source filei
echo "Compiling..."
javac Singleton.java

echo "------------------ Test Starting ----------------------"
echo "java Singleton" 

START=`date +%s%N`;
echo "Result:" `java Singleton`
END=`date +%s%N`;
time=$((END-START))
time=`expr $time / 1000000`
echo "Elapsed time:" $time "ms"
echo "---------------------- Test Ends ----------------------"



