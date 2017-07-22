mvn clean compile && $JAVA_HOME/bin/java -cp $(mvn dependency:build-classpath | grep "^/"):target/classes com.github.haynesgt.tradegame.TradeGameApplication
