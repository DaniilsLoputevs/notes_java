package custom.artefacts;


import java.util.HashMap;
import java.util.Map;

/**
 * Implement design pattern: Lightweight || Flyweight
 * Immutable class
 */
public class StatId {
    private final Stat.Type type;
    private final Stat.Modifier modifier;
    private final Stat.Category category;
    
    public static Map<String, StatId> internPool = new HashMap<>();
    
    /**
     * Check if exists StatId with provider argument.
     * if yes -> return link to exist object.
     * if not -> create and return link to new Object.
     */
    public static StatId of(
            Stat.Type type,
            Stat.Modifier modifier,
            Stat.Category category) {
        if (type == null) throw new IllegalArgumentException("type must be not null!");
        if (modifier == null) throw new IllegalArgumentException("modifier must be not null!");
        if (category == null) throw new IllegalArgumentException("category must be not null!");
        return internPool.computeIfAbsent(getInternKey(type, modifier, category), __ -> new StatId(type, modifier, category));
    }
    
    private static String getInternKey(
            Stat.Type type,
            Stat.Modifier modifier,
            Stat.Category category) {
        return type.getClass().getName() + ':' + type.name() + '-'
                + modifier.getClass().getName() + ':' + modifier.name() + '-'
                + category.getClass().getName() + ':' + category.name();
    }
    
    private StatId(Stat.Type type, Stat.Modifier modifier, Stat.Category category) {
        this.type = type;
        this.modifier = modifier;
        this.category = category;
    }
    
    public Stat.Type getCategory() {
        return type;
    }
    
    public Stat.Modifier getType() {
        return modifier;
    }
    
    public Stat.Category getModifier() {
        return category;
    }
}
