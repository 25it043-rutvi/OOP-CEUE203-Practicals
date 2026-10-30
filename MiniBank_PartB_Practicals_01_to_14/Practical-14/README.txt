OOP CEUE203 - Practical 14 Part B: Final MiniBank
JDK 17+ required.

This final checkpoint integrates:
- BankService and account operations
- Checked bank exceptions
- @Id annotation and generic repository
- Thread-pool transaction processor
- Console menu and transaction history

Compile from Practical-14:
    javac -d out src/model/annotation/*.java src/model/*.java src/exception/*.java src/service/*.java
Run:
    java -cp out service.MiniBank

Create runnable JAR:
    jar --create --file minibank.jar --main-class service.MiniBank -C out .
Run:
    java -jar minibank.jar
