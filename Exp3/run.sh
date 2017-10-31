#!/usr/bin/env bash
# Compile the source file
javac Exp3.java
echo "------------------ Test one ----------------------"
echo "java Exp3 1" 
START=`date +%s%N`;
echo Result : `java Exp3 1`
END=`date +%s%N`;
time=$((END-START))
time=`expr $time / 1000000`
echo "Elapsed time:" $time "ms"


echo "------------------ Test Two ----------------------"
echo "java Exp3 3"
START=`date +%s%N`;
echo Result : `java Exp3 3`
END=`date +%s%N`;
time=$((END-START))
time=`expr $time / 1000000`
echo "Elapsed time:" $time "ms"

echo "----------------- Test Three ---------------------"
echo "java Exp3 20"
START=`date +%s%N`;
echo Result : `java Exp3 20`
END=`date +%s%N`;
time=$((END-START))
time=`expr $time / 1000000`
echo "Elapsed time:" $time "ms"

echo "------------------ Test Four ---------------------"
echo "java Exp3 100"
START=`date +%s%N`;
echo Result : `java Exp3 100`
END=`date +%s%N`;
time=$((END-START))
time=`expr $time / 1000000`
echo "Elapsed time:" $time "ms"

echo "------------------ Test Five ---------------------"
echo "java Exp3 2017"
START=`date +%s%N`;
echo Result : `java Exp3 2017`
END=`date +%s%N`;
time=$((END-START))
time=`expr $time / 1000000`
echo "Elapsed time:" $time "ms"


echo "------------------ Test Six ----------------------"
echo "java Exp3 20172017" 
START=`date +%s%N`;
echo Result : `java Exp3 20172017`
END=`date +%s%N`;
time=$((END-START))
time=`expr $time / 1000000`
echo "Elapsed time:" $time "ms"

echo "----------------- Test Seven ---------------------"
echo "java Exp3 100000000"
START=`date +%s%N`;
echo Result : `java Exp3 100000000`
END=`date +%s%N`;
time=$((END-START))
time=`expr $time / 1000000`
echo "Elapsed time:" $time "ms"


