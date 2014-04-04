package com.rduke;

import com.rduke.tasks.Curse;
import com.rduke.tasks.FailSafe;
import com.rduke.tasks.Task;
import org.powerbot.bot.rt4.client.Tile;
import org.powerbot.script.PaintListener;
import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;
import org.powerbot.script.rt4.ClientContext;

import java.awt.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by rduke on 4/2/14.
 */

@Script.Manifest(
        name = "Auto Curse",
        description = "Curses the druid in Varrock castle.",
        properties = "client=4;"
)

public class AutoCurse extends PollingScript<ClientContext> implements PaintListener {
    final ArrayList<Task> tasks = new ArrayList<Task>();

    @Override
    public void start() {
        Utils.log(Level.INFO, "Starting...");

        tasks.add(new FailSafe(ctx));
        tasks.add(new Curse(ctx));
    }

    @Override
    public void suspend() {
        Utils.log(Level.INFO, "Suspended...");
    }

    @Override
    public void stop() {
        Utils.log(Level.INFO, "Stopped...");
    }

    @Override
    public void poll() {
        for (Task task : tasks) {
            if (task.validate())
                task.execute();
        }
    }

    @Override
    public void repaint(Graphics graphics) {
        graphics.setColor(Color.CYAN);
        graphics.drawRect(10, 35, 175, 115);

        graphics.setColor(new Color(0, 0, 0, 90));
        graphics.fillRect(11, 36, 174, 114);

        graphics.setColor(Color.WHITE);
        graphics.setFont(Font.getFont("Tahoma"));

        graphics.drawString("Auto Curse - v1.0", 40, 55);
        graphics.drawString("XP Gained: NULL", 20, 75);
        graphics.drawString("XP / Hour: NULL", 20, 90);
        graphics.drawString("Levels Gained: NULL", 20, 105);

    }
}
