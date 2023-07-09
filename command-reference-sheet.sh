# java compile commands
javac jarexample/user/APIUser.java 
javac jarexample/api/DummyAPI.java 
jar cvf api.jar jarexample/api/DummyAPI.class
jar cvf user.jar jarexample/user/APIUser.class
java -cp user.jar:api.jar jarexample.user.APIUser 1 1

# In phosphor directory, use java 16, instruments jre
java -jar phosphor-instrument-jigsaw/target/phosphor-instrument-jigsaw-0.1.0-SNAPSHOT.jar /usr/lib/jvm/java-16-openjdk-amd64/ jre-inst

# In phosphor directory, Instrument a jar file
java -jar Phosphor/target/Phosphor-0.1.0-SNAPSHOT.jar ../playground/observingbytecode/TaintExample.jar inst

# In phosphor directory, run the instrumented jar file
jre-inst/bin/java -javaagent:phosphor-jigsaw-javaagent/target/phosphor-jigsaw-javaagent-0.1.0-SNAPSHOT.jar -jar inst/TaintExample.jar 12 12
jre-inst/bin/java -javaagent:phosphor-jigsaw-javaagent/target/phosphor-jigsaw-javaagent-0.1.0-SNAPSHOT.jar=taintSources=../playground/observingbytecode/TaintExample.sources -jar inst/TaintExample.jar 12 12
jre-inst/bin/java -javaagent:phosphor-jigsaw-javaagent/target/phosphor-jigsaw-javaagent-0.1.0-SNAPSHOT.jar=taintSources=TaintExample.sources,taintSinks=TaintExample.sinks -jar inst/TaintExample.jar 12 12
jre-inst/bin/java -javaagent:phosphor-jigsaw-javaagent/target/phosphor-jigsaw-javaagent-0.1.0-SNAPSHOT.jar -cp /home/ahmad/.sdkman/candidates/scala/current/lib/scala-library-2.13.10.jar:inst/ScalaTaintExample.jar ScalaTaintExample 3 5
