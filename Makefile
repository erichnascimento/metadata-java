SRC_DIR = $(shell pwd)
DEST_DIR = /usr/src/metadata-java
MVN_VOL = metadata-java-maven-repo
MVN = docker run -it --rm -v "$(SRC_DIR)":"$(DEST_DIR)" -v $(MVN_VOL):/root/.m2 -w $(DEST_DIR) maven:latest

init:
	docker volume create --name $(MVN_VOL)

env:
	$(MVN) mvn --version

test: init
	$(MVN) mvn test
