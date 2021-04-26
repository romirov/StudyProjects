
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;


public class TestPhonebook {

	private static HashMap<Integer,String> response(){
		Map<Integer, String> codeResponse = new HashMap<>();
		codeResponse.put(100,"CONTINUE");
		codeResponse.put(101,"SWITCHING_PROTOCOLS");
		codeResponse.put(102,"PROCESSING"); 
		codeResponse.put(103,"CHECKPOINT");
		codeResponse.put(200,"OK");
		codeResponse.put(201,"CREATED");
		codeResponse.put(202,"ACCEPTED");
		codeResponse.put(203,"NON_AUTHORITATIVE_INFORMATION");
		codeResponse.put(204,"NO_CONTENT");
		codeResponse.put(205,"RESET_CONTENT");
		codeResponse.put(206,"PARTIAL_CONTENT");
		codeResponse.put(207,"MULTI_STATUS");
		codeResponse.put(208,"ALREADY_REPORTED");
		codeResponse.put(226,"IM_USED");
		codeResponse.put(300,"MULTIPLE_CHOICES");
		codeResponse.put(301,"MOVED_PERMANENTLY");
		codeResponse.put(302,"FOUND");
		codeResponse.put(302,"MOVED_TEMPORARILY");
		codeResponse.put(303,"SEE_OTHER");
		codeResponse.put(304,"NOT_MODIFIED");
		codeResponse.put(305,"USE_PROXY");
		codeResponse.put(307,"TEMPORARY_REDIRECT");
		codeResponse.put(308,"PERMANENT_REDIRECT");
		codeResponse.put(400,"BAD_REQUEST");
		codeResponse.put(401,"UNAUTHORIZED");
		codeResponse.put(402,"PAYMENT_REQUIRED");
		codeResponse.put(403,"FORBIDDEN");
		codeResponse.put(404,"NOT_FOUND");
		codeResponse.put(405,"METHOD_NOT_ALLOWED");
		codeResponse.put(406,"NOT_ACCEPTABLE");
		codeResponse.put(407,"PROXY_AUTHENTICATION_REQUIRED");
		codeResponse.put(408,"REQUEST_TIMEOUT");
		codeResponse.put(409,"CONFLICT");
		codeResponse.put(410,"GONE");
		codeResponse.put(411,"LENGTH_REQUIRED");
		codeResponse.put(412,"PRECONDITION_FAILED");
		codeResponse.put(413,"PAYLOAD_TOO_LARGE");
		codeResponse.put(413,"REQUEST_ENTITY_TOO_LARGE");
		codeResponse.put(414,"URI_TOO_LONG");
		codeResponse.put(414,"REQUEST_URI_TOO_LONG");
		codeResponse.put(415,"UNSUPPORTED_MEDIA_TYPE");
		codeResponse.put(416,"REQUESTED_RANGE_NOT_SATISFIABLE");
		codeResponse.put(417,"EXPECTATION_FAILED");
		codeResponse.put(418,"I_AM_A_TEAPOT");
		codeResponse.put(419,"INSUFFICIENT_SPACE_ON_RESOURCE");
		codeResponse.put(420,"METHOD_FAILURE");
		codeResponse.put(421,"DESTINATION_LOCKED");
		codeResponse.put(422,"UNPROCESSABLE_ENTITY");
		codeResponse.put(423,"LOCKED");
		codeResponse.put(424,"FAILED_DEPENDENCY");
		codeResponse.put(425,"TOO_EARLY");
		codeResponse.put(426,"UPGRADE_REQUIRED");
		codeResponse.put(428,"PRECONDITION_REQUIRED");
		codeResponse.put(429,"TOO_MANY_REQUESTS");
		codeResponse.put(431,"REQUEST_HEADER_FIELDS_TOO_LARGE");
		codeResponse.put(451,"UNAVAILABLE_FOR_LEGAL_REASONS");
		codeResponse.put(500,"INTERNAL_SERVER_ERROR");
		codeResponse.put(501,"NOT_IMPLEMENTED");
		codeResponse.put(502,"BAD_GATEWAY");
		codeResponse.put(503,"SERVICE_UNAVAILABLE");
		codeResponse.put(504,"GATEWAY_TIMEOUT");
		codeResponse.put(505,"HTTP_VERSION_NOT_SUPPORTED");
		codeResponse.put(506,"VARIANT_ALSO_NEGOTIATES");
		codeResponse.put(507,"INSUFFICIENT_STORAGE");
		codeResponse.put(508,"LOOP_DETECTED");
		codeResponse.put(509,"BANDWIDTH_LIMIT_EXCEEDED");
		codeResponse.put(510,"NOT_EXTENDED");
		codeResponse.put(511,"NETWORK_AUTHENTICATION_REQUIRED");
		return (HashMap) codeResponse;
	}
	
	public static void main(String[] args) {
		int statusCode = 0;
		HashMap<Integer, String> codeResponse = response();
		
		//Positive Test
		//тестирование получения списка всех пользователей GET /users
		String urlGetUsers = "http://localhost:8080/users";
		statusCode = testGet(urlGetUsers);
		if(statusCode > 200 && statusCode < 202)
			System.out.println("Positive test1: testing a GET request to get a list of all users passed. Response Code: " + statusCode + ". Response: " + codeResponse.get(statusCode));
		else 
			System.out.println("Positive test1: testing a GET request to get a list of all users failed. Response Code: " + statusCode + " Response: " + codeResponse.get(statusCode));
		
		//Тестирование получения списка всех контактов пользователей GET /users/{userId}/contacts
		String urlGetUsersUsersIdContacts = "http://localhost:8080/users/1/contacts";
    	statusCode = testGet(urlGetUsersUsersIdContacts);
    	if(statusCode > 200 && statusCode < 202)
			System.out.println("Positive test2: testing a GET request to get a list of all user's contacts passed. Response Code: " + statusCode + ". Response: " + codeResponse.get(statusCode));
		else 
			System.out.println("Positive test2: testing a GET request to get a list of all user's contacts failed. Error Code: " + statusCode + ". Response: " + codeResponse.get(statusCode));
    	
    	//NegotiveTest
    	//тестирование  добавления пользователей POST /users
    	String requestBodyTestPostUsers = "id=3&firstName=Test&lastName=Testing";
    	statusCode = testPost("http://localhost:8080/users/3?id=3&firstName=Test&lastName=Testing" ,requestBodyTestPostUsers);
    	if(statusCode > 200 && statusCode < 202)
			System.out.println("Negative test1: testing the POST request for adding users passed. Response Code: " + statusCode + ". Response: " + codeResponse.get(statusCode));
		else 
			System.out.println("Negative test1: testing the POST request for adding users failed. Error Code: " + statusCode + ". Response: " + codeResponse.get(statusCode));
    	
    	//тестирование изменения пользователя PUT /users/{userId}
    	String requestBodyTestPutUsers = "id=1&firstName=John&lastName=Snow";
    	statusCode = testPut("http://localhost:8080/users/1" ,requestBodyTestPutUsers);
    	if(statusCode > 200 && statusCode < 202)
			System.out.println("Negative test2: testing a PUT request for user change passed passed. Response Code: " + statusCode + ". Response: " + codeResponse.get(statusCode));
		else 
			System.out.println("Negative test2: testing a PUT request for user change failed. Error Code: " + statusCode + ". Response: " + codeResponse.get(statusCode));
    	
    	//String urlTestDeleteUsers= "http://localhost:8080/users?id=1";//тестирование  DELETE /users/{userId}
    	//testDelete(urlTestDeleteUsers);
    	
    	
	}
	
	public static Integer testGet(String url) {
		HttpResponse<String> response = null;
		try {
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder()
	        		  .header("accept", "*/*")
	        		  .header("Content-Type", "*/*")
	        		  .uri(URI.create(url))
			          .method("GET", HttpRequest.BodyPublishers.noBody())
				      .build();
			
			//client.sendAsync(request, BodyHandlers.ofString())
			//	      .thenApply(HttpResponse::body)
			//	      .thenAccept(System.out::println)
			//	      .join();
			
			response = client.send(request, BodyHandlers.ofString());
		      
	        //System.out.println(response.statusCode());
	        
			}catch(Exception e) {		            
				e.printStackTrace();
			}
		return response.statusCode();
	}
	
	public static Integer testPost(String url, String requestBody) {
		HttpResponse<String> response = null;
		try {
			//Map<Object, Object> data = new HashMap<>();
			//data.put("lastName", "Testing");
			//data.put("firstName", "Test");
			//data.put("id", "3");
	        
	        
			
			HttpClient client = HttpClient.newHttpClient();
	        HttpRequest request = HttpRequest.newBuilder()
	        		.header("accept", "*/*")
	        		.header("Content-Type", "*/*")
	                .uri(URI.create(url))
	                //.method("POST", HttpRequest.BodyPublishers.ofString(requestBody))
	                .method("POST", HttpRequest.BodyPublishers.ofString(requestBody))//buildFormDataFromMap(data))
	                .build();
	        response = client.send(request, BodyHandlers.ofString());
		      
	        //System.out.println(response.statusCode());
	        //System.out.println(response.body());  
		}catch(Exception e) {		            
			e.printStackTrace();
		}
		return response.statusCode();
	}
	
	public static Integer testDelete(String url) {
		HttpResponse<String> response = null;
		try {
			HttpClient client = HttpClient.newHttpClient();
	        HttpRequest request = HttpRequest.newBuilder()
	        		.header("accept", "*/*")
	        		.header("Content-Type", "*/*")
	                .uri(URI.create(url))
	                .method("DELETE", HttpRequest.BodyPublishers.ofString("3"))
	                .build();

	        response = client.send(request, BodyHandlers.ofString());
		      
	        //System.out.println(response.statusCode());
	        //System.out.println(response.body()); 
		}catch(Exception e) {		            
			e.printStackTrace();
		}
		return response.statusCode();
	}
	
	public static Integer testPut(String url, String requestBody) {
		HttpResponse<String> response = null;
		try {
			HttpClient client = HttpClient.newHttpClient();
	        HttpRequest request = HttpRequest.newBuilder()
	        		.header("accept", "*/*")
	        		.header("Content-Type", "*/*")
	                .uri(URI.create(url))
	                .method("PUT", HttpRequest.BodyPublishers.ofString(requestBody))
	                .build();

	        response = client.send(request, BodyHandlers.ofString());
		      
	        //System.out.println(response.statusCode());
	        //System.out.println(response.body()); 
		}catch(Exception e) {		            
			e.printStackTrace();
		}
		return response.statusCode();
	}
	
	private static HttpRequest.BodyPublisher buildFormDataFromMap(Map<Object, Object> data) {
        var builder = new StringBuilder();
        for (Map.Entry<Object, Object> entry : data.entrySet()) {
            if (builder.length() > 0) {
                builder.append("&");
            }
            builder.append(URLEncoder.encode(entry.getKey().toString(), StandardCharsets.UTF_8));
            builder.append("=");
            builder.append(URLEncoder.encode(entry.getValue().toString(), StandardCharsets.UTF_8));
        }
        System.out.println(builder.toString());
        return HttpRequest.BodyPublishers.ofString(builder.toString());
    }
}
