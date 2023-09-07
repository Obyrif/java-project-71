run-dist:
	./build/install/app/bin/app
.PHONY: build

build:
	./gradlew clean build

run:
	./gradlew run

test:
	./gradlew test

lint:
	./gradlew checkstyleMain

test-report:
	./gradlew test
	./gradlew jacocoTestReport

.PHONY: test
.PHONY: jacocoTestReport