# Java and Maven Settings

This workspace is set up for Java and Maven development. Here are some key settings:

## Java Version

The Java version used in this workspace is 1.8, as specified in the `maven.compiler.source` and `maven.compiler.target` properties in the pom.xml files of the [core](core/pom.xml), [service](service/pom.xml), and [webapp](webapp/pom.xml) modules.

## Maven Settings

### Parent Project

The parent project is defined in the [pom.xml](pom.xml) file at the root of the workspace. It has the artifactId `parent-project` and version `1.0-SNAPSHOT`.

### Modules

The parent project has three modules:

1. [core](core/pom.xml)
2. [service](service/pom.xml)
3. [webapp](webapp/pom.xml)

Each module has its own pom.xml file that defines its specific settings and dependencies.

### Dependencies

All modules depend on JUnit for testing, as specified in their respective pom.xml files. The `service` module also depends on the `core` module.

### Maven Archiver

The Maven Archiver has generated pom.properties files in the target directories of the [core](core/target/maven-archiver/pom.properties) and [webapp](webapp/target/maven-archiver/pom.properties) modules.

## Building the Project

To build the project, you can run the following command in the terminal:

```sh
mvn clean install