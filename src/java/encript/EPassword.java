package encript;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EPassword {

    public static String digestValue(Object obj, String digestType) {

        MessageDigest md = null;
        String digestedValue = null;

        try {

            md = MessageDigest.getInstance(digestType);
            byte[] digested = md.digest(obj.toString().getBytes());
            digestedValue = byteToHex(digested);

        } catch (NoSuchAlgorithmException ex) {
        }

        return digestedValue;
    }

    public static String byteToHex(byte buf[]) {

        StringBuffer strbuf = new StringBuffer(buf.length * 2);
        int i;

        for (i = 0; i < buf.length; i++) {
            if (((int) buf[i] & 0xff) < 0x10) {
                strbuf.append("0");
            }

            strbuf.append(Long.toString((int) buf[i] & 0xff, 16));
        }

        return strbuf.toString();

    }

}
