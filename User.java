import java.awt.HeadlessException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class User {
    private String fullName;
    private String username;
    private String password;
    private LocalDate birthDate;
    private String email;
    private PagePrivacyMode pagePrivacyMode;
    private ArrayList<User> followerUsersArrayList;
    private ArrayList<User> followingUsersArrayList;
    private ArrayList<User> followerRequestedUsersArrayList;
    private ArrayList<User> followingRequestedUsersArrayList;
    private ArrayList<User> blockedUsersArrayList;
    private ArrayList<Post> postsArrayList;
    private ArrayList<Post> homePagePostsArrayList;
    private ArrayList<Group> groupsArrayList;
    private ArrayList<PrivateChat> privateChatsArrayList;

    public User(String fullName, String username, String password, PagePrivacyMode pagePrivacy, String birthDate,
            String email) {
        setFullName(fullName);
        setUsername(username);
        setPassword(password);
        setPagePrivacyMode(pagePrivacy);
        setFollowerUsersArrayList(new ArrayList<>());
        setFollowingUsersArrayList(new ArrayList<>());
        setFollowerRequestedUsersArrayList(new ArrayList<>());
        setFollowingRequestedUsersArrayList(new ArrayList<>());
        setBlockedUsersArrayList(new ArrayList<>());
        setPostsArrayList(new ArrayList<>());
        setHomePagePostsArrayList(new ArrayList<>());
        setGroupsArrayList(new ArrayList<>());
        setPrivateChatsArrayList(new ArrayList<>());
        setBirthDate(birthDate);
        setEmail(email);
    }

    public void editProfile() throws NoSuchAlgorithmException, HeadlessException {
        switch (Integer.parseInt(JOptionPane.showInputDialog(null,
                "Which Data You'd Like to Edit?\n1. Full Name\n2. Username\n3. Password\n4. Birth Date\n5. Email\n6. Cancel",
                "Edit Profile", JOptionPane.QUESTION_MESSAGE))) {
            // Full Name
            case 1:
                String currentFullName = getFullName();
                String newFullName = JOptionPane.showInputDialog(null, "Please Enter Your New Full Name:",
                        "Edit Profile", JOptionPane.QUESTION_MESSAGE);

                setFullName(newFullName);

                JOptionPane.showMessageDialog(null,
                        "Your Full Name Was Successfully Changed From " + currentFullName + " to " + newFullName,
                        "Edit Profile", JOptionPane.INFORMATION_MESSAGE);
                break;

            // Username
            case 2:
                String currentUserName = getUsername();
                String newUserName = JOptionPane.showInputDialog(null, "Please Enter Your New UserName:",
                        "Edit Profile", JOptionPane.QUESTION_MESSAGE).toLowerCase();

                if (DataBase.isTakenUsername(newUserName))
                    JOptionPane.showMessageDialog(null, "Entered Username Is Already Taken By Another User.",
                            "Edit Profile", JOptionPane.ERROR_MESSAGE);
                else {
                    setUsername(newUserName);
                    JOptionPane.showMessageDialog(null,
                            "UserName Was Successfully Changed From " + currentUserName + " to " + newUserName,
                            "Edit Profile", JOptionPane.INFORMATION_MESSAGE);
                }
                break;

            // Password
            case 3:
                String newPassword = JOptionPane.showInputDialog(null, "Please Enter Your New Password:",
                        "Edit Profile", JOptionPane.QUESTION_MESSAGE);

                setPassword(DataBase.toHexString(DataBase.getSHA(newPassword)));

                JOptionPane.showMessageDialog(null, "Password Was Successfully Changed.", "Edit Profile",
                        JOptionPane.INFORMATION_MESSAGE);
                break;

            // Birth Date
            case 4:
                LocalDate currentBirthDate = getBirthDate();
                String newBirthDate = JOptionPane.showInputDialog(null,
                        "Please Enter Your New Birth Date in YYYY-MM-DD Format:", "Edit Profile",
                        JOptionPane.QUESTION_MESSAGE);

                setBirthDate(newBirthDate);

                JOptionPane.showMessageDialog(null,
                        "BirthDate Was Successfully Changed From " + currentBirthDate + " to " + newBirthDate,
                        "Edit Profile", JOptionPane.INFORMATION_MESSAGE);
                break;

            // Email
            case 5:
                String currentEmail = getEmail();
                String newEmail = JOptionPane.showInputDialog(null, "Please Enter Your New Email Address:",
                        "Edit Profile", JOptionPane.QUESTION_MESSAGE);

                JOptionPane.showMessageDialog(null,
                        "Your Email Address Was Successfully Changed From " + currentEmail + " to " + newEmail,
                        "Edit Profile", JOptionPane.INFORMATION_MESSAGE);

                setEmail(newEmail);

                break;

            // Cancel
            case 6:
                JOptionPane.showMessageDialog(null, "Editing Profile Was Successfully Canceled.", "Edit Profile",
                        JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }

    public static User logIn() throws HeadlessException, NoSuchAlgorithmException {
        if (DataBase.usersDataBase.isEmpty())
            JOptionPane.showMessageDialog(null,
                    "No Account is Currently Available in Users's Database.\nPlease Sign-up First.", "Log-In Page",
                    JOptionPane.ERROR_MESSAGE);
        else {
            String username = JOptionPane.showInputDialog(null, "Please Enter Your Username:", "Log-In Page",
                    JOptionPane.QUESTION_MESSAGE).toLowerCase();
            boolean haveFindUsername = false;

            for (User searchUser : DataBase.usersDataBase)
                if (username.equals(searchUser.getUsername())) {
                    haveFindUsername = true;

                    int countLogInAttempts = 0;
                    do {
                        String password = DataBase.toHexString(
                                DataBase.getSHA(JOptionPane.showInputDialog(null, "Please Enter Your Password:",
                                        "Log-In Page",
                                        JOptionPane.QUESTION_MESSAGE)));

                        if (password.equals(searchUser.getPassword())) {
                            JOptionPane.showMessageDialog(null,
                                    "Log-In Was Successful.\nWelcome " + DataBase.getUser(username).getFullName(),
                                    "Log-In Page",
                                    JOptionPane.INFORMATION_MESSAGE);

                            return searchUser;

                        } else {
                            countLogInAttempts += 1;

                            JOptionPane.showMessageDialog(null,
                                    "Wrong Password!\nPlease Try Again. [Wrong-Password Attempts Left: " + (3
                                            - countLogInAttempts) + "/3]",
                                    "Log-In Page",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    } while (countLogInAttempts != 3);

                    if (countLogInAttempts == 3) {
                        JOptionPane.showMessageDialog(null,
                                "Wrong-Password Limitation Reached.\nLog-In Operation Failed!", "Log-In Page",
                                JOptionPane.ERROR_MESSAGE);

                        break;
                    }
                }
            if (!haveFindUsername)
                JOptionPane.showMessageDialog(null, "Log-In Failed!\nInvalid Username!", "Log-In Page",
                        JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public static User signUp() throws HeadlessException, NoSuchAlgorithmException {
        String fullName = JOptionPane.showInputDialog(null, "Please Enter Your FullName:", "Sign-Up Page",
                JOptionPane.QUESTION_MESSAGE);
        boolean isUsernameAlreadyTaken = true;
        String username;

        do {
            username = JOptionPane.showInputDialog(null, "Please Enter Your Username:", "Sign-Up Page",
                    JOptionPane.QUESTION_MESSAGE).toLowerCase();
            if (DataBase.isTakenUsername(username))
                JOptionPane.showMessageDialog(null, "Entered Username Was Already Taken!\nPlease Try Again.",
                        "Sign-Up Page",
                        JOptionPane.ERROR_MESSAGE);
            else
                isUsernameAlreadyTaken = false;
        } while (isUsernameAlreadyTaken);

        String password = DataBase.toHexString(
                DataBase.getSHA(JOptionPane.showInputDialog(null, "Please Enter Your Password:", "Sign-Up Page",
                        JOptionPane.QUESTION_MESSAGE)));
        PagePrivacyMode pagePrivacyMode = null;
        boolean haveEnteredValidNumber = false;

        do {
            switch (Integer
                    .parseInt(JOptionPane.showInputDialog(null,
                            "Please Choose a Privacy Mode For Your Account:\n1. Public\n2. Private",
                            "Sign-Up Page", JOptionPane.QUESTION_MESSAGE))) {
                case 1:
                    pagePrivacyMode = PagePrivacyMode.PUBLIC;
                    haveEnteredValidNumber = true;
                    break;

                case 2:
                    pagePrivacyMode = PagePrivacyMode.PRIVATE;
                    haveEnteredValidNumber = true;
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Invalid Input!\nMust be 1 or 2.", "Sign-Up Page",
                            JOptionPane.ERROR_MESSAGE);
                    continue;
            }
        } while (!haveEnteredValidNumber);

        String birthDate = JOptionPane.showInputDialog(null, "Please Enter Your Birth Date in YYYY-MM-DD Format:",
                "Sign-Up Page", JOptionPane.QUESTION_MESSAGE);

        String email = JOptionPane.showInputDialog(null, "Please Enter Your Email Address:",
                "Sign-Up Page", JOptionPane.QUESTION_MESSAGE);

        User newUser = new User(fullName, username, password, pagePrivacyMode, birthDate, email);

        JOptionPane.showMessageDialog(null,
                "Congratulations!\nYour Account's Registration Was Completed Successfully.",
                "Sign-Up Page",
                JOptionPane.INFORMATION_MESSAGE);

        DataBase.usersDataBase.add(newUser);

        return newUser;
    }

    public String getFollowerRequestedUsersString() {
        String allFollowersRequestedUsers = "All Available Follower Requested Users{\n";

        for (User followerRequestedUser : getFollowerRequestedUsersArrayList())
            allFollowersRequestedUsers += followerRequestedUser.getFullName() + "("
                    + followerRequestedUser.getUsername() + ")\n";
        allFollowersRequestedUsers += "}";

        return allFollowersRequestedUsers;
    }

    public void followUser(User newFollowingUser) {
        if (!getBlockedUsersArrayList().contains(newFollowingUser))
            if (!getFollowingRequestedUsersArrayList().contains(newFollowingUser))
                switch (JOptionPane.showConfirmDialog(null,
                        "Are You Sure You'd Want to Follow "
                                + newFollowingUser.getFullName() + "'s Account? (Page Privacy Mode: "
                                + newFollowingUser.getPagePrivacyMode() + ")",
                        "Follow User", JOptionPane.YES_NO_OPTION)) {
                    case JOptionPane.YES_OPTION:
                        if (newFollowingUser.getPagePrivacyMode().equals(PagePrivacyMode.PUBLIC)) {
                            JOptionPane.showMessageDialog(null,
                                    newFollowingUser.getFullName()
                                            + "'s Account Was Followed Successfully.",
                                    "Follow User",
                                    JOptionPane.INFORMATION_MESSAGE);

                            addNewFollowing(newFollowingUser);
                            newFollowingUser.addNewFollower(this);
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "Your Follow Request Was Sent to " + newFollowingUser.getFullName()
                                            + ".\nPlease Wait For His Confirmation.",
                                    "Follow User", JOptionPane.INFORMATION_MESSAGE);

                            newFollowingUser.addNewFollowerRequest(this);
                            addNewFollowingRequest(newFollowingUser);
                        }
                        break;

                    case JOptionPane.NO_OPTION:
                        JOptionPane.showMessageDialog(null,
                                "Follow Operation Was Cancelled.", "Follow User",
                                JOptionPane.INFORMATION_MESSAGE);
                        break;
                }
            else
                JOptionPane.showMessageDialog(null, "You've Already Requested to This User.", "Follow User",
                        JOptionPane.ERROR_MESSAGE);
        else
            JOptionPane.showMessageDialog(null,
                    "You've Have Blocked " + newFollowingUser.getFullName() + "'s Account.\nUnBlock to Follow.",
                    "Follow User", JOptionPane.ERROR_MESSAGE);
    }

    private void addNewFollowerRequest(User newFollowerRequestedUser) {
        getFollowerRequestedUsersArrayList().add(newFollowerRequestedUser);
    }

    private void addNewFollowingRequest(User newFollowingRequestedUser) {
        getFollowingRequestedUsersArrayList().add(newFollowingRequestedUser);
    }

    public void unFollowUser(User unFollowUser) {
        if (getFollowingUsersArrayList().contains(unFollowUser)) {
            switch (JOptionPane.showConfirmDialog(null,
                    "Are You Sure You Want to UnFollow "
                            + unFollowUser.getFullName() + "'s Account?",
                    "UnFollow User", JOptionPane.YES_NO_OPTION)) {
                case JOptionPane.YES_OPTION:
                    JOptionPane.showMessageDialog(null,
                            unFollowUser.getFullName()
                                    + "'s Account Was UnFollowed Successfully.",
                            "UnFollow User",
                            JOptionPane.INFORMATION_MESSAGE);

                    removeFollowing(unFollowUser);
                    unFollowUser.removeFollower(this);

                    JOptionPane.showMessageDialog(null,
                            unFollowUser.getFullName() + "'s Account Was Successfully UnFollowed.",
                            "UnFollow User",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;

                case JOptionPane.NO_OPTION:
                    JOptionPane.showMessageDialog(null,
                            "UnFollow Operation Was Cancelled.",
                            "UnFollow User",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
            }
        } else
            JOptionPane.showMessageDialog(null, "You've Never Followed This User.",
                    "UnFollow User",
                    JOptionPane.ERROR_MESSAGE);
    }

    private void addNewFollowing(User newFollowingUser) {
        getFollowingUsersArrayList().add(newFollowingUser);
    }

    private void removeFollowing(User unFollowUser) {
        getFollowingUsersArrayList().remove(unFollowUser);
    }

    private void addNewFollower(User newFollowUser) {
        getFollowerUsersArrayList().add(newFollowUser);
    }

    private void removeFollower(User unFollowUser) {
        getFollowerUsersArrayList().remove(unFollowUser);

    }

    public String getProfileString() {
        String accountInfo = "FullName: " + getFullName() + "\nUsername: " + getUsername() + "\nAge: " + calculateAge()
                + " (BirthDate: " + getBirthDate() + ")" + "\nPage Privacy Mode: "
                + getPagePrivacyMode() + "\n\nFollowers[Count: " + getCountFollowers() + "]{\n";
        for (User user : getFollowerUsersArrayList())
            accountInfo += user.getFullName() + "(" + user.getUsername() + ")";
        accountInfo += "\n}\n\nFollowings[Count: " + getCountFollowings() + "]{\n";
        for (User user : getFollowingUsersArrayList())
            accountInfo += user.getFullName() + "(" + user.getUsername() + ")";
        accountInfo += "\n}\n\nFollower Requested[Count: " + getCountFollowerRequestedUsers() + "]{\n";
        for (User user : getFollowerRequestedUsersArrayList())
            accountInfo += user.getFullName() + "(" + user.getUsername() + ")";
        accountInfo += "\n}\n\nFollowing Requested[Count: " + getCountFollowingRequestedUsers() + "]{\n";
        for (User user : getFollowingRequestedUsersArrayList())
            accountInfo += user.getFullName() + "(" + user.getUsername() + ")";
        accountInfo += "\n}\n\nBlocked Users[Count: " + getCountBlockedUsers() + "]{\n";
        for (User user : getBlockedUsersArrayList())
            accountInfo += user.getFullName() + "(" + user.getUsername() + ")";
        accountInfo += "\n}\n\nGroups{\n";
        for (Group group : getGroupsArrayList())
            accountInfo += group.getName() + "(" + group.getID() + ")";
        accountInfo += "\n}";

        return accountInfo;
    }

    public int getCountBlockedUsers() {
        return getBlockedUsersArrayList().size();
    }

    public int getCountFollowers() {
        return getFollowerUsersArrayList().size();
    }

    public int getCountFollowings() {
        return getFollowingUsersArrayList().size();
    }

    public int getCountFollowerRequestedUsers() {
        return getFollowerRequestedUsersArrayList().size();
    }

    public int getCountFollowingRequestedUsers() {
        return getFollowingRequestedUsersArrayList().size();
    }

    public void AcceptFollowerRequestedUser(User followerRequestedUser) {
        if (getFollowerRequestedUsersArrayList()
                .contains(followerRequestedUser)) {
            JOptionPane.showMessageDialog(null,
                    followerRequestedUser.getFullName() + "'s Follower-Request Is Successfully Accepted.",
                    "Accept a Request", JOptionPane.INFORMATION_MESSAGE);

            addNewFollower(followerRequestedUser);
            followerRequestedUser.addNewFollowing(this);
            getFollowerRequestedUsersArrayList().remove(followerRequestedUser);
            followerRequestedUser.getFollowingRequestedUsersArrayList().remove(this);
        } else
            JOptionPane.showMessageDialog(null,
                    "Invalid User.\nEntered User Is NOT In Your Follower-Requested Users's List.",
                    "Accept a Request",
                    JOptionPane.ERROR_MESSAGE);
    }

    public void RejectFollowerRequestedUser(User followerRequestedUser) {
        if (getFollowerRequestedUsersArrayList()
                .contains(followerRequestedUser)) {
            JOptionPane.showMessageDialog(null,
                    followerRequestedUser.getFullName() + "'s Follower-Request Is Successfully Rejected.",
                    "Reject a Request", JOptionPane.INFORMATION_MESSAGE);

            getFollowerRequestedUsersArrayList().remove(followerRequestedUser);
            followerRequestedUser.getFollowingRequestedUsersArrayList().remove(this);
        } else
            JOptionPane.showMessageDialog(null,
                    "Invalid User.\nEntered User Is NOT In Your Follower-Requested Users's List.",
                    "Reject a Request",
                    JOptionPane.ERROR_MESSAGE);
    }

    public void blockUser(User blockUser) {
        switch (JOptionPane.showConfirmDialog(null,
                "Are You Sure You Want to Block "
                        + blockUser.getFullName() + "'s Account?",
                "Block User", JOptionPane.YES_NO_OPTION)) {
            case JOptionPane.YES_OPTION:
                JOptionPane.showMessageDialog(null,
                        blockUser.getFullName() + "'s Account Was Successfully Blocked.", "Block User",
                        JOptionPane.INFORMATION_MESSAGE);

                getBlockedUsersArrayList().add(blockUser);
                blockUser.getBlockedUsersArrayList().add(this);

                getFollowerUsersArrayList().remove(blockUser);
                getFollowingUsersArrayList().remove(blockUser);
                getFollowerRequestedUsersArrayList().remove(blockUser);
                getFollowingRequestedUsersArrayList().remove(blockUser);

                blockUser.getFollowerUsersArrayList().remove(this);
                blockUser.getFollowingUsersArrayList().remove(this);
                blockUser.getFollowerRequestedUsersArrayList().remove(this);
                blockUser.getFollowingRequestedUsersArrayList().remove(this);

                break;

            case JOptionPane.NO_OPTION:
                JOptionPane.showMessageDialog(null,
                        "Block Operation Was Cancelled.",
                        "Block User",
                        JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }

    public void unblockUser(User unblockUser) {
        if (getBlockedUsersArrayList().contains(unblockUser)) {
            JOptionPane.showMessageDialog(null, unblockUser.getFullName() + "'s Account Is Successfully UnBlocked.",
                    "UnBlock User",
                    JOptionPane.INFORMATION_MESSAGE);

            getBlockedUsersArrayList().remove(unblockUser);
            unblockUser.getBlockedUsersArrayList().remove(this);
        } else
            JOptionPane.showMessageDialog(null, "You've Not Blocked " + unblockUser.getFullName() + "'s Account.",
                    "UnBlock User", JOptionPane.ERROR_MESSAGE);
    }

    public void addNewPost(User uploaderUser) {
        String caption = JOptionPane.showInputDialog(null, "Please Enter a Caption For Your New Post:", "Add New Post",
                JOptionPane.QUESTION_MESSAGE);

        Post newPost = new Post(uploaderUser, caption);
        getPostsArrayList().add(newPost);

        for (User follower : getFollowerUsersArrayList())
            follower.getHomePagePostsArrayList().add(newPost);

        JOptionPane.showMessageDialog(null, "New Post Was Successfully Added.", "Add New Post",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public String getAllPostsString() {
        String allPosts = "";
        int counter = 1;

        for (Post post : getPostsArrayList()) {
            allPosts += counter + ".\nCaption: " + post.getCaptionString() + "\nLike Counts: " + post.getCountLikes()
                    + "\nComment Counts: " + post.getCountComments() + "\n";
            counter++;
        }

        return allPosts;
    }

    public int getCountPosts() {
        return getPostsArrayList().size();
    }

    public void deletePost() {
        if (getCountPosts() != 0) {
            int indexPost = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Which One of the Following Posts You'd Like to Delete?\n" + getAllPostsString(), "Delete Post",
                    JOptionPane.QUESTION_MESSAGE)) - 1;
            if (indexPost >= 0 && indexPost < getCountPosts()) {
                for (User followerUser : getFollowerUsersArrayList())
                    followerUser.getHomePagePostsArrayList().remove(getPostsArrayList().get(indexPost));
                getPostsArrayList().remove(indexPost);

                JOptionPane.showMessageDialog(null, "Post Was Successfully Deleted.", "Delete Post",
                        JOptionPane.INFORMATION_MESSAGE);
            } else
                JOptionPane.showMessageDialog(null,
                        "Invalid Input.\nDelete Post Operation Failed.\n\nInput Must Be an Integer Between 1 & "
                                + getCountPosts() + ".",
                        "Delete Post",
                        JOptionPane.ERROR_MESSAGE);
        } else
            JOptionPane.showMessageDialog(null, "You've No Posts to Delete.", "Delete Post", JOptionPane.ERROR_MESSAGE);
    }

    public void likePost(Post post) {
        if (post.getLikerUsersArrayList().contains(this))
            JOptionPane.showMessageDialog(null, "You've Already Liked This Post.", "Like Post",
                    JOptionPane.ERROR_MESSAGE);
        else {
            post.getLikerUsersArrayList().add(this);

            JOptionPane.showMessageDialog(null, "Post Was Successfully Liked.", "Like Post",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void disLikePost(Post post) {
        if (post.getLikerUsersArrayList().contains(this)) {
            post.getLikerUsersArrayList().remove(this);

            JOptionPane.showMessageDialog(null, "Post Was Successfully DisLiked.", "DisLike Post",
                    JOptionPane.INFORMATION_MESSAGE);
        } else
            JOptionPane.showMessageDialog(null, "You've Not Liked This Post.", "DisLike Post",
                    JOptionPane.ERROR_MESSAGE);
    }

    public void comment(Post post) {
        String commentCaption = JOptionPane.showInputDialog(null, "Please Enter Your Comment's Caption:",
                "Comment Post",
                JOptionPane.QUESTION_MESSAGE);

        Comment newComment = new Comment(this, commentCaption);
        post.getCommentsArrayList().add(newComment);

        JOptionPane.showMessageDialog(null, "Comment Was Successfully Added to the Post.", "Comment Post",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public String getAllHomePagePostsString() {
        String homePagePostsInfo = "All Available HomePage Posts:\n";
        int postIndex = 1;

        for (Post homePagePost : getHomePagePostsArrayList()) {
            homePagePostsInfo += postIndex + ".\n" + homePagePost.getPostString() + "\n";
            postIndex++;
        }

        return homePagePostsInfo;
    }

    public void likeComment(Comment comment) {
        if (comment.getLikerUsersArrayList()
                .contains(this))
            JOptionPane.showMessageDialog(null, "You've Already Liked This Comment", "Like Comment",
                    JOptionPane.ERROR_MESSAGE);
        else {
            comment.getLikerUsersArrayList()
                    .add(this);

            JOptionPane.showMessageDialog(null, "Comment Was Liked Successfully.", "Like Comment",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void likeChat(Comment chat) {
        if (chat.getLikerUsersArrayList().contains(this))
            JOptionPane.showMessageDialog(null, "You've Already Liked This Chat.", "Like Chat",
                    JOptionPane.ERROR_MESSAGE);
        else {
            chat.getLikerUsersArrayList().add(this);

            JOptionPane.showMessageDialog(null, "Chat Was Successfully Liked.", "Like Chat",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void disLikeComment(Comment comment) {
        if (comment.getLikerUsersArrayList()
                .contains(this)) {
            comment.getLikerUsersArrayList()
                    .remove(this);

            JOptionPane.showMessageDialog(null, "Comment Was Successfully DisLiked.", "DisLike Comment",
                    JOptionPane.INFORMATION_MESSAGE);
        } else
            JOptionPane.showMessageDialog(null, "You've Never Liked This Comment Before.", "DisLike Comment",
                    JOptionPane.ERROR_MESSAGE);
    }

    public void DisLikeChat(Comment chat) {
        if (chat.getLikerUsersArrayList().contains(this)) {
            chat.getLikerUsersArrayList().remove(this);

            JOptionPane.showMessageDialog(null, "Chat Was Successfully DisLiked.", "DisLike Chat",
                    JOptionPane.INFORMATION_MESSAGE);
        } else
            JOptionPane.showMessageDialog(null, "You've Never Liked This Chat.", "DisLike Chat",
                    JOptionPane.ERROR_MESSAGE);
    }

    public void replyComment(Comment comment) {
        comment.getRepliesStringsArrayList()
                .add(JOptionPane.showInputDialog(null, "Please Enter Your Reply:", "Reply to Comment",
                        JOptionPane.QUESTION_MESSAGE));
    }

    public void createNewGroup() {
        String newGroupName = JOptionPane.showInputDialog(null, "Please Enter New Group's Name:", "Create New Group",
                JOptionPane.QUESTION_MESSAGE);
        Group newGroup = new Group(newGroupName);

        getGroupsArrayList().add(newGroup);
        newGroup.getAdminUsersArrayList().add(this);
        DataBase.groupsDataBase.add(newGroup);

        JOptionPane.showMessageDialog(null, "Group Was Successfully Created.\n\n" + newGroup.getGroupString(),
                "Create New Group",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void joinGroup() {
        int groupID = Integer
                .parseInt(JOptionPane.showInputDialog(null, "Please Enter ID of the Group You'd Like to Join:",
                        "Join Group", JOptionPane.QUESTION_MESSAGE));

        if (DataBase.isValidGroupID(groupID)) {
            DataBase.getGroup(groupID).getRequestedUsersArrayList().add(this);

            JOptionPane.showMessageDialog(null,
                    "Join-Request Was Sent For the Admins.\nPlease Wait For Their Reaction.", "Join Group",
                    JOptionPane.INFORMATION_MESSAGE);
        } else
            JOptionPane.showMessageDialog(null, "Joining Group Was Failed!\nInvalid GroupID.", "Join Group",
                    JOptionPane.ERROR_MESSAGE);
    }

    public int getCountGroups() {
        return getGroupsArrayList().size();
    }

    public void SendMessage(Group group) {
        String chatCaptionString = JOptionPane.showInputDialog(null, "Please Enter Your Chat:",
                "Add New Message to Chat",
                JOptionPane.QUESTION_MESSAGE);

        Comment newChatComment = new Comment(this, chatCaptionString);
        group.getChatCommentsArrayList().add(newChatComment);

        JOptionPane.showMessageDialog(null, "Message Was Successfully Sent to The Group's Chat.",
                "Add New Message to Chat",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public boolean isAdmin(Group group) {
        return group.getAdminUsersArrayList().contains(this);
    }

    public void addToAdminsGroup(User requestedUser, Group group) {
        group.getRequestedUsersArrayList().remove(requestedUser);
        group.getAdminUsersArrayList().add(requestedUser);

        JOptionPane.showMessageDialog(null,
                requestedUser.getFullName() + " Was Successfully Added To the Admins Of the Groups.", "RequestPage",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void addToMembersGroup(User requestedUser, Group group) {
        group.getRequestedUsersArrayList().remove(requestedUser);
        group.getMemberUsersArrayList().add(requestedUser);

        JOptionPane.showMessageDialog(null,
                requestedUser.getFullName() + " Was Successfully Added To the Members Of the Groups.", "RequestPage",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void deleteChat(Group containingGroup, Comment chat) {
        if (chat.getCommenterUser().equals(this) || containingGroup.getAdminUsersArrayList().contains(this)) {
            containingGroup.getChatCommentsArrayList().remove(chat);

            JOptionPane.showMessageDialog(null, "Your Chat Was Successfully Deleted.", "Delete Chat",
                    JOptionPane.INFORMATION_MESSAGE);
        } else
            JOptionPane.showMessageDialog(null,
                    "You Can't Delete This Chat.\nYou're Not Uploader of the Chat, Nor One of Admins.", "Delete Chat",
                    JOptionPane.ERROR_MESSAGE);
    }

    public void forwardChat(Comment chat) {
        if (getGroupsArrayList().isEmpty() && getPrivateChatsArrayList().isEmpty())
            JOptionPane.showMessageDialog(null, "You've No Groups Or PrivateChats Available At the Moment.",
                    "Forward Chat", JOptionPane.ERROR_MESSAGE);
        else {
            switch (Integer.parseInt(
                    JOptionPane.showInputDialog(null,
                            "Which Kind of Chat You'd Like to Forward This Message To?\n1. Group\n2. Private Chat",
                            "Forward Message", JOptionPane.QUESTION_MESSAGE))) {
                case 1:
                    if (getGroupsArrayList().isEmpty())
                        JOptionPane.showMessageDialog(null, "You've No Group Available At the Moment.",
                                "Forward Message", JOptionPane.ERROR_MESSAGE);
                    else {
                        int chosenGroupIndex = Integer
                                .parseInt(
                                        JOptionPane.showInputDialog(null,
                                                getAllGroupsString() + "\n\nPlease Choose A Group's Number:",
                                                "Forward Chat", JOptionPane.QUESTION_MESSAGE))
                                - 1;

                        if (chosenGroupIndex >= 0 && chosenGroupIndex < getCountGroups()) {
                            getGroupsArrayList().get(chosenGroupIndex).getChatCommentsArrayList().add(chat);

                            JOptionPane.showMessageDialog(null,
                                    "Chat Was Successfully Forwarded to "
                                            + getGroupsArrayList().get(chosenGroupIndex).getName()
                                            + ".",
                                    "Forward Chat", JOptionPane.INFORMATION_MESSAGE);
                        } else
                            JOptionPane.showMessageDialog(null,
                                    "Invalid Input.\nInput Must Be an Integer Between 1 & " + getCountGroups() + ".",
                                    "Forward Chat",
                                    JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                case 2:
                    if (getPrivateChatsArrayList().isEmpty())
                        JOptionPane.showMessageDialog(null, "You've No Private Chats Available At the Moment.",
                                "Forward Message", JOptionPane.ERROR_MESSAGE);
                    else {
                        int chosenPrivateChatIndex = Integer
                                .parseInt(
                                        JOptionPane.showInputDialog(null,
                                                getAllPrivateChatsString()
                                                        + "\nPlease Choose A Private Chat's Number:",
                                                "Forward Chat", JOptionPane.QUESTION_MESSAGE))
                                - 1;

                        if (chosenPrivateChatIndex >= 0 && chosenPrivateChatIndex < getCountPrivateChats()) {
                            getPrivateChatsArrayList().get(chosenPrivateChatIndex).getChatCommentsArrayList()
                                    .add(chat);

                            JOptionPane.showMessageDialog(null,
                                    "Chat Was Successfully Forwarded to Your Private Chat.",
                                    "Forward Chat", JOptionPane.INFORMATION_MESSAGE);
                        } else
                            JOptionPane.showMessageDialog(null,
                                    "Invalid Input.\nInput Must Be an Integer Between 1 & " + getCountGroups() + ".",
                                    "Forward Chat",
                                    JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                case 3:
                    JOptionPane.showMessageDialog(null, "Operation Was Cancelled.", "Forward Chat",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
            }
        }
    }

    public String getAllGroupsString() {
        String allGroupsString = "All Available Groups:\n";
        int counterGroups = 1;

        for (Group group : getGroupsArrayList()) {
            allGroupsString += counterGroups + ". " + group.getName() + "(ID: " + group.getID() + ")\n";
            counterGroups++;
        }

        return allGroupsString;
    }

    public void replyChat(Comment chat) {
        chat.getRepliesStringsArrayList()
                .add(JOptionPane.showInputDialog(null, "Please Enter Your reply's Chat:", "Reply Chat",
                        JOptionPane.QUESTION_MESSAGE));

        JOptionPane.showMessageDialog(null, "Your Reply Was Successfully Added.", "Reply Chat",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void startNewPrivateChat() {
        String username = JOptionPane
                .showInputDialog(null,
                        "Please Enter the Username of the Person You'd Like to Start a Private Chat With:",
                        "Start New Private Chat", JOptionPane.QUESTION_MESSAGE)
                .toLowerCase();

        if (DataBase.isTakenUsername(username))
            if (alreadyHasAPrivateChat(DataBase.getUser(username)))
                JOptionPane.showMessageDialog(null, "You Already Have a Private Chat With " + username + ".",
                        "Start New Private Chat", JOptionPane.ERROR_MESSAGE);
            else {
                PrivateChat newPrivateChat = new PrivateChat(this, DataBase.getUser(username));
                DataBase.getUser(username).getPrivateChatsArrayList().add(newPrivateChat);
                getPrivateChatsArrayList().add(newPrivateChat);

                JOptionPane.showMessageDialog(null,
                        "New Private Chat Was Successfully Started With " + username + ".",
                        "Start New Private Chat", JOptionPane.INFORMATION_MESSAGE);
            }
        else
            JOptionPane.showMessageDialog(null, "Invalid Username.\nNo Such Username Was Found in the Database.",
                    "Start New Private Chat", JOptionPane.ERROR_MESSAGE);
    }

    private boolean alreadyHasAPrivateChat(User user) {
        for (PrivateChat privateChat : getPrivateChatsArrayList())
            if (privateChat.getUser1().equals(user) || privateChat.getUser2().equals(user))
                return true;
        return false;
    }

    public String getAllPrivateChatsString() {
        String allPrivateChatsString = "All Available Private Chats:\n";
        int counterPrivateChats = 1;

        for (PrivateChat privateChat : getPrivateChatsArrayList()) {
            allPrivateChatsString += counterPrivateChats + ". " + getPrivateChatUser(privateChat).getFullName() + "("
                    + getPrivateChatUser(privateChat).getUsername() + ")\n";
            counterPrivateChats++;
        }

        return allPrivateChatsString;
    }

    private User getPrivateChatUser(PrivateChat privateChat) {
        return privateChat.getUser1().equals(this) ? privateChat.getUser2() : privateChat.getUser1();
    }

    public int getCountPrivateChats() {
        return getPrivateChatsArrayList().size();
    }

    public void SendMessage(PrivateChat privateChat) {
        String chatCaptionString = JOptionPane.showInputDialog(null, "Please Enter Your Chat:",
                "Add New Message to Private Chat",
                JOptionPane.QUESTION_MESSAGE);

        Comment newChatComment = new Comment(this, chatCaptionString);
        privateChat.getChatCommentsArrayList().add(newChatComment);

        JOptionPane.showMessageDialog(null, "Message Was Successfully Sent to The Private Chat",
                "Add New Message to Chat",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private ArrayList<Post> bubbleSort_PostsArrayList(ArrayList<Post> postsArrayList) {
        ArrayList<Post> sortedPostsArrayList = postsArrayList;

        for (int i = 0; i < sortedPostsArrayList.size() - 1; i++)
            for (int j = 0; j < sortedPostsArrayList.size() - i - 1; j++)
                if (sortedPostsArrayList.get(j).getCountLikes() < sortedPostsArrayList.get(j + 1).getCountLikes()) {
                    Post tempPost = sortedPostsArrayList.get(j);
                    sortedPostsArrayList.set(j, sortedPostsArrayList.get(j + 1));
                    sortedPostsArrayList.set(j + 1, tempPost);
                }

        return sortedPostsArrayList;
    }

    public void showSortedPosts(ArrayList<Post> postsArrayList) {
        ArrayList<Post> sortedPostsArrayList = bubbleSort_PostsArrayList(postsArrayList);

        String sortedPostsInfo = "All Available Posts [SORTED]:\n";
        int postIndex = 1;

        for (Post post : sortedPostsArrayList) {
            sortedPostsInfo += postIndex + ".\n" + post.getPostString() + "\n";
            postIndex++;
        }

        JOptionPane.showMessageDialog(null, sortedPostsInfo, "Show Like-Count-Sorted HomePage Posts",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void addToMembersGroup(Group group) {
        if (isAdmin(group)) {
            String username = JOptionPane.showInputDialog(null,
                    "Please Enter the Username of the User You'd Like to Add to the Group:",
                    "Add New Member to the Group",
                    JOptionPane.QUESTION_MESSAGE).toLowerCase();

            if (DataBase.isTakenUsername(username)) {
                User newUser = DataBase.getUser(username);

                if (group.getMemberUsersArrayList().contains(newUser)
                        || group.getAdminUsersArrayList().contains(newUser))
                    JOptionPane.showMessageDialog(null, "Entered User is Already a Member of the Group.",
                            "Add New Member to the Group", JOptionPane.INFORMATION_MESSAGE);
                else {
                    group.getMemberUsersArrayList().add(newUser);

                    JOptionPane.showMessageDialog(null, "New User Has Been Successfully Added to the Group's Members.",
                            "Add New Member to the Group",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            } else
                JOptionPane.showMessageDialog(null,
                        "Invalid Username.\nEntered Username is Not Available in the Database.",
                        "Add New Member to the Group",
                        JOptionPane.ERROR_MESSAGE);
        } else
            JOptionPane.showMessageDialog(null, "Access Blocked.\nYou're Not Admin of This Group.",
                    "Add New Member to the Group",
                    JOptionPane.ERROR_MESSAGE);
    }

    public void addToAdminsGroup(Group group) {
        if (isAdmin(group)) {
            String username = JOptionPane.showInputDialog(null,
                    "Please Enter the Username of the User You'd Like to Add to the Group:",
                    "Add New Admin to the Group",
                    JOptionPane.QUESTION_MESSAGE).toLowerCase();

            if (DataBase.isTakenUsername(username)) {
                User newUser = DataBase.getUser(username);

                if (group.getAdminUsersArrayList().contains(newUser))
                    JOptionPane.showMessageDialog(null, "Entered User is Already a Admin of the Group.",
                            "Add New Admin to the Group", JOptionPane.INFORMATION_MESSAGE);
                else if (group.getMemberUsersArrayList().contains(newUser)) {
                    group.getMemberUsersArrayList().remove(newUser);
                    group.getAdminUsersArrayList().add(newUser);

                    JOptionPane.showMessageDialog(null, "New User Has Been Successfully Promoted From Member to Admin",
                            "Add New Admin to the Group",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    group.getAdminUsersArrayList().add(newUser);

                    JOptionPane.showMessageDialog(null,
                            "New User Has Been Successfully Successfully Added to the Admins of the Group.",
                            "Add New Admin to the Group",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            } else
                JOptionPane.showMessageDialog(null,
                        "Invalid Username.\nEntered Username is Not Available in the Database.",
                        "Add New Admin to the Group",
                        JOptionPane.ERROR_MESSAGE);
        } else
            JOptionPane.showMessageDialog(null, "Access Blocked.\nYou're Not Admin of This Group.",
                    "Add New Admin to the Group",
                    JOptionPane.ERROR_MESSAGE);
    }

    public int calculateAge() {
        if (getBirthDate().equals(null))
            return -1;
        return Period.between(getBirthDate(), LocalDate.now()).getYears();
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPagePrivacyMode(PagePrivacyMode pagePrivacyMode) {
        this.pagePrivacyMode = pagePrivacyMode;
    }

    public PagePrivacyMode getPagePrivacyMode() {
        return pagePrivacyMode;
    }

    public void setFollowerUsersArrayList(ArrayList<User> followerUsersArrayList) {
        this.followerUsersArrayList = followerUsersArrayList;
    }

    public ArrayList<User> getFollowerUsersArrayList() {
        return followerUsersArrayList;
    }

    public void setFollowerRequestedUsersArrayList(ArrayList<User> followerRequestedUsersArrayList) {
        this.followerRequestedUsersArrayList = followerRequestedUsersArrayList;
    }

    public ArrayList<User> getFollowerRequestedUsersArrayList() {
        return followerRequestedUsersArrayList;
    }

    public void setFollowingRequestedUsersArrayList(ArrayList<User> followingRequestedUsersArrayList) {
        this.followingRequestedUsersArrayList = followingRequestedUsersArrayList;
    }

    public ArrayList<User> getFollowingRequestedUsersArrayList() {
        return followingRequestedUsersArrayList;
    }

    public void setFollowingUsersArrayList(ArrayList<User> followingUsersArrayList) {
        this.followingUsersArrayList = followingUsersArrayList;
    }

    public ArrayList<User> getFollowingUsersArrayList() {
        return followingUsersArrayList;
    }

    public void setBlockedUsersArrayList(ArrayList<User> blockedUsersArrayList) {
        this.blockedUsersArrayList = blockedUsersArrayList;
    }

    public ArrayList<User> getBlockedUsersArrayList() {
        return blockedUsersArrayList;
    }

    public void setPostsArrayList(ArrayList<Post> postsArrayList) {
        this.postsArrayList = postsArrayList;
    }

    public ArrayList<Post> getPostsArrayList() {
        return postsArrayList;
    }

    public void setHomePagePostsArrayList(ArrayList<Post> homePagePostsArrayList) {
        this.homePagePostsArrayList = homePagePostsArrayList;
    }

    public ArrayList<Post> getHomePagePostsArrayList() {
        return homePagePostsArrayList;
    }

    public void setGroupsArrayList(ArrayList<Group> groupsArrayList) {
        this.groupsArrayList = groupsArrayList;
    }

    public ArrayList<Group> getGroupsArrayList() {
        return groupsArrayList;
    }

    public void setPrivateChatsArrayList(ArrayList<PrivateChat> privateChatsArrayList) {
        this.privateChatsArrayList = privateChatsArrayList;
    }

    public ArrayList<PrivateChat> getPrivateChatsArrayList() {
        return privateChatsArrayList;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = LocalDate.parse(birthDate);
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}