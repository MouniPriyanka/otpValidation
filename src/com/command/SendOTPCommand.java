package com.command;

import java.util.Random;

import javax.servlet.http.HttpSession;

import com.model.OtpModel;

public class SendOTPCommand {
	public static void sendOTP(HttpSession session, OtpModel otpModel)
	{
		int otp;
		Random random = new Random();
		try {
			// get the data from json file
			String accountNumber = otpModel.getAccountNumber();
			JSONParserClass.parseJSONfile(otpModel);
			
			//generate OTP
			otp=100000+random.nextInt(900000);
			
			//manage the session
			session.setMaxInactiveInterval(2*60);
			session.setAttribute("OTP", otp);
			
			String email= otpModel.getEmailID();
			System.out.println(email);
			String message= Integer.toString(otp);
			System.out.println(message);
			Mailer.sendMail("wellsteam04@gmail.com", "wellsteam4", email ,"Your OTP", message);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
