/**
 * 
 */
package com.hometools.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.springframework.stereotype.Component;

/**
 * @author adityacherla
 * 
 * Generic class for reading values from the property file.
 *
 */
@Component
public class PropertyReader {
	
	
	/**
	 * Default Class constructor
	 */
	public PropertyReader() {
		super();
	}
	
	private static final String messagePropertyFileLocation = "classpath:ValidationMessages.properties";
	private static final String regularExpPropertyFileLocation = "classpath:RegularExp.properties";
	private static final Properties regularExpproperties= new Properties();
	private static final Properties messagesProperties= new Properties();
	private static final String EMPTY_STRING="";
	
	static {
		FileInputStream messageinputStream = null;
		FileInputStream regExinputStream = null;
		try {
			File messagesPropertyFile = new File(messagePropertyFileLocation);
			File regExPropertyFile = new File(regularExpPropertyFileLocation);
			
			messageinputStream = new FileInputStream(messagesPropertyFile);
			regExinputStream = new FileInputStream(regExPropertyFile);
			
			messagesProperties.load(messageinputStream);
				
			regularExpproperties.load(regExinputStream);
			
		} catch (Exception e) {
			System.out.println("Exception in rading properties for messages and regular expressions");
			e.printStackTrace();
		} finally {
			try {
				if(messageinputStream!=null)messageinputStream.close();
				if(regExinputStream!=null)regExinputStream.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
		 
		
	}
	
	/**
	 * This method fetches the regular expression value of the key that you are providing.
	 * The regular expressions are stored in the <tt>RegularExp.properties</tt> file.
	 * 
	 * @param regExKey
	 * @return
	 */
	public static final String getRegExValue(String regExKey){
		if(regExKey==null || regExKey.isEmpty()) return EMPTY_STRING; 
		return regularExpproperties.getProperty(regExKey);
	}
	
	/**
	 * This method fetches the validation message value of the key that you are providing.
	 * The validation messages are stored in the <tt>ValidationMessages.properties</tt> file.
	 * 
	 * @param messageKey
	 * @return String
	 */
	public static final String getMessageValue(String messageKey){
		if(messageKey==null || messageKey.isEmpty()) return EMPTY_STRING; 
		return regularExpproperties.getProperty(messageKey);
	}
	
}