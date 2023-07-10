#!/bin/bash
JAVA_VER=$1

if [ -z "$JAVA_VER" ]; then
  echo "Error: Provide a java version number. Exiting..."
  exit 1
fi

export JAVA_HOME="/usr/lib/jvm/java-$JAVA_VER-openjdk-amd64/"
sudo update-alternatives --set java /usr/lib/jvm/java-$JAVA_VER-openjdk-amd64/bin/java
pushd phosphor
mvn clean package
rm -rf jre-inst 2> /dev/null
java -jar phosphor-instrument-jigsaw/target/phosphor-instrument-jigsaw-0.1.0-SNAPSHOT.jar /usr/lib/jvm/java-$JAVA_VER-openjdk-amd64/ jre-inst
echo "[CHECKING JAVA VERSION]"
jre-inst/bin/java -version || exit 1

echo "[CHECKING TAINTING SOURCE ONLY]"
jre-inst/bin/java -javaagent:phosphor-jigsaw-javaagent/target/phosphor-jigsaw-javaagent-0.1.0-SNAPSHOT.jar=taintSources=../playground/observingbytecode/TaintExample.sources -jar inst/TaintExample.jar 12 12
popd
echo "see command-reference-sheet.sh on how to instrument a jar"