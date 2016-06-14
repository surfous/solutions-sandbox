/**
    Copyright 2014-2015 Amazon.com, Inc. or its affiliates. All Rights Reserved.

    Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance with the License. A copy of the License is located at

        http://aws.amazon.com/apache2.0/

    or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
*/

/**
 * This sample shows how to create a Lambda function for handling Alexa Skill requests that:
 *
 * - Custom slot type: demonstrates using custom slot types to handle a finite set of known values
 *
 * Examples:
 * One-shot model:
 *  User: "Alexa, ask Minecraft Helper how to make paper."
 *  Alexa: "(reads back recipe for paper)"
 */

'use strict';

var AlexaSkill = require('./AlexaSkill')

var APP_ID = undefined; //OPTIONAL: replace with 'amzn1.echo-sdk-ams.app.[your-unique-value-here]';

/**
 * SmartthingsCustomSkill is a child of AlexaSkill.
 * To read more about inheritance in JavaScript, see the link below.
 *
 * @see https://developer.mozilla.org/en-US/docs/Web/JavaScript/Introduction_to_Object-Oriented_JavaScript#Inheritance
 */
var SmartthingsCustomSkill = function () {
    AlexaSkill.call(this, APP_ID);
};

// Extend AlexaSkill
SmartthingsCustomSkill.prototype = Object.create(AlexaSkill.prototype);
SmartthingsCustomSkill.prototype.constructor = SmartthingsCustomSkill;

SmartthingsCustomSkill.prototype.eventHandlers.onLaunch = function (launchRequest, session, response) {
	universalIntentHandler(intent, session, response)
};

SmartthingsCustomSkill.prototype.intentHandlers = {
    "DialogSmartDoorIntent": function (intent, session, response) {
		universalIntentHandler(intent, session, response)
    },

    "AMAZON.StopIntent": function (intent, session, response) {
		universalIntentHandler(intent, session, response)
    },

    "AMAZON.CancelIntent": function (intent, session, response) {
		universalIntentHandler(intent, session, response)
    },

    "AMAZON.HelpIntent": function (intent, session, response) {
		universalIntentHandler(intent, session, response)
    }
};

function universalIntentHandler(intent, session, response) {
	var cardTitle = "Called by Custom Skill";
    var speechOutput = "Thank you for trying the SmartThings Custom Skill for Alexa.";
	var cardContent = speechOutput;
	response.tellWithCard(speechOutput, cardTitle, cardContent);
}

exports.handler = function (event, context) {
    var smartthingsCustomSkill = new SmartthingsCustomSkill();
    smartthingsCustomSkill.execute(event, context);
};
