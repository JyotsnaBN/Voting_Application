# Voting_Application

The aim of this project is make a Real-time working and functioning voting application.
We are going to use Android Studio for this project and we are going to run the application on our
mobiles.
This application will have two views:
1. ADMIN VIEW
2. USER VIEW

There is another button that would be enabled only after election has been completed.

3. VIEW RESULTS.


Let us talk about each one of them in detail.

ADMIN

As an Admin who would be monitoring the elections, their responsibilities would be to preside over
the elections to ensure no malpractice takes place.The presides over the election at the fixed time,
from the start to the end of the elections according to the designated timeline.
The Admin can view the user list, the party list, the votes cast and how many votes have been cast
for each party.
When the Admin view is chosen, the admin is asked to enter an Admin ID AND password, if
validated the admin enters the admin view. If the Admin enters incorrect ID or password for more
than 5 times, the login button is disabled and they cannot login again.
The Admin possesses the information to view the User Database and Party database but cannot
modify them. At the end of the Election, the voting is stopped since the end time is reached and
the admin can display the number of votes gained by each party and who the Winner is.
The Admin can Logout from the Admin View at any time.

USER

When the user view is chosen, you are asked to enter the voter ID and password and you must be
an Indian Citizen above 18 years of age to be enrolled into the Voters list.
The Voter ID is unique for every citizen and when the ID and password are entered correctly, you
will see a page with party names and their symbols and you can cast your vote to a party of your
choice.
If the User enters incorrect ID or password for more than 5 times, the login button is disabled and
they cannot login again.
Every User can only login once and cast their vote only once.
Once you have voted you would be logged out of the application.

VIEW RESULTS

When the Election time is up, Voting is closed and users cannot login anymore and the View
Results button is enabled.
When this button is clicked the name of the Winner Party is displayed along with the number of
votes they have gained.
