package org.example.camera;

import org.example.camera.repositories.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class CameraService {
    private final Camera camera;
    private final AtomicInteger idCounter = new AtomicInteger(1);

    public CameraService() {
        this.camera = new Camera(35, -0.33, 128);
    }

    public void takePhoto(){
        if(camera.getMode() == CameraMode.ALL_AUTO){
            setAutoIso();
            setAutoAperature();
            setAutoShutterSpeed();
        }

        Random rand = new Random();

        double size = Math.round(rand.nextDouble(2) * 100.0) / 100.0;
        if(camera.getOccupiedSpace() + size < camera.getSdSize() && camera.getBattery() > 5) {
            camera.addToOccupiedSpace(size);
            camera.loseBattey(rand.nextDouble(3));

            camera.addPhoto(new Image(
                    idCounter.getAndIncrement(),
                    camera.getCurrentFileFormat(),
                    LocalDate.now(),
                    camera.getFocalLength(),
                    size,
                    camera.getAperture(),
                    new ShutterSpeed(camera.getShutterSpeed().getValue()),
                    camera.getIso()));
        }
    }

    public void setMode(CameraMode mode) {
        camera.setMode(mode);
    }

    public void setCurrentFileFormat(FileFormat currentFileFormat) {
        camera.setCurrentFileFormat(currentFileFormat);
    }

    public void deletePhotoById(int id) {
        camera.getGallery().removeIf(photo -> photo.getId() == id);
    }

    public void deleteAllPhotos() {
        camera.getGallery().clear();
    }

    public ArrayList<Image> getAllPhotos() {
        return camera.getGallery();
    }

    public void setManualIso(int iso) {
        if(camera.getMode() != CameraMode.AUTO_ISO) {
            camera.setIso(iso);

            if (camera.getMode() == CameraMode.AUTO_SHUTTER_SPEED) {
                setAutoShutterSpeed();
            }

            if (camera.getMode() == CameraMode.AUTO_APERTURE) {
                setAutoAperature();
            }
        }
    }

    public void setManualAperture(double aperture) {
        if(camera.getMode() != CameraMode.AUTO_APERTURE) {
            camera.setAperture(aperture);

            if (camera.getMode() == CameraMode.AUTO_ISO) {
                setAutoIso();
            }

            if (camera.getMode() == CameraMode.AUTO_SHUTTER_SPEED) {
                setAutoShutterSpeed();
            }
        }
    }

    public void setManualShutterSpeed(double shutterSpeed) {
        if(camera.getMode() != CameraMode.AUTO_SHUTTER_SPEED) {
            camera.setShutterSpeed(shutterSpeed);

            if(camera.getMode() == CameraMode.AUTO_ISO) {
                setAutoIso();
            }

            if(camera.getMode() == CameraMode.AUTO_APERTURE) {
                setAutoAperature();
            }
        }
    }

    public void setAutoIso(){
        Random rand = new Random();
        int id = rand.nextInt(camera.possibleIso.size());
        camera.setIso(camera.possibleIso.get(id));
    }

    public void setAutoAperature(){
        var rand = new Random();
        int id = rand.nextInt(camera.possibleAperature.size());
        camera.setAperture(camera.possibleAperature.get(id));
    }

    public void setAutoShutterSpeed() {
        Random rand = new Random();
        var a = new ArrayList<Integer>();
        int id = rand.nextInt(camera.getShutterSpeed().shutterValues.size());
        camera.getShutterSpeed().set(camera.getShutterSpeed().shutterValues.get(id));
    }

    public Camera getCamera() {
        return camera;
    }
}
