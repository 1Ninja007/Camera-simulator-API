package org.example.camera.repositories;

import java.time.LocalDate;

public class Image {
    private int id;
    private String fileName;
    private FileFormat fileFormat;
    private LocalDate takenDate;
    private double fileSize;
    private int iso;
    private String shutterSpeedLabel;
    private double aperture;
    private double focalLength;

    public Image(int id, FileFormat fileFormat, LocalDate takenDate, double focalLength, double fileSize, double aperture, ShutterSpeed shutterSpeed, int iso) {
        this.id = id;
        this.fileName = String.format("DSCF_%04d.",  id) + String.valueOf(fileFormat).toLowerCase();
        this.fileFormat = fileFormat;
        this.takenDate = takenDate;
        this.fileSize = fileSize;
        this.iso = iso;
        this.shutterSpeedLabel = shutterSpeed.getLabel();
        this.aperture = aperture;
        this.focalLength = focalLength;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getId() {
        return id;
    }

    public String getFileName() {
        return fileName;
    }

    public FileFormat getFileFormat() {
        return fileFormat;
    }

    public LocalDate getTakenDate() {
        return takenDate;
    }

    public double getFileSize() {
        return fileSize;
    }

    public int getIso() {
        return iso;
    }

    public String getShutterSpeedLabel() {
        return shutterSpeedLabel;
    }

    public double getAperture() {
        return aperture;
    }

    public double getFocalLength() {
        return focalLength;
    }
}
