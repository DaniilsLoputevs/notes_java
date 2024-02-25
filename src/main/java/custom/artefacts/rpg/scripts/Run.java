package custom.artefacts.rpg.scripts;

import custom.artefacts.Character;
import custom.artefacts.Stat;
import custom.artefacts.StatGroup;
import custom.artefacts.StatId;
import lombok.Getter;
import tools.PrintTable;

import java.util.Arrays;
import java.util.List;

import static custom.artefacts.Stat.*;

/**
 * TODO - Levelable || Experience
 *          - init (Level || experience)
 *          - max exp
 *          - curr exp
 *          - next level exp
 *          - level bonus Policy
 *          - addEnoughExpForLevelUp()
 */
public class Run {
    public static void main(String[] args) {
        var avatar = new Character();
        avatar.getStatGroup().addStat(List.of(
                new Stat(100.0d, StatId.of(Type.Default.HP, Modifier.Default.FLAT, Category.Default.BASIC)),
                new Stat(100.0d, StatId.of(Type.Default.MANA, Modifier.Default.FLAT, Category.Default.BASIC)),
                new Stat(10.0d, StatId.of(Type.Default.ATK, Modifier.Default.FLAT, Category.Default.BASIC)),
                new Stat(5.0d, StatId.of(Type.Default.DEF, Modifier.Default.FLAT, Category.Default.BASIC))
        ));
        System.out.println(new StatGroupTableFormatter().format(avatar.getStatGroup()));
    }
    
    interface StatGroupFormatter {
        String format(StatGroup statGroup);
    }
    
    static class StatGroupTableFormatter implements StatGroupFormatter {
        
        @Override public String format(StatGroup statGroup) {
            @Getter class StatLine {
                final Type category;
                final String name,
                        pureFlat,
                        purePercent,
                        basicFlat,
                        basicPercent,
                        additionalFlat,
                        additionalPercent;
                
                public StatLine(Type category) {
                    this.category = category;
                    name = category.name();
                    pureFlat = getValue(Modifier.Default.FLAT, Category.Default.PURE);
                    purePercent = getValue(Modifier.Default.PERCENT, Category.Default.PURE);
                    basicFlat = getValue(Modifier.Default.FLAT, Category.Default.BASIC);
                    basicPercent = getValue(Modifier.Default.PERCENT, Category.Default.BASIC);
                    additionalFlat = getValue(Modifier.Default.FLAT, Category.Default.ADDITIONAL);
                    additionalPercent = getValue(Modifier.Default.PERCENT, Category.Default.ADDITIONAL);
                }
                
                private String getValue(Modifier type, Category modifier) {
                    Stat stat = statGroup.getById(StatId.of(category, type, modifier));
                    return (stat == null) ? "" : "" + stat.value();
                }
            }
            
            return PrintTable.of(Arrays.stream(Stat.Type.Default.values()).map(StatLine::new))
                    .column("NAME", StatLine::getName)
                    .column("PURE(FLAT)", StatLine::getPureFlat)
                    .column("PURE(%)", StatLine::getPurePercent)
                    .column("BASIC(FLAT)", StatLine::getBasicFlat)
                    .column("BASIC(%)", StatLine::getBasicPercent)
                    .column("ADDITIONAL(FLAT)", StatLine::getAdditionalFlat)
                    .column("ADDITIONAL(%)", StatLine::getAdditionalPercent)
                    .toString();
        }
    }
}
