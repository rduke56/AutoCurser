package com.rduke.tasks;

import org.powerbot.script.rt4.ClientContext;

/**
 * Created by rduke on 4/2/14.
 */
public abstract class Task extends ClientContext {
    public Task(ClientContext ctx) {
        super(ctx);
    }

    public abstract boolean validate();
    public abstract void execute();
}
