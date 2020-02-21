# assessment
Simple JSON Web Service - FetchRewards

Email Checker:
Please write a web service that accepts http requests and returns responses based on the following problem statement. 
You may define the request and response format as you see fit based on the problem statement.
Problem statement: Accept a list of email addresses and return an integer indicating the number of unique email addresses.
Where "unique" email addresses means they will be delivered to the same account using Gmail account matching. Specifically: 
Gmail will ignore the placement of "." in the username. And it will ignore any portion of the username after a "+".
Examples:
test.email@gmail.com, test.email+spam@gmail.com and testemail@gmail.com will all go to the same address, and thus the result should be 1.
For any requirements not specified via an example, use your best judgement to determine expected result.


Use cases 
WebService 
Unique email address

Assumptions:
character set is ASCII
the emails vector size is possible to store in memory
the email length is possible to store in memory
Each emails[i] contains exactly one '@' character.
All local and domain names are non-empty.
Local names do not start with a '+' character.

Design
RESTFul Web Service 
JSON format { "emails": [ "test.email@gmail.com", "test.email+spam@gmail.com", "testemail@gmail.com" ] }

Complexity Analysis

Time Complexity: O(n), where n is the total content of emails vector. 
Space Complexity: O(n) (worst case). 

Tests:
I use a TDD approach because
All software must be covered 100% by tests for future integration/new features
I understood that it is out of this scope for now
Anyway I provided a little client to test the wwebservice
In general I use Junit to test the software (very useful for automatic unit and integration tests) 
