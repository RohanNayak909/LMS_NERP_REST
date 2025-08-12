package nirmalya.aatithya.restmodule.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import com.google.auth.oauth2.GoogleCredentials;

public class FCMNewNotification {

	private String accessToken;
	private Date expiredAt;

	public String generateToken() {
		try {
			FileInputStream serviceAccount = new FileInputStream("src/main/resources/firebasedetails.json");

			GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount)
					.createScoped("https://www.googleapis.com/auth/cloud-platform");

			credentials.refreshIfExpired();

			accessToken = credentials.getAccessToken().getTokenValue();
//			expiredAt = credentials.getAccessToken().getExpirationTime();
			Date createdAt = new Date(); 
			expiredAt = new Date(createdAt.getTime() + 5 * 60 * 1000);


		} catch (IOException e) {
			e.printStackTrace();
		}
		return accessToken;
	}

	public boolean isTokenExpired() {
		return expiredAt == null || new Date().after(expiredAt);
	}

	public String getAccessToken() {
		return accessToken;
	}

	public String getTokenExpiryTime() {
		return expiredAt.toString();
	}
}
