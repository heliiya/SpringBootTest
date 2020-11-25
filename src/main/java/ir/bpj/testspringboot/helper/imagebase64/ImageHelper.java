package ir.bpj.testspringboot.helper.imagebase64;

import java.util.Base64;

public class ImageHelper {

    public static String convertImageByteArrayToBase64String(byte[] image){
        return Base64.getEncoder().encodeToString(image);
    }

    public static byte[] convertBase64StringToImageByteArray(String image){
        return Base64.getDecoder().decode(image);
    }

}