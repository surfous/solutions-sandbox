
var ST_HOSTNAME = "graph.api.smartthings.com";

var HTTP_PORT = 443;

/**
 * Request a user's specific installation ID of a Web Service SmartApp
 * @param  String accessToken 	OAUTH2 Access Token
 * @param  String smartappIdeClientId 	Client ID of the SmartApp code from the IDE; not specific to any one user
 * @return Map             http(s) request object
 */
function getSmartAppPathOptions(accessToken, smartappIdeClientId) {
    var smartAppUrl = '/api/smartapps/endpoints/' + smartappIdeClientId;
    return {
        hostname: ST_HOSTNAME,
        port: 443,
        path: smartAppUrl,
        method: 'GET',
        headers: {accept: '*/*', Authorization: 'Bearer ' + accessToken}
    };
}

// Resolve the correct SmartApp URL using the client id and access token
// Each user's Amazon Echo SmartApp has its own URL
// When successful, call the resultCallback(event, context, URL) function
function getSmartAppPath(event, context, resultCallback) {
    log("getSmartAppPath", "");
    //var accessToken = event.payload.accessToken.trim();
    var accessToken = getAccessTokenFromEvent(event);

    var options = getSmartAppPathOptions(accessToken);

    callback = function (response) {
        var str = '';

        response.on('data', function (chunk) {
            str += chunk;
        });
        response.on('error', function (e) {
            log("getSmartAppPath", e.message);
            sendErrorResponseV1(context, event, INTERNAL_ERROR, "Unknown error when identifying the SmartApp: " + e.message);
        });
        response.on('end', function () {
            log("getSmartAppPath", "response statusCode: " + response.statusCode);

            var json = parseResponseCheckForError(event, context, str);
            if (json !== null) {
                log("getSmartAppPath", "Got "+json.length+" SmartApps");
                var index = json.length - 1;
                // TODO Deal with multiple locations!!
                if (json[index] != null && json[index].url != null) {
                    // TODO change to 0?
                    log("getSmartAppPath", "SmartApp URL is " + json[index].url);

                    // Url will be in format '/api/smartapps/installations/5a2843e2-49e1-4be5-9564-39db029ec961'
                    // extract the id
                    resultCallback(event, context, json[index].url.substring(json[index].url.lastIndexOf('/') + 1), json[index].base_url);
                } else if (str = "[]") {
                    // No endpoints found but token was valid, this most likely means that the SmartApp has been uninstalled
                    // Would it make more sense to send INTERNAL_ERROR?
                    log("getSmartAppPath", "SmartApp might have been uninstalled");
                    sendErrorResponseV1(context, event, INVALID_ACCESS_TOKEN, "SmartApp has been uninstalled, user should relink with SmartThings");
                } else {
                    log("getSmartAppPath", "Unexpected response");
                    sendErrorResponseV1(context, event, INTERNAL_ERROR, "Unexpected response received while identifying SmartApp");
                }
            } else {
                log("getSmartAppPath", "response (expected JSON but did not get it): " + str);
            }
        });
    };
    logNetwork("lambda->SmartApp getSmartAppPath", options);
    var req = http.get(options, callback).end();
}
