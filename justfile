# just inst base
inst mod:
	mvn install -DskipTests -f {{mod}}/pom.xml
tree:
	mvn dependency:tree

