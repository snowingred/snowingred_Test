package design23Demo.factoryDesign.abstrctfactory;

public class ModernFactory extends  Abstractfactory {
    @Override
    Food createFood() {
        return new Bread();
    }

    @Override
    FightingTools createFightingTools() {
        return new Ak47();
    }

    @Override
    RunningTool createRunningTool() {
        return new Car();
    }
}
