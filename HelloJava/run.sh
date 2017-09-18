javac demo.java
echo "------------------ Test one ----------------------"
echo "java -Xmx200M demo 60 10000000 F0I9C5P3S2 F0I9C5P3S3 F0I9C5P3S27" 

START=`date +%s%N`;
echo Result: `java -Xmx200M demo 60 10000000 F0I9C5P3S2 F0I9C5P3S3 F0I9C5P3S27`
END=`date +%s%N`;
time=$((END-START))
time=`expr $time / 1000000`
echo "Elapsed time:" $time "ms"

echo "------------------ Test Two ----------------------"
echo "java -Xmx200M Minimum 5 4 F0I2C3P2S7 F1I2C3P4S5"

START=`date +%s%N`;
echo Result: `java -Xmx200M demo 5 4 F0I2C3P2S7 F1I2C3P4S5`
END=`date +%s%N`;
time=$((END-START))
time=`expr $time / 1000000`
echo "Elapsed time:" $time "ms"


