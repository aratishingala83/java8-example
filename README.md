## Core Java 8

This module contains articles about Java 8 core features

### Relevant Articles: 
- [New Features in Java 8](https://www.baeldung.com/java-8-new-features)
- [Guide to Java 8 groupingBy Collector](https://www.baeldung.com/java-groupingby-collector)
- [Strategy Design Pattern in Java 8](https://www.baeldung.com/java-strategy-pattern)
- [Guide to Java 8 Comparator.comparing()](https://www.baeldung.com/java-8-comparator-comparing)
- [Guide to the Java 8 forEach](https://www.baeldung.com/foreach-java)
- [Introduction to Spliterator in Java](https://www.baeldung.com/java-spliterator)
- [Finding Min/Max in an Array with Java](https://www.baeldung.com/java-array-min-max)
- [Internationalization and Localization in Java 8](https://www.baeldung.com/java-8-localization)
- [Generalized Target-Type Inference in Java](https://www.baeldung.com/java-generalized-target-type-inference)
- [[More -->]](/core-java-modules/core-java-8-2)


If you want to check whether the Oracle JDBC URL contains a specific port and schema along with the "jdbc:oracle:" part, you can modify the regular expression as follows:

regex
Copy code
.*jdbc:oracle:(?:thin|oci|kprb):[^:]+:[0-9]+/(?:[A-Za-z0-9_\-]+).*
Explanation of the modified pattern:

.* matches any character (except newline) zero or more times.
jdbc:oracle: matches the literal string "jdbc:oracle:".
(?:thin|oci|kprb): matches one of the supported Oracle JDBC URL connection types (thin, oci, kprb).
[^:]+: matches one or more characters that are not a colon, followed by a colon (matches the hostname).
[0-9]+ matches one or more digits (matches the port number).
/(?:[A-Za-z0-9_\-]+) matches a forward slash followed by the schema name, which can contain alphanumeric characters, underscores, and hyphens.

Context ctx = new InitialContext();
Subject subject = (Subject) ctx.lookup("j2cAuthenticationAlias");
PasswordCredential credential = (PasswordCredential) subject.getPrivateCredentials().iterator().next();

// Set the actual password
String actualPassword = "myActualPassword";
credential.setPassword(actualPassword);
.* matches any character (except newline) zero or more times.
You can use this modified regex in your database WHERE clause to filter out rows based on the presence of Oracle JDBC URLs with the specified port and schema.

For example, if you have a table called "my_table" with a column named "url_column," and you want to retrieve rows where the "url_column" contains an Oracle JDBC URL with a specific port (e.g., 1521) and schema (e.g., "hr"), you can use the following SQL query:

sql
Copy code
SELECT * FROM my_table WHERE url_column REGEXP_LIKE(url_column, '.*jdbc:oracle:(?:thin|oci|kprb):[^:]+:1521/(?:hr).*');
Adjust the table and column names, port number, and schema name according to your specific requirements.
