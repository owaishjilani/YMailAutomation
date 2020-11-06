Feature: Login to Ymail and fetch mails with the subject of searched text

Scenario: Login with correct credentials
	Given user navigates to "https://login.yahoo.com/?.src=ym&.lang=en-US&.intl=us&.done=https%3A%2F%2Fmail.yahoo.com%2Fd" site
	When user enters email address as "owaishmustafa@ymail.com"
	Then user clicks on the next button
	When user enters password as "Bissi2019!"
	Then user clicks on login button
	And user logged in successfully
#	Given user is logged into the account
	Then user searches for "Check out delicious lunch options" on the search box
	Then user clicks on search
	And user receives search results
#	Given user is on the search results page
	Then user fetches email received on "Oct 3"
	Then user fetches email received last "10 days"
#	And user user closes the window