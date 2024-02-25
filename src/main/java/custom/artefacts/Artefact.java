package custom.artefacts;


import java.util.Collection;
import java.util.List;

/**
 * Code projection kind of items like: Artefact or vechical module.
 * Implement design pattern: Composite
 * TODO - Can be upgraded
 * TODO - Level Policy
 * TODO - Rare Policy
 */
interface StatModule {
    
    void setStat(Stat stat);
    
    Stat getById(StatId id);
    
    Collection<Stat> getAll();
    
    StatModuleSlot getSlot();
   

//    Object getLevel();

}
interface StatModuleSlot {
    String name();
}

interface HasLevel {
    Level getLevel();
}

class Level {}

interface HasRare {
    Rare getRare();
}

class Rare {}

interface HasDescription {
    Description getDescription();
}

class Description {}


/**
 * - description
 * - Редкость
 * - set (for Grid is Full set)
 * - lvl (прокачка) + потенциальные Ранги (разные экземпляры StatGroup для разных механик прокачки)
 * прототип
 * процентные значения(баффы?)
 *
 * - ? свойства Комплекта артефактов(каталог свойств + DSL?)?
 */
class Artefact {
    public Stat primary;
    public List<Stat> allSecondary;
}

class ArtefactV2 implements StatModule, HasLevel, HasRare, HasDescription {
    
    
    @Override public void setStat(Stat stat) {
    
    }
    
    @Override public Stat getById(StatId id) {
        return null;
    }
    
    @Override public Collection<Stat> getAll() {
        return null;
    }
    
    @Override public StatModuleSlot getSlot() {
        return null;
    }
    
    
    @Override public Level getLevel() {
        return null;
    }
    
    @Override public Rare getRare() {
        return null;
    }
    
    @Override public Description getDescription() {
        return null;
    }
}

enum ArtefactSlotType {
    HEAD, BODY, LEGS, RING
}

/**
 * todo - возвращать причину Почему арт не возможно поместить в сетку
 */
interface StatModuleGrid {
    boolean canSetArtefact(Artefact artefact);
    
    void setArtefact(Artefact artefact);
    
    List<StatModule> getAllModules();

//    StatInfo getStatsInfo();
}