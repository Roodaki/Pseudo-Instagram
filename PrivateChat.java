import java.util.ArrayList;

public class PrivateChat extends Chat {
    private User user1, user2;

    public PrivateChat(User user1, User user2) {
        setUser1(user1);
        setUser2(user2);
        setChatCommentsArrayList(new ArrayList<>());
    }

    public String getPrivateChatMessagesString() {
        String privateChatsMessages = "All Available Messages in This Private Chat:\n";
        int counterMessage = 1;

        for (Comment messageComment : getChatCommentsArrayList()) {
            privateChatsMessages += counterMessage + ".\n" + messageComment.getCommentInfo() + "\n";
            counterMessage++;
        }

        return privateChatsMessages;
    }

    public int getCountMessages() {
        return getChatCommentsArrayList().size();
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

    public User getUser2() {
        return user2;
    }
}
