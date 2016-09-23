package com.company.main.contracts;

public interface AsynchDownloader extends Downloader {
    void downloadOnNewThread(String fileUrl);
}
