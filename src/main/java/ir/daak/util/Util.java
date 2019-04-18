package ir.daak.util;

import java.util.Base64;

public class Util {
    public static final byte[] fromHexString(final String s) {
        //TODO from davood akbari: use the Hex class supplied with the Apache commons-codec library
        byte[] arr = new byte[s.length()/2];
        for ( int start = 0; start < s.length(); start += 2 )
        {
            String thisByte = s.substring(start, start + 2);
            arr[start/2] = Byte.valueOf((byte) Integer.parseInt(thisByte, 16));
        }
        return arr;
    }

    //TODO from davood akbari: for this method will write test
    public static String Base64HexSyringToByteAttay(String base64) {
        String hexImg = new String(Base64.getDecoder().decode(base64));
        byte [] data = fromHexString(hexImg);
        return Base64.getEncoder().encodeToString(data);
    }
}
