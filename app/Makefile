.PHONY: build
run-dist:
		./build/install/app/bin/app $(ARGS)
build:
	./gradlew build

test:
	./gradlew test

checkstyle:
	./gradlew checkstyleMain checkstyleTest

sonar:
	./gradlew sonar

clean:
	./gradlew clean