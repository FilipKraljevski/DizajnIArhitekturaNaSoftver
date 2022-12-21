package mk.ukim.finki.backend.model;

import lombok.Data;

@Data
public class Restaurant {
    private Long id;
    private String name;
    private String suburb;
    private String street;
    private Double lat;
    private Double lon;
    private String opens;
    private String closes;
    private String website;
    private String phone;

    public Restaurant(String name, String suburb, String street, Double lat, Double lon, String opens, String closes, String website, String phone) {
        this.id = (long) (Math.random() * 1000);
        this.name = name;
        this.suburb = suburb;
        this.street = street;
        this.lat = lat;
        this.lon = lon;
        this.opens = opens;
        this.closes = closes;
        this.website = website;
        this.phone = phone;
    }
}
