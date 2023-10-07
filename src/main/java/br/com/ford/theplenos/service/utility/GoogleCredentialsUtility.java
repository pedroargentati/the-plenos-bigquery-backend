package br.com.ford.theplenos.service.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ServiceAccountCredentials;

import lombok.experimental.UtilityClass;

@UtilityClass
public class GoogleCredentialsUtility {

	public static GoogleCredentials getCreds(final String workingDirectory, final String filename) throws IOException {
		GoogleCredentials credentials;
		final String credsPath = File.separator + "src" + File.separator + "main" + File.separator;
		System.out.println(System.getProperty("user.dir") +credsPath + workingDirectory + File.separator);
		
		final File credentialsPath = new File(System.getProperty("user.dir") + credsPath + workingDirectory + File.separator , filename);
		
		try (FileInputStream serviceAccountStream = new FileInputStream(credentialsPath)) {
			System.out.println(serviceAccountStream);
			credentials = ServiceAccountCredentials.fromStream(serviceAccountStream);
		}
		System.out.println(credentialsPath);
		return credentials;
	}
}
