package mk.ukim.finki.backend.bootsrap;

import com.opencsv.CSVWriter;
import jakarta.annotation.PostConstruct;
import mk.ukim.finki.backend.model.Restaurant;
import mk.ukim.finki.backend.model.User;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Restaurant> restaurants = new ArrayList<>();
    public static List<User> users = new ArrayList<>();

    @PostConstruct
    public void init(){
        String path = "./database/RestourantsInSkopje.csv";
        File file = new File(path);
        try {
            BufferedReader bf = new BufferedReader(new FileReader(file));
            String line = bf.readLine();
            while ((line = bf.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0];
                String suburb = parts[1];
                String street = parts[2];
                Double lon = Double.parseDouble(parts[3]);
                Double lat = Double.parseDouble(parts[4]);
                String opens = parts[5];
                String closes = parts[6];
                String website = parts[7];
                String phone = parts[8];
                restaurants.add(new Restaurant(name, suburb, street, lon, lat, opens, closes, website, phone));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        path = "./database/User.csv";
        file = new File(path);
        try{
            BufferedReader bf = new BufferedReader(new FileReader(file));
            String line = bf.readLine();
            while ((line = bf.readLine()) != null) {
                String[] parts = line.split(",");
                String username = parts[0];
                String email = parts[0];
                String password = parts[0];
                users.add(new User(username, email, password));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveRestaurant(Restaurant restaurant){
        String path = "./database/RestourantsInSkopje.csv";
        File file = new File(path);
        try {
            FileWriter fileWriter = new FileWriter(file);
            CSVWriter writer = new CSVWriter(fileWriter);
            String[] data = {restaurant.getName(), restaurant.getSuburb(), restaurant.getStreet(), restaurant.getLon().toString(),
                    restaurant.getLat().toString(), restaurant.getOpens(), restaurant.getCloses(), restaurant.getWebsite(),
                    restaurant.getPhone()};
            writer.writeNext(data);
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveUser(User user){
        String path = "./database/User.csv";
        File file = new File(path);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            CSVWriter writer = new CSVWriter(fileWriter);
            String[] data = {user.getUsername(), user.getEmail(), user.getPassword()};
            writer.writeNext(data);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
