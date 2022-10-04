<h1 align="center">Pseudo-Instagram</h1>

* Pseudo-Instagram Implentation Using [Java](<https://en.wikipedia.org/wiki/Java_(programming_language)>) [OOP](https://en.wikipedia.org/wiki/Object-oriented_programming) & [JOptionPane](https://docs.oracle.com/javase/7/docs/api/javax/swing/JOptionPane.html) GUI

* [UML](https://en.wikipedia.org/wiki/Unified_Modeling_Language) - [Class Diagram](https://en.wikipedia.org/wiki/Class_diagram):

  ![UML-Class Diagram](https://user-images.githubusercontent.com/89901590/192552014-5232deaf-7f82-474b-a1bd-1b081767c015.jpeg)
<h1 align="center">Program's Features</h1>

## 1. Welcome Page
  ![Screenshot (463)](https://user-images.githubusercontent.com/89901590/192552252-d4130969-4017-46b4-b132-e3ee31d03bb4.png)
## 2. Log-In/Sign-Up Page
  ![Screenshot (464)](https://user-images.githubusercontent.com/89901590/192552631-f998f729-122c-4138-9fee-7abd9ee21a0d.png)
### 2.1. Sign-Up Page
  * Setting Full-Name, Username, Password & Email Address.
  
    ![Screenshot (465)](https://user-images.githubusercontent.com/89901590/192552763-eaac5c0b-f1ed-49aa-8f98-a355369ecc2b.png)
  
    ![Screenshot (466)](https://user-images.githubusercontent.com/89901590/192552845-8b31e541-4d09-414f-b9fb-1a22f5157a24.png)
  
    ![Screenshot (467)](https://user-images.githubusercontent.com/89901590/192552892-5c96be8f-3984-4bac-846e-494c53e55cf3.png)
    
    ![Screenshot (470)](https://user-images.githubusercontent.com/89901590/192554006-b07f41fc-dac4-4a1b-8ef4-d4d3d10d91d0.png)

  * Setting Privacy-Mode
    * Instagram Accounts Are Either Public Or Private.
    * Private Accounts Require Follow-Request. On The Other Hand, Public Accounts Can Be Followed Directly.
    
    ![Screenshot (468)](https://user-images.githubusercontent.com/89901590/192553021-6eaf59d4-2fdd-45cd-b08c-7406e9614639.png)
  * Setting BirthDate & Age
    * BirthDate & Age Are Handled Using [Java LocalDate Class](https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html) & [Java Period Class](https://docs.oracle.com/javase/8/docs/api/java/time/Period.html)
    
    ![Screenshot (469)](https://user-images.githubusercontent.com/89901590/192553856-2b84478c-ebe7-48fc-a512-c72b47a871df.png)  
  * Sign-Up Result
  
    ![Screenshot (471)](https://user-images.githubusercontent.com/89901590/192554110-a50fdb58-f3d2-45bd-b011-444684e8de38.png)
### 2.2. Log-In Page
  * Getting Username & Password.
  
    ![Screenshot (472)](https://user-images.githubusercontent.com/89901590/192554414-c2d79a13-79eb-4c9e-87c4-f363bc82e86d.png)
  
    ![Screenshot (473)](https://user-images.githubusercontent.com/89901590/192554467-0a9288d0-c107-4a40-8ceb-f9c1aea6eacb.png)
  * Log-In Result
  
    ![Screenshot (474)](https://user-images.githubusercontent.com/89901590/192554552-3f8278b2-92da-4e7b-89e8-366eba630a71.png)
## 3. Control Panel
  * All Features Are Categorized in 5 Main Pages:
    1. Home Page (To View, Like & Comment On Following Accounts' Posts.) 
    2. User Page (To View or Edit Profile Page & Check Follower-Requests.)
    3. Post Page (To View, Add & Delete Profile's Posts.)
    4. Message Page (To Send, Like & Reply To Messages On PrivateChats or Groups.)
    5. Search Page (To Find Another User's Account & Follow, UnFollow, Block, UnBlock It.)
    
    ![Screenshot (475)](https://user-images.githubusercontent.com/89901590/192554890-7e7fb51a-267a-45bd-b360-52a8fa45733f.png)
## 4. Home Page
### 4.1. Sort Posts Base On Number of Likes
  ![Screenshot (513)](https://user-images.githubusercontent.com/89901590/192562152-5c258871-b10d-4fc8-b130-54e5a4072ddb.png)
### 4.2. View Post's Details
  ![Screenshot (500)](https://user-images.githubusercontent.com/89901590/192562838-361510b5-4054-4852-8385-ae7319b711cf.png)
  
  ![Screenshot (501)](https://user-images.githubusercontent.com/89901590/192562745-26dcaa18-6840-43ae-9977-3747790635c6.png)
### 4.2.1. Like Section
  
  ![Screenshot (502)](https://user-images.githubusercontent.com/89901590/192563253-ec8decc1-42b7-4745-a469-8a9dc89a3f7c.png)
  * Like Post
  * DisLike Post
  * View List of All Likers
### 4.2.2. Comment Section
  
  ![Screenshot (563)](https://user-images.githubusercontent.com/89901590/192563392-6b4a8818-b779-4d8e-93e0-38b82a03d3e5.png)
  * View A Comment's Details

    ![Screenshot (515)](https://user-images.githubusercontent.com/89901590/192563970-5b4b9c99-24e9-4f49-97c3-bc4f60cfbd45.png)

    ![Screenshot (516)](https://user-images.githubusercontent.com/89901590/192564011-e3ada845-6c86-4a02-9711-c772772907ac.png)
    * Like Comment
    * DisLike Comment
    * View Replies
    * Reply To Comment
  * Add New Comment
    * Setting New Comment's Caption

      ![Screenshot (506)](https://user-images.githubusercontent.com/89901590/192563755-d16dbb98-f0ba-4f69-804d-b3a98af3ad18.png)
    * Result

      ![Screenshot (507)](https://user-images.githubusercontent.com/89901590/192563829-e5b171fc-5904-4190-9f27-f17c6cbbdd3c.png)
## 5. User Page
  ![Screenshot (476)](https://user-images.githubusercontent.com/89901590/192556938-41772cdc-ea4c-4d99-b4cf-6f028d078ece.png)
### 5.1. View Profile
  ![Screenshot (488)](https://user-images.githubusercontent.com/89901590/192560542-2410c297-3965-46da-921e-4e93ddcc3089.png)
### 5.2. Edit Profile
  ![Screenshot (489)](https://user-images.githubusercontent.com/89901590/192560779-58501dc9-5636-4532-8661-fa15b90b9ae9.png)
  * Setting New Value
  
    ![Screenshot (490)](https://user-images.githubusercontent.com/89901590/192560853-738c8572-8adb-4670-a6e8-2407a1e2d268.png)
  * Result
  
    ![Screenshot (491)](https://user-images.githubusercontent.com/89901590/192560903-894f708a-f5ee-4345-adb8-daa054d875ff.png)
### 5.3. Check Follower-Requests
  ![Screenshot (484)](https://user-images.githubusercontent.com/89901590/192559851-6c994eea-498a-43f1-9302-92189251f6ca.png)
  * Accept A Request
    * Getting Requested User's Username
    
      ![Screenshot (485)](https://user-images.githubusercontent.com/89901590/192560021-b6be1d8f-ede9-4c16-8321-97b200b435e9.png)
    * Result
    
      ![Screenshot (486)](https://user-images.githubusercontent.com/89901590/192560229-77d7b71c-0113-4794-b915-3c4df9914a0a.png)
  * Reject A Request
    * Getting Requested User's Username
    
      ![Screenshot (485)](https://user-images.githubusercontent.com/89901590/192560021-b6be1d8f-ede9-4c16-8321-97b200b435e9.png)
    * Result
    
      ![Screenshot (487)](https://user-images.githubusercontent.com/89901590/192560464-2b258baa-258a-4c86-a811-cb23f7ba82d3.png)
## 6. Post Page
  * This Version Of the Program Does Not Support Videos & Images.
  
  ![Screenshot (492)](https://user-images.githubusercontent.com/89901590/192561015-53da3262-df7b-46c3-b923-2c71d4d0f365.png)
### 6.1. Post New Post
  * Setting A Caption
  
    ![Screenshot (493)](https://user-images.githubusercontent.com/89901590/192561276-b7d9c8a3-01c2-4167-b8af-7df3b45af120.png)
  * Result
  
    ![Screenshot (494)](https://user-images.githubusercontent.com/89901590/192561523-94596288-b7a8-488f-af8e-35a9099c2403.png)
### 6.2. Delete A Posted Post
  * Selecting Target Post
  
    ![Screenshot (496)](https://user-images.githubusercontent.com/89901590/192561622-4593158e-0148-4f27-b3e8-3085393060ad.png)
  * Result
  
    ![Screenshot (497)](https://user-images.githubusercontent.com/89901590/192561673-93485289-6993-4664-a866-a3f4bd1e6eda.png)
## 7. Message Page
  ![Screenshot (525)](https://user-images.githubusercontent.com/89901590/192564764-fda06128-5c9c-473a-89ee-aa71f21b4d8f.png)
### 7.1. Group Page
  ![Screenshot (540)](https://user-images.githubusercontent.com/89901590/192565038-17d9e2ea-13ed-4589-9a05-8505e7a77885.png)
### 7.1.1. Join An Existing Group
  * Getting Target Group's ID

    ![Screenshot (559)](https://user-images.githubusercontent.com/89901590/192568546-dc3df0b9-75bd-4340-ac60-63cf727d6125.png)
  * Result

    ![Screenshot (560)](https://user-images.githubusercontent.com/89901590/192568619-b621a25f-ce0e-45c3-b5fa-9d97504872d4.png)
### 7.1.2. Open A Joined Group
  
  ![Screenshot (543)](https://user-images.githubusercontent.com/89901590/192567236-7d955150-5b54-453f-9523-f408f26ba4be.png)

  ![Screenshot (544)](https://user-images.githubusercontent.com/89901590/192567264-dd302ea4-894d-4625-b0f2-b2572ee13b4c.png)
  * View All Messages

    ![Screenshot (548)](https://user-images.githubusercontent.com/89901590/192567749-140e11b8-8ed0-4235-ac72-ed36d5539c76.png)
  * Add New Message
    * Setting New Message's Caption

      ![Screenshot (545)](https://user-images.githubusercontent.com/89901590/192567636-282c42e5-e680-4b03-aadc-422bdf1d544c.png)
    * Result

      ![Screenshot (546)](https://user-images.githubusercontent.com/89901590/192567681-9be2da33-6e14-4663-8d8d-2c0ef04c0a16.png)
  * View Join-Requests

    ![Screenshot (561)](https://user-images.githubusercontent.com/89901590/192568684-9c9b006a-1749-4b2c-8908-49255528a7b7.png)

    ![Screenshot (562)](https://user-images.githubusercontent.com/89901590/192568727-1db4a2ee-fa00-41de-9f00-3731109ddba5.png)
    * Options
      * Accept & Add To Members
      * Accept & Add To Admins
      * Reject
  * View Group's Profile

    ![Screenshot (558)](https://user-images.githubusercontent.com/89901590/192568447-3caceb43-849a-43cd-a44d-44b53e219f19.png)
  * Add New Member
    * Getting Target User's Username

      ![Screenshot (555)](https://user-images.githubusercontent.com/89901590/192567966-f8773891-c1aa-46fe-8458-0875b634b583.png)
    * Result

      ![Screenshot (556)](https://user-images.githubusercontent.com/89901590/192568373-f796d3b6-ab9e-4689-a352-a531089fa366.png)
  * Add New Admin
    * Getting Target User's Username

      ![Screenshot (550)](https://user-images.githubusercontent.com/89901590/192567840-41432ce4-0177-45b4-a66f-3fba8ce5ec59.png)
    * Result

      ![Screenshot (551)](https://user-images.githubusercontent.com/89901590/192567881-4367c1f1-a298-4081-baa9-356960db1449.png)
### 7.1.3. Create A New Group
  * Seeting New Group's Name

    ![Screenshot (541)](https://user-images.githubusercontent.com/89901590/192567117-765cb15f-8f1a-49d4-af21-4808c1b292bd.png)
  * Result

    ![Screenshot (542)](https://user-images.githubusercontent.com/89901590/192567193-05fbe3f4-965c-404b-9daf-5ed52f86c7da.png)
### 7.2. Private Chats

  ![Screenshot (565)](https://user-images.githubusercontent.com/89901590/192565574-790c887e-0c28-4080-9917-a1a283bd4152.png)
### 7.2.1. Start New Private Chat
  * Getting Target's Username

    ![Screenshot (526)](https://user-images.githubusercontent.com/89901590/192565285-f9da05e8-c9b5-4f3d-8fee-1df682b95f4a.png)
  * Result

    ![Screenshot (527)](https://user-images.githubusercontent.com/89901590/192565346-95353c3e-3ac4-4a32-b9c8-78588ff2d5df.png)
### 7.2.2. Open A Private Chat
  
  ![Screenshot (533)](https://user-images.githubusercontent.com/89901590/192566645-f90eacb8-05df-4f31-ad07-83c18b8d8c6d.png)

  ![Screenshot (534)](https://user-images.githubusercontent.com/89901590/192566690-773721af-7149-4290-a369-3b03bc2e4eba.png)
  * Send Message

    ![Screenshot (530)](https://user-images.githubusercontent.com/89901590/192566327-b988da44-ce78-42ad-a289-a27d9e91bde3.png)
  * View A Message's Details

    ![Screenshot (531)](https://user-images.githubusercontent.com/89901590/192566387-6c391b27-b329-40d7-ad25-18811e4da481.png)

    ![Screenshot (532)](https://user-images.githubusercontent.com/89901590/192566402-5e14ef28-578f-421c-820c-212f7075189a.png)
    * Like Message
    * DisLike Message
    * Reply To Message
    * Forward The Message
      * Selecting Target Chat

        ![Screenshot (535)](https://user-images.githubusercontent.com/89901590/192566840-5139bf50-4db4-4f42-8eee-45301a70db01.png)

        ![Screenshot (537)](https://user-images.githubusercontent.com/89901590/192566865-a220628e-2f2c-4a22-9df1-bbafbada6bac.png)
      * Result

        ![Screenshot (538)](https://user-images.githubusercontent.com/89901590/192566923-9a4cac13-6fbd-42f9-99dc-a2476da5e510.png)
    * View All Replies
## 8. Search Page
### 8.1. Seaching Process
  * Getting Target User's Username
  
    ![Screenshot (477)](https://user-images.githubusercontent.com/89901590/192557113-8abecbb4-acb4-4a65-8d81-8c7e44773828.png)
  * Result
  
    ![Screenshot (479)](https://user-images.githubusercontent.com/89901590/192557224-66715f07-7308-437d-80dc-cf50887ec119.png)
    ![Screenshot (480)](https://user-images.githubusercontent.com/89901590/192557251-d51242a7-ede2-4aab-8547-2b4f238fa578.png)
### 8.2. Operations
  ![Screenshot (564)](https://user-images.githubusercontent.com/89901590/192558027-b7dd5cde-b916-48e3-89ad-33449bfd3fd0.png)
  * Follow
    * Confirmation
      
      ![Screenshot (481)](https://user-images.githubusercontent.com/89901590/192559172-efaad057-05c9-4d10-a1d8-248ed9130a1a.png)
    * Result
    
      ![Screenshot (482)](https://user-images.githubusercontent.com/89901590/192559227-bdcef503-bd1d-4f25-8972-dbf406e5e709.png)
  * UnFollow
    * Confirmatoin
    
      ![Screenshot (519)](https://user-images.githubusercontent.com/89901590/192564452-11f29ad5-c6f8-4e6b-8c0f-18d903f7ebee.png)
    * Result
    
      ![Screenshot (520)](https://user-images.githubusercontent.com/89901590/192564501-71d905fe-3dad-484e-99f3-62bbce1593c2.png)
  * Block
  * UnBlock
  * View Searched User's Profile
  * View Searched User' Post Page
