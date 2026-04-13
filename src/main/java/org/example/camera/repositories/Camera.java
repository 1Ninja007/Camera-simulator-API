package org.example.camera.repositories;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Camera {
    private double focalLength;
    private int battery;
    private final int sdSize;
    private double occupiedSpace;

    private FileFormat currentFileFormat;

    private double preferableExposure;
    private double currentExposure;
    private double aperture;
    private ShutterSpeed shutterSpeed;
    private int iso;

    private CameraMode mode;
    private ArrayList<Image> gallery;

    public final ArrayList<Integer> possibleIso = new ArrayList<>(Arrays.asList(160, 200, 250, 320, 400, 500, 640, 800, 1000, 1250,
            1600, 2000, 2500, 3200, 4000, 5000, 6400, 8000, 10000, 12800));
    public final ArrayList<Double> possibleAperature = new ArrayList<Double>(Arrays.asList(2.0, 2.2, 2.5, 2.8, 3.2, 3.6, 4.0, 4.5,
            5.0, 5.6, 6.4, 7.1, 8.0, 9.0, 10.0, 11.0, 13.0, 14.0, 16.0));


    public Camera(double focalLength, double preferableExposure, int sd) {
        this.focalLength = focalLength;
        this.sdSize = sd;
        this.occupiedSpace = 0;

        this.preferableExposure = preferableExposure;
        this.battery = 100;
        this.mode = CameraMode.ALL_AUTO;

        this.aperture = 2;
        this.shutterSpeed = new ShutterSpeed(0.008);
        this.iso = 200;
        this.currentFileFormat = FileFormat.JPG;

        this.gallery = new ArrayList<>();


        updateCurrentExposure();
    }

    private void updateCurrentExposure() {
        Random rand = new Random();

        this.currentExposure = (rand.nextInt(19) / 3.0) - 3.0;
    }

    public double getFocalLength() {
        return focalLength;
    }

    public int getBattery() {
        return battery;
    }

    public int getSdSize() {
        return sdSize;
    }

    public double getOccupiedSpace() {
        return occupiedSpace;
    }

    public FileFormat getCurrentFileFormat() {
        return currentFileFormat;
    }

    public double getPreferableExposure() {
        return preferableExposure;
    }

    public double getCurrentExposure() {
        return currentExposure;
    }

    public double getAperture() {
        return aperture;
    }

    public ShutterSpeed getShutterSpeed() {
        return shutterSpeed;
    }

    public int getIso() {
        return iso;
    }

    public CameraMode getMode() {
        return mode;
    }

    public ArrayList<Image> getGallery() {
        return gallery;
    }

    public void setCurrentFileFormat(FileFormat currentFileFormat) {
        this.currentFileFormat = currentFileFormat;
    }

    public void setPreferableExposure(double preferableExposure) {
        this.preferableExposure = preferableExposure;
    }

    public void setAperture(double aperture) {
        this.aperture = aperture;
    }

    public void setShutterSpeed(double shutterSpeed) {
        this.shutterSpeed.set(shutterSpeed);
    }

    public void setIso(int iso) {
        this.iso = iso;
    }

    public void setMode(CameraMode mode) {
        this.mode = mode;
    }

    public void addToOccupiedSpace(double occupiedSpace) {
        this.occupiedSpace += occupiedSpace;
    }

    public void loseBattey(double percentage) {
        this.battery -= percentage;
    }

    public void addPhoto(Image image) {
        this.gallery.add(image);
    }
}
