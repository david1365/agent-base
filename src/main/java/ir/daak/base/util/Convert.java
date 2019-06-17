package ir.daak.base.util;

/**
 * @author Davood Akbari - 1398
 * daak1365@gmail.com
 * daak1365@yahoo.com
 * 09125188694
 */

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

public class Convert {
    private static final char[] hex =
            { '0' , '1' , '2' , '3' , '4' , '5' , '6' , '7' ,
                    '8' , '9' , 'a' , 'b' , 'c' , 'd' , 'e' , 'f'};

    public static String encodeHex(char[] data) {
        StringBuilder sb = new StringBuilder(data.length * 2);
        for (int i=0; i<data.length; i++ ) {
            sb.append(hex[(data[i] & 0xf0) >>> 4]);
            sb.append(hex[data[i] & 0x0f] );
        }
        return sb.toString();
    }

    public static final byte[] decodeHex(final String hexString) throws DecoderException {
        return Hex.decodeHex(hexString);
    }

    //TODO from davood akbari: for this method will write test
    public static String Base64HexSyringToBase64ByteArray(String base64) throws DecoderException {
        String hexImg = new String(Base64.getDecoder().decode(base64));
        byte[] data = decodeHex(hexImg);
        return Base64.getEncoder().encodeToString(data);
    }

    public static byte[] str2ByteArr(String str) {
        if (str == null || str.isEmpty())
            return null;
        byte[] face = new byte[str.length() / 2];
        for (int i = 0; i < str.length(); i += 2)
            face[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character
                    .digit(str.charAt(i + 1), 16));

        return face;
    }

    public static String byteArr2Str(byte[] B) {
        if (B == null)
            return "";
        String S = "";
        for (int i = 0; i < B.length; i++)
            S += String.format("%02X", B[i]);
        return S;
    }

    public static String byteArrayToBase64(byte[] bytes) {
        try {
            return Base64.getEncoder().encodeToString(bytes);
        } catch (Exception e) {
            throw e;
        }
    }

    public static byte[] getBytes(BufferedImage fingerprintImage) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write( fingerprintImage, "jpg", byteArrayOutputStream );

        byteArrayOutputStream.flush();
        byte[] fingerprintImageBytes = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();

        return fingerprintImageBytes;
    }
}
