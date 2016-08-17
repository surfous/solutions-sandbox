/**
 *  Copyright 2016 SmartThings
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *	  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 */
metadata {

	definition (name: "Simulated Camera", namespace: "smartthings/testing", author: "SmartThings") {
		capability "Switch"
		capability "Video Camera"
		capability "Video Capture"
	}

	tiles {
		standardTile("switch", "device.switch", width: 2, height: 2, canChangeIcon: true) {
			state "off", label: '${currentValue}', action: "switch.on", icon: "st.switches.switch.off", backgroundColor: "#ffffff"
			state "on", label: '${currentValue}', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#79b821"
		}
		standardTile("on", "device.switch", decoration: "flat") {
			state "default", label: 'On', action: "switch.on", backgroundColor: "#ffffff"
		}
		standardTile("off", "device.switch", decoration: "flat") {
			state "default", label: 'Off', action: "switch.off", backgroundColor: "#ffffff"
		}
		main "switch"
		details(["switch","on","off"])
	}
}

def parse(String description) {
	def pair = description.split(":")
	createEvent(name: pair[0].trim(), value: pair[1].trim())
}

def on() {
	log.debug "$version on()"
	sendEvent(name: "switch", value: "on")
}

def off() {
	log.debug "$version off()"
	sendEvent(name: "switch", value: "off")
}

private getVersion() {
	"1.0"
}
