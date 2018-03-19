# rsvp-api
RSVP Management Backend API

Allows for users to manage an event, invitatations to an event, and guest registrations to the event. Guests can register for an event and view event info.

## Guest functionality:
The following endpoints are for a user's guests to rsvp to an event.

### GET http://localhost:8080/rsvp-ws/rsvp/info/id/{id} 
Allows guests to retrieve information about an event

### POST http://localhost:8080/rsvp-ws/rsvp/register
Allows guests to register for an event while specifying how many additional guests they are bringing. The time that they register is saved as well.

## Admin functionality:
Admin webservices are role based and locked down server side. 

### Guest utilities
#### GET http://localhost:8080/rsvp-ws/admin/guests/duplicates/eventid/{id}
Retrieves a list of duplicate registrations for the same guest. Perhaps they registered twice because they forgot. If multiple records for the same guest shows up, the user will be able to check if the guest registered the same amount of additional guests in their multiple registrations

#### GET http://localhost:8080/rsvp-ws/admin/guests/expected/eventid/{id}
Retrieves a list of guests that were on the guest list and also registered for the event. 

#### GET http://localhost:8080/rsvp-ws/admin/guests/noninvited/eventid/{id} 
Retrieves a list of guests that were not on the guest list but registered. The user may use this list to contact the people who invited themselves to their event, or just to plan accordingly.

#### GET http://localhost:8080/rsvp-ws/admin/guests/underestimated/eventid/{id}
Retrieves a list of guests that the user underestimated the number of additional guests for. For example, in our guest list, we can estimate that Joe Dohn is going to bring 1 additional guest with him. However, Joe Dohn registered and wrote that he will bring 3 additional guests. This allows the user to find these underestimated expenses to either put aside more budget, or to tell Joe Dohn that he can't bring 3 more people.

### Event CRUD
The following endpoints allow a user to create, retrieve, update, and delete events. 
#### Delete by id: DELETE http://localhost:8080/rsvp-ws/admin/events/id/{id}
#### Get all: GET http://localhost:8080/rsvp-ws/admin/events/
#### Get by id: GET http://localhost:8080/rsvp-ws/admin/events/id/{id}
#### Create: POST http://localhost:8080/rsvp-ws/admin/events/
#### Update: PUT http://localhost:8080/rsvp-ws/admin/events/  

### Invitation CRUD
The following endpoints allow a user to create, retrieve, update, and delete invitations. 
#### Delete by id: DELETE http://localhost:8080/rsvp-ws/invitations/events/id/{id}
#### Get all: GET http://localhost:8080/rsvp-ws/admin/invitations/
#### Get by id: GET http://localhost:8080/rsvp-ws/admin/invitations/id/{id}
#### Create: POST http://localhost:8080/rsvp-ws/admin/invitations/
#### Update: PUT http://localhost:8080/rsvp-ws/admin/invitations/  

### Regisration CRUD
The following endpoints allow a user to create, retrieve, update, and delete registrations. 
#### Delete by id: DELETE http://localhost:8080/rsvp-ws/regisrations/events/id/{id}
#### Get all: GET http://localhost:8080/rsvp-ws/admin/regisrations/
#### Get by id: GET http://localhost:8080/rsvp-ws/admin/regisrations/id/{id}
#### Create: POST http://localhost:8080/rsvp-ws/admin/regisrations/
#### Update: PUT http://localhost:8080/rsvp-ws/admin/regisrations/  
