package custom.artefacts;


/**
 * todo - ? объединить с StatId, что бы StatGroup было проще юзать HashMap?
 * todo - ? Observes for value update
 * todo - ? buffs
 * todo - ? spell pool - how to implement?
 * Immutable class
 */
public record Stat(
        double value,
        StatId id
) {
    public interface Type {
        String name();
        
        enum Default implements Type {HP, MANA, ATK, DEF}
    }
    
    public interface Modifier {
        String name();
        
        enum Default implements Modifier {FLAT, PERCENT}
    }
    
    public interface Category {
        String name();
        
        enum Default implements Category {PURE, BASIC, ADDITIONAL}
    }
    
    
    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stat stat = (Stat) o;
        return this.id.equals(stat.id);
    }
    
    @Override public int hashCode() {
        return this.id.hashCode();
    }
    
}


