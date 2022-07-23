# Hubitat driver for Nuki Smart Lock

This driver integrates Nuki locks with Hubitat.
The Nuki lock must be connected to Nuki web service via a Nuki bridge or via an integrated WiFi support.
The driver was tested with Nuki Lock 3.0 Pro, but should work with any Nuki lock connected to Nuki web service.

To start using the lock, you first need to generate an API token on Nuki web service, see instructions below.

 Instructions:
  1. Add driver to Hubitat: on your Hubitat web interface, go to "Drivers code", click on "New Driver", copy and past the "Nuki-lock" code and Save.  
 Creating an API Token:
  2. Go to https://web.nuki.io/#/pages/web-api
  3. Under "API tokens", click on "Generate API token", provide a name, click "Save" and copy the token
  4. On the Hubitat Nucky lock driver page, under "Preferences", paste the token you copied on step 2, into "API Token" parameter.
  5. Click "Save preferences"

Special thanks to Hubitat community (https://community.hubitat.com/) for assisting.
