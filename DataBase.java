import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class DataBase {
    public static ArrayList<User> usersDataBase = new ArrayList<>();
    public static ArrayList<Group> groupsDataBase = new ArrayList<>();

    public static User getUser(String username) {
        for (User searchUser : getUsersDataBase())
            if (username.equals(searchUser.getUsername()))
                return searchUser;
        return null;
    }

    public static boolean isTakenUsername(String username) {
        for (User searchUser : getUsersDataBase())
            if (username.equals(searchUser.getUsername()))
                return true;
        return false;
    }

    public static Group getGroup(int groupID) {
        for (Group group : getGroupsDataBase())
            if (group.getID() == groupID)
                return group;
        return null;

    }

    public static boolean isValidGroupID(int groupID) {
        return groupID > 0 && groupID < Group.creationID ? true : false;
    }

    public static ArrayList<User> getUsersDataBase() {
        return usersDataBase;
    }

    public static ArrayList<Group> getGroupsDataBase() {
        return groupsDataBase;
    }

    public static byte[] getSHA(String input) throws NoSuchAlgorithmException {
        return MessageDigest.getInstance("SHA-256").digest(input.getBytes(StandardCharsets.UTF_8));
    }

    public static String toHexString(byte[] hash) {
        StringBuilder hexString = new StringBuilder(new BigInteger(1, hash).toString(16));

        while (hexString.length() < 32)
            hexString.insert(0, '0');

        return hexString.toString();
    }
}