#!/bin/bash
export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.7.0_71.jdk/Contents/Home/

mvn clean
mvn -Dmaven.test.skip=true install


