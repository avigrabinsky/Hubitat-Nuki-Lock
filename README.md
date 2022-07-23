# Hubitat driver for Nuki Smart Lock

This driver integrates Nuki smart locks with Hubitat.
To use the driver, make sure to connect Nuki lock to Nuki Web service via a Nuki bridge or via an integrated WiFi.
The driver was tested with Nuki Smart Lock 3.0 Pro, but should work with any Nuki lock connected to Nuki web service.

To start using the driver, follow the instructions below.

 Instructions:
  1. Add driver to Hubitat: on your Hubitat web interface, go to "Drivers code", click on "New Driver", copy and paste the "nuki-lock.groovy" file content and hit Save.  
  
  Connecting to Nuki Web service:
  2. In the Nuki App, go to "manage my devices" -> Smart Lock -> choose your lock -> "Features & Configuration" -> "Manage Nuki Web". 
  3. Follow the instructions and register to the service.
  
  Creating an API Token:
  5. Go to https://web.nuki.io/#/pages/web-api
  6. Under "API tokens", click on "Generate API token", provide a name, click "Save" and copy the token
  7. On the Hubitat Nucky lock driver page, under "Preferences", paste the token you copied on step 2, into "API Token" parameter.
  8. Click "Save preferences"

Special thanks to Hubitat community (https://community.hubitat.com/) for assisting.
