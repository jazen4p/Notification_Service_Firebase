package com.example.notificationservice.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

//import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;

@Service
public class FCMInitializer {

    @Value("${app.firebase-configuration-file}")
    private String firebaseConfigPath;

    Logger logger = LoggerFactory.getLogger(FCMInitializer.class);

    @PostConstruct
    public void initialize() {
        try {
            FileInputStream serviceAccount =
                    new FileInputStream("C:\\Users\\User 19\\OneDrive\\Desktop\\BNI - Kerja\\Project redbank\\Jasen - Task November\\notificationservice\\src\\main\\resources\\file\\spring-notification-service-firebase-adminsdk-qej4u-e9a3de5ec3.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            FirebaseApp.initializeApp(options);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

}
