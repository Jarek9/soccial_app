DROP TABLE IF EXISTS SocialNetworkPostDataBase;
CREATE TABLE SocialNetworkPostDataBase (
PostId int NOT NULL AUTO_INCREMENT PRIMARY KEY,
AuthorName VARCHAR(50) NOT NULL,
PostContent VARCHAR(MAX) NOT NULL,
PostDate DATE,
ViewCount int NOT NULL
);
