OOP CEUE203 - Practical 06 Part B
Package-based MiniBank using Transactable, InterestBearing, WithdrawRule and Premium.
JDK 17+ required.

Compile from Practical-06:
    javac -d out src/model/*.java src/util/*.java src/service/*.java
Run:
    java -cp out service.MiniBank

Create runnable JAR:
    jar --create --file minibank.jar --main-class service.MiniBank -C out .
Run:
    java -jar minibank.jar
