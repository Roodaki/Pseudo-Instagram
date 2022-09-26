import java.util.ArrayList;

public class Post {
    private User uploaderUser;
    private String captionString;
    private ArrayList<User> likerUsersArrayList;
    private ArrayList<Comment> commentsArrayList;

    public Post(User uploaderUser, String caption) {
        setUploaderUser(uploaderUser);
        setCaptionString(caption);
        setLikerUsersArrayList(new ArrayList<>());
        setCommentsArrayList(new ArrayList<>());
    }

    public String getPostString() {
        return "Uploader User: "
                + getUploaderUser().getFullName() + "("
                + getUploaderUser().getUsername() + ")" + "\nCaption: "
                + getCaptionString() + "\nCount Likes: "
                + getCountLikes() + "\nCount Comments: "
                + getCountComments();
    }

    public String getLikerUsersString() {
        String likersList = "All Likers Of This Post:\n";
        int likerIndex = 1;

        for (User likerUser : getLikerUsersArrayList()) {
            likersList += likerIndex + ". " + likerUser.getFullName() + "(" + likerUser.getUsername() + ")";
            likerIndex++;
        }

        return likersList;
    }

    public String getCommentsString() {
        String allCommentsInfo = "All Comments On This Post:\n";
        int commentIndex = 1;

        for (Comment comment : getCommentsArrayList()) {
            allCommentsInfo += commentIndex + ".\n" + comment.getCommentInfo();
            commentIndex++;
        }

        return allCommentsInfo;
    }

    public int getCountLikes() {
        return getLikerUsersArrayList().size();
    }

    public int getCountComments() {
        return getCommentsArrayList().size();
    }

    public void setUploaderUser(User uploaderUser) {
        this.uploaderUser = uploaderUser;
    }

    public User getUploaderUser() {
        return uploaderUser;
    }

    public void setCaptionString(String captionString) {
        this.captionString = captionString;
    }

    public String getCaptionString() {
        return captionString;
    }

    public void setLikerUsersArrayList(ArrayList<User> likerUsersArrayList) {
        this.likerUsersArrayList = likerUsersArrayList;
    }

    public ArrayList<User> getLikerUsersArrayList() {
        return likerUsersArrayList;
    }

    public void setCommentsArrayList(ArrayList<Comment> commentsArrayList) {
        this.commentsArrayList = commentsArrayList;
    }

    public ArrayList<Comment> getCommentsArrayList() {
        return commentsArrayList;
    }

}
