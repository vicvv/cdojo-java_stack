public class ProjectTest{
    public static void main(String[] args){
        Project p1 = new Project();
        Project p2 = new Project("vicky");
        Project p3 = new Project("vicky","vicky is an idiot");
        Project p4 = new Project("vicky", "idiot", 55.00);

        p1.setProjectName("p1 name");
        p1.setProjectDescription("p1 description");
        p1.setProjectCost(55.01);
        System.out.println(p1.projectInfo());
        System.out.println(p1.getProjectCost());
        System.out.println(p1.getProjectName());
        System.out.println(p1.getProjectDescription());

        p2.setProjectDescription("p2 description");
        p2.setProjectCost(43.12);
        System.out.println(p2.projectInfo());
        System.out.println(p2.getProjectCost());
        System.out.println(p2.getProjectName());
        System.out.println(p2.getProjectDescription());

        p3.setProjectCost(100.11);
        System.out.println(p3.projectInfo());
        System.out.println(p3.getProjectCost());
        System.out.println(p3.getProjectName());
        System.out.println(p3.getProjectDescription());

        System.out.println(p4.projectInfo());

        Portfolio p = new Portfolio();
        p.addProject(p1);
        p.addProject(p2);
        p.addProject(p3);
        p.getPortfolioCost();
        p.showPortfolio();
        
    }
}