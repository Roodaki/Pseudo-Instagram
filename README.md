<div align="center">
  <h1><strong>Pseudo-Instagram</strong></h1>
  <p><strong>Pseudo-Instagram is an object-oriented programming (OOP) project implemented in Java, showcasing the development of a social media application with a graphical user interface (GUI) built using JOptionPane. Inspired by Instagram, this project aims to provide a simulated Instagram experience, allowing users to perform various actions such as creating an account, managing their profile, interacting with posts, sending messages, and more.</strong></p>
</div>

![Screenshot (475)](https://user-images.githubusercontent.com/89901590/192554890-7e7fb51a-267a-45bd-b360-52a8fa45733f.png)

![Screenshot (488)](https://user-images.githubusercontent.com/89901590/192560542-2410c297-3965-46da-921e-4e93ddcc3089.png)

![Screenshot (519)](https://user-images.githubusercontent.com/89901590/192564452-11f29ad5-c6f8-4e6b-8c0f-18d903f7ebee.png)

## Table of Contents
- [Features](#features)
  - [Welcome Page](#welcome-page)
  - [Log-In/Sign-Up Page](#log-in-and-sign-up-page)
  - [Control Panel](#control-panel)
  - [Home Page](#home-page)
  - [User Page](#user-page)
  - [Post Page](#post-page)
  - [Message Page](#message-page)
  - [Search Page](#search-page)
- [Getting Started](#getting-started)
  - [Requirements](#requirements)
  - [Installation](#installation)
  - [Usage Guide](#usage-guide)

## Features
### Welcome Page
  Displays a welcome message to the user upon launching the application.
### Log-In and Sign-Up Page
- **Sign-Up Page**: Allows users to create a new account by providing their full name, username, password, email address, and additional information such as privacy mode, and birth date.
- **Log-In Page**: Enables users to log in to their existing accounts by entering their username and password.
### Control Panel
Provides access to various features categorized into five main pages:
- **Home Page**: Allows users to view, like, and comment on posts from the accounts they follow.
- **User Page**: Allows users to view or edit their profile page, as well as check follower requests.
- **Post Page**: Enables users to view, add, and delete their own posts.
- **Message Page**: Allows users to send, like, and reply to messages in private chats or groups.
- **Search Page**: Enables users to find other user accounts and perform actions like follow, unfollow, block, or unblock.
### Home Page
- **Sort Posts Based on Number of Likes**: Allows users to sort posts in their home feed based on the number of likes.
- **View Post Details**: Provides options to interact with a post, such as liking, disliking, viewing likers, and commenting.
  - **Like Section**: Allows users to like or dislike a post and view a list of all users who liked the post.
  - **Comment Section**: Allows users to view comment details, like or dislike comments, view replies, and add new comments.
### User Page
- **View Profile**: Displays the user's profile information.
- **Edit Profile**: Allows users to modify their profile information.
- **Check Follower Requests**: Shows pending follower requests and provides options to accept or reject them.
### Post Page
- **Post New Post**: Allows users to create a new post by adding a caption.
- **Delete A Posted Post**: Enables users to delete their previously posted content.
### Message Page
- Group Page
  - **Join An Existing Group**: Allows users to join an existing group by providing the necessary group ID.
  - **Open A Joined Group**: Allows users to view all messages in a group they have joined.
    - **Add New Message**: Enables users to send a new message in the group.
    - **View Join-Requests**: Displays join requests from other users and provides options to accept and add them to members or admins, or reject the requests.
    - **View Group's Profile**: Shows the profile information of the joined group.
    - **Add New Member**: Allows users to add a new member to the group by entering their username.
    - **Add New Admin**: Enables admins to promote another group member to admin by entering their username.
- Private Chats
  - **Start New Private Chat**: Enables users to start a new private chat with another user by entering their username.
  - **Open A Private Chat**: Allows users to view and interact with messages in an existing private chat.
    - **Send Message**: Allows users to send messages in the private chat.
    - **Reply To Message**: Enables users to reply to a message in the private chat.
    - **Forward The Message**: Allows users to forward a message to another private chat.
    - **View All Replies**: Displays all replies to a specific message in the private chat.
### Search Page
- **Searching Process**: Allows users to search for another user's account by entering their username.
- **Operations**: Provides options to follow, unfollow, block, unblock, and view the profile or post page of the searched user.

## Getting Started
### Requirements
* Java Development Kit (JDK) 8 or later
* Git command line tool (or Git GUI client) to clone the repository.
### Installation
1. Open a terminal or command prompt.
2. Clone this repository: `git clone https://github.com/Roodaki/Pseudo-Instagram`
3. Navigate to the cloned repository's directory and Compile the Java classes using the following command: `javac *.java`
4. Run the program using the following command: `java PseudoInstagram`
### Usage Guide
You will be prompted to enter the number of the operation you wish to perform. Enter the number of the operation that you want to perform, based on the options presented to you.

Note: The application stores all data in memory, so if you terminate the application, all data will be lost.
