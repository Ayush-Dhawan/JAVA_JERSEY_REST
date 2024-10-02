<h2>Add these in pom.xml to initialize hibernate</h2>

          <dependency>
            <groupId>org.hibernate.orm</groupId>
            <artifactId>hibernate-core</artifactId>
            <version>6.3.1.Final</version>
        </dependency>
        <dependency>
            <groupId>com.mysql</groupId>
            <artifactId>mysql-connector-j</artifactId>
            <version>9.0.0</version>
        </dependency>
        <dependency>
            <groupId>org.glassfish.jaxb</groupId>
            <artifactId>jaxb-runtime</artifactId>
            <version>4.0.3</version>
        </dependency>

<h2>Add hibernate.cfg file in resources folder within src</h2>

<h2>Make the classes you want to save in db as entities (here Alien)</h2>

<h2>Create HibernateUtil class which stores a session once the webserver is loaded, enables us to reuse the session</h2>

<h2>Refer HibernateUtil.java, Alien.java, AlienResource.java, AlienRepository.java (getAllAliens and addNewAlien)</h2>
