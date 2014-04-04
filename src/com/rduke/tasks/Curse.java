package com.rduke.tasks;

import com.rduke.Utils;
import org.powerbot.script.Condition;
import org.powerbot.script.Random;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Component;
import org.powerbot.script.rt4.Game;
import org.powerbot.script.rt4.Npc;

import java.util.concurrent.Callable;
import java.util.logging.Level;

/**
 * Created by rduke on 4/4/14.
 */
public class Curse extends Task {
    public Curse(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean validate() {
        return (players.local().animation() == -1 && npcs.select().id(383).nearest().poll().inViewport());
    }

    @Override
    public void execute() {
        Component curseSpell = widgets.widget(192).component(11);
        Npc monk = npcs.select().id(383).nearest().poll();

        if( curseSpell.visible() && !monk.equals(npcs.nil()) ) {
            curseSpell.click();
            monk.click();
        } else {
            if(monk.equals(npcs.nil())) {
                Utils.log(Level.INFO, "Monks is nil!");
            } else {
                Utils.log(Level.INFO, "Magic tab is not open, or the curse spell is not visible.");
                game.tab(Game.Tab.MAGIC);
            }
        }

        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return players.local().animation() == -1;
            }
        }, Random.nextInt(100, 250), 1);
    }
}
