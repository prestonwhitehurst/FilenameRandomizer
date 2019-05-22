package com.resmagnus.filenamerandomizer;

import java.io.File;

public class FilenameRandomizerModel {
    private File folder;
    private File[] files;

    public void setFolder(File folder) {
        this.folder = folder;
        setFiles(folder.listFiles());
    }

    public File getFolder() {
        return folder;
    }

    public void setFiles(File[] files) {
        this.files = files;
    }

    public File[] getFiles() {
        return files;
    }
}