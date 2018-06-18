package com.command;

import java.io.FileReader;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.model.OtpModel;

public class JSONParserClass {
	 public static void parseJSONfile(OtpModel otpModel) {
		 try {
			 JSONParser parser = new JSONParser();
			 //Have to add the local test.json file- TO-DO
			 Object obj = parser.parse(new FileReader("C:\\Users\\Mouni\\Desktop\\TEAM4\\test.json"));
			 
			 System.out.println(obj);
			 JSONObject jsonObject = (JSONObject) obj;
			 
			 String accountNumber= (String) ((HashMap<?, ?>) ((HashMap<?, ?>) jsonObject.get("Account")).get("Customer")).get("Account Number");
			 String email = null ;
			 if(accountNumber.equalsIgnoreCase((otpModel.getAccountNumber()))){
				 email= (String) ((HashMap<?, ?>) ((HashMap<?, ?>) jsonObject.get("Account")).get("Customer")).get("Email");				 
				 
				 otpModel.setEmailID(email);
			 }			 
			 System.out.println(accountNumber + email);
			 
		 }
		 catch(Exception ex) {
			 ex.printStackTrace();
		 }
	 }
	

}
