# soccial_app
Springboot maven project that will expose a CRUD API

EndPoints:

GET:
http://localhost:8090/socialNetworkPost/all               -retrieve list of all posts

http://localhost:8090/socialNetworkPost/topPosts          -retrieve list of 10 most popular posts (biggest view number)

http://localhost:8090/socialNetworkPost/find/{postId}     -find a single post

POST:
http://localhost:8090/socialNetworkPost/add               -create new post
{
        
        "authorName": "Kass",
        "postDate": "2017-02-18",
        "postContent": "Consequat voluptate duis deserunt sit amet ex quis amet ipsum. Magna ad deserunt velit reprehenderit veniam laboris est aute in proident. Cupidatat laborum consectetur proident irure Lorem duis aliquip pariatur. In enim culpa anim proident officia quis velit.\r\n"
       
    }
PUT:
http://localhost:8090/socialNetworkPost/update/{postId}   -update post

{
        "authorName": "Kassi",
        "postContent": "Consequat . In enim culpa anim proident officia quis velit.\r\n",
        "postDate": "2017-02-18",
        "viewCount": 7
}

To open data base console:
http://localhost:8090/h2-console

App properties:

spring.sql.init.mode=always

spring.sql.init.platform=h2

spring.datasource.url=jdbc:h2:file:./h2-local-storage/SocialNetworkPostDataBase

spring.datasource.driverClassName=org.h2.Driver

spring.datasource.username=sa

spring.datasource.password=pass

spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

spring.jpa.defer-datasource-initialization=true

spring.h2.console.enabled=true

spring.jpa.properties.hibernate.id.new_generator_mappings=false

server.port=8090

