/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;

/**
 *
 * @author ryanzaeni
 */
public class Javasql {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection conn = null; //general connection to database
        Statement stmt = null; //statement for general connection
        Connection booksconn =  null; //connection to books in database
        Statement booksstmt =  null; //statment for books connection
        
        String sqlCreateDatabaseBooks = "CREATE DATABASE IF NOT EXISTS Books";
        
        
        String sqlCreateTablepublishers = "CREATE TABLE IF NOT EXISTS publishers"
        + "(publisherID INTEGER, "
        + " publisherName CHAR(100), "
        + "PRIMARY KEY( publisherID ))";
        
        String sqlCreateTabletitles = "CREATE TABLE IF NOT EXISTS titles"
        + " (isbn CHAR(10), "
        + " title varchar(500), "
        + " editionNumber INTEGER, "
        + " year CHAR(4), "
        + " publisherID INTEGER, "
        + " price DECIMAL (5,2) NOT NULL, "
        + " PRIMARY KEY( isbn ), "
        + " FOREIGN KEY (publisherID) REFERENCES publishers(publisherID))";
        
        String sqlCreateTableauthors = "CREATE TABLE IF NOT EXISTS authors"
        + "(authorID INTEGER not NULL AUTO_INCREMENT, "
        + " firstName CHAR(20), "
        + " lastName CHAR(20), "
        + " PRIMARY KEY ( authorID ))";
        
        String sqlCreateTableauthorISBN = "CREATE TABLE IF NOT EXISTS authorISBN"
        + "(authorID INTEGER, "
        + " isbn CHAR(10), "
        + " FOREIGN KEY(authorID) REFERENCES authors(authorID), "
        + " FOREIGN KEY(isbn) REFERENCES titles(isbn))";
        
        
        
        
        
        //HERE ARE INSERT STRINGS FOR AUTHOR TABLE
        String authorEntry1 = "INSERT IGNORE INTO Books.authors(authorID, firstName, lastName) VALUES (1, 'Ryan', 'Zaeni')";
        String authorEntry2 = "INSERT IGNORE INTO Books.authors(authorID, firstName, lastName) VALUES (2, 'John', 'Johnson')";
        String authorEntry3 = "INSERT IGNORE INTO Books.authors(authorID, firstName, lastName) VALUES (3, 'Ahmed', 'Ezzat')";
        String authorEntry4 = "INSERT IGNORE INTO Books.authors(authorID, firstName, lastName) VALUES (4, 'Rick', 'Ross')";
        String authorEntry5 = "INSERT IGNORE INTO Books.authors(authorID, firstName, lastName) VALUES (5, 'Rick', 'Jones')";
        String authorEntry6 = "INSERT IGNORE INTO Books.authors(authorID, firstName, lastName) VALUES (6, 'Peter', 'Griffin')";
        String authorEntry7 = "INSERT IGNORE INTO Books.authors(authorID, firstName, lastName) VALUES (7, 'Peter', 'Parker')";
        String authorEntry8 = "INSERT IGNORE INTO Books.authors(authorID, firstName, lastName) VALUES (8, 'Jack', 'Black')";
        String authorEntry9 = "INSERT IGNORE INTO Books.authors(authorID, firstName, lastName) VALUES (9, 'Nick', 'Jonas')";
        String authorEntry10 = "INSERT IGNORE INTO Books.authors(authorID, firstName, lastName) VALUES (10, 'Taylor', 'Swift')";
        String authorEntry11 = "INSERT IGNORE INTO Books.authors(authorID, firstName, lastName) VALUES (11, 'Donald', 'Trump')";
        String authorEntry12 = "INSERT IGNORE INTO Books.authors(authorID, firstName, lastName) VALUES (12, 'Barrack', 'Obama')";
        String authorEntry13 = "INSERT IGNORE INTO Books.authors(authorID, firstName, lastName) VALUES (13, 'George', 'Bush')";
        String authorEntry14 = "INSERT IGNORE INTO Books.authors(authorID, firstName, lastName) VALUES (14, 'Bill', 'Clinton')";
        String authorEntry15 = "INSERT IGNORE INTO Books.authors(authorID, firstName, lastName) VALUES (15, 'Hilary', 'Clinton')";
        
        //HERE ARE INSERT STRINGS FOR authorISBN TABLE
        String authorISBNEntry1 = "INSERT IGNORE INTO Books.authorISBN(authorID, isbn) VALUES (1, 'ABC1')";
        String authorISBNEntry2 = "INSERT IGNORE INTO Books.authorISBN(authorID, isbn) VALUES (2, 'ABC2')";
        String authorISBNEntry3 = "INSERT IGNORE INTO Books.authorISBN(authorID, isbn) VALUES (3, 'ABC3')";
        String authorISBNEntry4 = "INSERT IGNORE INTO Books.authorISBN(authorID, isbn) VALUES (4, 'ABC4')";
        String authorISBNEntry5 = "INSERT IGNORE INTO Books.authorISBN(authorID, isbn) VALUES (5, 'ABC5')";
        String authorISBNEntry6 = "INSERT IGNORE INTO Books.authorISBN(authorID, isbn) VALUES (6, 'ABC6')";
        String authorISBNEntry7 = "INSERT IGNORE INTO Books.authorISBN(authorID, isbn) VALUES (7, 'ABC7')";
        String authorISBNEntry8 = "INSERT IGNORE INTO Books.authorISBN(authorID, isbn) VALUES (8, 'ABC8')";
        String authorISBNEntry9 = "INSERT IGNORE INTO Books.authorISBN(authorID, isbn) VALUES (9, 'ABC9')";
        String authorISBNEntry10 = "INSERT IGNORE INTO Books.authorISBN(authorID, isbn) VALUES (10, 'ABC10')";
        String authorISBNEntry11 = "INSERT IGNORE INTO Books.authorISBN(authorID, isbn) VALUES (11, 'ABC11')";
        String authorISBNEntry12 = "INSERT IGNORE INTO Books.authorISBN(authorID, isbn) VALUES (12, 'ABC12')";
        String authorISBNEntry13 = "INSERT IGNORE INTO Books.authorISBN(authorID, isbn) VALUES (13, 'ABC13')";
        String authorISBNEntry14 = "INSERT IGNORE INTO Books.authorISBN(authorID, isbn) VALUES (14, 'ABC14')";
        String authorISBNEntry15 = "INSERT IGNORE INTO Books.authorISBN(authorID, isbn) VALUES (15, 'ABC15')";
        
        
        //HERE ARE INSERT STRINGS FOR titles TABLE
        String titlesEntry1 = "INSERT IGNORE INTO Books.titles(isbn, title, editionNumber, year, publisherID, price) VALUES ('ABC1', 'Harry Potter', 1, 2000, 1, 30.00)";
        String titlesEntry2 = "INSERT IGNORE INTO Books.titles(isbn, title, editionNumber, year, publisherID, price) VALUES ('ABC2', 'Harry Potter', 3, 2002, 1, 30.00)";
        String titlesEntry3 = "INSERT IGNORE INTO Books.titles(isbn, title, editionNumber, year, publisherID, price) VALUES ('ABC3', 'Heart Of Darkness', 1, 1990, 2, 10.00)";
        String titlesEntry4 = "INSERT IGNORE INTO Books.titles(isbn, title, editionNumber, year, publisherID, price) VALUES ('ABC4', 'Lord Of The Rings', 1, 1999, 3, 60.00)";
        String titlesEntry5 = "INSERT IGNORE INTO Books.titles(isbn, title, editionNumber, year, publisherID, price) VALUES ('ABC5', 'Lord Of The Rings', 2, 2001, 3, 70.00)";
        String titlesEntry6 = "INSERT IGNORE INTO Books.titles(isbn, title, editionNumber, year, publisherID, price) VALUES ('ABC6', 'Lord Of The Rings', 3, 2003, 3, 70.00)";
        String titlesEntry7 = "INSERT IGNORE INTO Books.titles(isbn, title, editionNumber, year, publisherID, price) VALUES ('ABC7', 'The Great Gatsby', 1, 1960, 4, 30.00)";
        String titlesEntry8 = "INSERT IGNORE INTO Books.titles(isbn, title, editionNumber, year, publisherID, price) VALUES ('ABC8', 'The Beauty and The Beast', 5, 1980, 5, 20.00)";
        String titlesEntry9 = "INSERT IGNORE INTO Books.titles(isbn, title, editionNumber, year, publisherID, price) VALUES ('ABC9', 'Animal Farm', 1, 1985, 6, 25.00)";
        String titlesEntry10 = "INSERT IGNORE INTO Books.titles(isbn, title, editionNumber, year, publisherID, price) VALUES ('ABC10', 'The Hardy Boys', 1, 1950, 7, 20.00)";
        String titlesEntry11 = "INSERT IGNORE INTO Books.titles(isbn, title, editionNumber, year, publisherID, price) VALUES ('ABC11', 'Python for Dummies', 1, 2003, 8, 50.00)";
        String titlesEntry12 = "INSERT IGNORE INTO Books.titles(isbn, title, editionNumber, year, publisherID, price) VALUES ('ABC12', 'Java for Dummies', 1, 1995, 8, 50.00)";
        String titlesEntry13 = "INSERT IGNORE INTO Books.titles(isbn, title, editionNumber, year, publisherID, price) VALUES ('ABC13', 'C for Dummies', 1, 1990, 8, 50.00)";
        String titlesEntry14 = "INSERT IGNORE INTO Books.titles(isbn, title, editionNumber, year, publisherID, price) VALUES ('ABC14', 'C++ for Dummies', 1, 1992, 8, 50.00)";
        String titlesEntry15 = "INSERT IGNORE INTO Books.titles(isbn, title, editionNumber, year, publisherID, price) VALUES ('ABC15', 'Hadoop for DUmmies', 1, 2005, 8, 50.00)";
        
        
        
        
        //HERE ARE INSERTS FOR publishers TABLE
        String publishersEntry1 = "INSERT IGNORE INTO Books.publishers(publisherID, publisherName) VALUES (1, 'HarryPotterPublisher')";
        String publishersEntry2 = "INSERT IGNORE INTO Books.publishers(publisherID, publisherName) VALUES (2, 'HeartOfDarknessPublisher')";
        String publishersEntry3 = "INSERT IGNORE INTO Books.publishers(publisherID, publisherName) VALUES (3, 'LordOfTheRingsPublisher')";
        String publishersEntry4 = "INSERT IGNORE INTO Books.publishers(publisherID, publisherName) VALUES (4, 'GreatGatsbyPublisher')";
        String publishersEntry5 = "INSERT IGNORE INTO Books.publishers(publisherID, publisherName) VALUES (5, 'TheBeautyAndTheBeastPublisher')";
        String publishersEntry6 = "INSERT IGNORE INTO Books.publishers(publisherID, publisherName) VALUES (6, 'AnimalFarmPublisher')";
        String publishersEntry7 = "INSERT IGNORE INTO Books.publishers(publisherID, publisherName) VALUES (7, 'TheHardyBoysPublisher')";
        String publishersEntry8 = "INSERT IGNORE INTO Books.publishers(publisherID, publisherName) VALUES (8, 'ForDummiesPublisher')";
        String publishersEntry9 = "INSERT IGNORE INTO Books.publishers(publisherID, publisherName) VALUES (9, 'GameOfThronesPublisher')";
        String publishersEntry10 = "INSERT IGNORE INTO Books.publishers(publisherID, publisherName) VALUES (10, '10Publisher')";
        String publishersEntry11 = "INSERT IGNORE INTO Books.publishers(publisherID, publisherName) VALUES (11, '11Publisher')";
        String publishersEntry12 = "INSERT IGNORE INTO Books.publishers(publisherID, publisherName) VALUES (12, '12Publisher')";
        String publishersEntry13 = "INSERT IGNORE INTO Books.publishers(publisherID, publisherName) VALUES (13, '13Publisher')";
        String publishersEntry14 = "INSERT IGNORE INTO Books.publishers(publisherID, publisherName) VALUES (14, '14Publisher')";
        String publishersEntry15 = "INSERT IGNORE INTO Books.publishers(publisherID, publisherName) VALUES (15, '15Publisher')";
        
        //HERE ARE THE RESULTSET OBJECTS
        ResultSet rsSelectAllAuthorsFromauthors = null;
        ResultSet rsSelectAllPublishersFrompublishers = null;
        ResultSet rsSelectSpecificPublisher = null;
        
        
        
        
        try{
            //This is where we load the JDBC driver(Step 1)
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("WORKS");
            
            
            //All DB access is within try/catch block(Step 2)
            //Connect to the database specifying the user, password
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Books","root", "password" );
            stmt = conn.createStatement();
            
            stmt.execute(sqlCreateDatabaseBooks); //Create Schema Books
            System.out.println("Created Database Books");
            
            //Now connect to Books within LocalHost
            booksconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Books", "root" , "password");
            booksstmt = booksconn.createStatement();
            
            //Now Create the tables needed.
            booksstmt.executeUpdate(sqlCreateTablepublishers);
            booksstmt.executeUpdate(sqlCreateTabletitles);
            booksstmt.executeUpdate(sqlCreateTableauthors);
            booksstmt.executeUpdate(sqlCreateTableauthorISBN);
            
            
            System.out.println("Tables are now created");
            
            //Put values in the publishers table
            booksstmt.executeUpdate(publishersEntry1);
            booksstmt.executeUpdate(publishersEntry2);
            booksstmt.executeUpdate(publishersEntry3);
            booksstmt.executeUpdate(publishersEntry4);
            booksstmt.executeUpdate(publishersEntry5);
            booksstmt.executeUpdate(publishersEntry6);
            booksstmt.executeUpdate(publishersEntry7);
            booksstmt.executeUpdate(publishersEntry8);
            booksstmt.executeUpdate(publishersEntry9);
            booksstmt.executeUpdate(publishersEntry10);
            booksstmt.executeUpdate(publishersEntry12);
            booksstmt.executeUpdate(publishersEntry13);
            booksstmt.executeUpdate(publishersEntry14);
            booksstmt.executeUpdate(publishersEntry15);
            
            //Put values in the table titles
            booksstmt.executeUpdate(titlesEntry1);
            booksstmt.executeUpdate(titlesEntry2);
            booksstmt.executeUpdate(titlesEntry3);
            booksstmt.executeUpdate(titlesEntry4);
            booksstmt.executeUpdate(titlesEntry5);
            booksstmt.executeUpdate(titlesEntry6);
            booksstmt.executeUpdate(titlesEntry7);
            booksstmt.executeUpdate(titlesEntry8);
            booksstmt.executeUpdate(titlesEntry9);
            booksstmt.executeUpdate(titlesEntry10);
            booksstmt.executeUpdate(titlesEntry11);
            booksstmt.executeUpdate(titlesEntry12);
            booksstmt.executeUpdate(titlesEntry13);
            booksstmt.executeUpdate(titlesEntry14);
            booksstmt.executeUpdate(titlesEntry15);
            
            
            
            //Now Time to put values in the table author
            booksstmt.executeUpdate(authorEntry1);
            booksstmt.executeUpdate(authorEntry2);
            booksstmt.executeUpdate(authorEntry3);
            booksstmt.executeUpdate(authorEntry4);
            booksstmt.executeUpdate(authorEntry5);
            booksstmt.executeUpdate(authorEntry6);
            booksstmt.executeUpdate(authorEntry7);
            booksstmt.executeUpdate(authorEntry8);
            booksstmt.executeUpdate(authorEntry9);
            booksstmt.executeUpdate(authorEntry10);
            booksstmt.executeUpdate(authorEntry11);
            booksstmt.executeUpdate(authorEntry12);
            booksstmt.executeUpdate(authorEntry13);
            booksstmt.executeUpdate(authorEntry14);
            booksstmt.executeUpdate(authorEntry15);
            
            
            //Put values in the table authorISBN
            booksstmt.executeUpdate(authorISBNEntry1);
            booksstmt.executeUpdate(authorISBNEntry2);
            booksstmt.executeUpdate(authorISBNEntry3);
            booksstmt.executeUpdate(authorISBNEntry4);
            booksstmt.executeUpdate(authorISBNEntry5);
            booksstmt.executeUpdate(authorISBNEntry6);
            booksstmt.executeUpdate(authorISBNEntry7);
            booksstmt.executeUpdate(authorISBNEntry8);
            booksstmt.executeUpdate(authorISBNEntry9);
            booksstmt.executeUpdate(authorISBNEntry10);
            booksstmt.executeUpdate(authorISBNEntry11);
            booksstmt.executeUpdate(authorISBNEntry12);
            booksstmt.executeUpdate(authorISBNEntry13);
            booksstmt.executeUpdate(authorISBNEntry14);
            booksstmt.executeUpdate(authorISBNEntry15);
            
            //TIME TO EXECUTE SOME QUERIES
            
            
            
            
            //EXECUTE ALL AUTHORS BY LAST NAME ORDER QUERY
            System.out.println();
            System.out.println("**************All Authors By Ordered Last Name**************** ");
            rsSelectAllAuthorsFromauthors = booksstmt.executeQuery("SELECT * FROM authors ORDER BY lastName ASC, firstName ASC");
            while(rsSelectAllAuthorsFromauthors.next()){
                System.out.println(rsSelectAllAuthorsFromauthors.getString("lastName") + " " +
                                   rsSelectAllAuthorsFromauthors.getString("firstName"));
            }
            
            //QUERY ALL PUBLISHERS FROM PUBLISHERS TABLE
            System.out.println();
            System.out.println("********All Publishers*************");
            rsSelectAllPublishersFrompublishers = booksstmt.executeQuery("SELECT * FROM publishers");
            while(rsSelectAllPublishersFrompublishers.next()){
                System.out.println(rsSelectAllPublishersFrompublishers.getString("publisherName"));
            }
            
            //QUERY FOR SPECIFIC PUBLISHER AND LIST ALL THEIR BOOKS. ORDERED BY TITLE.
            //rsSelectSpecificPublisher = booksstmt.executeQuery("SELECT * FROM ")
            
            
        }
        catch(SQLException se){
            se.printStackTrace();
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }finally{
            try{
                if(stmt != null)
                    stmt.close();
            } catch(SQLException se1){
                
            }
            try{
                if(conn != null)
                    conn.close();
            }catch(SQLException se)
            {
                se.printStackTrace();
            }
        }//end finally block
        
    }
    
}
