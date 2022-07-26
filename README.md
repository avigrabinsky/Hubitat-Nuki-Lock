# Hubitat driver for Nuki Smart Lock

This driver integrates Nuki smart locks with Hubitat.
The driver was tested with Nuki Smart Lock 3.0 Pro, but should work with any Nuki lock connected to Nuki web service.

To start using the driver, follow these instructions:
 
  1. Add driver to Hubitat: on your Hubitat web interface, go to "Drivers code", click on "New Driver", copy and paste the "nuki-lock.groovy" file content and hit Save.  
  
  Connecting your lock to Nuki Web service (requires a Nuki bridge or an integrated WiFi):
  
  2. In the Nuki App, go to "manage my devices" -> Smart Lock -> choose your lock -> "Features & Configuration" -> "Manage Nuki Web". 
  3. Follow the instructions and register to the service.
  
  Creating an API Token:
  
  4. Go to https://web.nuki.io/#/pages/web-api
  5. Under "API tokens", click on "Generate API token", provide a name, click "Save" and copy the token
  6. On the Hubitat Nuki lock driver page, under "Preferences", paste the token you copied on the previous step, into "API Token" parameter.
  7. Click "Save preferences"

Special thanks to Hubitat community (https://community.hubitat.com/) for assisting.
