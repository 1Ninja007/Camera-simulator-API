package org.example.camera;

import org.example.camera.repositories.CameraMode;
import org.example.camera.repositories.FileFormat;
import org.example.camera.repositories.Image;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class CameraController {
    private final CameraService cameraService;

    public CameraController(CameraService camera) {
        this.cameraService = camera;
    }

    @GetMapping("/download")
    public ArrayList<Image> getAllPhotos() {
        return cameraService.getAllPhotos();
    }

    @PostMapping("/shutter")
    public Image takePhoto() {
        cameraService.takePhoto();
        System.out.println(cameraService.getCamera().getMode());
        return cameraService.getCamera().getGallery().getLast();
    }

    @PutMapping("/mode/{mode}")
    public void changeMode(@PathVariable String mode) {
        if(Objects.equals(mode, "manual")) {
            this.cameraService.setMode(CameraMode.MANUAL);
        }
        else if(Objects.equals(mode, "auto")) {
            this.cameraService.setMode(CameraMode.ALL_AUTO);
        }
        else if(Objects.equals(mode, "iso")) {
            this.cameraService.setMode(CameraMode.AUTO_ISO);
        }
        else if(Objects.equals(mode, "aperture")) {
            this.cameraService.setMode(CameraMode.AUTO_APERTURE);
        }
        else if (Objects.equals(mode, "shutterspeed")) {
            this.cameraService.setMode(CameraMode.AUTO_SHUTTER_SPEED);
        }
    }

    @PutMapping("/file/{file}")
    public void changeFileFormat(@PathVariable String file) {
        if(file.equals("raf")) {
            this.cameraService.setCurrentFileFormat(FileFormat.RAF);
        }
        else if(file.equals("jpg")) {
            this.cameraService.setCurrentFileFormat(FileFormat.JPG);
        }
    }

    @PutMapping("/aperture/{value}")
    public void setAperture(@PathVariable double value) {
        this.cameraService.setManualAperture(value);
    }

    @PutMapping("/iso/{value}")
    public void setIso(@PathVariable int value) {
        this.cameraService.setManualIso(value);
    }

    @PutMapping("/shutterspeed/{value}")
    public void setShutterSpeed(@PathVariable double value) {
        this.cameraService.setManualShutterSpeed(value);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id) {
        cameraService.deletePhotoById(id);
    }

    @DeleteMapping("/delete")
    public void deleteAll() {
        cameraService.deleteAllPhotos();
    }
}
