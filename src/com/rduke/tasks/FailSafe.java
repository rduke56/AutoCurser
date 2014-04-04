package com.rduke.tasks;

import com.rduke.AutoCurse;
import com.rduke.Utils;
import org.powerbot.script.rt4.ClientContext;

import java.util.logging.Level;

/**
 * Created by rduke on 4/4/14.
 */
public class FailSafe extends Task {
    public FailSafe(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean validate() {
        return ( (!npcs.select().id(383).isEmpty() || !npcs.nearest().poll().inViewport()) );
    }

    @Override
    public void execute() {
        if(npcs.isEmpty()) {
            Utils.log(Level.INFO, "Zamorack monk is not visible! Closing bot.");
            bot().close();
        } else {
            camera.turnTo(npcs.nearest().poll());
        }
    }
}
