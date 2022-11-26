Name of members
- Hidri Ghebretinsae 614658
- Bereket Haileslassie Beudemariam 614608
- Abdelghani Houbbadi 614624

## How to run our project

We attached a video demo for our project,

https://drive.google.com/file/d/1TY7G19wx9vt9oni6jAFSwF3ZeerDRj1o/view?usp=sharing

Make sure you have docker setup on your machine
Make sure you have kubernetes setup on your machine


###commands

for this project you don't need to build the container by your self we arleady push the container to docker hub, and 
if you run the following command 
>> kubectl apply -f ./  #everything will start run on your machine

>> http://localhost:9191/api/account/save create an account

>> http://localhost:9191/authenticate using username and password of the created account using Post meethod to generate TWT token

for every request use the generated token before except get all products
