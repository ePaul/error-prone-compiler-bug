# Java Generics Varargs bug demonstration for ErrorProne

When using ErrorProne from Maven as indicated by their documentation, a different Javac version is used than the one provided by the JDK/JRE you are running with.

That one seems to have some bugs. I found one which let some of my tests fail.
It happens when a varargs method calls another one, which is overloaded and has several matching methods.

Run `mvn test` for the result with your default compiler, `mvn test -P error-prone` for the result with ErrorProne.
The latter has one failing test. 