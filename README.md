<h1><u>In order for the jersey project to work with tomcat 10 make sure to add this in the maven archetype</u></h1>

GroupId : org.glassfish.jersey.archetypes <br />
ArtifactId : jersey-quickstart-webapp <br />
Version : 3.1.3 <br />


<h1><u>Refer AlienResource.java in order to create a Get request which returns Alien objext as Json data</u></h1>
<b>In order for Json data to be shown on the browser when hitting the resource url add this to pom.xml</b>


    <dependency>
        <groupId>org.glassfish.jersey.media</groupId>
        <artifactId>jersey-media-json-jackson</artifactId>
        <version>3.0.0</version>
    </dependency>


**Error message without adding the dependancy:**
      `org.glassfish.jersey.message.internal.WriterInterceptorExecutor$TerminalWriterInterceptor.aroundWriteTo 
      MessageBodyWriter not found for media type=application/json, 
      type=class org.apicode.Alien, genericType=class org.apicode.Alien.
      `

<b>In order for XML data to be shown on the browser when hitting the resource url add this to pom.xml</b>


    <dependency>
        <groupId>org.glassfish.jersey.media</groupId>
        <artifactId>jersey-media-jaxb</artifactId>
        <version>3.0.0</version>
    </dependency>

    <dependency>
        <groupId>jakarta.xml.bind</groupId> //used to import @XmlRootElement which tells java a class's object is returned in xml (refer Alien.java)
        <artifactId>jakarta.xml.bind-api</artifactId>
        <version>3.0.1</version>
    </dependency>

     <dependency>
        <groupId>org.glassfish.jersey.media</groupId>
        <artifactId>jersey-media-json-jackson</artifactId>
        <version>3.0.0</version>
    </dependency>



**Error message without adding the dependancy:**
      `org.glassfish.jersey.message.internal.WriterInterceptorExecutor$TerminalWriterInterceptor.aroundWriteTo 
      MessageBodyWriter not found for media type=application/xml, 
      type=class org.apicode.Alien, genericType=class org.apicode.Alien.
      `

  
