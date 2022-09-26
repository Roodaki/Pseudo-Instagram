import java.util.ArrayList;

public class Chat {
    private ArrayList<Comment> chatCommentsArrayList;

    public Chat() {
        setChatCommentsArrayList(new ArrayList<>());
    }

    public void setChatCommentsArrayList(ArrayList<Comment> chatCommentsArrayList) {
        this.chatCommentsArrayList = chatCommentsArrayList;
    }

    public ArrayList<Comment> getChatCommentsArrayList() {
        return chatCommentsArrayList;
    }
}
