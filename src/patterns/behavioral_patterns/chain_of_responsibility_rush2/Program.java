package patterns.behavioral_patterns.chain_of_responsibility_rush2;

import patterns.behavioral_patterns.chain_of_responsibility_rush2.space.SpaceShip;
import patterns.behavioral_patterns.chain_of_responsibility_rush2.space.crew.AbstractCrewMember;

/**
 * Chain of Responsibility
 *
 *  Cabin boy
 *      -> Engineer
 *          -> First mate
 *              -> Captain
 *
 * "Полы может помыть и юнга, а приказ "к бою!" может дать только капитан!"
 *
 * Метод handleRequest передает управление до уполномоченного уровня.
 * (Работу может выполнить только член команды соотвествующей компетенции)
 * При добавлении новых должностей в метод не потребуется вносить изменения.
 *
 * P.P.S. Все enum поддерживают интерфейс Comparable.
 */
public class Program {
    public static void main(String[] args) {
        SpaceShip spaceShip = new SpaceShip();
        AbstractCrewMember crewMember = spaceShip.getCrewChain();

        crewMember.handleRequest(AbstractCrewMember.CompetencyLevel.EXPERT, "ATTACK");
        System.out.println("-----------------------------------------");
        crewMember.handleRequest(AbstractCrewMember.CompetencyLevel.NOVICE, "WASH THE FLOOR");
        System.out.println("-----------------------------------------");
        crewMember.handleRequest(AbstractCrewMember.CompetencyLevel.INTERMEDIATE, "CHECK ENGINE");
        System.out.println("-----------------------------------------");
        crewMember.handleRequest(AbstractCrewMember.CompetencyLevel.ADVANCED, "SET ROUTE");
    }
}
