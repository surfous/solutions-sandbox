var testMessages = {
	"smartHome": {
		"discovery": smartHomeDiscoveryRequest,
		"control": smartHomeControlRequest
	},
	"customSkill": {
		"IntentRequest": customSkillEvent
	}
}


var smartHomeDiscoveryRequest = {
	"header": {
		"namespace": "Alexa.ConnectedHome.Discovery",
		"name": "DiscoverAppliancesResponse",
		"payloadVersion": "2"
	},
	"payload": {
		"accessToken": "sampleAccessToken",
		"discoveredAppliances": [
			{
				"applianceId": "testApplianceId1",
				"manufacturerName": "testManufacturerName",
				"modelName": "testModelName",
				"version": "testVersion",
				"friendlyName": "testFriendlyName",
				"friendlyDescription": "testFriendlyDescription",
				"isReachable": true,
				"additionalApplianceDetails": {}
			},
			{
				"applianceId": "testApplianceId2",
				"manufacturerName": "testManufacturerName",
				"modelName": "testModelName",
				"version": "testVersion",
				"friendlyName": "testFriendlyName",
				"friendlyDescription": "testFriendlyDescription",
				"isReachable": true,
				"additionalApplianceDetails": {
					"key2": "value2",
					"key1": "value1"
				}
			}
		]
	}
};

var smartHomeControlRequest = {
  "header": {
    "payloadVersion": "2",
    "namespace": "Alexa.ConnectedHome.Control",
    "name": "SwitchOnOffRequest"
  },
  "payload": {
    "switchControlAction": "TURN_ON",
    "appliance": {
      "additionalApplianceDetails": {
        "key2": "value2",
        "key1": "value1"
      },
      "applianceId": "sampleId"
    },
    "accessToken": "sampleAccessToken"
  }
};

var customSkillIntentRequest = {
  "session": {
    "new": false,
    "sessionId": "session1234",
    "attributes": {},
    "user": {
      "userId": null,
	  "accessToken": "sampleAccessToken"
    },
    "application": {
      "applicationId": "amzn1.echo-sdk-ams.app.f1fc7835-a6ed-4ada-bb1a-26c251c91ab8"
    }
  },
  "version": "1.0",
  "request": {
    "intent": {
      "slots": {
        "LockOperation": {
          "name": "LockOperation",
          "value": "lock"
        },
        "Whichlock": {
            "name": "Whichlock",
            "value": "front door"
        }
      },
      "name": "DialogSmartDoorIntent"
    },
    "type": "IntentRequest",
    "requestId": "request5678"
  }
};
