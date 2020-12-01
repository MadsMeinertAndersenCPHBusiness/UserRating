package dk.dd.user.rating;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class UserRatingApplication {
    public static void main(String[] args) {

        SpringApplication.run(UserRatingApplication.class, args);
    }

}
