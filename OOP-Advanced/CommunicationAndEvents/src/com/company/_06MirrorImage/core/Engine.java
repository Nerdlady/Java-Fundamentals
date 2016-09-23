package com.company._06MirrorImage.core;


import com.company._06MirrorImage.creators.IdCreator;
import com.company._06MirrorImage.interfaces.Executor;
import com.company._06MirrorImage.interfaces.Wizard;
import com.company._06MirrorImage.models.WizardImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Engine {

    private Executor executor;
    BufferedReader reader;
    public Engine(Executor executor) {
        this.executor = executor;
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void run() throws IOException {
        createFirstWizard();

        while (true) {
            String[] input = reader.readLine().split("\\s+");
            if (input[0].equals("END")){
                break;
            }
            this.executor.execute(input);
        }
    }

    private void createFirstWizard() throws IOException {

        String[] rootWizardData = this.reader.readLine().split("\\s+");
        String rootWizardName = rootWizardData[0];
        int rootWizardPower = Integer.valueOf(rootWizardData[1]);

        Wizard rootWizard = new WizardImpl( rootWizardName,IdCreator.nextId(), rootWizardPower);
        WizardData.getInstance().addWizard(rootWizard);
    }
}
