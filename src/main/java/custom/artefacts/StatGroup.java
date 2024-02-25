package custom.artefacts;

import java.util.Collection;

/**
 * TODO - if make StatId.of() - this interface come useless
 */
public interface StatGroup {
    void addStat(Stat stat);
    
    default void addStat(Iterable<Stat> stats) {
        stats.forEach(this::addStat);
    }

//    /**
//     * @implNote Если внутри StatGroup есть более одного подходящего Stat,
//     * - предполагается что все они будут с конкатенированы в один через "+".
//     */
//    Stat getStatBy(Stat.Slot type, Stat.Modifier modifier, Stat.Category category);
    
    //    List<Stat> getStatBy(Stat.Slot type);
    Stat getById(StatId id);
    
    Collection<Stat> getAll();
    
}
