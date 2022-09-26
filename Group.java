import java.util.ArrayList;

public class Group extends Chat {
    private String name;
    public static int creationID;
    private int ID;
    private ArrayList<User> adminUsersArrayList;
    private ArrayList<User> memberUsersArrayList;
    private ArrayList<User> requestedUsersArrayList;

    static {
        creationID = 1;
    }

    public Group(String name) {
        setName(name);
        setID();
        setAdminUsersArrayList(new ArrayList<>());
        setMemberUsersArrayList(new ArrayList<>());
        setRequestedUsersArrayList(new ArrayList<>());
        setChatCommentsArrayList(new ArrayList<>());
    }

    public String getGroupString() {
        String groupInfoString = "Name: " + getName() + "\nID: " + getID()
                + "\n\nAdmins [Count: " + getCountAdmins() + "]{\n";
        for (User adminUser : getAdminUsersArrayList())
            groupInfoString += adminUser.getFullName() + "(" + adminUser.getUsername() + ")\n";
        groupInfoString += "\n}\n\nMembers [Count: " + getCountMembers() + "]{\n";
        for (User memberUser : getMemberUsersArrayList())
            groupInfoString += memberUser.getFullName() + "(" + memberUser.getUsername() + ")\n";
        groupInfoString += "\n}\n\nRequested Users [Count: " + getCountRequestedUsers() + "]{\n";
        for (User requestedUser : getRequestedUsersArrayList())
            groupInfoString += requestedUser.getFullName() + "(" + requestedUser.getUsername() + ")\n";

        return groupInfoString + "\n}";
    }

    public String getAllChatsString() {
        int counterChat = 1;
        String allChatsString = "All Chats Available in " + getName() + "'s Group:\n";

        for (Comment chatComment : getChatCommentsArrayList()) {
            allChatsString += counterChat + ".\n" + "Uploader User: " + chatComment.getCommenterUser().getFullName()
                    + "(" + chatComment.getCommenterUser().getUsername() + ")\nChat: "
                    + chatComment.getCommentString() + "\nCount Likes: " + chatComment.getCountLikes()
                    + "\nCount Replies: " + chatComment.getCountReplies() + "\n";
            counterChat++;
        }

        return allChatsString;
    }

    public String getAllRequestedUserString() {
        int counterRequestedUsers = 1;
        String allRequestedUserString = "";

        for (User requestedUser : getRequestedUsersArrayList()) {
            allRequestedUserString += counterRequestedUsers + ". " + requestedUser.getFullName() + "("
                    + requestedUser.getUsername() + ")\n";
            counterRequestedUsers++;
        }

        return allRequestedUserString;
    }

    public int getCountChats() {
        return getChatCommentsArrayList().size();
    }

    public int getCountAdmins() {
        return adminUsersArrayList.size();
    }

    public int getCountMembers() {
        return getMemberUsersArrayList().size();
    }

    public int getCountRequestedUsers() {
        return getRequestedUsersArrayList().size();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setID() {
        ID = creationID++;
    }

    public int getID() {
        return ID;
    }

    public void setAdminUsersArrayList(ArrayList<User> adminUsersArrayList) {
        this.adminUsersArrayList = adminUsersArrayList;
    }

    public ArrayList<User> getAdminUsersArrayList() {
        return adminUsersArrayList;
    }

    public void setMemberUsersArrayList(ArrayList<User> memberUsersArrayList) {
        this.memberUsersArrayList = memberUsersArrayList;
    }

    public ArrayList<User> getMemberUsersArrayList() {
        return memberUsersArrayList;
    }

    public void setRequestedUsersArrayList(ArrayList<User> requestedUsersArrayList) {
        this.requestedUsersArrayList = requestedUsersArrayList;
    }

    public ArrayList<User> getRequestedUsersArrayList() {
        return requestedUsersArrayList;
    }
}
