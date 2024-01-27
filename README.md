# Sectors

## Tasks

1. Correct all of the deficiencies in index.html (attached file)
2. "Sectors" selectbox:
   1. Add all the entries from the "Sectors" selectbox to database
   2. Compose the "Sectors" selectbox using data from database
3. Perform the following activities after the "Save" button has been pressed:
   1. Validate all input data (all fields are mandatory)
   2. Store all input data to database (Name, Sectors, Agree to terms)
   3. Refill the form using stored data
   4. Allow the user to edit his/her own data during the session

## Database setup from scratch
1. See base source_index.html for how to "build" the JSON file from the HTML
2. Place the JSON file in the resources directory
3. Uncomment db/LoadDatabase.java
   1. NB! If you set your database to persist after builds (e.g. not storing in memory), leaving it uncommented will cause crashes or errors.
4. Add `spring.jpa.properties.hibernate.enable_lazy_load_no_trans=true` in application.properties
5. Run the application

## Notes
Still a few too many DB requests, even though I have done my best to reduce them.
Issues mostly stem from the self-referential relationships.

