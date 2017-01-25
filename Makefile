VERSION?=$(shell grep '<version' pom.xml | cut -f2 -d">"| cut -f1 -d"<" | head -n 1)

help:
	@echo "usage: make TARGET"
	@echo "    release                   - prepare a release for Github"
	@echo "    package                   - create jar"

package: target/log4j-plugin-fluency-${VERSION}-jar-with-dependencies.jar

target/log4j-plugin-fluency-${VERSION}-jar-with-dependencies.jar:
	mvn clean
	mvn dependency:resolve
	mvn package -Dmaven.test.skip=true

clean:
	-rm -rf target/*
	-rm -rf release/*

release: target/log4j-plugin-fluency-${VERSION}-jar-with-dependencies.jar
	-mkdir release
	cp target/log4j-plugin-fluency-${VERSION}-jar-with-dependencies.jar release/

deploy: target/log4j-plugin-fluency-${VERSION}-jar-with-dependencies.jar
	mvn clean deploy

.PHONY: package clean release deploy