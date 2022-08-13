/*
 * Nuki Lock driver
 *
 * Uses Nuki Cloud API for lock or unlock
 * 
 * To start using the lock, you need to first generate API token with Nuki, see instructions below.
 *
 * Follow the instructions on the ReadMe file
 *
 * Writeen by Avi Grabisnky
 *
 */
import groovy.json.JsonSlurper

metadata {
    definition(name: "Nuki Lock", namespace: "community", author: "Avi Grabinsky") {
        capability "Actuator"
        capability "Lock"
        capability "Sensor"
    }
}

preferences {
    section("Nuki numbers") { 
        input "Token", "text", title: "API token", required: true
        input name: "logEnable", type: "bool", title: "Enable debug logging", defaultValue: false
    }
}

def updated(){
    def obs = [:]
    log.warn "installed..."
    /* get Nuki lock id */
    def params = [
        uri: "https://api.nuki.io/smartlock/",
        headers: [Authorization: "Bearer ${settings.Token}"],
        contentType: "application/json"
    ]
    try {
        httpGet(params) { resp ->
            if (resp.success) { 
                device.updateSetting("LockID",[type:"integer",value:resp.data.smartlockId[0]])
            }
            if (logEnable)
                if (resp.data) log.debug "LockID: ${LockID}"
        }
    } catch (Exception e) {
        log.warn "Call to lock failed: ${e.message}"
    }
}

def logsOff() {
    log.warn "debug logging disabled..."
    device.updateSetting("logEnable", [value: "false", type: "bool"])
}

def parse(String description) {
    if (logEnable) log.debug(description)
}

def lock() {
    if (logEnable) log.debug "Sending POST request for locking"
  
    def params = [
        uri: "https://api.nuki.io/smartlock/${settings.LockID}/action/lock",
        headers: [Authorization: "Bearer ${settings.Token}"],
        contentType: "application/json",  
        textParser: true
    ]
    try {
        httpPost(params) { resp ->
            if (resp.success) {
                sendEvent(name: "Lock", value: "locked", isStateChange: true)
            }
            if (logEnable)
                if (resp.data) log.debug "${resp.data}"
        }
    } catch (Exception e) {
        log.warn "Call to lock failed: ${e.message}"
    }
}

def unlock() {
    if (logEnable) log.debug "Sending POST request for unlocking"
    def params = [
        uri: "https://api.nuki.io/smartlock/${settings.LockID}/action/unlock",
        headers: [Authorization: "Bearer ${settings.Token}"],
        contentType: "application/json",  
        textParser: true
    ]
    try {
        httpPost(params) { resp ->
            if (resp.success) {
                sendEvent(name: "Lock", value: "unlocked", isStateChange: true)
            }
            if (logEnable)
                if (resp.data) log.debug "${resp.data}"
        }
    } catch (Exception e) {
        log.warn "Call to unlock failed: ${e.message}"
    }
}
