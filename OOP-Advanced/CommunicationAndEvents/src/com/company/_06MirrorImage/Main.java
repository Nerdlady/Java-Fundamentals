package com.company._06MirrorImage;

import com.company._06MirrorImage.core.CommandExecutor;
import com.company._06MirrorImage.core.Engine;
import com.company._06MirrorImage.creators.SpellCreator;
import com.company._06MirrorImage.creators.WizardCreator;
import com.company._06MirrorImage.interfaces.Executor;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        WizardCreator wizardCreator = new WizardCreator();
        SpellCreator spellCreator = new SpellCreator();
        Executor executor = new CommandExecutor(spellCreator);

        Engine engine = new Engine(executor);
        engine.run();

    }
}
