import java.awt.HeadlessException;
import java.security.NoSuchAlgorithmException;

import javax.swing.JOptionPane;

public class PseudoInstagram {
	public static void main(String[] args) throws HeadlessException, NoSuchAlgorithmException {
		JOptionPane.showMessageDialog(null, "Welcome to the Pseudo-Instagram Application.", "Welcome Note",
				JOptionPane.INFORMATION_MESSAGE);

		boolean isAppRunning = true;
		while (isAppRunning)
			switch (Integer
					.parseInt(JOptionPane.showInputDialog(null,
							"Please Choose a Method:\n1. Log In\n2. Sign Up\n3. Exit", "LogIn/SignUp Page",
							JOptionPane.QUESTION_MESSAGE))) {
				// Log In
				case 1:
					User currentUser = User.logIn();

					if (currentUser != null) {
						String searchUsername = null;

						boolean isLoggedIn = true;
						while (isLoggedIn)
							switch (Integer.parseInt(
									JOptionPane.showInputDialog(null,
											"Which Page You'd Like To View?\n1. HomePage\n2. UserPage\n3. PostPage\n4. MessagePage\n5. SearchPage\n6. Log Out",
											"Control Panel",
											JOptionPane.QUESTION_MESSAGE))) {
								// HomePage
								case 1:
									if (currentUser.getHomePagePostsArrayList().isEmpty())
										JOptionPane.showMessageDialog(null,
												"Your HomePage is Currently Empty.\nWait For Your Followings To Add New Posts.",
												"HomePage",
												JOptionPane.INFORMATION_MESSAGE);
									else {
										boolean isInHomePage = true;
										while (isInHomePage)
											switch (Integer.parseInt(
													JOptionPane.showInputDialog(null, currentUser
															.getAllHomePagePostsString()
															+ "\nWhat Do You Want to Do?\n1. Show Like-Count-Sorted HomePage Posts\n2. View Post's DataPage\n3. Back to Control Panel",
															"HomePage",
															JOptionPane.QUESTION_MESSAGE))) {
												// Show Like-Count-Sorted HomePage Posts
												case 1:
													currentUser
															.showSortedPosts(currentUser.getHomePagePostsArrayList());
													continue;

												// View Post's DataPage
												case 2:
													int chosenHomePagePostIndex = Integer.parseInt(JOptionPane
															.showInputDialog(null, currentUser
																	.getAllHomePagePostsString()
																	+ "\nPlease Enter a Post's Number to View It's Detail:",
																	"Post's DataPage",
																	JOptionPane.QUESTION_MESSAGE))
															- 1;

													if (chosenHomePagePostIndex >= 0
															&& chosenHomePagePostIndex < currentUser
																	.getHomePagePostsArrayList()
																	.size()) {
														Post chosenHomePagePost = currentUser
																.getHomePagePostsArrayList()
																.get(chosenHomePagePostIndex);

														Boolean isViewingPostsDetail = true;
														while (isViewingPostsDetail)
															switch (Integer.parseInt(JOptionPane.showInputDialog(null,
																	"Chosen Post:\n"
																			+ chosenHomePagePost.getPostString()
																			+ "\n\nWhat Do You Want to Do?\n1. View Like Section\n2. View Comment Section\n3. Back to HomePage",
																	"Post's DataPage",
																	JOptionPane.QUESTION_MESSAGE))) {
																// View Like Section
																case 1:
																	boolean isInLikeSection = true;
																	while (isInLikeSection)
																		switch (Integer.parseInt(
																				JOptionPane.showInputDialog(null,
																						"Which Task You'd Like to Perform in Like Section?\n1. Like Post\n2. DisLike Post\n3. View Likers's List\n4. Back to \"Post's DataPage\"",
																						"Like Section",
																						JOptionPane.QUESTION_MESSAGE))) {
																			// Like Post
																			case 1:
																				currentUser
																						.likePost(chosenHomePagePost);
																				continue;

																			// DisLike Post
																			case 2:
																				currentUser.disLikePost(
																						chosenHomePagePost);
																				continue;

																			// View Likers's List
																			case 3:
																				JOptionPane.showMessageDialog(null,
																						chosenHomePagePost
																								.getLikerUsersString(),
																						"Like Section",
																						JOptionPane.INFORMATION_MESSAGE);
																				continue;

																			// Back to Post's DataPage
																			case 4:
																				isInLikeSection = false;
																				break;

																			default:
																				JOptionPane.showMessageDialog(null,
																						"Invalid Input.\nMust be an Integer Between 1 & .",
																						"Like Section",
																						JOptionPane.ERROR_MESSAGE);
																				continue;
																		}
																	continue;

																// View Comment Section
																case 2:
																	boolean isInCommentSection = true;
																	while (isInCommentSection)
																		switch (Integer.parseInt(
																				JOptionPane.showInputDialog(null,
																						chosenHomePagePost
																								.getCommentsString() +
																								"\n\nWhich Task You'd Like to Perform in Comment Section?\n1. View Comments's DataPage\n2. Add New Comment\n3. Back to Back to \"View Post's DataPage\"",
																						"Comment Section",
																						JOptionPane.QUESTION_MESSAGE))) {
																			// View Comments's DataPage
																			case 1:
																				int chosenCommentIndex = Integer
																						.parseInt(
																								JOptionPane
																										.showInputDialog(
																												null,
																												chosenHomePagePost
																														.getCommentsString()
																														+ "\n\nPlease Choose A Comment's Index:",
																												"Comments's DataPage",
																												JOptionPane.QUESTION_MESSAGE))
																						- 1;

																				if (chosenCommentIndex >= 0
																						&& chosenCommentIndex < chosenHomePagePost
																								.getCountComments()) {
																					Comment chosenComment = chosenHomePagePost
																							.getCommentsArrayList()
																							.get(chosenCommentIndex);

																					boolean isInViewingCommentSection = true;
																					while (isInViewingCommentSection)
																						switch (Integer
																								.parseInt(JOptionPane
																										.showInputDialog(
																												null,
																												chosenComment
																														.getCommentInfo()
																														+ "\n\nWhat Do You Want to Do With This Comment?\n1. Like Comment\n2. DisLike Comment\n3. View ReplyPage\n4. Reply to Comment\n5. Back to Comment Section",
																												"Comments's DataPage",
																												JOptionPane.QUESTION_MESSAGE))) {
																							// Like Comment
																							case 1:
																								currentUser.likeComment(
																										chosenComment);
																								continue;

																							// DisLike Comment
																							case 2:
																								currentUser
																										.disLikeComment(
																												chosenComment);
																								continue;

																							// View ReplyPage
																							case 3:
																								JOptionPane
																										.showMessageDialog(
																												null,
																												chosenComment
																														.getAllRepliesString(),
																												"View ReplyPage",
																												JOptionPane.INFORMATION_MESSAGE);
																								continue;

																							// Reply to Comment
																							case 4:
																								currentUser
																										.replyComment(
																												chosenComment);
																								continue;

																							// Back to Comment Section
																							case 5:
																								isInViewingCommentSection = false;
																								break;

																							default:
																								JOptionPane
																										.showMessageDialog(
																												null,
																												"Invalid Input.\nMust be an Integer Between 1 & .",
																												"Comments's DataPage",
																												JOptionPane.ERROR_MESSAGE);
																								continue;
																						}
																				} else
																					JOptionPane.showMessageDialog(null,
																							"Invalid Input.\nInput Must Be an Integer Between 1 & "
																									+ chosenHomePagePost
																											.getCountComments(),
																							"Comments's DataPage",
																							JOptionPane.ERROR_MESSAGE);
																				continue;

																			// Add New Comment
																			case 2:
																				currentUser.comment(
																						chosenHomePagePost);
																				continue;

																			// Back to "Post's DataPage"
																			case 3:
																				isInCommentSection = false;
																				break;

																			default:
																				JOptionPane.showMessageDialog(null,
																						"Invalid Input.\nMust be an Integer Between 1 & .",
																						"Comment Section",
																						JOptionPane.ERROR_MESSAGE);
																				continue;
																		}
																	continue;

																// Back to HomePage
																case 3:
																	isViewingPostsDetail = false;
																	break;

																default:
																	JOptionPane.showMessageDialog(null,
																			"Invalid Input.\nMust be an Integer Between 1 & .",
																			"View Post's DataPage",
																			JOptionPane.ERROR_MESSAGE);
																	continue;
															}
													} else
														JOptionPane.showMessageDialog(null,
																"Invalid Input.\nInput Must Be an Integer Between 1 & "
																		+ currentUser.getHomePagePostsArrayList().size()
																		+ "\n\n\"View Post's DataPage\"'s Operation Failed!",
																"View Post's DataPage", JOptionPane.ERROR_MESSAGE);
													continue;

												// Back to Control Panel
												case 3:
													isInHomePage = false;
													break;

												default:
													JOptionPane.showMessageDialog(null,
															"Invalid Input.\nMust be an Integer Between 1 & .",
															"HomePage",
															JOptionPane.ERROR_MESSAGE);
													continue;
											}
									}
									continue;

								// UserPage
								case 2:
									Boolean isInUserPage = true;
									while (isInUserPage)
										switch (Integer.parseInt(
												JOptionPane.showInputDialog(null,
														"Which Task You'd Like to Perform?\n1. View Profile\n2. Edit Profile\n3. Check Follower Requests\n4. Back to Control Panel",
														"UserPage",
														JOptionPane.QUESTION_MESSAGE))) {
											// View Profile
											case 1:
												JOptionPane.showMessageDialog(null, currentUser.getProfileString(),
														"UserPage",
														JOptionPane.INFORMATION_MESSAGE);
												continue;

											// Edit Profile
											case 2:
												currentUser.editProfile();
												continue;

											// Check Follower Requests
											case 3:
												if (currentUser.getFollowerRequestedUsersArrayList().isEmpty())
													JOptionPane.showMessageDialog(null,
															"You've No Follower Requests Currently.",
															"Check Follower Requests",
															JOptionPane.INFORMATION_MESSAGE);
												else {
													boolean isInCheckFollowerRequestsPage = true;
													while (isInCheckFollowerRequestsPage)
														switch (Integer.parseInt(JOptionPane.showInputDialog(null,
																currentUser
																		.getFollowerRequestedUsersString()
																		+ "\nWhat Do You Want to Do?\n1. Accept a Request\n2. Reject a Request\n3. Back to User page",
																"Check Follower Requests",
																JOptionPane.QUESTION_MESSAGE))) {
															// Accept a Request
															case 1:
																String followerRequestedUsername = JOptionPane
																		.showInputDialog(
																				null,
																				"Please Enter the Username of the Follower-Requested User:",
																				"Accept a Request",
																				JOptionPane.QUESTION_MESSAGE);
																if (DataBase
																		.isTakenUsername(followerRequestedUsername)) {
																	User followerRequestedUser = DataBase
																			.getUser(followerRequestedUsername);
																	currentUser.AcceptFollowerRequestedUser(
																			followerRequestedUser);
																} else
																	JOptionPane.showMessageDialog(null,
																			"Invalid Username.\nEntered Username Is NOT Available in User's Database.",
																			"Accept a Request",
																			JOptionPane.ERROR_MESSAGE);
																continue;

															// Reject a Request
															case 2:
																followerRequestedUsername = JOptionPane
																		.showInputDialog(
																				null,
																				"Please Enter the Username of the Follower-Requested User:",
																				"Reject a Request",
																				JOptionPane.QUESTION_MESSAGE);

																if (DataBase
																		.isTakenUsername(followerRequestedUsername)) {
																	User followerRequestedUser = DataBase
																			.getUser(followerRequestedUsername);
																	currentUser.RejectFollowerRequestedUser(
																			followerRequestedUser);
																} else
																	JOptionPane.showMessageDialog(null,
																			"Invalid Username.\nEntered Username Is NOT Available in User's Database.",
																			"Reject a Request",
																			JOptionPane.ERROR_MESSAGE);
																continue;

															// Back to User page
															case 3:
																isInCheckFollowerRequestsPage = false;
																break;

															// Others
															default:
																JOptionPane.showMessageDialog(null,
																		"Invalid Input.\nMust be an Integer Between 1 & .",
																		"Check Follower Requests",
																		JOptionPane.ERROR_MESSAGE);
																continue;
														}
												}
												continue;

											// Back to Control Panel
											case 4:
												isInUserPage = false;
												break;

											// Others
											default:
												JOptionPane.showMessageDialog(null,
														"Invalid Input.\nMust be an Integer Between 1 & .",
														"UserPage",
														JOptionPane.ERROR_MESSAGE);
												continue;
										}
									continue;

								// PostPage
								case 3:
									boolean isInPostPage = true;
									while (isInPostPage) {
										switch (Integer.parseInt(
												JOptionPane.showInputDialog(null,
														"What Do You Want to Do?\n1. View All Posts\n2. Add New Post\n3. Delete Post\n4. Back to Control Panel",
														"PostPage",
														JOptionPane.QUESTION_MESSAGE))) {
											// View All Posts
											case 1:
												if (currentUser.getCountPosts() == 0)
													JOptionPane.showMessageDialog(null,
															"No Posts Found.\nYou've Never Added a Post.",
															"View All Posts",
															JOptionPane.ERROR_MESSAGE);
												else
													JOptionPane.showMessageDialog(null,
															"All Available Posts:\n" + currentUser.getAllPostsString(),
															"View All Posts",
															JOptionPane.INFORMATION_MESSAGE);
												continue;

											// Add New Post
											case 2:
												currentUser.addNewPost(currentUser);
												continue;

											// Delete Post
											case 3:
												currentUser.deletePost();
												continue;

											// Back to Control Panel
											case 4:
												isInPostPage = false;
												break;

											default:
												JOptionPane.showMessageDialog(null,
														"Invalid Input.\nMust be an Integer Between 1 & .",
														"PostPage",
														JOptionPane.ERROR_MESSAGE);
												continue;
										}
									}
									continue;

								// MessagePage
								case 4:
									boolean isInMessagePage = true;
									while (isInMessagePage)
										switch (Integer.parseInt(
												JOptionPane.showInputDialog(null,
														"Please Choose a page?\n1. Group Page\n2. Private Chats\n3. Back to Control Panel",
														"MessagePage",
														JOptionPane.QUESTION_MESSAGE))) {
											// Group Page
											case 1:
												Boolean isInGroupPage = true;
												while (isInGroupPage)
													switch (Integer.parseInt(
															JOptionPane.showInputDialog(null,
																	"Which Task you'd Like to perform?\n1. Join a Group\n2. Open a Group\n3. Create New Group\n4. Back to Control Panel",
																	"MessagePage",
																	JOptionPane.QUESTION_MESSAGE))) {
														// Join a Group
														case 1:
															currentUser.joinGroup();
															continue;

														// Open a Group
														case 2:
															if (currentUser.getGroupsArrayList().isEmpty())
																JOptionPane.showMessageDialog(null,
																		"You've No Groups Available.",
																		"Open a Group",
																		JOptionPane.ERROR_MESSAGE);
															else {
																boolean isOpeningGroup = true;
																while (isOpeningGroup) {
																	int chosenGroupNumber = Integer.parseInt(
																			JOptionPane.showInputDialog(null,
																					currentUser.getAllGroupsString()
																							+ "\nPlease Enter Your Chosen Group's Number:",
																					"Open a Group",
																					JOptionPane.QUESTION_MESSAGE));

																	if (chosenGroupNumber > 0
																			&& chosenGroupNumber <= currentUser
																					.getCountGroups()) {
																		Group currentGroup = DataBase
																				.getGroup(chosenGroupNumber);

																		boolean isViewingGroup = true;
																		while (isViewingGroup)
																			switch (Integer.parseInt(
																					JOptionPane.showInputDialog(
																							null,
																							"What Do You Want to Do With This Group?\n1. View ChatPage\n2. Add New Message to Chat\n3. View RequestPage\n4. View Group's Info\n5. Add New Member\n6. Add New Admin\n7. Back to MessagePage",
																							"GroupPage",
																							JOptionPane.QUESTION_MESSAGE))) {
																				// View ChatPage
																				case 1:
																					if (currentGroup
																							.getChatCommentsArrayList()
																							.isEmpty())
																						JOptionPane.showMessageDialog(
																								null,
																								"No Chat Was Found.\nChatBox Is Currently Empty.",
																								"ChatPage",
																								JOptionPane.INFORMATION_MESSAGE);
																					else {
																						boolean isViewingChatPage = true;
																						while (isViewingChatPage)
																							switch (Integer.parseInt(
																									JOptionPane
																											.showInputDialog(
																													null,
																													currentGroup
																															.getAllChatsString()
																															+ "\n\nWhat Do You Want to Do?\n1. View Chat's Details\n2. Back to GroupPage",
																													"ChatPage",
																													JOptionPane.QUESTION_MESSAGE))) {
																								// View Chat's Details
																								case 1:
																									int chosenChatIndex = Integer
																											.parseInt(
																													JOptionPane
																															.showInputDialog(
																																	null,
																																	currentGroup
																																			.getAllChatsString()
																																			+ "\n\nPlease Enter Wanted Chat's Number:",
																																	"ChatPage",
																																	JOptionPane.QUESTION_MESSAGE))
																											- 1;

																									if (chosenChatIndex >= 0
																											& chosenChatIndex < currentGroup
																													.getCountChats()) {
																										Comment chosenChat = currentGroup
																												.getChatCommentsArrayList()
																												.get(chosenChatIndex);

																										boolean isViewingChatPageDetails = true;
																										while (isViewingChatPageDetails)
																											switch (Integer
																													.parseInt(
																															JOptionPane
																																	.showInputDialog(
																																			null,
																																			chosenChat
																																					.getCommentString()
																																					+ "\n\nWhich Task You'd Like to Perform?\n1. Like Chat\n2. DisLike Chat\n3. Delete Chat\n4. Reply Chat\n5. Forward Chat\n6. View All Replies\n7. Back to Last Page",
																																			"ChatPage",
																																			JOptionPane.QUESTION_MESSAGE))) {
																												// Like
																												// Chat
																												case 1:
																													currentUser
																															.likeChat(
																																	chosenChat);
																													continue;

																												// DisLike
																												// Chat
																												case 2:
																													currentUser
																															.DisLikeChat(
																																	chosenChat);
																													continue;

																												// Delete
																												// Chat
																												case 3:
																													currentUser
																															.deleteChat(
																																	currentGroup,
																																	chosenChat);
																													continue;

																												// Reply
																												// Chat
																												case 4:
																													currentUser
																															.replyChat(
																																	chosenChat);
																													continue;

																												// Forward
																												// Chat
																												case 5:
																													currentUser
																															.forwardChat(
																																	chosenChat);
																													continue;

																												// View
																												// All
																												// Replies
																												case 6:
																													JOptionPane
																															.showMessageDialog(
																																	null,
																																	chosenChat
																																			.getAllRepliesString(),
																																	"ReplyPage",
																																	JOptionPane.INFORMATION_MESSAGE);
																													continue;

																												// Back
																												// to
																												// Last
																												// Page
																												case 7:
																													isViewingChatPageDetails = false;
																													break;

																												default:
																													JOptionPane
																															.showMessageDialog(
																																	null,
																																	"Invalid Input.\nMust be an Integer Between 1 & .",
																																	"ChatPage",
																																	JOptionPane.ERROR_MESSAGE);
																													continue;
																											}
																									} else
																										JOptionPane
																												.showMessageDialog(
																														null,
																														"Invalid Input.\nInput Must Be an Integer Between 1 & "
																																+ currentGroup
																																		.getCountChats()
																																+ ".",
																														"ChatPage",
																														JOptionPane.ERROR_MESSAGE);
																									continue;

																								// Back to GroupPage
																								case 2:
																									isViewingChatPage = false;
																									break;

																								default:
																									JOptionPane
																											.showMessageDialog(
																													null,
																													"Invalid Input.\nMust be an Integer Between 1 & .",
																													"ChatPage",
																													JOptionPane.ERROR_MESSAGE);
																									continue;
																							}

																					}
																					continue;

																				// Add New Message to Chat
																				case 2:
																					currentUser.SendMessage(
																							currentGroup);
																					continue;

																				// View RequestPage
																				case 3:
																					if (currentUser
																							.isAdmin(currentGroup))
																						if (currentGroup
																								.getRequestedUsersArrayList()
																								.isEmpty())
																							JOptionPane
																									.showMessageDialog(
																											null,
																											"No Requests Was Found.",
																											"RequestPage",
																											JOptionPane.INFORMATION_MESSAGE);
																						else {
																							int chosenRequestedUserIndex = Integer
																									.parseInt(
																											JOptionPane
																													.showInputDialog(
																															null,
																															"Please Choose an Requested User:\n"
																																	+ currentGroup
																																			.getAllRequestedUserString(),
																															"RequestPage",
																															JOptionPane.QUESTION_MESSAGE))
																									- 1;

																							if (chosenRequestedUserIndex >= 0
																									&& chosenRequestedUserIndex < currentGroup
																											.getCountRequestedUsers()) {
																								User requestedUser = currentGroup
																										.getRequestedUsersArrayList()
																										.get(chosenRequestedUserIndex);

																								boolean isInRequestPage = true;
																								while (isInRequestPage)

																									switch (Integer
																											.parseInt(
																													JOptionPane
																															.showInputDialog(
																																	null,
																																	"What Do You Want to Do With "
																																			+ requestedUser
																																					.getFullName()
																																			+ "("
																																			+ requestedUser
																																					.getUsername()
																																			+ ")'s Request?\n1. Accept & Add to Members\n2. Accept & Add to Admins\n3. Reject\n4. Back to GroupPage",
																																	"RequestPage",
																																	JOptionPane.QUESTION_MESSAGE))) {
																										// Accept & Add
																										// to Members
																										case 1:
																											currentUser
																													.addToMembersGroup(
																															requestedUser,
																															currentGroup);
																											continue;

																										// Accept & Add
																										// to Admins
																										case 2:
																											currentUser
																													.addToAdminsGroup(
																															requestedUser,
																															currentGroup);
																											continue;

																										// Reject
																										case 3:
																											currentGroup
																													.getRequestedUsersArrayList()
																													.remove(requestedUser);
																											continue;

																										// Back to
																										// GroupPage
																										case 4:
																											isInRequestPage = false;
																											break;

																										default:
																											JOptionPane
																													.showMessageDialog(
																															null,
																															"Invalid Input.\nMust be an Integer Between 1 & .",
																															"RequestPage",
																															JOptionPane.ERROR_MESSAGE);
																											continue;
																									}
																							} else
																								JOptionPane
																										.showMessageDialog(
																												null,
																												"Invalid Input.\nInput Must Be an Integer Between 1 & "
																														+ currentGroup
																																.getCountRequestedUsers()
																														+ ".",
																												"RequestPage",
																												JOptionPane.ERROR_MESSAGE);
																						}
																					else
																						JOptionPane.showMessageDialog(
																								null,
																								"You'e Not an Admin in This Groups.",
																								"RequestPage",
																								JOptionPane.ERROR_MESSAGE);
																					continue;

																				// View Group's Info
																				case 4:
																					JOptionPane.showMessageDialog(null,
																							"Group's Information:\n"
																									+ currentGroup
																											.getGroupString(),
																							"GroupPage",
																							JOptionPane.INFORMATION_MESSAGE);
																					continue;

																				// Add New Member
																				case 5:
																					currentUser.addToMembersGroup(
																							currentGroup);
																					continue;

																				// Add New Admin
																				case 6:
																					currentUser.addToAdminsGroup(
																							currentGroup);
																					continue;

																				// Back to MessagePage
																				case 7:
																					isViewingGroup = false;
																					break;

																				default:
																					JOptionPane.showMessageDialog(null,
																							"Invalid Input.\nMust be an Integer Between 1 & .",
																							"GroupPage",
																							JOptionPane.ERROR_MESSAGE);
																					continue;
																			}
																	} else {
																		JOptionPane.showMessageDialog(null,
																				"Invalid Input.\nInput Must Be an Integer Between 1 & "
																						+ currentUser.getCountGroups()
																						+ ".",
																				"Open a Group",
																				JOptionPane.ERROR_MESSAGE);
																		break;
																	}
																}
															}
															continue;

														// Create New Group
														case 3:
															currentUser.createNewGroup();
															continue;

														// Back to Control Panel
														case 4:
															isInGroupPage = false;
															break;

														default:
															JOptionPane.showMessageDialog(null,
																	"Invalid Input.\nMust be an Integer Between 1 & .",
																	"MessagePage",
																	JOptionPane.ERROR_MESSAGE);
															continue;
													}
												continue;

											// Private Chats
											case 2:
												boolean isInPrivateChats = true;
												while (isInPrivateChats)
													switch (Integer.parseInt(JOptionPane.showInputDialog(null,
															"Please Choose a Method?\n1. Start New Private Chat\n2. Open a Private Chat\n3. Back to Last Page",
															"Private Chats", JOptionPane.QUESTION_MESSAGE))) {
														// Start New Private Chat
														case 1:
															currentUser.startNewPrivateChat();
															continue;

														// Open a Private Chat
														case 2:
															if (currentUser.getPrivateChatsArrayList().isEmpty())
																JOptionPane.showMessageDialog(null,
																		"You Have No Private Chats Available.",
																		"Open a Private Chat",
																		JOptionPane.ERROR_MESSAGE);
															else {
																int chosenPrivateChatIndex = Integer
																		.parseInt(JOptionPane.showInputDialog(
																				null,
																				currentUser.getAllPrivateChatsString()
																						+ "\nPlease Choose a private Chat's Number:",
																				"Open a Private Chat",
																				JOptionPane.QUESTION_MESSAGE))
																		- 1;

																if (chosenPrivateChatIndex >= 0
																		&& chosenPrivateChatIndex < currentUser
																				.getCountPrivateChats()) {
																	PrivateChat chosenPrivateChat = currentUser
																			.getPrivateChatsArrayList()
																			.get(chosenPrivateChatIndex);

																	boolean isOpeningPrivateChat = true;
																	while (isOpeningPrivateChat)
																		switch (Integer
																				.parseInt(JOptionPane.showInputDialog(
																						null,
																						"Please Choose a Method?\n1. Send Message\n2. View Message's Details\n3. Back to Last Page",
																						"Open a Private Chat",
																						JOptionPane.QUESTION_MESSAGE))) {
																			// Send Message
																			case 1:
																				currentUser.SendMessage(
																						chosenPrivateChat);
																				continue;

																			// View Message's Details
																			case 2:
																				if (chosenPrivateChat
																						.getChatCommentsArrayList()
																						.isEmpty())
																					JOptionPane.showMessageDialog(null,
																							"No Message Was Found In This Private Chat.",
																							"View Chat's Details",
																							JOptionPane.ERROR_MESSAGE);
																				else {
																					int chosenMessageIndex = Integer
																							.parseInt(
																									JOptionPane
																											.showInputDialog(
																													null,
																													chosenPrivateChat
																															.getPrivateChatMessagesString()
																															+ "\nPlease Enter Message's Number:",
																													"View Chat's Details",
																													JOptionPane.QUESTION_MESSAGE))
																							- 1;

																					if (chosenMessageIndex >= 0
																							&& chosenMessageIndex < chosenPrivateChat
																									.getCountMessages()) {
																						Comment chosenMessage = chosenPrivateChat
																								.getChatCommentsArrayList()
																								.get(chosenMessageIndex);

																						boolean isViewingChatPageDetails = true;
																						while (isViewingChatPageDetails)
																							switch (Integer
																									.parseInt(
																											JOptionPane
																													.showInputDialog(
																															null,
																															chosenMessage
																																	.getCommentInfo()
																																	+ "\n\nWhat Do You Want to Do With This Message?\n1. Like\n2. DisLike\n3. Reply\n4. Forward\n5. View Replies\n6. Back to Last Page",
																															"View Chat's Details",
																															JOptionPane.QUESTION_MESSAGE))) {
																								// Like
																								case 1:
																									currentUser
																											.likeChat(
																													chosenMessage);
																									continue;

																								// DisLike
																								case 2:
																									currentUser
																											.DisLikeChat(
																													chosenMessage);
																									continue;

																								// Reply
																								case 3:
																									currentUser
																											.replyChat(
																													chosenMessage);
																									continue;

																								// Forward
																								case 4:
																									currentUser
																											.forwardChat(
																													chosenMessage);
																									continue;

																								// View Replies
																								case 5:
																									JOptionPane
																											.showMessageDialog(
																													null,
																													chosenMessage
																															.getAllRepliesString(),
																													"View Replies",
																													JOptionPane.INFORMATION_MESSAGE);
																									continue;

																								// Back to Last Page
																								case 6:
																									isViewingChatPageDetails = false;
																									break;

																								default:
																									JOptionPane
																											.showMessageDialog(
																													null,
																													"Invalid Input.\nMust be an Integer Between 1 & .",
																													"View Chat's Details",
																													JOptionPane.ERROR_MESSAGE);
																									continue;
																							}
																					} else
																						JOptionPane.showMessageDialog(
																								null,
																								"Invalid Input.\nInput Must Be an Integer Between 1 & "
																										+ chosenPrivateChat
																												.getCountMessages()
																										+ ".",
																								"View Chat's Details",
																								JOptionPane.ERROR_MESSAGE);

																				}
																				continue;

																			// Back to Last Page
																			case 3:
																				isOpeningPrivateChat = false;
																				break;

																			default:
																				JOptionPane.showMessageDialog(null,
																						"Invalid Input.\nMust be an Integer Between 1 & .",
																						"Open a Private Chat",
																						JOptionPane.ERROR_MESSAGE);
																				continue;
																		}
																} else
																	JOptionPane.showConfirmDialog(null,
																			"Invalid Input.\nInput Must Be an Integer Between 1 & "
																					+ currentUser.getCountPrivateChats()
																					+ ".",
																			"Open a Private Chat",
																			JOptionPane.ERROR_MESSAGE);
															}
															continue;

														// Back to Last Page
														case 3:
															isInPrivateChats = false;
															break;

														default:
															JOptionPane.showMessageDialog(null,
																	"Invalid Input.\nMust be an Integer Between 1 & .",
																	"MessagePage",
																	JOptionPane.ERROR_MESSAGE);
															continue;
													}
												continue;

											// Back to Control Panel
											case 3:
												isInMessagePage = false;
												break;

											default:
												JOptionPane.showMessageDialog(null,
														"Invalid Input.\nMust be an Integer Between 1 & .",
														"MessagePage",
														JOptionPane.ERROR_MESSAGE);
												continue;
										}
									continue;

								// SearchPage
								case 5:
									searchUsername = JOptionPane.showInputDialog(null,
											"Please Enter the Username You'd Like to Search:",
											"SearchPage",
											JOptionPane.QUESTION_MESSAGE).toLowerCase();

									if (DataBase.isTakenUsername(searchUsername)) {
										User searchUser = DataBase.getUser(searchUsername);

										if (searchUser.equals(currentUser)) {
											JOptionPane.showMessageDialog(null,
													"You've Entered Your Own Username.\nTo View Your Account's Data Use Other Options in Control Panel.",
													"SearchPage",
													JOptionPane.ERROR_MESSAGE);
											continue;
										} else {
											JOptionPane.showMessageDialog(null,
													searchUser.getFullName()
															+ "'s Page Was Found Successfully.",
													"SearchPage",
													JOptionPane.INFORMATION_MESSAGE);

											Boolean isInSearchPage = true;
											while (isInSearchPage)
												switch (Integer.parseInt(JOptionPane.showInputDialog(null,
														"What Do You Want to Do With This Account?\n1. Follow\n2. UnFollow\n3. Block\n4. UnBlock\n5. View Searched User's Profile\n6. View Searched User's PostPage\n7. Back to Control Panel",
														"SearchPage", JOptionPane.QUESTION_MESSAGE))) {
													// Follow
													case 1:
														currentUser.followUser(searchUser);
														continue;

													// UnFollow
													case 2:
														currentUser.unFollowUser(searchUser);
														continue;

													// Block
													case 3:
														currentUser.blockUser(searchUser);
														continue;

													// UnBlock
													case 4:
														currentUser.unblockUser(searchUser);
														continue;

													// View Searched User's UserPage
													case 5:
														JOptionPane.showMessageDialog(null,
																searchUser.getProfileString(),
																"View Searched User's UserPage",
																JOptionPane.INFORMATION_MESSAGE);
														continue;

													// View Searched User's PostPage
													case 6:
														if (searchUser.getPagePrivacyMode()
																.equals(PagePrivacyMode.PRIVATE)
																&& !searchUser.getFollowerUsersArrayList()
																		.contains(currentUser))
															JOptionPane.showMessageDialog(null,
																	"Searched User's Page is Private.\nTo View His/Her Posts You Must Follow First.",
																	"View Searched User's PostPage",
																	JOptionPane.ERROR_MESSAGE);
														else {
															if (searchUser.getPostsArrayList().isEmpty())
																JOptionPane.showMessageDialog(null,
																		searchUser.getFullName()
																				+ "'s PostPage is Currently Empty.\nWait For He/She To Add New Posts.",
																		"View Searched User's PostPage",
																		JOptionPane.INFORMATION_MESSAGE);
															else {
																boolean isViewingSearchedUsersPostPage = true;
																while (isViewingSearchedUsersPostPage)
																	switch (Integer.parseInt(
																			JOptionPane.showInputDialog(null, searchUser
																					.getAllPostsString()
																					+ "\nWhat Do You Want to Do?\n1. Show Like-Count-Sorted Posts\n2. View Post's DataPage\n3. Back to Last Page",
																					"View Searched User's PostPage",
																					JOptionPane.QUESTION_MESSAGE))) {
																		// Show Like-Count-Sorted Posts
																		case 1:
																			searchUser.showSortedPosts(
																					searchUser.getPostsArrayList());
																			continue;

																		// View Post's DataPage
																		case 2:
																			int chosenPostIndex = Integer
																					.parseInt(JOptionPane
																							.showInputDialog(null,
																									searchUser
																											.getAllPostsString()
																											+ "\nPlease Enter a Post's Number to View It's Detail:",
																									"Post's DataPage",
																									JOptionPane.QUESTION_MESSAGE))
																					- 1;

																			if (chosenPostIndex >= 0
																					&& chosenPostIndex < searchUser
																							.getCountPosts()) {
																				Post chosenPost = searchUser
																						.getPostsArrayList()
																						.get(chosenPostIndex);

																				Boolean isViewingPostsDetail = true;
																				while (isViewingPostsDetail)
																					switch (Integer.parseInt(JOptionPane
																							.showInputDialog(null,
																									"Chosen Post:\n"
																											+ chosenPost
																													.getPostString()
																											+ "\n\nWhat Do You Want to Do?\n1. View Like Section\n2. View Comment Section\n3. Back to HomePage",
																									"Post's DataPage",
																									JOptionPane.QUESTION_MESSAGE))) {
																						// View Like Section
																						case 1:
																							boolean isInLikeSection = true;
																							while (isInLikeSection)
																								switch (Integer
																										.parseInt(
																												JOptionPane
																														.showInputDialog(
																																null,
																																"Which Task You'd Like to Perform in Like Section?\n1. Like Post\n2. DisLike Post\n3. View Likers's List\n4. Back to \"Post's DataPage\"",
																																"Like Section",
																																JOptionPane.QUESTION_MESSAGE))) {
																									// Like Post
																									case 1:
																										currentUser
																												.likePost(
																														chosenPost);
																										continue;

																									// DisLike Post
																									case 2:
																										currentUser
																												.disLikePost(
																														chosenPost);
																										continue;

																									// View Likers's
																									// List
																									case 3:
																										JOptionPane
																												.showMessageDialog(
																														null,
																														chosenPost
																																.getLikerUsersString(),
																														"Like Section",
																														JOptionPane.INFORMATION_MESSAGE);
																										continue;

																									// Back to Post's
																									// DataPage
																									case 4:
																										isInLikeSection = false;
																										break;

																									default:
																										JOptionPane
																												.showMessageDialog(
																														null,
																														"Invalid Input.\nMust be an Integer Between 1 & .",
																														"Like Section",
																														JOptionPane.ERROR_MESSAGE);
																										continue;
																								}
																							continue;

																						// View Comment Section
																						case 2:
																							boolean isInCommentSection = true;
																							while (isInCommentSection)
																								switch (Integer
																										.parseInt(
																												JOptionPane
																														.showInputDialog(
																																null,
																																chosenPost
																																		.getCommentsString()
																																		+
																																		"\n\nWhich Task You'd Like to Perform in Comment Section?\n1. View Comments's DataPage\n2. Add New Comment\n3. Back to Back to \"View Post's DataPage\"",
																																"Comment Section",
																																JOptionPane.QUESTION_MESSAGE))) {
																									// View Comments's
																									// DataPage
																									case 1:
																										int chosenCommentIndex = Integer
																												.parseInt(
																														JOptionPane
																																.showInputDialog(
																																		null,
																																		chosenPost
																																				.getCommentsString()
																																				+ "\n\nPlease Choose A Comment's Index:",
																																		"Comments's DataPage",
																																		JOptionPane.QUESTION_MESSAGE))
																												- 1;

																										if (chosenCommentIndex >= 0
																												&& chosenCommentIndex < chosenPost
																														.getCountComments()) {
																											Comment chosenComment = chosenPost
																													.getCommentsArrayList()
																													.get(chosenCommentIndex);

																											boolean isInViewingCommentSection = true;
																											while (isInViewingCommentSection)
																												switch (Integer
																														.parseInt(
																																JOptionPane
																																		.showInputDialog(
																																				null,
																																				chosenComment
																																						.getCommentInfo()
																																						+ "\n\nWhat Do You Want to Do With This Comment?\n1. Like Comment\n2. DisLike Comment\n3. View ReplyPage\n4. Reply to Comment\n5. Back to Comment Section",
																																				"Comments's DataPage",
																																				JOptionPane.QUESTION_MESSAGE))) {
																													// Like
																													// Comment
																													case 1:
																														currentUser
																																.likeComment(
																																		chosenComment);
																														continue;

																													// DisLike
																													// Comment
																													case 2:
																														currentUser
																																.disLikeComment(
																																		chosenComment);
																														continue;

																													// View
																													// ReplyPage
																													case 3:
																														JOptionPane
																																.showMessageDialog(
																																		null,
																																		chosenComment
																																				.getAllRepliesString(),
																																		"View ReplyPage",
																																		JOptionPane.INFORMATION_MESSAGE);
																														continue;

																													// Reply
																													// to
																													// Comment
																													case 4:
																														currentUser
																																.replyComment(
																																		chosenComment);
																														continue;

																													// Back
																													// to
																													// Comment
																													// Section
																													case 5:
																														isInViewingCommentSection = false;
																														break;

																													default:
																														JOptionPane
																																.showMessageDialog(
																																		null,
																																		"Invalid Input.\nMust be an Integer Between 1 & .",
																																		"Comments's DataPage",
																																		JOptionPane.ERROR_MESSAGE);
																														continue;
																												}
																										} else
																											JOptionPane
																													.showMessageDialog(
																															null,
																															"Invalid Input.\nInput Must Be an Integer Between 1 & "
																																	+ chosenPost
																																			.getCountComments(),
																															"Comments's DataPage",
																															JOptionPane.ERROR_MESSAGE);
																										continue;

																									// Add New Comment
																									case 2:
																										currentUser
																												.comment(
																														chosenPost);
																										continue;

																									// Back to "Post's
																									// DataPage"
																									case 3:
																										isInCommentSection = false;
																										break;

																									default:
																										JOptionPane
																												.showMessageDialog(
																														null,
																														"Invalid Input.\nMust be an Integer Between 1 & .",
																														"Comment Section",
																														JOptionPane.ERROR_MESSAGE);
																										continue;
																								}
																							continue;

																						// Back to HomePage
																						case 3:
																							isViewingPostsDetail = false;
																							break;

																						default:
																							JOptionPane
																									.showMessageDialog(
																											null,
																											"Invalid Input.\nMust be an Integer Between 1 & .",
																											"View Post's DataPage",
																											JOptionPane.ERROR_MESSAGE);
																							continue;
																					}
																			} else
																				JOptionPane.showMessageDialog(null,
																						"Invalid Input.\nInput Must Be an Integer Between 1 & "
																								+ currentUser
																										.getHomePagePostsArrayList()
																										.size()
																								+ "\n\n\"View Post's DataPage\"'s Operation Failed!",
																						"View Post's DataPage",
																						JOptionPane.ERROR_MESSAGE);
																			continue;

																		// Back to Last page
																		case 3:
																			isViewingSearchedUsersPostPage = false;
																			break;

																		default:
																			JOptionPane.showMessageDialog(null,
																					"Invalid Input.\nMust be an Integer Between 1 & .",
																					"HomePage",
																					JOptionPane.ERROR_MESSAGE);
																			continue;
																	}
															}
														}
														continue;

													// Back to Control Panel
													case 7:
														isInSearchPage = false;
														break;

													// Others
													default:
														JOptionPane.showMessageDialog(null,
																"Invalid Input.\nMust be an Integer Between 1 & .",
																"SearchPage",
																JOptionPane.ERROR_MESSAGE);
														continue;
												}
										}
									} else
										JOptionPane.showMessageDialog(null,
												"Invalid Username.\nEntered Username Was Not Found.",
												"SearchPage", JOptionPane.ERROR_MESSAGE);
									continue;

								// Back to LogIn/SignUp Page
								case 6:
									JOptionPane.showMessageDialog(null, "Your Logged Out of Your Account.",
											"Back to LogIn/SignUp Page",
											JOptionPane.INFORMATION_MESSAGE);
									isLoggedIn = false;
									break;

								// Others
								default:
									JOptionPane.showMessageDialog(null,
											"Invalid Input.\nMust be an Integer Between 1 & 6.",
											"Choose Task",
											JOptionPane.ERROR_MESSAGE);
									continue;
							}
					}
					continue;

				// Sign-Up
				case 2:
					User.signUp();
					continue;

				// Exit
				case 3:
					isAppRunning = false;
					break;

				// Others
				default:
					JOptionPane.showMessageDialog(null, "Invalid Input.\nMust be an Integer Between 1 & 3.",
							"LogIn/SignUp Page", JOptionPane.ERROR_MESSAGE);
					continue;
			}

		JOptionPane.showMessageDialog(null,
				"Thanks for Using Pseudo-Instagram Application.\nHope You've Enjoyed.\n\nThis App Was Written & Developed by AmirHossein Roodaki.",
				"GoodBye Note", JOptionPane.INFORMATION_MESSAGE);

	}
}
