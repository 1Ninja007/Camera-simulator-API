# Camera-simulator-API
It’s a Java and Spring Boot-based REST API, built with Maven, that simulates the real digital camera. User can take simulated photos, download the whole gallery, changing basic settings or switch between different shooting modes. This application also simulates battery level and memory card capacity.

## How to run
In desired directory paste the commands listed below:
```bash
git clone https://github.com/1Ninja007/Camera-simulator-API.git
cd Camera-simulator-API
./mvnw spring-boot:run
```

## Features
* **Take photos:** posts the object imitating single image.
* **Download the gallery:** gets list of all images in the gallery.
* **Change shooting mode:** chooses from all manual mode, all auto, manual ISO, manual shutter speed, manual aperture. In all modes the auto parameters are set randomly.
* **Set exposure triangle:** sets manually chosen parameter (ISO, shutter speed, aperture).
* **Change file format:** chooses .jpg or .raw file format.
* **Simulating battery and SD memory:** each taken photo lowers the battery percentage and takes up memory.
* **Delete unwanted photos:** deletes chosen photo from the gallery.

## Available endpoints
| HTTP METHOD |          ENDPOINT           |                                                                                                                 DESCRIPTION                                                                                                                 |
|:-----------:|:---------------------------:|:-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|
|    POST     |       `/api/shutter`        |                                                               triggers the shutter to take a photo and returns new `Image` object with set or randomly generated parameters.                                                                |
|     GET     |       `/api/download`       |                                                                                              returns a list of all taken photos (`Image` list)                                                                                              |
|     PUT     |     `/api/mode/{mode}`      |                                                                         sets the camera mode from available: `manual`, `auto`, `iso`, `shutterspeed`  , `aperture`                                                                          |
|     PUT     |     `/api/iso/{value}`      |                      manually sets ISO value from available: `160`, `200`, `250`, `320`, `400`, `500`, `640`, `800`, `1000`, `1250`, `1600`, `2000`, `2500`, `3200`, `4000`, `5000`, `6400`, `8000`, `10000`, `12800`                       |
|     PUT     | `/api/shutterspeed/{value}` | manually sets shutter speed value from available: `0.00025`, `0.0005`, `0.001`, `0.002`, `0.004`, `0.008`, `0.016`, `0.033`, `0.066`, `0.125`, `0.25`, `0.5`, `1.0`, `2.0`, `4.0`, `8.0`, `15.0`, `30.0`, `60.0`, `120.0`, `300.0`, `900.0` |
|     PUT     |   `/api/aperture/{value}`   |                            manually sets aperture value from available: `2.0`, `2.2`, `2.5`, `2.8`, `3.2`, `3.6`, `4.0`, `4.5`, `5.0`, `5.6`, `6.4`, `7.1`, `8.0`, `9.0`, `10.0`, `11.0`, `13.0`, `14.0`, `16.0`                            |
|     PUT     |     `/api/file/{file}`      |                                                                                          sets the camera file format from available: `raf`, `jpg`                                                                                           |
|   DELETE    |     `/api/delete/{id}`      |                                                                                                 deletes a photo by its ID from the gallery                                                                                                  |
|   DELETE    |        `/api/delete`        |                                                                                                     deletes all photos from the gallery                                                                                                     |

## Image format example
```JSON
{
  "id": 0,
  "fileFormat": "JPG",
  "takenDate": "2026-04-13",
  "focalLength": 35.0,
  "fileSize": 1.59,
  "aperture": 5.6,
  "iso": 200,
  "fileName": "DSCF_0001.jpg",
  "shutterSpeedLabel": "1/125"
}
```