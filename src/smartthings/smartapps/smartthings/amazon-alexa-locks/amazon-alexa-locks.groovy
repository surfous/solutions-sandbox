/**
 *  Amazon Alexa Home Skill - US production
 *
 *  Supports lights, dimmers, thermostats and Routines
 *
 *  Author: SmartThings
 */

definition(
	name: "Amazon Alexa",
	namespace: "smartthings",
	author: "SmartThings",
	description: "Allows Amazon Alexa to interact with your SmartThings devices and Routines.",
	category: "Convenience",
	iconUrl: "https://s3.amazonaws.com/smartapp-icons/Convenience/App-AmazonAlexa.png",
	iconX2Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/App-AmazonAlexa@2x.png",
	iconX3Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/App-AmazonAlexa@3x.png",
	oauth: [displayName: "Amazon Alexa", displayLink: ""],
	singleInstance: true
)

// // Uncomment the provisioning URL for the instance this SmartApp services

// @Field final String AVS_SKILL_PROVISIONING_URL = 'https://www.amazon.com/ap/signin?_encoding=UTF8&openid.assoc_handle=usflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fpitangui.amazon.com%2Fapi%2Fskills%2Fredirect-to-skill-authorization-uri%3FskillId%3Damzn1.ask.skill.2bdbc74f-ce4d-4e2d-b741-326c7ba358f0%3Bstage%3Dlive' // US production instance
// @Field final String AVS_SKILL_PROVISIONING_URL = 'https://www.amazon.com/ap/signin?_encoding=UTF8&openid.assoc_handle=usflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Flayla.amazon.com%2Fapi%2Fskills%2Fredirect-to-skill-authorization-uri%3FskillId%3Damzn1.ask.skill.ef172d0e-8408-4120-b0f9-deab2d0572c1%3Bstage%3Dlive' // UK production instance
// @Field final String AVS_SKILL_PROVISIONING_URL = 'https://www.amazon.com/ap/signin?_encoding=UTF8&openid.assoc_handle=usflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fpitangui.amazon.com%2Fapi%2Fskills%2Fredirect-to-skill-authorization-uri%3FskillId%3Damzn1.ask.skill.2bdbc74f-ce4d-4e2d-b741-326c7ba358f0%3Bstage%3Ddevelopment' // Custom Skill RC superuser instance
// @Field final String AVS_SKILL_PROVISIONING_URL = 'https://www.amazon.com/ap/signin?_encoding=UTF8&openid.assoc_handle=usflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fpitangui.amazon.com%2Fapi%2Fskills%2Fredirect-to-skill-authorization-uri%3FskillId%3Damzn1.ask.skill.e706fbba-7f07-441a-b264-a01175dae7a5%3Bstage%3Ddevelopment' // US Home Skill RC superuser instance
// @Field final String AVS_SKILL_PROVISIONING_URL = 'https://www.amazon.com/ap/signin?_encoding=UTF8&openid.assoc_handle=usflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Flayla.amazon.com%2Fapi%2Fskills%2Fredirect-to-skill-authorization-uri%3FskillId%3Damzn1.ask.skill.5a8fe0ae-2db4-415f-9ef4-1090decf136c%3Bstage%3Ddevelopment' // UK Home Skill RC superuser instance
// @Field final String AVS_SKILL_PROVISIONING_URL = 'https://www.amazon.com/ap/signin?_encoding=UTF8&openid.assoc_handle=usflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Flayla.amazon.com%2Fapi%2Fskills%2Fredirect-to-skill-authorization-uri%3FskillId%3Damzn1.ask.skill.dc0e3954-91d3-4fa4-b2fe-9f078fbd1cc6%3Bstage%3Ddevelopment' // amazonalexa@smartthings.com UK Home Skill
// @Field final String AVS_SKILL_PROVISIONING_URL = 'https://www.amazon.com/ap/signin?_encoding=UTF8&openid.assoc_handle=usflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fpitangui.amazon.com%2Fapi%2Fskills%2Fredirect-to-skill-authorization-uri%3FskillId%3Damzn1.ask.skill.2130fb6c-7e17-41e1-9735-f99602bcddba%3Bstage%3Ddevelopment' // test-prod superuser instance
// @Field final String AVS_SKILL_PROVISIONING_URL = 'https://www.amazon.com/ap/signin?_encoding=UTF8&openid.assoc_handle=usflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fpitangui.amazon.com%2Fapi%2Fskills%2Fredirect-to-skill-authorization-uri%3FskillId%3Damzn1.ask.skill.5c7bce44-5049-4d92-b9a3-f8b1f3a5a496%3Bstage%3Ddevelopment' // kshuk - home + custom
@Field final String AVS_SKILL_PROVISIONING_URL = 'https://www.amazon.com/ap/signin?_encoding=UTF8&openid.assoc_handle=usflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fpitangui.amazon.com%2Fapi%2Fskills%2Fredirect-to-skill-authorization-uri%3FskillId%3Damzn1.ask.skill.214e2164-ce6e-42ba-9dc2-88af56c2df80%3Bstage%3Ddevelopment' // kshuk - home only
// @Field final String AVS_SKILL_PROVISIONING_URL = 'https://www.amazon.com/ap/signin?_encoding=UTF8&openid.assoc_handle=usflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fpitangui.amazon.com%2Fapi%2Fskills%2Fredirect-to-skill-authorization-uri%3FskillId%3Damzn1.ask.skill.ace36df2-76c7-464d-9449-34b746b12f0c%3Bstage%3Ddevelopment' // Alex - home + custom
// @Field final String AVS_SKILL_PROVISIONING_URL = 'https://www.amazon.com/ap/signin?_encoding=UTF8&openid.assoc_handle=usflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fpitangui.amazon.com%2Fapi%2Fskills%2Fredirect-to-skill-authorization-uri%3FskillId%3Damzn1.ask.skill.151c9883-5155-4b8a-90b0-81de29fdaeed%3Bstage%3Ddevelopment' // Alex - home only
// @Field final String AVS_SKILL_PROVISIONING_URL = 'https://www.amazon.com/ap/signin?_encoding=UTF8&openid.assoc_handle=usflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fpitangui.amazon.com%2Fapi%2Fskills%2Fredirect-to-skill-authorization-uri%3FskillId%3Damzn1.ask.skill.14f0c291-7aed-4777-8a91-c3bf075ed3b5%3Bstage%3Ddevelopment' // Igor


// Version kshuk_dev

// Changelist:

// In development
// Add lock locking

// 1.1.18
// Updated thermostat response to HEAT,COOL and AUTO according to Amazon API

// 1.1.17
// Re-enable Routines
// Update OAUTH copy
// Add Routines KB article

// 1.1.16
// Remove SmartThings Extra section and update copy

// 1.1.15
// Add dynamic landing page

// 1.1.14
// Fix NPE in discovery()

// 1.1.13
// P99 fix for Harmony
// Blanket permissions
// Improve OSRAM bulb identification
// Disable routines
// Changed versioning scheme: x.1.x where 1 is for US; x.2.x where 2 is for UK

// 1.1.11
// Handle restricted routines:
// Send push notification first time routine is executed if restriced
// Educate users about restrictions on OAUTH, Alexa app and device selection page
// Hack to fix "I'm Back!"
// Heartbeat fix for new Z-wave device types
// Updated Jasco devices

// 1.1.10
// Dynamic preferences
// Harmony workaround
// Heartbeat zwaveinfo fix
// Setup heartbeat when discovery is called
// Added singleInstance

// 1.1.9
// Add MSR data for Jasco devices

// 1.1.8
// Add support for routines
// Add support for blanket permissions

// 1.1.7
// Handle lastActivity == null for devices that actually support heart beat
// Reformatted code to tabs instead of spaces according to SmartThings standard

// 1.1.6
// Removed lastActivity = null offline check since it caused issues for virtual switches

// 1.1.5
// Fixed hub version parse bug

// 1.1.4
// NAC release candidate
// Cleaned up printouts
// Added thermostats error message for unknown modes

// 1.1.3.5
// Fixed NAC 0%-turnOn bug
// Fixed thermostat Off error message

// 1.1.3.4
// Added Leviton Outlet

// 1.1.3.3
// Retry setup if failed
// Use delay for refresh() commands to distribute z-wave commands

// 1.1.3.2
// Added hub version check to block V1 hubs from using heartbeat

// 1.1.3.1
// First version to QA

// 1.1.3
// Add device health for "zwave switch" and "dimmer switch"
// Fixed NAC bug, if level is set to 0% and turn on is called then light should go to 100%

// 1.1.2
// Bugfixes - Increase/Decrease thermostat in auto mode temperature conversion
// Removed unnecessary log printouts

// 1.1.1 (first CoHo V2 release to production)
// Bugfixes

// 1.1.0
// Bugfixes

// 1.0.9
// Support for Amazon V2 connected home
// Added thermostat support
// Code cleanup
// Renamed endpoints to match Alexa APIs

// 1.0.8 (released)
// Disable heartbeat due to V2 local device type execution issue
// Catch exception in case "elevated priviliges" is removed

// 1.0.7 (released)
// Add level switches (dimming)

// 1.0.6
// Check device health for supported device (temporary fix using "hearbeat")
// Removed www.amazon.com from OAUTH

// 1.0.5
// Added friendly name
// Updated OAUTH url
// Updated text string when selecting devices

// Todos:
// Add support for manufacturerName/modelName
// Add support for appliance version
// Add support for capabilities in createFriendlyText()

import groovy.transform.Field

@Field final String LOCK_LOCKED_STATE = "LOCKED"
@Field final String LOCK_UNLOCKED_STATE = "UNLOCKED"
@Field final List VALID_LOCK_STATES = [LOCK_LOCKED_STATE, LOCK_UNLOCKED_STATE]

@Field final List DEVICE_TYPE_NAME_EXCLUSION_LIST = ['Samsung Range']
@Field final List DEVICE_CAPABILITY_EXCLUSION_LIST = ['Buffered Video Capture', 'Image Capture', 'Video Capture', 'Video Camera']

preferences(oauthPage: "oauthPage") {
	page(name: "firstPage", content: "chooseFirstPage")
	page(name: "deviceAuthorizationPage", content: "buildDeviceAuthorizationPage")

	// This is a static page for generating the OAUTH page - this is not shown in the SmartApp
	page(name: "oauthPage", title: "", nextPage: "instructionPage", uninstall: false) {
		section("") {
			input "allEnabled", type: "enum", title: "Access to all devices and Routines", options: [[(true): "Yes (Note: At this time, Amazon will only support Routines with lighting and thermostat devices) OR No, I wish to choose from the following:"]], defaultValue: false, multiple: false, required: false
			input "switches", "capability.switch", title: "Switches", multiple: true, required: false
			input "thermostats", "capability.thermostat", title: "Thermostats", multiple: true, required: false
			input "locks", "capability.lock", title: "Locks", multiple: true, required: false
			input "routinesEnabled", type: "enum", title: "Routines", options: [[(true): "All Routines (Note: At this time, Amazon will only support Routines with lighting and thermostat devices)"]], defaultValue: false, multiple: false, required: false
		}
	}

	// Instructions for the user on how to run appliance discovery from Alexa to update its device list
	// install: true is needed here to have a Done button which will return user to SmartApp list.
	page(name: "instructionPage", content: "buildInstructionPage", install: true)

	page(name: "helpPage", title: "Help") {
		section("Knowledgebase Articles") {
			href(
				name: "href_kb_205275404",
				title: "How to connect Amazon Alexa with SmartThings",
				description: "",
				url: "https://support.smartthings.com/hc/en-us/articles/205275404",
				style: "embedded"
			)
			href(
				name: "href_kb_207808076",
				title: "SmartThings + Amazon Alexa FAQ",
				description: "",
				url: "https://support.smartthings.com/hc/en-us/articles/207808076",
				style: "embedded"
			)
			href(
				name: "href_kb_210204906",
				title: "SmartThings Routines + Amazon Alexa",
				description: "",
				url: "https://support.smartthings.com/hc/en-us/articles/210204906",
				style: "embedded"
			)
		}
	}

	// Separate page for uninstalling, we dont want the user to accidentaly uninstall since the app can only be automatically reinstalled
	page(name: "uninstallPage", title: "Uninstall", uninstall: true) {
		section("") {
			paragraph '''\
If you uninstall this SmartApp, remember to unlink your SmartThings account from Alexa:
  1. Open the Amazon Alexa application
  2. Go to Menu (three lines, upper left) > Skills, then tap "Your Skills" in the upper right corner
  3. Tap the skill to open it, then tap "Disable Skill"'''
		}
	}
}

/**
 * Decides and returns the first page to display -
 * Landing page until we install, then deviceAuthorization thereafter,
 * @method firstPage
 * @return dynamicPage object
 */
private def chooseFirstPage() {
	def firstPage
	Boolean showLandingPage = true
	if (state?.showLandingPage != null) {
		showLandingPage = booleanize(state?.showLandingPage)
	}
	if (app?.installationState == "COMPLETE") {
		// app has already been installed - don't show landing page
		showLandingPage = false
	}
	state.showLandingPage = showLandingPage // save back to state

	if (booleanize(state?.recentInstall) == true) {
		state.recentInstall = false
		firstPage = buildInstructionPageFP()
	} else if (showLandingPage) {
		firstPage = buildLandingPage()
	} else {
		firstPage = buildDeviceAuthorizationPageFP()
	}
	return firstPage
}

private def buildLandingPage() {
	dynamicPage(name: "firstPage", title: "Use your Amazon Echo with SmartThings", install: true) {
		section("What's an Amazon Echo?") {
			image(name: "heroImage",
			title: "Amazon Alexa + SmartThings",
			required: false,
			image: "https://smartapp-resources.s3.amazonaws.com/alexa/AmazonAlexa-header-img.png")

			emitProvisioningUrlHref()

			paragraph '''\
Amazon Echo is a hands-free speaker you control with your voice. Echo connects to the Alexa Voice Service to play music, provide information, news, sports scores, weather, and more—instantly. But, most importantly, you can use it to control your SmartThings Smart home!

Use Alexa to switch on the lamp before getting out of bed, turn on the fan or space heater while reading in your favorite chair, or dim the lights from the couch to watch a movie—all without lifting a finger.

Alexa works with devices such as lights, switches, outlets, dimmers, thermostats, and even SmartThings Routines.'''

			element(name: "videoElement",
				element: "video",
				type:   "video",
				title: "Just ask Alexa",
				required: false,
				image: "https://smartapp-resources.s3.amazonaws.com/alexa/AmazonAlexa-Enabled-thumbnail.png",
				video: "https://smartapp-resources.s3.amazonaws.com/alexa/AmazonAlexa-Enabled.mp4")

			emitProvisioningUrlHref()
		}
	}
}

private def emitProvisioningUrlHref() {
	href(name: "href_provision",
		title: "Tap to Link Alexa",
		required: false,
		style: "embedded",
		description: "This will create a SmartApp in your SmartThings account",
		image: "https://s3.amazonaws.com/smartapp-icons/Convenience/App-AmazonAlexa.png",
		url: AVS_SKILL_PROVISIONING_URL,
		state: "complete")
}

private def buildDeviceAuthorizationPageFP() {
	return dynamicPage(name: "firstPage", title: "Device Authorization", nextPage: "instructionPage") {
		fillDeviceAuthorizationPage()
	}
}

// The other option for firstPage
private def buildDeviceAuthorizationPage() {
	// Initial page where user can pick which switches should be available to Alexa
	// Assumption is that level switches all support regular switch as well. This is to avoid
	// having two inputs that might confuse the user
	log.debug "settings.allEnabled value is: ${settings?.allEnabled}. as Boolean: ${isBlanketAuthorized()}"
	return dynamicPage(name: "deviceAuthorizationPage", title: "Device Authorization", nextPage: "instructionPage") {
		fillDeviceAuthorizationPage()
	}
}

private def fillDeviceAuthorizationPage() {
	section("") {
		String blanketAllEnabled = "Alexa can access\nall devices and Routines"
		String blanketSelectOnly = "Alexa can access\n only the devices and Routines\n selected below"

		input "allEnabled", "bool", title: "Allow Alexa to access\nall devices and Routines", required: false, submitOnChange:true
	}

	if (!isBlanketAuthorized()) {
		section("Please choose from the following") {
			input "switches", "capability.switch", title: "Switches", description: "Tap to select", multiple: true, required: false
			input "thermostats", "capability.thermostat", title: "Thermostats", multiple: true, required: false
			input "locks", "capability.lock", title: "locks", multiple: true, required: false
			input "routinesEnabled", "bool", title: "Routines", required: false, submitOnChange: true
		}
	}
	if (isBlanketAuthorized() || areRoutinesEnabled()) {
		def routines = location.helloHome?.getPhrases()
		def restrictedRoutines = ""
		if (routines) {
			// sort them alphabetically
			routines.sort()
			routines.each {
				if (it.hasSecureActions) {
					if (restrictedRoutines.isEmpty()) {
							restrictedRoutines += it.label
					} else {
							restrictedRoutines += ", ${it.label}"
					}
				}
			}

			if (!restrictedRoutines.isEmpty()) {
				section("") {
					paragraph title: "Note: The following Routines cannot be used by Alexa. For security reasons, they have been disabled by Amazon because they contain a prohibited device. To reenable, please remove locks, garage doors, cameras,  security systems, and security devices.", "$restrictedRoutines"
				}
			}
		}
	}

	section("") {
		href(name: "href_help",
				title: "Help",
				required: false,
				description: "",
				page: "helpPage")
		href(name: "href_uninstall",
				title: "Uninstall",
				required: false,
				description: "",
				page: "uninstallPage")
	}
}

private def buildInstructionPageFP() {
	dynamicPage(name: "firstPage", title: "Device Discovery", install: true) {
		fillInstructionPage()
	}
}

private def buildInstructionPage() {
	dynamicPage(name: "instructionPage", title: "Device Discovery", install: true) {
		fillInstructionPage()
	}
}

private def fillInstructionPage() {
	section("") {
		paragraph "You have made a change to your device list.\n\n" +
				"Now, complete device discovery by saying the following to Alexa:"
		paragraph title: "\"Alexa, discover my devices\"", ""
		paragraph 'Finally, tap "Done" in the upper right corner'
	}
}

/**
 * Returns the value of settings.allEnabled always as a Boolean, no matter how settings stores it.
 * @method isBlanketAuthorized
 * @return Value of settings.allEnabled forced to a Boolean
 */
Boolean isBlanketAuthorized() {
	return booleanize(settings?.allEnabled)
}

/**
 * Returns the value of settings.routinesEnabled always as a Boolean, no matter how settings stores it.
 * @method areRoutinesEnabled
 * @return Value of settings.routinesEnabled forced to a Boolean
 */
Boolean areRoutinesEnabled() {
	return booleanize(settings?.routinesEnabled)
}

/**
 * Evaluates a collection as a Boolean by considering the first value
 * @method booleanize
 * @param inValue  A collection for which the first element will be put through general booleanize()
 * @return Boolean coercion of input parameter
 */
Boolean booleanize(Collection inCollection) {
	def inValue
	if (inCollection != null && !inCollection.isEmpty() ) {
		inValue = inCollection[0]
	} else {
		inValue = "${inCollection}"
	}
	return booleanize(inValue)
}

/**
 * Evaluates a value as a boolean by first forcing to a string. If the string is either '1' or
 * 'true' (case insensitive), the return will be true (Boolean), otherwise false (Boolean)
 *  namely to avoid the fact that "false" == true
 *
 * @method booleanize
 * @param  inValue Any scalar value
 * @return		 Boolean evaluation of string representation of input parameter
 */
Boolean booleanize(def inValue) {
	Boolean outBoolean
	try {
		outBoolean = "$inValue".toBoolean()
	} catch (Exception ex) {
		outBoolean = false
	}
	return outBoolean
}

mappings {
	// list all available devices
	path("/discovery") {
		action:
		[
				GET: "discovery"
		]
	}

	// query the nominal state of the appliance
	path("/query/:id/:command") {
		action:
		[
				GET: "query"
		]
	}

	// turn devices on an off
	path("/control/:id/:command") {
		action:
		[
				POST: "control"
		]
	}

	// set devices to specific level
	path("/control/:id/:command/:value") { //
		action:
		[
				POST: "control"
		]
	}
}

def installed() {
	log.debug settings
	if (state?.recentInstall == null) {
		state.recentInstall = true
	}
	initialize()
}

def updated() {
	log.debug settings
	initialize()
}

def initialize() {
	log.debug "initialize"
	state.showLandingPage = false // we have been installed at this point
	if (!checkIfV1Hub()) {
		if (state.heartbeatDevices == null) {
			state.heartbeatDevices = [:]
		}
		runIn(1, deviceHeartbeatCheck)
		runEvery30Minutes(deviceHeartbeatCheck)
	}
}

/**
 * Returns a list of all available devices, and each device's supported information.
 * Currently supports switches and thermostats.
 *
 * @return a list of available devices and each device's supported information
 */
def discovery() {
	// removing isDeviceAllowed filtering for now - This is done on the backend for routines only
	// def switchList = getEnabledSwitches()?.findAll{isDeviceAllowed(it)}.collect {deviceItem(it)} ?: []
	def applianceList = []

	applianceList += getEnabledSwitches()?.collect { deviceItem(it) } ?: []
	applianceList += getEnabledThermostats()?.collect { deviceItem(it) } ?: []
	applianceList += getEnabledLocks()?.collect { deviceItem(it) } ?: []

	if (areRoutinesEnabled() || isBlanketAuthorized()) {
		def routines = location.helloHome?.getPhrases()
		if (routines) {
			// sort them alphabetically
			routines.sort()
			routines.each {
				applianceList << routineItem(it)
			}
		}
	} else {
		log.info "Routines disabled"
	}

	setupHeartbeat()

	log.debug "discovery ${applianceList}"

	// never a recent install after discovery completes once
	state.recentInstall = false

	// Format according to Alexa API
	[discoveredAppliances: applianceList]
}

/**
 * Queries a device attribute
 *
 * Supported commands:
 * 	-GetLockStateRequest - returns the current value of device.lock for a device with capability.lock
 *
 *  return 200 and JSON body with appropriate Amazon COHO error if applicable
 */
def query() {
	def data = request.JSON
	def response = [:]
	def command = params.command

	def device = getDevice(params.id)

	log.debug "query, params: ${params}, request: ${data}, devices: ${devices*.id} params.id: ${params?.id} params.command: ${params?.command} params.value: ${params?.value}"

	if (!command) {
		// TODO There might be a better error code for this in the future
		response << [error: "DriverInternalError", payload: [:]]
		log.error "Command missing"
	} else if (!device) {
		response << [error: "NoSuchTargetError", payload: [:]]
		log.error "Device ${params?.id} is not found"
	} else if (!checkDeviceOnLine(device)) {
		response << [error: "TargetOfflineError", payload: [:]]
		log.warn "$device is offline"
	} else {
		// Handle command
		switch (command) {
			case "GetLockStateRequest":
				getLockStateCommand(device, response)
				break;

			default:
				// TODO There might be a better error code for this in the future
				log.error "$command is an unknown command"
				response << [error: "DriverInternalError", payload: [:]]
		}
	}
	return response
}


/**
 * Sends a command to a device
 *
 * Supported commands:
 * 	-TurnOnRequest
 * 	-TurnOffRequest
 * 	-SetPercentageRequest  (level between 0-100)
 * 	-IncrementPercentageRequest  (+level adjustment, an adjustment resulting in a level >100 will set level to 100)
 *  -DecrementPercentageRequest  (-level adjustment, an adjustment resulting in a level < 0 will turn off switch)
 *  -SetTargetTemperatureRequest (expects temp in celcius, within allowed bounds if thermostat supports min/max attributes)
 *  -DecrementTargetTemperatureRequest (expects temp in celcius, within allowed bounds if thermostat supports min/max attributes)
 *  -IncrementTargetTemperatureRequest (expects temp in celcius, within allowed bounds if thermostat supports min/max attributes)
 *  -SetLockStateRequest (expects target lock value - only LOCKED is supported at present)
 *  return 200 and JSON body with appropriate Amazon COHO error if applicable
 */
def control() {
	def data = request.JSON
	def response = [:]
	def command = params.command

	def device = getDevice(params.id)

	// If device wasn't found, check if it is a routine (if routines are enabled)
	def routine = null
	if (device == null && (areRoutinesEnabled() || isBlanketAuthorized())) {
		routine = findRoutine(params.id)
	}

	log.debug "control, params: ${params}, request: ${data}, devices: ${devices*.id} params.id: ${params?.id} params.command: ${params?.command} params.value: ${params?.value}"

	if (!command) {
		// TODO There might be a better error code for this in the future
		response << [error: "DriverInternalError", payload: [:]]
		log.error "Command missing"
	} else if (!device && !routine) {
		response << [error: "NoSuchTargetError", payload: [:]]
		log.error "Device ${params?.id} is not found"
	} else if (!routine && !checkDeviceOnLine(device)) {
		response << [error: "TargetOfflineError", payload: [:]]
		log.warn "$device is offline"
	} else {
		// Set if command is to increase or decrease a value
		def changeValue = 0;
		// Set to -1 if command is to decrease, 1 if increase
		def changeSign = 1;

		// Handle command
		switch (command) {
			case "TurnOnRequest":
				onOffCommand(device, true, response, routine)
				break;
			case "TurnOffRequest":
				onOffCommand(device, false, response, routine)
				break;

			case "DecrementPercentageRequest":
				changeSign = -1;
			case "IncrementPercentageRequest":
				changeValue = Float.parseFloat(params.value)
			case "SetPercentageRequest":
				setPercentageCommand(device, params.value, changeValue, changeSign, response)
				break;

			case "DecrementTargetTemperatureRequest":
				changeSign = -1
			case "IncrementTargetTemperatureRequest":
				changeValue = Float.parseFloat(params.value)
			case "SetTargetTemperatureRequest":
				setTemperatureCommand(device, params.value, changeValue, changeSign, response);
				break;

			case "SetLockStateRequest":
				setLockStateCommand(device, params.value, response)
				break;

			default:
				// TODO There might be a better error code for this in the future
				log.error "$command is an unknown command"
				response << [error: "DriverInternalError", payload: [:]]
		}
	}
	return response
}

/**
 * Extract supported information for a device to return to the Echo
 *
 * @param it a device
 * @return a map with supported information about a device
 */
private deviceItem(it) {
	def actions = []
	if (it.hasCapability("Switch")) {
		actions.add "turnOn"
		actions.add "turnOff"
	}
	if (it.hasCapability("Switch Level")) {
		actions.add "incrementPercentage"
		actions.add "decrementPercentage"
		actions.add "setPercentage"
	}
	if (it.hasCapability("Thermostat")) {
		actions.add "incrementTargetTemperature"
		actions.add "decrementTargetTemperature"
		actions.add "setTargetTemperature"
	}
	if (it.hasCapability("Lock")) {
		actions.add "getLockState"
		actions.add "setLockState"
	}
	// Format according to Alexa API
	it ? [applianceId: it.id, manufacturerName: "SmartThings", modelName: it.name, version: "V1.0", friendlyName: it.displayName, friendlyDescription: createFriendlyText(it), isReachable: checkDeviceOnLine(it), actions: actions] : null
}

/**
 * Extract supported information for a routine to return to the Echo. Routine will appear like a button in Echo.
 *
 * @param it a routine
 * @return a map with supported information about routine
 */
private routineItem(it) {
	def actions = []
	def description = "SmartThings Routine"
	// Temporary workaround since "I'm Back!" is not recognized by Amazon Voice Model
	def label = it.label == "I'm Back!" ? "IAmBack": it.label
	if (it.hasSecureActions) {
		description = "SmartThings Routine (Disabled because it contains device(s) unsupported by Alexa)"
	}
	actions.add "turnOn"
	it ? [applianceId: it.id, manufacturerName: "SmartThings", modelName: "SmartThings", version: "V1.0", friendlyName: label , friendlyDescription: description, isReachable: true, actions: actions] : null
}

/**
 * Finds a routine with a specified id.
 *
 * @param id id of routine
 * @return routine or null if not found
 */
private findRoutine(id) {
	def routines = location.helloHome?.getPhrases()
	def routine = routines?.find {
		it.id == id
	}
	return routine
}

/**
 * Determine based on device type name what category it falls under (light, outlet, thermostat or unknown=device).
 *
 * @param displayName a device type name
 * @return Light , Outlet, Thermostat, Switch or Device
 */
private createFriendlyText(device) {
	// Friendly name prefix = SmartThings:
	def result = "SmartThings "

	if (device.hasCapability("Thermostat")) {
		result += "Thermostat"
	} else if (device.hasCapability("Lock")) {
		result += "Door Lock"
	} else if (device.hasCapability("Switch")) {
		// Strings indicating a device type is a light, see createFriendlyText()
		// dimmer should be checked for capability later once Amazon supports dimmer, for now call it light
		def lightStrings = ["light", "led", "bulb", "dimmer", "lamp"]

		def nameLowerCase = device.name ? device.name.toLowerCase() : ""

		if (nameLowerCase.contains("outlet")) {
			result += "Outlet"
		} else if (lightStrings.any { nameLowerCase.contains(it) }) {
			result += "Light"
		} else if (nameLowerCase.contains("switch")) {
			result += "Switch"
		} else {
			result += "Device"
		}

		if (device.hasCapability("Switch Level")) {
			result += " (dimmable)"
		}
	} else {
		result += "Unknown"
	}
	return result
}

/////////////// Temperature conversion ///////////////
def fToC(tempInF) {
	// T(°C) = (T(°F) - 32) × 5/9
	return ((tempInF - 32) * 5 / 9)
}

def cToF(tempInC) {
	// T(°F) = T(°C) × 9/5 + 32
	return tempInC * 9 / 5 + 32
}

def celsiusToLocationUnit(temp) {
	if (getTemperatureScale() == "F") {
		return (temp * 9 / 5 + 32) as Float
	}
	return temp
}

def toCelsius(temp) {
	if (getTemperatureScale() == "F") {
		return ((temp - 32) * 5 / 9) as Float
	}
	return temp
}

def toFahrenheit(temp) {
	if (getTemperatureScale() == "C") {
		return (temp * 9 / 5 + 32) as Float
	}
	return temp
}

/////////////// Commands ///////////////

/**
 * Turn on or off a device
 *
 * @param device a device to update
 * @param turnOn true if device should be turned on, false otherwise
 * @param response the response to modify according to result
 * @param routine if exists, will override device and instead run routine with this label
 */
def onOffCommand(device, turnOn, response, routine = null) {
	if (device) {
		if (turnOn) {
			log.debug "Turn on $device"
			if (device.currentSwitch == "on") {
				// Call on() anyways just in case platform is out of sync and currentLevel is wrong
				response << [error: "AlreadySetToTargetError", payload: [:]]
			}
			// This is a workaround for long running Harmony activities causing timeouts in lambda
			if (device.name?.equalsIgnoreCase("Harmony Activity")) {
				runIn(1, "runHarmony", [data: [id: "$device.id", command: "on"]])
			} else {
				device.on()
			}
		} else {
			log.debug "Turn off $device"
			if (device.currentSwitch == "off") {
				// Call off() anyways just in case platform is out of sync and currentLevel is wrong
				response << [error: "AlreadySetToTargetError", payload: [:]]
			}
			// This is a workaround for long running Harmony activities causing timeouts in lambda
			if (device.name?.equalsIgnoreCase("Harmony Activity")) {
				runIn(1, "runHarmony", [data: [id: "$device.id", command: "off"]])
			} else {
				device.off()
			}
		}
	} else if (routine) {
		// Stores the id of a routine if it contains secure actions and is executed
		// This is used to prevent more than one push notification for each routine to
		// warn the user that they are using restricted devices with Alexa
		if (state.routineNotifications == null) {
			state.routineNotifications = [:]
		}
		if (routine.hasSecureActions) {
			response << [error: "UnsupportedOperationError", payload: [:]]
			log.warn "$routine.label contains restricted devices, will not run"
			sendPush("Your $routine.label Routine was not activated because it contains locking or security devices unsupported by Alexa.")
			/* Disabled for now on Amazons requrest
			if (!state.routineNotifications[routine.id]) {
				state.routineNotifications[routine.id] = true
				sendPush("Your $routine.label Routine contains unsupported locking or security devices by Alexa. Those devices were not activated.")
			}
			runIn(1, "runRoutine", [data: [routine: "$routine.label"]])
			*/
		} else {
			state.routineNotifications[routine.id] = false
			runIn(1, "runRoutine", [data: [routine: "$routine.label"]])
		}
	}
}

/**
 * Set a level switch to a specific level or increase/decrease it
 *
 * @param device a device to update
 * @param value the new level to set to (if changeValue == 0, otherwise ignored)
 * @param changeValue the amount to increase or decrease the current level with
 * @param changeSign -1 if a level decrease, 1 if a level increase
 * @param response the response to modify according to result
 */
def setPercentageCommand(device, value, changeValue, changeSign, response) {
	Float newLevel = Float.parseFloat(value)

	if (changeValue != 0) {
		log.debug "Change $device level with ${changeValue * changeSign}"
	} else {
		log.debug "Set $device level to $newLevel"
	}

	if (!device.hasCapability("Switch Level")) {
		response << [error: DriverInternalError, payload: [:]]
		log.error "$device does not support this command"
	} else if (changeValue != 0) {
		newLevel = device.currentLevel
		// If device is off, brighten should start from 0 and not current value
		if (device.currentValue("switch") == "off") {
			newLevel = 0
		}
		newLevel += (changeValue * changeSign)

		if (newLevel > 100) {
			newLevel = 100
		} else if (newLevel < 0) {
			newLevel = 0
		}
		log.debug "Change $device to $newLevel (diff=${changeValue * changeSign}, currentValue=$device.currentLevel)"

		if (device.currentLevel == newLevel) {
			// Call setLevel anyways just in case platform is out of sync and currentLevel is wrong
			response << [error: "AlreadySetToTargetError", payload: [:]]
		}
		device.setLevel(newLevel)
	} else if (newLevel < 0 || newLevel > 100) {
		response << [error: "ValueOutOfRangeError", payload: [minimumValue: 0, maximumValue: 100]]
		log.error "Level $newLevel is outside of allowed range, (0-100)"
	} else {
		if (device.currentLevel == newLevel) {
			// Call setLevel anyways just in case platform is out of sync and currentLevel is wrong
			response << [error: "AlreadySetToTargetError", payload: [:]]
		}
		device.setLevel(newLevel)
	}
}

/**
 * Check if a temperature is within a thermostats allowed range
 *
 * @param device a device to check
 * @param temperature the requested temperature to check
 * @param response the response to modify according to result
 *
 * @result true if temperature is acceptable or thermostat does not provide min/max values
 */
def isTemperatureWithinRange(device, Float temperature, response) {
	Float min = null
	Float max = null
	Float minLimitF = 45
	Float maxLimitF = 90
	Float minLimitC = 8
	Float maxLimitC = 32

	switch (device.currentThermostatMode) {
		case "emergency heat":
		case "heat":
			if (device.currentMinHeatingSetpoint != null && device.currentMaxHeatingSetpoint != null) {
				min = device.currentMinHeatingSetpoint.floatValue()
				max = device.currentMaxHeatingSetpoint.floatValue()
			} else if (getTemperatureScale() == "F") {
				min = minLimitF
				max = maxLimitF
			} else {
				min = minLimitC
				max = maxLimitC
			}
			break;
		case "cool":
			if (device.currentMinCoolingSetpoint != null && device.currentMaxCoolingSetpoint != null) {
				min = device.currentMinCoolingSetpoint.floatValue()
				max = device.currentMaxCoolingSetpoint.floatValue()
			} else if (getTemperatureScale() == "F") {
				min = minLimitF
				max = maxLimitF
			} else {
				min = minLimitC
				max = maxLimitC
			}
			break;
		case "auto":
			if (device.currentMinCoolingSetpoint != null && device.currentMaxHeatingSetpoint != null) {
				min = device.currentMinCoolingSetpoint.floatValue()
				max = device.currentMaxHeatingSetpoint.floatValue()
			} else if (getTemperatureScale() == "F") {
				min = minLimitF
				max = maxLimitF
			} else {
				min = minLimitC
				max = maxLimitC
			}
			break;
	}

	if (min != max && (temperature < min || temperature > max)) {
		response << [error: "ValueOutOfRangeError", payload: [minimumValue: toCelsius(min), maximumValue: toCelsius(max)]]
		log.error "Temperature $temperature is outside of allowed range, ($min-$max)"
		return false
	}
	return true
}

/**
 * Set a thermostat to a specific temperature or increase/decrease it
 *
 * @param device a device to update
 * @param value the new temperature to set to in celsius (if changeValue == 0, otherwise ignored)
 * @param changeValue the temperature to increase or decrease the current level with in celsius
 * @param changeSign -1 if a temperature decrease, 1 if a temperature increase
 * @param response the response to modify according to result
 */
def setTemperatureCommand(device, value, changeValue, changeSign, response) {
	Float newTemp = Float.parseFloat(value)
	if (changeValue != 0) {
		log.debug "Change $device temperature with ${changeValue * changeSign}"
	} else {
		log.debug "Set $device temperature to $newTemp"
	}

	if (!device.hasCapability("Thermostat")) {
		response << [error: "DriverInternalError", payload: [:]]
		log.error "$device does not support this command"
	} else {
		log.debug "Mode: $device.currentThermostatMode TemperatureScale: ${getTemperatureScale()}"

		switch (device.currentThermostatMode) {
			case "emergency heat":
			case "heat":
				log.debug "currentHeatingSetpoint: $device.currentHeatingSetpoint currentThermostatSetpoint: $device.currentThermostatSetpoint"
				if (changeValue != 0) {
					if (getTemperatureScale() == "F")
						newTemp = cToF(fToC(device.currentHeatingSetpoint) + (changeValue * changeSign))
					else
						newTemp = device.currentHeatingSetpoint + (changeValue * changeSign)
				} else if (getTemperatureScale() == "F") {
					newTemp = cToF(newTemp)
				}
				newTemp = newTemp.round()

				if (newTemp == device.currentHeatingSetpoint) {
					response << [error: "AlreadySetToTargetError", payload: [:]]
				} else if (isTemperatureWithinRange(device, newTemp, response)) {
					log.debug "set to $newTemp (heat)"
					newTemp = newTemp.round()
					response << [targetTemperature: [value: "${toCelsius(newTemp)}"], temperatureMode: [value: "HEAT"]]
					device.setHeatingSetpoint(newTemp)
				}
				break;
			case "cool":
				log.debug "currentCoolingSetpoint: $device.currentCoolingSetpoint currentThermostatSetpoint: $device.currentThermostatSetpoint"
				if (changeValue != 0) {
					if (getTemperatureScale() == "F")
						newTemp = cToF(fToC(device.currentCoolingSetpoint) + (changeValue * changeSign))
					else
						newTemp = device.currentCoolingSetpoint + (changeValue * changeSign)
				} else if (getTemperatureScale() == "F") {
					newTemp = cToF(newTemp)
				}
				newTemp = newTemp.round()

				if (newTemp == device.currentCoolingSetpoint) {
					response << [error: "AlreadySetToTargetError", payload: [:]]
				} else if (isTemperatureWithinRange(device, newTemp, response)) {
					log.debug "set to $newTemp (cool)"
					response << [targetTemperature: [value: "${toCelsius(newTemp)}"], temperatureMode: [value: "COOL"]]
					device.setCoolingSetpoint(newTemp)
				}
				break;
			case "auto":
				log.debug "currentHeatingSetpoint: $device.currentHeatingSetpoint currentCoolingSetpoint: $device.currentCoolingSetpoint currentThermostatSetpoint: $device.currentThermostatSetpoint"
				if (changeValue != 0) {
					if (getTemperatureScale() == "F")
						newTemp = cToF(fToC(device.currentThermostatSetpoint) + (changeValue * changeSign))
					else
						newTemp = device.currentThermostatSetpoint + (changeValue * changeSign)
				} else if (getTemperatureScale() == "F") {
					newTemp = cToF(newTemp)
				}
				newTemp = newTemp.round()

				log.debug "set to $newTemp (auto)"
				if (newTemp == device.currentThermostatSetpoint) {
					response << [error: "AlreadySetToTargetError", payload: [:]]
				} else if (isTemperatureWithinRange(device, newTemp, response)) {
					response << [targetTemperature: [value: "${toCelsius(newTemp)}"], temperatureMode: [value: "AUTO"]]
					device.setHeatingSetpoint(newTemp)
					device.setCoolingSetpoint(newTemp)
				}
				break;
			case "off":
				response << [error: "UnwillingToSetValueError", payload: [errorInfo: [code: "ThermostatIsOff", description: "Thermostat is in Off mode"]]]
				log.warn "$device is Off"
				break;
			default:
				response << [error: "NotSupportedInCurrentModeError", payload: [currentDeviceMode: "OTHER"]]
				log.error "Unsupported thermostat mode"
		}
	}
}

@Field def lockPreviousState = null
@Field def lockCurrentState = null

private Boolean hasLockStateBeenUpdated(device) {
	if (!lockPreviousState) {
		recordLockPreviousState(device)
	}
	lockCurrentState = recordLockCurrentState(device)
	// log.debug "Previous: ${lockPreviousState?.getDate()}; Current: ${lockCurrentState?.getDate()}"
	if (lockCurrentState?.getDate() > lockPreviousState?.getDate()) {
		return true
	}
	return false
}

private def recordLockPreviousState(device) {
	lockPreviousState = device.currentState("lock")
}

private def recordLockCurrentState(device) {
	lockCurrentState = device.currentState("lock")
}

private String stLockStateToAmazon(lockState) {
	String amazonLockState
	lockState = lockState as String
	if (lockState.toLowerCase().startsWith("locked")) {
		amazonLockState = LOCK_LOCKED_STATE
	} else if (lockState.toLowerCase().startsWith("unlocked")) {
		amazonLockState = LOCK_UNLOCKED_STATE
	}
	log.debug "lock state is currently $lockState; returning $amazonLockState"
	return amazonLockState
}

def void getLockStateCommand(device, response) {
	// params.id, params
	def payload
	try {
		recordLockCurrentState(device)
		String lockState = lockCurrentState.getStringValue()
		String amazonLockState = stLockStateToAmazon(lockState)
		Date lockStateDate = lockCurrentState.getDate()
		def lockStateTimestamp = lockStateDate.getTime()
		payload = [lockState: [value: amazonLockState], stateTimestamp: [value: lockStateTimestamp]]
		log.debug "getLockStateCommand returning payload: $payload"
	} catch (Exception ex) {
		payload = [error: "DriverInternalError", payload: [:]]
		log.error "An error occurred in getLockStateCommand: ${ex}. Returning payload: $payload"
	}
	response << payload
}

def void setLockStateCommand(device, value, response) {
	Integer timeoutMs = 19000
	Integer startTime = now()
	def payload

	String lockLabel = device.getLabel()

	recordLockPreviousState(device)
	String amazonLockPreviousState = stLockStateToAmazon(lockPreviousState.getStringValue())

	log.debug "setLockState to $value"
	if (!amazonLockPreviousState) {
		// starting lock state is questionable
		payload = [error: "UnableToSetValueError", payload: [errorInfo: [code: [value: "HARDWARE_FAILURE"], description: [value: "The $lockLabel is in an unknown state. Please check it before retrying the command."]]]]
	} else if (VALID_LOCK_STATES.any {it == value}) {
		// target lock state is valid
		try {
			device.lock()
			Integer elapsedMs = 1
			Boolean lockStateUpdated = false
			while (elapsedMs < timeoutMs && !lockStateUpdated) {
				// update the loop conditions
				elapsedMs = now() - startTime
				lockStateUpdated = hasLockStateBeenUpdated(device)
				// log.debug "elapsed ms: $elapsedMs; updated lock state? $lockStateUpdated" // useful for debugging
			}

			if (!lockStateUpdated) {
				log.warn "We didn't get an updated device state before timeout"
			}

			// prepare the return payload
			String amazonLockCurrentState = stLockStateToAmazon(lockCurrentState.getStringValue())
			payload = [previousState: [lockState: [value: amazonLockPreviousState]], lockState: [value: amazonLockCurrentState]]
			log.info "Returning setLockStateResponse after $elapsedMs ms: $payload"
		} catch (Exception ex) {
			// handle and log unexpected error
			payload = [error: "DriverInternalError", payload: [:]]
			log.error "An error occurred while trying to set $lockLabel lock attribute to $value: ${ex}. Returning $payload"
		}
	} else {
		// target lock state is not valid
		payload = [error: "UnsupportedTargetSettingError", payload: [:]]
		log.error "Device $lockLabel cannot be set to $value: $payload"
	}
	response << payload
}

/**
 * Setup heartbeat service that will periodically poll heartbeat supported devices that have not been polled or checked in
 * in a timely manner.
 */
def setupHeartbeat() {
	// No heartbeat has previously been setup, initialize state
	if (state.heartbeatDevices == null) {
		state.heartbeatDevices = [:]
	}

	// Reset exists flag for all current heartbeat devices, used to see if previously existing devices have been removed
	state.heartbeatDevices?.each {
		it.value?.exists = false
	}

	// Setup device health poll, store a list of device ids and online status for all supported device type handlers
	// Devices are checked every 30 min, and offline devices are polled every 2h
	// (4 cycles of 30 min each, offline refresh() is done on cycle 0)
	getEnabledSwitches()?.each {
		def timeout = getDeviceHeartbeatTimeout(it)
		if (timeout > 0) {
			if (state.heartbeatDevices[it.id] != null) {
				state.heartbeatDevices[it.id].exists = true
			} else {
				state.heartbeatDevices[it.id] = [online: checkDeviceOnLine(it), timeout: timeout, exists: true, pollCycle: 0]
			// , label: it.label ?: it.name (useful for debugging)
			}
		}
	}

	// Remove heartbeat devices that we previously flagged as non existing
	def toRemove = state.heartbeatDevices?.find {!it.value?.exists}
	toRemove?.each {
	 	state.heartbeatDevices.remove(it.key)
	}
}

/**
 * Every 30 min cycle Amazon Echo SmartApp will for each heartbeat device:
 * 1. If device has been heard from in the last 25 min, mark as Online (it must have been polled by hub (every 15 min) or checked in (every 10 min))
 * 2. If device has been heard from in the last 25-35 min, mark as Online and send a refresh() (it was probably polled by Echo SmartApp so poll again
 *	to maintain device online, 30 min +-5 to account for delays in scheduler)
 * 3. if device was not heard from in the last 35 min but was heard from last cycle, mark it as Offline and send a refresh() in case status is wrong
 * 4. If devices was Offline last cycle, then try a refresh() every fourth cycle (i.e. 2h) for all devices marked as Offline
 */
def deviceHeartbeatCheck() {
	if (state.heartbeatDevices == null || state.heartbeatDevices.isEmpty()) {
		// No devices to check
		return
	}

	Calendar time25 = Calendar.getInstance()
	time25.add(Calendar.MINUTE, -25)

	Calendar time35 = Calendar.getInstance()
	time35.add(Calendar.MINUTE, -35)

	// Used to delay one second between polls, because issuing Z-wave commands to offline devices too fast can cause trouble
	def delayCounter = 0
	getEnabledSwitches()?.each {
		if (state.heartbeatDevices[it.id] != null) {
			// Previously, poll cycle was tracked by device so add it if not existing
			if (state.heartbeatDevices[it.id].pollCycle == null) {
				state.heartbeatDevices[it.id].pollCycle = 0
			}

			if (it.getLastActivity() != null) {
				Date deviceLastChecking = new Date(it.getLastActivity()?.getTime())
				if (deviceLastChecking?.after(time25.getTime())) {
					state.heartbeatDevices[it.id]?.online = true
				} else if (deviceLastChecking?.after(time35.getTime())) {
					state.heartbeatDevices[it.id]?.online = true
					if (it.hasCapability("Refresh")) {
						it.refresh([delay: delayCounter++ * 1000])
						log.debug "refreshing $it å(regular poll)"
					}
				} else {
					// Device did not report in, mark as offline and if cycle 0 or it was previously online, then issue a refresh() command
					def previousStatus = state.heartbeatDevices[it.id]?.online
					state.heartbeatDevices[it.id]?.online = false
					if ((previousStatus || state.heartbeatDevices[it.id].pollCycle == 0) && it.hasCapability("Refresh")) {
						it.refresh([delay: delayCounter++ * 1000])
						log.debug "refreshing $it (one time or first cycle) ($delayCounter)"
					}
				}
			} else {
				state.heartbeatDevices[it.id].online = false
			}
			state.heartbeatDevices[it.id].pollCycle = (state.heartbeatDevices[it.id].pollCycle + 1) % 4
		}
	}
}

/**
 * Check if device is a supported heartbeat device. If it is, will return the maximum time interval that the devices is expected to be heard from within.
 *
 * @param device device to get heartbeat timeout for
 * @return number of minutes after last activity that the device should be considered offline for, or 0 if no support for heartbeat
 */
 private getDeviceHeartbeatTimeout(device) {
	def timeout = 0
	String timeoutReason = ""
	try {
		String deviceTypeName = device.getTypeName()
		switch (deviceTypeName) {
			case "SmartPower Outlet": // works for US and UK SmartPower Outlets
			case "OSRAM LIGHTIFY LED Tunable White 60W": // by older, specific DH
				timeout = 35
				timeoutReason = "device type is $deviceTypeName"
				break
			case "Z-Wave Switch":
			case "Z-Wave Switch Generic":
			case "Dimmer Switch":
			case "Z-Wave Dimmer Switch Generic":
				def msr = "${device?.getZwaveInfo()?.mfr}-${device?.getZwaveInfo()?.prod}-${device?.getZwaveInfo()?.model}"
				if (msr != null) {
					switch (msr) {
						case "001D-1B03-0334":  // ZWAVE Leviton In-Wall Switch (dimmable) (DZMX1-1LZ)
						case "001D-1C02-0334":  // ZWAVE Leviton In-Wall Switch (non-dimmable) (DZS15-1LZ)
						case "001D-1D04-0334":  // ZWAVE Leviton Receptacle (DZR15-1LZ)
						case "001D-1A02-0334":  // ZWAVE Leviton Plug in Appliance Module (Non-Dimmable) (DZPA1-1LW)
						case "001D-1902-0334":  // ZWAVE Leviton Plug in Lamp Dimmer Module (DZPD3-1LW)
						case "0063-4952-3031":  // ZWAVE Jasco In-Wall Smart Outlet (12721)
						case "0063-4952-3033":  // ZWAVE Jasco In-Wall Smart Switch (Toggle Style) (12727)
						case "0063-4952-3032":  // ZWAVE Jasco In-Wall Smart Switch (Decora) (12722)
						case "0063-5052-3031":  // ZWAVE Jasco Plug-in Smart Switch (12719)
						case "0063-4F50-3031":  // ZWAVE Jasco Plug-in Outdoor Smart Switch (12720)
						case "0063-4944-3031":  // ZWAVE Jasco In-Wall Smart Dimmer (Decora) (12724)
						case "0063-4944-3032":  // ZWAVE Jasco In-Wall 1000 Watt Smart Dimmer (Decora) (12725)
						case "0063-4944-3033":  // ZWAVE Jasco In-Wall Smart Dimmer (Toggle Style) (12729)
						case "0063-5044-3031":  // ZWAVE Jasco Plug-in Smart Dimmer (12718)
						case "0063-4944-3034":  // ZWAVE Jasco In-Wall Smart Fan Control (12730)
							timeout = 60
							timeoutReason = "device type is $deviceTypeName and msr $msr is in the list of heartbeat supported devices"
							break
					}
				}
				break
		}

		// Check the Data
		if (timeout == 0 && (deviceTypeName.startsWith('ZigBee') || deviceTypeName.startsWith('ZLL'))) {
			String dataManufacturer = device.device?.getDataValue("manufacturer")
			String dataApplication = device.device?.getDataValue("application")
			String dataModel = device.device?.getDataValue("model")
			String dataEval = [dataManufacturer, dataApplication, dataModel].toString()
			switch (dataEval) {
				case ['OSRAM', '03', 'LIGHTIFY A19 Tunable White'].toString(): // US
					timeout = 35
					timeoutReason = "device type is a ZigBee device and product data is recognized ($dataEval)"
					break
			}
		}

		// Check DTHs with ambiguous names in type name
		if (timeout == 0) { // Still!
			switch (device.name) {
				case "OSRAM LIGHTIFY LED Tunable White 60W": // US
					timeout = 35
					timeoutReason = "$device.name is recognized to support heartbeat"
					break
			}
		}
	} catch (Exception e) {
		// Catching blanket exception here, only reason is that getData() above is dependent on privileged access and
		// we don't want to break device discovery if platform changes are made that breaks above code.
		log.error "Heartbeat device lookup failed: $e"
		timeoutReason = "heartbeat device lookup failed with an exception which has already been logged"
	}
	if (!timeoutReason.isEmpty()) {
		log.debug "Heartbeat timeout for $device.name is $timeout because $timeoutReason"
	}
	return timeout
}

/**
 * Determine if a device is online, temporary solution is to check only a restricted number of supported devices
 * for lastActivity time. If timestamp has been updated the last X min (depending on DTH expectations), then the device is
 * considered online.
 *
 * If device is found to be offline, report that back to Echo but issue a refresh() command in case device is actually
 * online. If status is indeed online, then if user tries again after a few seconds it will work.
 *
 * @param device
 * @return true if device is considered online or device heartbeat is not supported
 */
private checkDeviceOnLine(device) {
	// Default is true for all devices that don't support heartbeat
	boolean result = true

	// timeout interval in minutes (after this time device is considered offline)
	// if 0 then device type is not supported and online status will default to true
	def timeout = getDeviceHeartbeatTimeout(device)
	if (timeout != 0) {
		if (device.getLastActivity() == null) {
			// getLastActivity() == null means platform has not seen any activity for a long time and erased the field
			result = false
		} else {
			Calendar c = Calendar.getInstance()
			c.add(Calendar.MINUTE, -timeout)
			Date deviceLastChecking = new Date(device.getLastActivity()?.getTime())
			if (!deviceLastChecking.after(c.getTime())) {
				// No heartbeat found but expected
				// Send refresh in case device is actually online but just missed last poll
				if (device.hasCapability("Refresh")) {
					device.refresh()
				}
				result = false
			}
		}
	}

	return result
}

private boolean isDeviceAllowed(device) {
	// by device type name
	string deviceTypeName = device.getTypeName()
	boolean isDeviceExcludedByTypeName = DEVICE_TYPE_NAME_EXCLUSION_LIST.contains(deviceTypeName)
	def forbiddenCap = device.capabilities.find {
		DEVICE_CAPABILITY_EXCLUSION_LIST.contains(it.name)
	}

	if (isDeviceExcludedByTypeName || forbiddenCap != null) {
		String exclusionReason = isDeviceExcludedByTypeName?"type name $deviceTypeName":"capability $forbiddenCap.name"
		log.info "Device $device.displayName is excluded by $exclusionReason"
		return false
	}
	return true
}
/**
 * Checks if the current hub is V1 which we do not support heartbeat for
 * @return true if V1, false if newer model like V2 or TV
 */
private checkIfV1Hub() {
	boolean v1Found = false
	location.hubs.each {
		if ("$it.type".toUpperCase() == "PHYSICAL") {
			try {
				def id = Integer.parseInt(it.hub?.hardwareID, 16)
				if ((id >= 1 && id <= 5)) { // 1-5 are all V1 hubs
					v1Found = true
				}
			} catch (NumberFormatException e) {
				// Something went wrong with parsing, assume not V1 hub since we know that is a numeric value from 1-5
			}
		}
	}
	return v1Found
}

/**
 * Run a routine
 * @param input a map with value routine being routine label, e.g. [routine: "Good Night!"]
 */
def runRoutine(Map input) {
	log.debug "runRoutine ${input?.routine}"
	location.helloHome?.execute(input.routine, false, "Alexa", "Alexa")
}

/**
 * Run a harmony activity
 * @param input a map with id of device id and command, e.g. [id: "xx-yy", command: "on"]
 */
def runHarmony(Map input) {
	def device = getDevice(input?.id)
	if (input?.command == "on") {
		device?.on()
	} else {
		device?.off()
	}
}

/**
 * Find all switches the user has given Alexa access to, either by selecting specific switches or by selecting
 * allow all switches.
 *
 * @return a list of all switches accessible to Alexa
 */
private getEnabledSwitches() {
	if (isBlanketAuthorized()) {
		return findAllDevicesByCapability("switch")
	} else {
		return switches
	}
}

/**
 * Find all thermostats the user has given Alexa access to, either by selecting specific thermostats or by selecting
 * allow all thermostats.
 *
 * @return a list of all thermostats accessible to Alexa
 */
private getEnabledThermostats() {
	if (isBlanketAuthorized()) {
		return findAllDevicesByCapability("thermostat")
	} else {
		return thermostats
	}
}

/**
 * Find all locks the user has given Alexa access to, either by selecting specific locks or by selecting
 * allow all locks.
 *
 * @return a list of all locks accessible to Alexa
 */
private getEnabledLocks() {
	if (isBlanketAuthorized()) {
		return findAllDevicesByCapability("lock")
	} else {
		return locks
	}
}

/**
 * Find a specific device amongst all the devices the user has given access to in the SmartHome skill.
 *
 * (devices for custom skill will not be returned)
 *
 * @param id device's id
 * @return a device or null if device not found
 */
private getDevice(id) {
	// Start with switches which is the most common device
	def device = getEnabledSwitches()?.find {
		it.id == id
	}

	// If device not found, check next input
	if (!device) {
		device = getEnabledThermostats()?.find {
			it.id == id
		}
	}

	if (!device) {
		device = getEnabledLocks()?.find {
			it.id == id
		}
	}
	return device
}
