package ir.daak.util;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

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
    public static String Base64HexSyringToByteAttay(String base64) throws DecoderException {
        String hexImg = new String(Base64.getDecoder().decode(base64));
        byte [] data = decodeHex(hexImg);
        return Base64.getEncoder().encodeToString(data);
    }
}
