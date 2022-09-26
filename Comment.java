import java.util.ArrayList;

public class Comment {
    private User commenterUser;
    private String commentString;
    private ArrayList<User> likerUsersArrayList;
    private ArrayList<String> repliesStringsArrayList;

    public Comment(User commenter, String comment) {
        setCommenterUser(commenter);
        setCommentString(comment);
        setLikerUsersArrayList(new ArrayList<>());
        setRepliesStringsArrayList(new ArrayList<>());
    }

    public String getCommentInfo() {
        return "Commenter User: " + getCommenterUser().getFullName() + "("
                + getCommenterUser().getUsername() + ")" + "\nComment: " + getCommentString()
                + "\nCount Likes: " + getCountLikes() + "\nCount Replies: " + getCountReplies();
    }

    public String getAllRepliesString() {
        int countReply = 1;
        String allRepliesString = "All Replies On This Comment:\n";

        for (String reply : getRepliesStringsArrayList()) {
            allRepliesString += countReply + ". " + reply + "\n";
            countReply++;
        }

        return allRepliesString;
    }

    public int getCountLikes() {
        return getLikerUsersArrayList().size();
    }

    public int getCountReplies() {
        return getRepliesStringsArrayList().size();
    }

    public void setCommenterUser(User commenterUser) {
        this.commenterUser = commenterUser;
    }

    public User getCommenterUser() {
        return commenterUser;
    }

    public void setCommentString(String commentString) {
        this.commentString = commentString;
    }

    public String getCommentString() {
        return commentString;
    }

    public void setLikerUsersArrayList(ArrayList<User> likerUsersArrayList) {
        this.likerUsersArrayList = likerUsersArrayList;
    }

    public ArrayList<User> getLikerUsersArrayList() {
        return likerUsersArrayList;
    }

    public void setRepliesStringsArrayList(ArrayList<String> repliesStringsArrayList) {
        this.repliesStringsArrayList = repliesStringsArrayList;
    }

    public ArrayList<String> getRepliesStringsArrayList() {
        return repliesStringsArrayList;
    }
}