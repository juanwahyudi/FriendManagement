# FriendManagement
FriendManagement API for SPGroup Software Engineer Test


Technical Choices :

1. Web API was built on top of Java Jersey Framework.
2. Backend database was built on top of MySQL platform (please find attached MySQL schema generations scripts).

Why did I Choose to build this WebAPI by using Java Jersey Framework and MySQL as the backend database?
Because I've been already quite familiar with this both platform.

How to test the Web API using POSTMAN

1. As a user, I need an API to create a friend connection between two email addresses.
Send the POST REQUEST to this following URL :
http://ec2-52-77-226-121.ap-southeast-1.compute.amazonaws.com:8080/FriendManagement/REST/User/CreateFriendConnection

2. As a user, I need an API to retrieve the friends list for an email address.
Send the POST REQUEST to this following URL :
http://ec2-52-77-226-121.ap-southeast-1.compute.amazonaws.com:8080/FriendManagement/REST/User/RetrieveFriendsList

3. As a user, I need an API to retrieve the common friends list between two email addresses.
Send the POST REQUEST to this following URL :
http://ec2-52-77-226-121.ap-southeast-1.compute.amazonaws.com:8080/FriendManagement/REST/User/RetrieveMutualFriendsList

4. As a user, I need an API to subscribe to updates from an email address.
Send the POST REQUEST to this following URL:
http://ec2-52-77-226-121.ap-southeast-1.compute.amazonaws.com:8080/FriendManagement/REST/Subscription/SubscribetoUpdates

5. As a user, I need an API to block updates from an email address.
Send the POST REQUEST to this following URL:
http://ec2-52-77-226-121.ap-southeast-1.compute.amazonaws.com:8080/FriendManagement/REST/Subscription/BlockSubscription

6. As a user, I need an API to retrieve all email addresses that can receive updates from an email address.
Send the POST REQUEST to this following URL:
http://ec2-52-77-226-121.ap-southeast-1.compute.amazonaws.com:8080/FriendManagement/REST/Subscription/RetrieveSubscriptionUpdates

Why did I choose to host in Amazon Web Services (AWS) Cloud?
Because it provided the FREE TIER for 12 months for its Elastic Computing EC2 service. :)
