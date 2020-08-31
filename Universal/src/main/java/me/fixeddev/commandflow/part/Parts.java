package me.fixeddev.commandflow.part;

import me.fixeddev.commandflow.CommandContext;
import me.fixeddev.commandflow.stack.ArgumentStack;

import java.util.Arrays;

/**
 * An utility class to ease the use of {@link CommandPart} and his sub classes.
 */
public final class Parts {
    /**
     * Creates a part that limits the available arguments for the given {@link CommandPart} into the given limit.
     *
     * @param part  The {@link CommandPart} to limit.
     * @param limit The limit for the specified {@link CommandPart}.
     * @return The given {@link CommandPart} that has a limit in what number of arguments it can take.
     */
    public static CommandPart limit(CommandPart part, int limit) {
        return new LimitingPart(part, limit);
    }

    /**
     * A basic {@link CommandPart} that takes a string from the {@link me.fixeddev.commandflow.stack.ArgumentStack}
     *
     * @param name The name for this part.
     * @return A {@link CommandPart} with the given name that takes a {@link String} as argument.
     */
    public static CommandPart newStringPart(String name) {
        return new StringPart(name);
    }

    /**
     * A {@link CommandPart} that consist on a sequence of other CommandParts.
     *
     * After calling {@link CommandPart#parse(CommandContext, ArgumentStack)} on this {@link CommandPart} every part on
     * this CommandPart will be parsed until all the parts are parsed or an error is thrown
     *
     * @param name  The name for this part.
     * @param parts The sequence of {@link CommandPart} instances that this {@link CommandPart} will delegate to.
     * @return A {@link CommandPart} that consists on a sequence of other CommandParts.
     */
    public static CommandPart sequential(String name, CommandPart... parts) {
        return new SequentialCommandPart(name, Arrays.asList(parts));
    }
}