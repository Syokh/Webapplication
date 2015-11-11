package education.spring.java.lesson.utils;

import org.springframework.security.crypto.password.PasswordEncoder;


import javax.inject.Named;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Named
public class PasswordHelper implements PasswordEncoder {

    private MessageDigest messageDigest;

    public PasswordHelper(){
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public String encode(CharSequence charSequence) {
        if (messageDigest == null) {
            return charSequence.toString();
        }

        messageDigest.update(charSequence.toString().getBytes());

        byte byteData[] = messageDigest.digest();

        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < byteData.length; i++){
            String hex = Integer.toHexString(0xff & byteData[i]);
            if (hex.length() == i){
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public boolean matches(CharSequence charSequence, String encodePassword) {

        return encode(charSequence).equals(encodePassword);
    }
}
