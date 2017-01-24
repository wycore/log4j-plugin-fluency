VERSION?=$(shell grep log4jplugin.version plugin.properties | cut -d'=' -f2)

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

release:
	-mkdir release
	cp target/log4j-plugin-fluency-${VERSION}-jar-with-dependencies.jar release/

.PHONY: package clean release