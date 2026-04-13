package org.example.camera.repositories;

import java.time.LocalDate;

public class Image {
    private int id;
    private String fileName;
    private FileFormat fileFormat;
    private LocalDate takenDate;
    private double fileSize;
    private double aperture;
    private String shutterSpeedLabel;
    private double focalLength;
    private int iso;

    public Image(int id, FileFormat fileFormat, LocalDate takenDate, double focalLength, double fileSize, double aperture, ShutterSpeed shutterSpeed, int iso) {
        this.id = id;
        this.fileName = String.format("DSCF_%04d.",  id) + String.valueOf(fileFormat).toLowerCase();
        this.fileFormat = fileFormat;
        this.takenDate = takenDate;
        this.fileSize = fileSize;
        this.aperture = aperture;
        this.shutterSpeedLabel = shutterSpeed.getLabel();
        this.focalLength = focalLength;
        this.iso = iso;
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

    public double getAperture() {
        return aperture;
    }

    public String getShutterSpeedLabel() {
        return shutterSpeedLabel;
    }

    public double getFocalLength() {
        return focalLength;
    }

    public int getIso() {
        return iso;
    }
}
