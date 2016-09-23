package com.company.main.io.commands;

import com.company.main.annotations.Alias;
import com.company.main.annotations.Inject;
import com.company.main.contracts.*;

@Alias("download")
public class DownloadFileCommand extends Command implements Executable {

    @Inject
    private AsynchDownloader downloader;

    public DownloadFileCommand(String input, String[] data) {
        super(input, data);
    }

    @Override
    public void execute() throws Exception {
        String[] data = this.getData();
        if (this.checkLenght(2)) {
            String fileUrl = data[1];
            this.downloader.download(fileUrl);
        }
    }
}
