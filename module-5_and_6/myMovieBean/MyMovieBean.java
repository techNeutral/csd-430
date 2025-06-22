//Brett Fuller
//CSD-430 Assignment 5 and 6
//6/22/2025

//JavaBean that has all of the database logic and also creates dynamic tables based on the data in the fuller_movies_data table.
package myMovieBean;

public class MyMovieBean implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	
	java.sql.Connection connection;
    java.sql.Statement statement;
	
    //no argument constructor required in a bean that has the connection logic for connecting to the CSD430 database.
	public MyMovieBean() {
		try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		String url = "jdbc:mysql://localhost:3306/CSD430?";
    		connection = java.sql.DriverManager.getConnection(url + "user=student1&password=pass");
    		statement = connection.createStatement();
    	}
    	catch(ClassNotFoundException cnfe) {
    		System.out.print("SQL Exception" + cnfe);
    	}
    	catch(java.sql.SQLException sqle){
    		System.out.print("SQL Exception" + sqle);
    	}
	}
	
	//method that first drops fuller_movies_data if it exists and then creates the empty table in the CSD430 database.
	public String createTable() {
		StringBuilder dataStringBuilder = new StringBuilder();

    	try{
    		statement.executeUpdate("DROP TABLE fuller_movies_data");
    		dataStringBuilder.append("<b>Table fuller_movies_data Dropped.</b><br />");
    	}
    	catch(java.sql.SQLException e){
    		dataStringBuilder.append("<b>Table fuller_movies_data does not exist.</b><br />");
    	}
    	
    	try{
    		statement.executeUpdate("CREATE TABLE fuller_movies_data(Title CHAR(150) NOT NULL, Director CHAR(150) NOT NULL, Year INT NOT NULL PRIMARY KEY, LeadActor CHAR(150) NOT NULL, LeadActress CHAR(150) NOT NULL)");
    		dataStringBuilder.append("<b>Table fuller_movies_data Created.</b><br />");
    	}
    	catch(java.sql.SQLException e){
    		dataStringBuilder.append("<b>Table fuller_movies_data Creation failed.</b><br />");
    	}
    	
    	return dataStringBuilder.toString();
    }

	//method that returns all entries in the fuller_movies_data table in the format of an HTML table.
	public String read() {
	    	
	    	StringBuilder dataStringBuilder = new StringBuilder();    	
	    	
	    	java.sql.ResultSet resultSet = null;   	
	    	
	        try{
	        	resultSet = statement.executeQuery("SELECT * FROM fuller_movies_data");
	        }
	        catch(java.sql.SQLException e){
	        }
	        
	        try{
	            
	        	dataStringBuilder.append("<table border='1' bgcolor='FA8072'>");
	        	
	        	dataStringBuilder.append("<tr>");
				dataStringBuilder.append("<th>");
				dataStringBuilder.append("Title");
				dataStringBuilder.append("</th>");
				dataStringBuilder.append("<th>");
				dataStringBuilder.append("Director");
				dataStringBuilder.append("</th>");
				dataStringBuilder.append("<th>");
				dataStringBuilder.append("Year");
				dataStringBuilder.append("</th>");
				dataStringBuilder.append("<th>");
				dataStringBuilder.append("Lead Actor");
				dataStringBuilder.append("</th>");
				dataStringBuilder.append("<th>");
				dataStringBuilder.append("Lead Actress");
				dataStringBuilder.append("</th>");
				dataStringBuilder.append("</tr>");
	            
	            while(resultSet.next()){
	            	dataStringBuilder.append("<tr>");
	                  
	              for(int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++){
	            	  dataStringBuilder.append("<td>");
	            	  dataStringBuilder.append((resultSet.getString(i)).trim());
	            	  dataStringBuilder.append("</td>");
	              }
	                  
	              dataStringBuilder.append("</tr>");
	            }
	              
	            dataStringBuilder.append("</table>");            
	          }
	          catch(Exception e){
	
	        	System.out.print("<b>Exception.</b><br />");
	        	System.out.print(e);
	          }
	    	
	    	return dataStringBuilder.toString();
	    }
	//create a form that you can select the year, the years are populated on the years in the fuller_movies_data table.
	public String formGetPK(String requestURL) {
		
		java.sql.ResultSet resultSet = null;
	
	    try{
	    	
	    	resultSet = statement.executeQuery("SELECT Year FROM fuller_movies_data");
	    }
	    catch(java.sql.SQLException e){
	    }
		
		
		StringBuilder dataStringBuilder = new StringBuilder();
		
		// Add Data to StringBuilder
		dataStringBuilder.append("<form method='post' action='" + requestURL + "'>\n");    	
		dataStringBuilder.append("<label>Select the year to see what movie won best pircture at the Oscars that year</label>&nbsp;&nbsp;&nbsp;\n");    	
		dataStringBuilder.append("<br /> \n");    	
		dataStringBuilder.append("<label for=\\\"Year\\\">Select a Year:</label>\n");    	
		dataStringBuilder.append("<select name=\"Year\" id=\"lYear\">\n");    	
	
	    try{
	        
	        while(resultSet.next()){
	
	          for(int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++){
	
	        	dataStringBuilder.append("<option value=\"");
	
	        	dataStringBuilder.append((resultSet.getString(i)));
	
	        	dataStringBuilder.append("\">\n");
	
	        	dataStringBuilder.append((resultSet.getString(i)));
	
	        	dataStringBuilder.append("</option>");          	
	          }
	        }
	        
	      }
	      catch(Exception e){
	
	    	System.out.print("<b>Exception.</b><br />");
	    	System.out.print(e);
	      }
	
		dataStringBuilder.append("</select>");
	
		dataStringBuilder.append("<input type='submit' />");
	
		dataStringBuilder.append("</form>");
	
		resultSet = null;
		
		return dataStringBuilder.toString();
	}
	
	//method to get a record from the fuller_movies_data table based on a date that the user selected.
	public String getOscarFromYear(int year) {
		
		StringBuilder dataStringBuilder = new StringBuilder();    	
		
		//create empty result set
		java.sql.ResultSet resultSet = null;   
		
		//query database for the date provided by the user
	    try{
	    	resultSet = statement.executeQuery("SELECT * FROM fuller_movies_data Where Year = " + year);
	    }
	    catch(java.sql.SQLException e){
	    }
	    //create a table to display the selected record in 
	    try{
	        
	    	dataStringBuilder.append("<table border='1' bgcolor='FA8072'>");
	    	dataStringBuilder.append("<tr>");
			dataStringBuilder.append("<th>");
			dataStringBuilder.append("Title");
			dataStringBuilder.append("</th>");
			dataStringBuilder.append("<th>");
			dataStringBuilder.append("Director");
			dataStringBuilder.append("</th>");
			dataStringBuilder.append("<th>");
			dataStringBuilder.append("Year");
			dataStringBuilder.append("</th>");
			dataStringBuilder.append("<th>");
			dataStringBuilder.append("Lead Actor");
			dataStringBuilder.append("</th>");
			dataStringBuilder.append("<th>");
			dataStringBuilder.append("Lead Actress");
			dataStringBuilder.append("</th>");
			dataStringBuilder.append("</tr>");
	        
	        while(resultSet.next()){
	        	
	        	dataStringBuilder.append("<tr>");
	              
	          for(int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++){
	        	  
	        	  dataStringBuilder.append("<td>");
	        	  dataStringBuilder.append((resultSet.getString(i)).trim());
	        	  dataStringBuilder.append("</td>");
	          }
	              
	          dataStringBuilder.append("</tr>");
	        }
	          
	        dataStringBuilder.append("</table>");            
	      }
	      catch(Exception e){
	
	    	System.out.print("<b>Exception.</b><br />");
	    	System.out.print(e);
	      }
		
		return dataStringBuilder.toString();
	}

	// method to add all records to the fuller_movies_data table
	public String populateTable() {
		StringBuilder dataStringBuilder = new StringBuilder();

    	try{
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('Anora', 'Sean Baker', 2024, 'Mark Eydelshteyn', 'Mikey Madison')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('Oppenheimer', 'Christopher Nolan', 2023, 'Cillian Murphy', 'Emily Blunt')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('Everything Everywhere All at Once', 'Daniels', 2022, 'Ke Huy Quan', 'Michelle Yeoh')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('CODA', 'Sian Heder', 2021, 'Emilia Jones', 'Marlee Matlin')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('Nomadland', 'Chloé Zhao', 2020, 'David Strathairn', 'Frances McDormand')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('Parasite', 'Bong Joon-ho', 2019, 'Song Kang-ho', 'Cho Yeo-jeong')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('Green Book', 'Peter Farrelly', 2018, 'Viggo Mortensen', 'Linda Cardellini')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('The Shape of Water', 'Guillermo del Toro', 2017, 'Doug Jones', 'Sally Hawkins')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('Moonlight', 'Barry Jenkins', 2016, 'Mahershala Ali', 'Naomie Harris')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('Spotlight', 'Tom McCarthy', 2015, 'Mark Ruffalo', 'Rachel McAdams')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('Birdman', 'Alejandro G. Iñárritu', 2014, 'Michael Keaton', 'Emma Stone')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('12 Years a Slave', 'Steve McQueen', 2013, 'Chiwetel Ejiofor', 'Lupita Nyongo')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('Argo', 'Ben Affleck', 2012, 'Ben Affleck', 'Kerry Condon')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('The Artist', 'Michel Hazanavicius', 2011, 'Jean Dujardin', 'Bérénice Bejo')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('The Kings Speech', 'Tom Hooper', 2010, 'Colin Firth', 'Helena Bonham Carter')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('The Hurt Locker', 'Kathryn Bigelow', 2009, 'Jeremy Renner', 'N/A')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('Slumdog Millionaire', 'Danny Boyle', 2008, 'Dev Patel', 'Freida Pinto')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('No Country for Old Men', 'Ethan Coen & Joel Coen', 2007, 'Josh Brolin', 'Kelly Macdonald')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('The Departed', 'Martin Scorsese', 2006, 'Leonardo DiCaprio', 'Vera Farmiga')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('Crash', 'Paul Haggis', 2005, 'Don Cheadle', 'Sandra Bullock')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('Million Dollar Baby', 'Clint Eastwood', 2004, 'Clint Eastwood', 'Hilary Swank')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('The Lord of the Rings: The Return of the King', 'Peter Jackson', 2003, 'Viggo Mortensen', 'Liv Tyler')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('Chicago', 'Rob Marshall', 2002, 'Richard Gere', 'Catherine Zeta-Jones')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('A Beautiful Mind', 'Ron Howard', 2001, 'Russell Crowe', 'Jennifer Connelly')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('Gladiator', 'Ridley Scott', 2000, 'Russell Crowe', 'Connie Nielsen')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('American Beauty', 'Sam Mendes', 1999, 'Kevin Spacey', 'Annette Bening')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('Shakespeare in Love', 'John Madden', 1998, 'Joseph Fiennes', 'Gwyneth Paltrow')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('Titanic', 'James Cameron', 1997, 'Leonardo DiCaprio', 'Kate Winslet')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('The English Patient', 'Anthony Minghella', 1996, 'Ralph Fiennes', 'Kristin Scott Thomas')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('Braveheart', 'Mel Gibson', 1995, 'Mel Gibson', 'Sophie Marceau')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('Forrest Gump', 'Robert Zemeckis', 1994, 'Tom Hanks', 'Robin Wright')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('Schindlers List', 'Steven Spielberg', 1993, 'Liam Neeson', 'Caroline Goodall')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('Unforgiven', 'Clint Eastwood', 1992, 'Clint Eastwood', 'Gene Hackman')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('The Silence of the Lambs', 'Jonathan Demme', 1991, 'Anthony Hopkins', 'Jodie Foster')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('Dances with Wolves', 'Kevin Costner', 1990, 'Kevin Costner', 'Mary McDonnell')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('Driving Miss Daisy', 'Bruce Beresford', 1989, 'Morgan Freeman', 'Jessica Tandy')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('Rain Man', 'Barry Levinson', 1988, 'Dustin Hoffman', 'Valeria Golino')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('The Last Emperor', 'Bernardo Bertolucci', 1987, 'John Lone', 'Joan Chen')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('Platoon', 'Oliver Stone', 1986, 'Charlie Sheen', 'N/A')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('Out of Africa', 'Sydney Pollack', 1985, 'Robert Redford', 'Meryl Streep')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('Amadeus', 'Milos Forman', 1984, 'F. Murray Abraham', 'Elizabeth Berridge')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('Terms of Endearment', 'James L. Brooks', 1983, 'Jack Nicholson', 'Shirley MacLaine')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('Gandhi', 'Richard Attenborough', 1982, 'Ben Kingsley', 'Candice Bergen')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('Chariots of Fire', 'Hugh Hudson', 1981, 'Ben Cross', 'Alice Krige')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('Ordinary People', 'Robert Redford', 1980, 'Donald Sutherland', 'Mary Tyler Moore')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('Kramer vs. Kramer', 'Robert Benton', 1979, 'Dustin Hoffman', 'Meryl Streep')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('The Deer Hunter', 'Michael Cimino', 1978, 'Robert De Niro', 'Meryl Streep')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('Annie Hall', 'Woody Allen', 1977, 'Woody Allen', 'Diane Keaton')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('Rocky', 'John G. Avildsen', 1976, 'Sylvester Stallone', 'Talia Shire')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('One Flew Over the Cuckoos Nest', 'Milos Forman', 1975, 'Jack Nicholson', 'Louise Fletcher')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('The Godfather Part II', 'Francis Ford Coppola', 1974, 'Al Pacino', 'Diane Keaton')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('The Sting', 'George Roy Hill', 1973, 'Paul Newman', 'Robert Redford')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('The Godfather', 'Francis Ford Coppola', 1972, 'Marlon Brando', 'Diane Keaton')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('The French Connection', 'William Friedkin', 1971, 'Gene Hackman', 'N/A')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('Patton', 'Franklin J. Schaffner', 1970, 'George C. Scott', 'N/A')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('Midnight Cowboy', 'John Schlesinger', 1969, 'Dustin Hoffman', 'N/A')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('Oliver!', 'Carol Reed', 1968, 'Ron Moody', 'Shani Wallis')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('In the Heat of the Night', 'Norman Jewison', 1967, 'Sidney Poitier', 'Lee Grant')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('A Man for All Seasons', 'Fred Zinnemann', 1966, 'Paul Scofield', 'Wendy Hiller')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('The Sound of Music', 'Robert Wise', 1965, 'Christopher Plummer', 'Julie Andrews')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('My Fair Lady', 'George Cukor', 1964, 'Rex Harrison', 'Audrey Hepburn')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('Tom Jones', 'Tony Richardson', 1963, 'Albert Finney', 'Susannah York')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('Lawrence of Arabia', 'David Lean', 1962, 'Peter OToole', 'N/A')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('West Side Story', 'Robert Wise & Jerome Robbins', 1961, 'Richard Beymer', 'Natalie Wood')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('The Apartment', 'Billy Wilder', 1960, 'Jack Lemmon', 'Shirley MacLaine')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('Ben-Hur', 'William Wyler', 1959, 'Charlton Heston', 'Haya Harareet')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('Gigi', 'Vincente Minnelli', 1958, 'Louis Jourdan', 'Leslie Caron')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('The Bridge on the River Kwai', 'David Lean', 1957, 'William Holden', 'N/A')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('Around the World in 80 Days', 'Michael Anderson', 1956, 'David Niven', 'Shirley MacLaine')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('Marty', 'Delbert Mann', 1955, 'Ernest Borgnine', 'Betsy Blair')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('On the Waterfront', 'Elia Kazan', 1954, 'Marlon Brando', 'Eva Marie Saint')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('From Here to Eternity', 'Fred Zinnemann', 1953, 'Burt Lancaster', 'Deborah Kerr')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('The Greatest Show on Earth', 'Cecil B. DeMille', 1952, 'Charlton Heston', 'Betty Hutton')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('An American in Paris', 'Vincente Minnelli', 1951, 'Gene Kelly', 'Leslie Caron')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('All About Eve', 'Joseph L. Mankiewicz', 1950, 'Bette Davis', 'Anne Baxter')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('All the Kings Men', 'Robert Rossen', 1949, 'Broderick Crawford', 'Joanne Dru')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('Hamlet', 'Laurence Olivier', 1948, 'Laurence Olivier', 'Jean Simmons')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('Gentlemans Agreement', 'Elia Kazan', 1947, 'Gregory Peck', 'Dorothy McGuire')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('The Best Years of Our Lives', 'William Wyler', 1946, 'Fredric March', 'Myrna Loy')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('The Lost Weekend', 'Billy Wilder', 1945, 'Ray Milland', 'Jane Wyman')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('Going My Way', 'Leo McCarey', 1944, 'Bing Crosby', 'Ingrid Bergman')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('Casablanca', 'Michael Curtiz', 1943, 'Humphrey Bogart', 'Ingrid Bergman')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('Mrs. Miniver', 'William Wyler', 1942, 'Walter Pidgeon', 'Greer Garson')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('How Green Was My Valley', 'John Ford', 1941, 'Walter Pidgeon', 'Maureen OHara')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('Rebecca', 'Alfred Hitchcock', 1940, 'Laurence Olivier', 'Joan Fontaine')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('Gone with the Wind', 'Victor Fleming', 1939, 'Clark Gable', 'Vivien Leigh')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('You Cant Take It with You', 'Frank Capra', 1938, 'James Stewart', 'Jean Arthur')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('The Life of Emile Zola', 'William Dieterle', 1937, 'Paul Muni', 'Gale Sondergaard')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('The Great Ziegfeld', 'Robert Z. Leonard', 1936, 'William Powell', 'Myrna Loy')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('Mutiny on the Bounty', 'Frank Lloyd', 1935, 'Charles Laughton', 'N/A')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('It Happened One Night', 'Frank Capra', 1934, 'Clark Gable', 'Claudette Colbert')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('Cavalcade', 'Frank Lloyd', 1932, 'Clive Brook', 'Diana Wynyard')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('Grand Hotel', 'Edmund Goulding', 1931, 'John Barrymore', 'Greta Garbo')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('Cimarron', 'Wesley Ruggles', 1930, 'Richard Dix', 'Irene Dunne')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('All Quiet on the Western Front', 'Lewis Milestone', 1929, 'Lew Ayres', 'N/A')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('The Broadway Melody', 'Harry Beaumont', 1928, 'Charles King', 'Anita Page')");
    		statement.executeUpdate("INSERT INTO fuller_movies_data(Title, Director, Year, LeadActor, LeadActress)VALUES('Wings', 'William A. Wellman', 1927, 'Charles Rogers', 'Clara Bow')");

    		//commit the changes to the database
    		statement.executeUpdate("COMMIT");
            
            dataStringBuilder.append("All Records added to the table");
    	}
    	catch(java.sql.SQLException e){
    		dataStringBuilder.append("<b>Error inserting data</b><br />");
    	}
    	
    	return dataStringBuilder.toString();
    }
	
}
