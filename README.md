# simple-project-management

Autoryzacja jest wykonana przy użyciu tokenów, więc aby wysłać zadanie należy uzyskać token z AuthenticationControllera (przykladowe dane logowania  {  "password": "user",  "username": "user"}) 
Uzyskany w ten sposób token trzeba wykorzystać do autoryzacji dodając na początku jeszcze "Bearer ". Wówczas podczas zadania będzie dodawany header "Authorization" z tokenem. 
