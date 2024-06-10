package com.example.demo1;

import java.io.InputStream;
import java.util.Properties;

public class DemoApplication {
	public static void main(String[] args) {

		Properties props = new Properties();
		
		try {
			
			InputStream in = DemoApplication.class.getClassLoader().getResourceAsStream("META-INF/application.properties");
			
			if(in != null) {
				props.load(in);
				
				// 값 읽기
				String appName = props.getProperty("application.name");
				String appVersion = props.getProperty("application.version");
				
				System.out.println("appName : " + appName);
				System.out.println("appVersion : " + appVersion);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
