package com.opitz.utility;

import com.opitz.repository.UserRepository;
import com.opitz.model.User;
import com.opitz.repository.InMemoryUserRepository;

public class Logger {

    private UserRepository userRepository = new InMemoryUserRepository();

    public boolean isValid(String username, String password) {


        for (User user : userRepository.getUsers()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    return true;
            }

        }
        return  false;


    }


}
