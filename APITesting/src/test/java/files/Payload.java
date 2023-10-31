package files;

public class Payload {

	
	public static String AddPlace() {
		
		return "{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -38.383494,\r\n"
				+ "    \"lng\": 33.427362\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \"SVR Nivas123\",\r\n"
				+ "  \"phone_number\": \"(+91) 123 456 789\",\r\n"
				+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"http://google.com\",\r\n"
				+ "  \"language\": \"French-IN\"\r\n"
				+ "}\r\n"
				+ "";
	}
public static String AddPlace(String Lat, String Long, String Accuracy, String Name, String PhoneNumber, String Address, String Website, String Language) {
		
		return "{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": "+Lat+",\r\n"
				+ "    \"lng\": "+Long+"\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": "+Accuracy+",\r\n"
				+ "  \"name\": \""+Name+"\",\r\n"
				+ "  \"phone_number\": \""+PhoneNumber+"\",\r\n"
				+ "  \"address\": \""+Address+"\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \""+Website+"\",\r\n"
				+ "  \"language\": \""+Language+"\"\r\n"
				+ "}\r\n"
				+ "";
	}
	
	public static String UpdatePlace(String Place) {
		
		return "{\r\n"
				+ "\"place_id\":\""+Place+"\",\r\n"
				+ "\"address\":\"SVR Nivas, Anakapalli\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}\r\n"
				+ "";
	}
	
	public static String Test() {
		return "{\r\n"
				+ "\r\n"
				+ "\"dashboard\": {\r\n"
				+ "\r\n"
				+ "\"purchaseAmount\": 910,\r\n"
				+ "\r\n"
				+ "\"website\": \"rahulshettyacademy.com\"\r\n"
				+ "\r\n"
				+ "},\r\n"
				+ "\r\n"
				+ "\"courses\": [\r\n"
				+ "\r\n"
				+ "{\r\n"
				+ "\r\n"
				+ "\"title\": \"Selenium Python\",\r\n"
				+ "\r\n"
				+ "\"price\": 50,\r\n"
				+ "\r\n"
				+ "\"copies\": 6\r\n"
				+ "\r\n"
				+ "},\r\n"
				+ "\r\n"
				+ "{\r\n"
				+ "\r\n"
				+ "\"title\": \"Cypress\",\r\n"
				+ "\r\n"
				+ "\"price\": 40,\r\n"
				+ "\r\n"
				+ "\"copies\": 4\r\n"
				+ "\r\n"
				+ "},\r\n"
				+ "\r\n"
				+ "{\r\n"
				+ "\r\n"
				+ "\"title\": \"RPA\",\r\n"
				+ "\r\n"
				+ "\"price\": 45,\r\n"
				+ "\r\n"
				+ "\"copies\": 10\r\n"
				+ "\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "]\r\n"
				+ "\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "";
	}
	
	public static String libraryData() {
		return "{\r\n"
				+ "\r\n"
				+ "\"name\":\"Learn Appium Automation with Java1234\",\r\n"
				+ "\"isbn\":\"abcd\",\r\n"
				+ "\"aisle\":\"227456\",\r\n"
				+ "\"author\":\"John fore\"\r\n"
				+ "}\r\n"
				+ "";
	}
	public static String libraryData(String name,String isbn,String aisle,String author) {
		return "{\r\n"
				+ "\r\n"
				+ "\"name\":\""+name+"\",\r\n"
				+ "\"isbn\":\""+isbn+"\",\r\n"
				+ "\"aisle\":\""+aisle+"\",\r\n"
				+ "\"author\":\""+author+"\"\r\n"
				+ "}\r\n"
				+ "";
	}
	public static String libraryDataDelete(String bookID) {
//		System.out.println( "{\r\n"
//				+ "\r\n"
//				+ "\"ID\":\""+bookID+"\"\r\n"
//				+ "}\r\n"
//				+ "");
		
		return "{\r\n"
				+ "\r\n"
				+ "\"ID\":\""+bookID+"\"\r\n"
				+ "}\r\n"
				+ "";
	}
	
	public static String JiraLogin() {
return "{\r\n"
		+ "\"username\": \"sivaprasadsurisetty\",\r\n"
		+ "\"password\": \"B4itfun!\"\r\n"
		+ "} ";
	}
	public static String JiraAddComment() {
		return "{\r\n"
				+ "    \"body\": \"Commenting from Eclipse Testing pupose-- 2nd comment with attachment\",\r\n"
				+ "    \"visibility\": {\r\n"
				+ "        \"type\": \"role\",\r\n"
				+ "        \"value\": \"Administrators\"\r\n"
				+ "    }\r\n"
				+ "}";}
}
