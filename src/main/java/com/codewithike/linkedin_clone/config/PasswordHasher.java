package com.codewithike.linkedin_clone.config;
import org.mindrot.jbcrypt.BCrypt;

public class PasswordHasher {
    // Method to hash a password
    public static String hashPassword(String password){
         // Define a cost factor (work factor). Default is 10.
        int logRounds = 12; // Increasing this value makes it more secure, but slower

        //Generate the salt
        String salt = BCrypt.gensalt(logRounds);

        //Hash the password with the salt
        return BCrypt.hashpw(password, salt);

    }
}
