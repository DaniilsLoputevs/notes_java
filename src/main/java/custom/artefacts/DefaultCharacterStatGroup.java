package custom.artefacts;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * todo - extends from LinkedHashMap?
 */
class DefaultCharacterStatGroup implements StatGroup {
    private final Map<StatId, Stat> stats = new HashMap<>();
    
    
    @Override public void addStat(Stat stat) {
        stats.put(stat.id(), stat);
    }

//    @Override public Stat getStatBy(Stat.Slot type, Stat.Modifier modifier, Stat.Category category) {
//        return stats.get(stat.id());
//    }
//
//    @Override public List<Stat> getStatBy(Stat.Slot type) {
//        return stats.values().stream().filter(s -> s.type() == type).toList();
//    }
    
    @Override public Collection<Stat> getAll() {
        return stats.values();
    }
    
    @Override public Stat getById(StatId id) {
        return stats.get(id);
    }
}
