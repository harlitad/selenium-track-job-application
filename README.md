## Track Job Application

>This repo created for documenting when I was playing around with Blibli Career to explore my selenium skill.

I write a simple test case to track my job application progress in https://careers.blibli.com/#jobs.
I think its very common test case to input form of email and application ID then assert the result. 
But wait, the fact that Blibli Career site have dynamic html id, this is very challenging for me.

Example to get selectors for email and application ID field but 
they have the same ID like `bli-input-xxxx` the following `xxxx` is random number generated every time reload the page.
So, I am using XPATH contains to select all elements with id like `bli-input-` then slice by the index to select the field. Thats all.

>Still wondering the best practice to get the element with dynamic selector.



