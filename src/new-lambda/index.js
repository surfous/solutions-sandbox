var https = require( 'https' );


var SKILL_APP_ID = 'amzn1.echo-sdk-ams.app.f1fc7835-a6ed-4ada-bb1a-26c251c91ab8';

var STappID = 'xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx';  // AppID from Apps Editor
var STtoken = 'xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx';  //Token from Apps Editor
//var STappID = '6f89555e-76f7-4264-b349-ffe05fe3ae39' // ID for Auto OAUTH
//if (event.session.user.accessToken) {STtoken = event.session.user.accessToken; }

/**
 * The AlexaSkill prototype and helper functions
 */
var AlexaSkill = require('./AlexaSkill');

// SmartDoor is a child of AlexaSkill
var SmartDoor = function () {
   AlexaSkill.call(this, SKILL_APP_ID);
};

// Extend AlexaSkill
SmartDoor.prototype = Object.create(AlexaSkill.prototype);
SmartDoor.prototype.constructor = SmartDoor;


// ----------------------- Override AlexaSkill request and intent handlers -----------------------

TidePooler.prototype.eventHandlers.onSessionStarted = function (sessionStartedRequest, session) {
    console.log("onSessionStarted requestId: " + sessionStartedRequest.requestId
        + ", sessionId: " + session.sessionId);
    // any initialization logic goes here
};

TidePooler.prototype.eventHandlers.onLaunch = function (launchRequest, session, response) {
    console.log("onLaunch requestId: " + launchRequest.requestId + ", sessionId: " + session.sessionId);
    handleWelcomeRequest(response);
};

TidePooler.prototype.eventHandlers.onSessionEnded = function (sessionEndedRequest, session) {
    console.log("onSessionEnded requestId: " + sessionEndedRequest.requestId
        + ", sessionId: " + session.sessionId);
    // any cleanup logic goes here
};

/**
 * override intentHandlers to map intent handling functions.
 */
TidePooler.prototype.intentHandlers = {
    "OneshotTideIntent": function (intent, session, response) {
        handleOneshotTideRequest(intent, session, response);
    },

    "DialogSmartDoorIntent": function (intent, session, response) {
        // Determine if this turn is for city, for date, or an error.
        // We could be passed slots with values, no slots, slots with no value.
        var citySlot = intent.slots.City;
        var dateSlot = intent.slots.Date;
        if (citySlot && citySlot.value) {
            handleCityDialogRequest(intent, session, response);
        } else if (dateSlot && dateSlot.value) {
            handleDateDialogRequest(intent, session, response);
        } else {
            handleNoSlotDialogRequest(intent, session, response);
        }
    },

    "SupportedCitiesIntent": function (intent, session, response) {
        handleSupportedCitiesRequest(intent, session, response);
    },

    "AMAZON.HelpIntent": function (intent, session, response) {
        handleHelpRequest(response);
    },

    "AMAZON.StopIntent": function (intent, session, response) {
        handleCancelRequest(response);
    },

    "AMAZON.CancelIntent": function (intent, session, response) {
        handleCancelRequest(response);
    }
};

function handleCancelRequest(response) {
    var speechOutput = "Goodbye";
    response.tell(speechOutput);
}


function handleHelpRequest(response) {
    var repromptText = "Which city would you like tide information for?";
    var speechOutput = "I can lead you through locking your connected doors "
        + "day of the week to get tide information, "
        + "or you can simply open Tide Pooler and ask a question like, "
        + "get tide information for Seattle on Saturday. "
        + "For a list of supported cities, ask what cities are supported. "
        + "Or you can say exit. "
        + repromptText;

    response.ask(speechOutput, repromptText);
}


   if (event.request.intent.name == "Home") {
        var Operator = event.request.intent.slots.Operator.value;
        var Noun = event.request.intent.slots.Noun.value;
        var Operand = event.request.intent.slots.Operand.value;
        var Inquisitor = event.request.intent.slots.Inquisitor.value;
        if (!Operator) {Operator = "none";}
        if (!Noun) {Noun = "none";}
        if (!Operand) {Operand = "none";}
        if (!Inquisitor) {Inquisitor = "none";}
        var url = 'https://graph.api.smartthings.com/api/smartapps/installations/' + STappID + '/' +
                 Noun + '/' + Operator + '/'+ Operand + '/' + Inquisitor  +'?access_token=' + STtoken;
        console.log(url)
        https.get( url, function( response ) {
            response.on( 'data', function( data ) {
                var resJSON = JSON.parse(data);
                var speechText = 'The App on SmartThings did not return any message.'
                if (resJSON.talk2me) { speechText = resJSON.talk2me; }
                console.log(speechText);
                output(speechText, context);
                console.log("after the fact");
            } );
        } );
    } else {
       output("Another intent goes here.", context)
    }
};


function output( text, context ) {
   var response = {
      outputSpeech: {
         type: "PlainText",
         text: text
      },
      card: {
         type: "Simple",
         title: "System Data",
         content: text
      },
   shouldEndSession: true
   };
   context.succeed( { response: response } );
}
