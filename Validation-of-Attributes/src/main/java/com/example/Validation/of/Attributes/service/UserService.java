package com.example.Validation.of.Attributes.service;

import com.example.Validation.of.Attributes.entity.User;
import com.example.Validation.of.Attributes.repository.UserRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepositoy userRepo;
    public User saveUser(User user) {

        User user1 = new User();

        long max = 9999999;
        long min = 1000000;
        long randomWithMathRandom = (long) ((Math.random() * (max - min)) + min);
        user1.setCustomerId(randomWithMathRandom);

        user1.setName(user.getName());
        user1.setEmail(user.getEmail());
        user1.setPassword(user.getPassword());
        user1.setAddress(user.getAddress());
        user1.setMobileNumber(user.getMobileNumber());
        user1.setNomineeName(user.getNomineeName());
        user1.setRelationWithNominee(user.getRelationWithNominee());

        return userRepo.save(user1);
    }

//    @Bean
//    public CommandLineRunner run(UserRepository userRepository) throws Exception {
//        return (String[] args) -> {
//            User user1 = new User("Bob", "bob@domain.com");
//            User user2 = new User("Jenny", "jenny@domain.com");
//            userRepository.save(user1);
//            userRepository.save(user2);
//            userRepository.findAll().forEach(System.out::println);
//        };
//    }
}
