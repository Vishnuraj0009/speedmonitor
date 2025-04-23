1. Key Requirements
- Speed limit per rental set by the fleet company.

- Per-customer configuration.

- Speed monitoring during the rental.

- Alerts to the driver on over-speed.

- Notifications to the company via Firebase

  2. Android Automotive App Interface
- Service Layer: For continuous speed monitoring using the CarSensorManager.

- UI Layer: To display driver alerts and rental information.

- Backend Communication: Send notifications via Firebase


3. App Architecture
  +-------------------------+
|  Rental Configuration   |
| - Customer ID          |
| - Speed Limit (km/h)   |
+-------------------------+
            |
            v
+-------------------------+
|  Speed Monitoring       |
| - CarSensorManager      |
| - Location/GPS (if needed)|
+-------------------------+
            |
  Exceeds Speed Limit?
        /     \
     Yes       No
     |           |
     v           v
+----------------------------+       +-------------------------+
|  Alert Driver (UI Alert)   |       |      Continue Monitor   |
+----------------------------+       +-------------------------+
            |
            v
+-----------------------------+
| Notify Backend (Firebase)  |
+-----------------------------+

4. Project Structure

com.example.speedmonitor
├── MainActivity.java
├── SpeedMonitorService.java
├── RentalConfig.java
├── FirebaseNotifier.java
├── AlertUtils.java
├── AndroidManifest.xml




