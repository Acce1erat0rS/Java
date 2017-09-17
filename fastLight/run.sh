# Compile the source file
javac Minimum.java

echo "------------------ Test one ----------------------"
echo "java -Xmx1M demo 60 10000000 F0I9C5P3S2 F0I9C5P3S3 F0I9C5P3S27" 

START=`date +%s%N`;
echo "Result:" `java -Xmx1M Minimum 60 10000000 F0I9C5P3S2 F0I9C5P3S3 F0I9C5P3S27`
END=`date +%s%N`;
time=$((END-START))
time=`expr $time / 1000000`
echo "Elapsed time:" $time "ms"

echo "------------------ Test Two ----------------------"
echo "java -Xmx1M Minimum 5 4 F0I2C3P2S7 P4S5F1I2C3"

START=`date +%s%N`;
echo Result: `java -Xmx1M Minimum 5 4 F0I2C3P2S7 P4S5F1I2C3`
END=`date +%s%N`;
time=$((END-START))
time=`expr $time / 1000000`
echo "Elapsed time:" $time "ms"


