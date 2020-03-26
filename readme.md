# Example project for error demonstration

### Project details
The project is using Kotlin 1.4-M1 with the new JS IR compiler backend.
So far, I ran this under Windows 10 with Gradle 6.2.2 and 6.3.

### Error description
Somehow, after a successful build, there is a java process lingering that has open file handles to some compiler output.
This blocks subsequent builds, because the files in question cannot be deleted or overwritten.

### How to reproduce
1. Clone the repo
1. Run `gradlew build`
1. run `gradlew clean`

The clean task fails with the output:
```
> Task :clean FAILED

FAILURE: Build failed with an exception.

* What went wrong:
Execution failed for task ':clean'.
> java.io.IOException: Unable to delete directory '<project root dir>\build'
    Failed to delete some children. This might happen because a process has files open or has its working directory set in the target directory.
    - <project root dir>\build\classes\kotlin\main\default\ir\bodies.knb
    - <project root dir>\build\classes\kotlin\main\default\ir\files.knf
    - <project root dir>\build\classes\kotlin\main\default\ir\irDeclarations.knd
    - <project root dir>\build\classes\kotlin\main\default\ir\signatures.knt
    - <project root dir>\build\classes\kotlin\main\default\ir\strings.knt
    - <project root dir>\build\classes\kotlin\main\default\ir\types.knt
    - <project root dir>\build\classes\kotlin\main\default\ir
    - <project root dir>\build\classes\kotlin\main\default
    - <project root dir>\build\classes\kotlin\main
    - <project root dir>\build\classes\kotlin
    - <project root dir>\build\classes
```
