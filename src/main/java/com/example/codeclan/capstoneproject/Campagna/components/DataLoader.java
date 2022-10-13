package com.example.codeclan.capstoneproject.Campagna.components;

import com.example.codeclan.capstoneproject.Campagna.models.bookings.BandB;
import com.example.codeclan.capstoneproject.Campagna.models.bookings.Booking;
import com.example.codeclan.capstoneproject.Campagna.models.products.Food;
import com.example.codeclan.capstoneproject.Campagna.models.products.FoodType;
import com.example.codeclan.capstoneproject.Campagna.models.user.Farmer;
import com.example.codeclan.capstoneproject.Campagna.repositories.BandBRepository;
import com.example.codeclan.capstoneproject.Campagna.repositories.BookingRepository;
import com.example.codeclan.capstoneproject.Campagna.repositories.FarmerRepository;
import com.example.codeclan.capstoneproject.Campagna.repositories.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FarmerRepository farmerRepository;
    @Autowired
    FoodRepository foodRepository;
    @Autowired
    BandBRepository bandBRepository;
    @Autowired
    BookingRepository bookingRepository;
    public DataLoader() {
    }

    @Override
    public void run(ApplicationArguments args) {

        BandB bandB = new BandB("The Bee and Bear", "B&B@BeeBear.com", "+4477", "bb01.png", "bb01int.png");
        Booking booking = new Booking(bandB, LocalDate.of(2022, 5, 20), LocalDate.of(2022, 5, 3), 2);
        BandB marBanB = new BandB("Mar's Creepy Cottage", "TheCreepyCottage@MarCottage.com", "+4475", "bb04.jpeg", "bb04int.jpeg");
        //Tribute to my wonderful little hamster who passed away.
        BandB WilbursBurrow = new BandB("Wilbur's Burrow", "theGentlemanHam@wilbur.com", "+4475", "wilbur.png", "wilbur2.png");
        bandBRepository.save(bandB);
        bookingRepository.save(booking);
        bandBRepository.save(marBanB);
        bandBRepository.save(WilbursBurrow);

        Farmer farmer1 = new Farmer(
                "Nicholas Bigbelly",
                "The Bigbelly family has been producing honey and wine for several generations..."
        );
        farmerRepository.save(farmer1);

        Farmer farmer2 = new Farmer(
                "Jeremiah Lostsoul",
                "Lostsoul properties include vineyards, wheat crops and cattle farms."
        );
        farmerRepository.save(farmer2);


        Farmer farmer3 = new Farmer(
                "Thomas Longhand",
                "At the Longhand farms you will find all the best meat and milk from the region, and genuine fresh cheese."
        );
        farmerRepository.save(farmer3);

        Food food1 = new Food(
                "Wild Thistle Honey",
                19,
                FoodType.HONEY,
                500,
                "A golden amber coloured, aromatic honey that slowly crystalises over time.",
                "honey01.png",
                farmer1
        );
        foodRepository.save(food1);

        Food food2 = new Food(
                "Pantumas White Wine",
                28,
                FoodType.DRINK,
                70,
                "Pantumas has a light golden colour like onion skin, it is fruity, floral, fresh, mineral with a very persistent aftertaste.",
                "wine01.png",
                farmer1
        );
        foodRepository.save(food2);

        Food food3 = new Food(
                "Homemade Wheat Bran Sourdough Bread",
                7,
                FoodType.BAKERY,
                450,
                "Super rich in flavor, this traditional homemade bread is plenty of healthy fiber and vitamins.",
                "bread01.png",
                farmer2
        );
        foodRepository.save(food3);

        Food food4 = new Food(
                "Extra Virgin Unfiltered Olive Oil",
                14,
                FoodType.OIL,
                500,
                "Like fresh juice, this unfiltered extra-virgin olive oil retains a light olive pulp, offering a fuller palette of taste notes.",
                "oil01.png",
                farmer2
        );
        foodRepository.save(food4);
    }
}