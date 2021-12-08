package com.inventory.utills;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.inventory.enums.Authority;
import com.inventory.model.dummy.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.*;

public class Utils {

    private static JsonParser jsonParser = new JsonParser();

    public static User generateUserFromJsonStr(String userStr) {
        if(userStr == "" || userStr.equals("")) {
            User requester = new User();
            requester.setUsername("anonymous");
            List<Authority> authorities = new ArrayList<>();
            authorities.add(Authority.ANONYMOUS);
            requester.setAuthorities(authorities);
            return requester;
        }
        JsonObject currentUserJO = jsonParser.parse(userStr).getAsJsonObject();
        User currentUser = new User();
        try {
            currentUser.setUsername(currentUserJO.has("username") ? currentUserJO.get("username").getAsString() : null);
            String authoritiesStr = currentUserJO.has("authorities") ? currentUserJO.get("authorities").getAsString() : "";
            List<String> authorityStrList = Arrays.asList(authoritiesStr.split(","));
            List<Authority> authorities = new ArrayList<>();
            for (String authorityStr : authorityStrList) {
                if(authorityStr.equals(Authority.ROLE_ADMIN.getAuthority())) {
                    authorities.add(Authority.ROLE_ADMIN);
                } else if(authorityStr.equals(Authority.ROLE_EMPLOYEE.getAuthority())) {
                    authorities.add(Authority.ROLE_EMPLOYEE);
                } else if (authorityStr.equals(Authority.ANONYMOUS.getAuthority())) {
                    authorities.add(Authority.ANONYMOUS);
                }
            }
            currentUser.setAuthorities(authorities);

        } catch (Exception ex) {
            return  currentUser;
        }
        return currentUser;
    }

    public static String removeAllSpaceWithUnderScore(String input) {
        return input.replaceAll("\\s+","_");
    }

    public static String removeAllSpaceWithDash(String input) {
        return input.replaceAll("\\s+","-");
    }

    public static boolean isStringEquals(String val1, String val2) {
        if(val1 == val2 || val1.equals(val2)) {
            return true;
        }
        return false;
    }

    public static String getBase64EncodedString(String originalString){
        String encodedString = Base64.getEncoder().encodeToString(originalString.getBytes());
        return encodedString;
    }

    public static String getBase64DecodedSrtring(String encodedString){
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        String decodedString = new String(decodedBytes);
        return decodedString;
    }

    public static HttpHeaders generateHttpHeaders(String userStr) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("requester", userStr);
        return headers;

    }
    public static String generateRandomNumber(int length) {
        int number = (int) Math.pow(10, length - 1);
        number = number + new Random().nextInt(9 * number);
        return Integer.toString(number);
    }
   /* public static HttpHeaders generateHttpHeaders(String userStr) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("current-user", userStr);
        return headers;
    }*/
}
