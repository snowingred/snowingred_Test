package design23Demo.factoryDesign.abstrctfactory;

public class MagicFactory extends Abstractfactory {
    @Override
    Food createFood() {
        return new Mushroom();
    }

    @Override
    FightingTools createFightingTools() {
        return new Magicwand();
    }

    @Override
    RunningTool createRunningTool() {
        return new MagicCarret();
    }
}
