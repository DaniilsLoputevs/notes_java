package custom.artefacts;

import lombok.Getter;

@Getter
public class Character {
    private final StatGroup statGroup = new DefaultCharacterStatGroup();
    private StatModuleGrid statModuleGrid;
}

